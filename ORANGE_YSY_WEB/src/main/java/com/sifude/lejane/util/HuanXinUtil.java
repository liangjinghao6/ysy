package com.sifude.lejane.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sifude.lejane.entity.mvo.HXChatResponse;
import com.sifude.tool.util.HttpUtil;
import com.sifude.tool.util.StreamUtil;

public class HuanXinUtil {
	private static Logger log = LoggerFactory.getLogger(HuanXinUtil.class);

	private String clientId;
	private String clientSecret;
	private String urlToken;
	private String urlRegist;
	private String urlBatchRegist;
	private String urlChat;
	private String grantType = "client_credentials";
	private static String token;
	private final ObjectMapper mapper = new ObjectMapper();

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public void setUrlToken(String urlToken) {
		this.urlToken = urlToken;
	}

	public void setUrlRegist(String urlRegist) {
		this.urlRegist = urlRegist;
	}

	public void setUrlBatchRegist(String urlBatchRegist) {
		this.urlBatchRegist = urlBatchRegist;
	}

	public void setUrlChat(String urlChat) {
		this.urlChat = urlChat;
	}

	/**
	 * 注册用户
	 * 
	 * @param account
	 * @param password
	 * @param name
	 */
	public void registChatUser(String account, String password, String name) {

		// if(HuanXinUtil.token == null) {
		// this.login();
		// }

		Map<String, Object> param = new HashMap<String, Object>();

		param.put("username", account);
		param.put("password", "hx" + account);
		param.put("nickname", name);

		log.debug("开始在环信注册用户url=" + urlRegist + ",param=" + param);
		try {
			String result = HttpUtil.postWithToken(urlRegist,
					mapper.writeValueAsString(param), token);
			log.debug("在环信注册用户结束result=" + result);
		} catch (JsonProcessingException e) {
			log.error("json 处理异常:" + e.getMessage());
		}

	}

	/**
	 * 批量注册用户
	 * 
	 * @param users
	 */
	public void batchRegistChatUser(List<Map<String, Object>> users) {

		if (HuanXinUtil.token == null) {
			this.login();
		}

		int begin = 0;
		int step = 1;
		int length = users.size();
		try {
			while (begin < length) {

				int end = begin + step < length ? begin + step : length;

				List<Map<String, Object>> subUsers = users.subList(begin, end);

				log.debug("开始在环信批量注册begin=" + begin + ",end=" + end);
				log.debug("开始在环信批量注册用户url=" + urlBatchRegist + ",param="
						+ subUsers);

				String result = HttpUtil.postWithToken(urlBatchRegist,
						mapper.writeValueAsString(subUsers), token);

				log.debug("在环信注册用户结束result=" + result);

				begin = begin + step;
				Thread.sleep(100);
			}
		} catch (JsonProcessingException e) {
			log.error("json 处理异常:" + e.getMessage());
		} catch (InterruptedException e) {
			log.error(e.getMessage());
		}
	}

	/**
	 * 获取聊天记录
	 * 
	 * @param users
	 */
	public HXChatResponse getChatHistory(String type, String content) {

		if (HuanXinUtil.token == null) {
			this.login();
		}
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put(type, content);
		log.debug("开始获取聊天记录户url=" + urlChat + ",param=" + param);

		String result = null;
		try {
			HttpGet get = new HttpGet(HttpUtil._getUri(urlChat, param));

			get.addHeader("Authorization", "Bearer " + token);
			HttpResponse response = HttpClients.createDefault().execute(get);
			HttpEntity entity = response.getEntity();
			if (response.getStatusLine().getStatusCode() == 401) {
				token = null;
				return getChatHistory(type, content);
			} else if (response.getStatusLine().getStatusCode() == 200) {
				result = StreamUtil.inputStream2String(entity.getContent());
			} else {
				log.warn(response.getStatusLine().getStatusCode() + "||"
						+ response.getStatusLine().getReasonPhrase());
			}
		//	log.debug("获取聊天记录结束result=" + result);
			return mapper.readValue(result, HXChatResponse.class);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}

	/**
	 * 登陆
	 */
	private void login() {
		if (StringUtils.isNotEmpty(urlToken)) {

			Map<String, Object> param = new HashMap<String, Object>();

			param.put("client_id", clientId);
			param.put("client_secret", clientSecret);
			param.put("grant_type", grantType);

			log.debug("开始在环信注册用户url=" + urlToken + ",param=" + param);
			String result;
			try {
				result = HttpUtil.post(urlToken, null,
						mapper.writeValueAsString(param));
				log.debug("在环信注册用户结束result=" + result);
				if (result != null) {
					token = (String) mapper.readValue(result, Map.class).get(
							"access_token");
				}
			} catch (JsonProcessingException e) {
				log.error("json 处理异常:" + e.getMessage());
			} catch (IOException e) {
				log.error("读写异常:" + e.getMessage());
			}

			// access_token
		}
	}

}
