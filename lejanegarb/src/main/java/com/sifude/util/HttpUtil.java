package com.sifude.util;

import java.net.URI;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * 工具类(HTTP)
 * @author Sunny
 *
 */
public class HttpUtil {
	private static Logger log = LogManager.getLogger(HttpUtil.class);
	/**
	 * GET请求
	 * @param url URL路径
	 * @param operator 键值对参数
	 * @return String 返回结果
	 */
	public static String get(String url, Map<?, ?> operator){
		String result = null;
		try {
			HttpGet httpget = new HttpGet(_getUri(url, operator));
			HttpResponse response = HttpClients.createDefault().execute(httpget);
			HttpEntity entity = response.getEntity();
			if (response.getStatusLine().getStatusCode() == 200) {
				result = StreamUtil.inputStream2String(entity.getContent());
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return result;
	}
	/**
	 * POST请求
	 * @param url URL路径
	 * @param params 键值对参数
	 * @param content Post内容
	 * @return String 返回结果
	 */
	public static String post(String url, Map<?, ?> params, String content){
		String result = null;
		try {
			HttpPost httppost = new HttpPost(_getUri(url, params));
			HttpEntity postentity = new StringEntity(content,Configs.DefaultEncoding);
			httppost.setEntity(postentity);
			HttpResponse response = HttpClients.createDefault().execute(httppost);
			HttpEntity entity = response.getEntity();
			if (response.getStatusLine().getStatusCode() == 200) {
				result = StreamUtil.inputStream2String(entity.getContent());
			} else {
				log.warn(response.getStatusLine().getStatusCode() + "||" + response.getStatusLine().getReasonPhrase());
				log.debug(StreamUtil.inputStream2String(entity.getContent()));
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return result;
	}
	
	
	
	/**
	 * POST请求
	 * @param url URL路径
	 * @param bodyMap 键值对参数
	 * @param bodyContent Post内容
	 * @param headMap 头内容参数
	 * @return String 返回结果
	 */
	public static String post(String url, Map<?, ?> bodyMap, String bodyContent, Map<?, ?> headMap){
		String result = null;
		try {
			HttpPost httppost = new HttpPost(_getUri(url, bodyMap));
			for(Object key : headMap.keySet()) {
				httppost.addHeader((String) key, (String) headMap.get(key));
			}
			HttpEntity postentity = new StringEntity(bodyContent,Configs.DefaultEncoding);
			httppost.setEntity(postentity);
			HttpResponse response = HttpClients.createDefault().execute(httppost);
			HttpEntity entity = response.getEntity();
			if (response.getStatusLine().getStatusCode() == 200) {
				result = StreamUtil.inputStream2String(entity.getContent());
			} else {
				log.warn(response.getStatusLine().getStatusCode() + "||" + response.getStatusLine().getReasonPhrase());
				log.debug(StreamUtil.inputStream2String(entity.getContent()));
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return result;
	}
	/**
	 * POST请求
	 * @param url URL路径
	 * @param params 键值对参数
	 * @param content Post内容<br/>
	 * <blockquote>
	 * <pre>
	 * 例:
	 * MultipartEntityBuilder entity = MultipartEntityBuilder.create();
	 * //设置模式及编码，防止中文乱码
	 * entity.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
	 * entity.setCharset(Charset.forName("UTF-8"));
	 * //添加form表单项
	 * entity.addTextBody("a", CodingUtil.paramEncoding("中文"));
	 * //添加文件
	 * entity.addPart("file", new FileBody(new File("C:\\中文.txt")));
	 * </pre>
	 * </blockquote>
	 * @return String 返回结果
	 */
	public static String post(String url, Map<String, String> params, HttpEntity content){
		String result = null;
		try {
			HttpPost httppost = new HttpPost(_getUri(url, params));
			httppost.setEntity(content);
			HttpResponse response = HttpClients.createDefault().execute(httppost);
			HttpEntity entity = response.getEntity();
			if (response.getStatusLine().getStatusCode() == 200) {
				result = StreamUtil.inputStream2String(entity.getContent());
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return result;
	}
	public static URI _getUri(String url, Map<?, ?> params){
		URI uri = null;
		try {
			URIBuilder urib = new URIBuilder(url);
			if(params != null) {
				Iterator<?> iterator = params.keySet().iterator();
				while (iterator.hasNext()) {
					String p = (String) iterator.next();
					Object pv=params.get(p);
					if(pv instanceof Integer){
						urib.setParameter(p, pv.toString());
					}else if(pv instanceof Long){
						urib.setParameter(p, pv.toString());
					}else if (pv instanceof Date){
						urib.setParameter(p, pv.toString());
					}else{
						urib.setParameter(p, (String)pv);
					}
					
				}
			}
			uri = urib.build();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return uri;
	}
}
