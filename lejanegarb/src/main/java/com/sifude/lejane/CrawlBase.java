 /**  
 *@Description:     
 */ 
package com.sifude.lejane;  

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.HttpClients;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sifude.util.CharsetUtil;
import com.sifude.util.StreamUtil;
  
  
public abstract class CrawlBase {
	private static Logger log = LogManager.getLogger(CrawlBase.class);
	
	private String pageSourceCode;
	
	private Header[] reponseHeaders = null;
	//默认最大访问次数
	private static int maxConnectTimes = 3;
	/**
	 * @param urlStr
	 * @param params
	 * @param charsetName
	 * @return
	 * @Author:lulei  
	 * @Description: GET方式请求页面
	 */
	public boolean readPageByGet(String urlStr, HashMap<String, String> params, String charsetName) {
		HttpGet method = createGetMethod(urlStr, params);
		return  readPage(method, charsetName, urlStr);
	}
	
	/**
	 * @param urlStr
	 * @param params
	 * @param charsetName
	 * @return
	 * @Author:lulei  
	 * @Description: POST方式请求页面
	 */
	public boolean readPageByPost(String urlStr, HashMap<String, String> params, String charsetName) {
		HttpPost method = createPostMethod(urlStr, params);
		return  readPage(method, charsetName, urlStr);
	}
	
	/*		String result = null;
		try {
			
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
		*/
	/**
	 * @param method
	 * @param defaultCharset
	 * @param urlStr
	 * @return
	 * @Author:lulei  
	 * @Description: 执行HttpMethod，获取服务器返回的头信息和网页源代码
	 */
	private boolean readPage(HttpRequestBase method, String defaultCharset, String urlStr) {
		int n = maxConnectTimes;
		while (n > 0) {	
			try {
				HttpResponse response = HttpClients.createDefault().execute(method);
				HttpEntity entity = response.getEntity();
				
				if (response.getStatusLine().getStatusCode() == 200) {
					reponseHeaders = response.getAllHeaders();
					InputStream inputStream = entity.getContent();
					//检测流的编码方式
					String charset = CharsetUtil.getStreamCharset(inputStream, defaultCharset);
						
					BufferedReader bufferReader = new BufferedReader(new InputStreamReader(inputStream, charset));
					StringBuffer stringBuffer = new StringBuffer();
					String lineString = "";
					while ((lineString = bufferReader.readLine()) != null) {
						stringBuffer.append(lineString);
						stringBuffer.append("\n");
					}
					pageSourceCode = stringBuffer.toString();
					
					return true;
				} else {
					log.warn(response.getStatusLine().getStatusCode() + "||" + response.getStatusLine().getReasonPhrase());
					log.debug(StreamUtil.inputStream2String(entity.getContent()));
					return false;
				}
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				return false;
			}
		}
		return false;
	}
	
	/**
	 * @param urlStr
	 * @param params 请求头信息
	 * @return
	 * @Author:lulei  
	 * @Description: 创建GET请求
	 */
	private HttpGet createGetMethod(String urlStr, HashMap<String, String> params){
		HttpGet httpget = new HttpGet(urlStr);
		for(Object key : params.keySet()) {
			httpget.addHeader((String) key, (String) params.get(key));
		}
	
		return httpget;
	}

	/**
	 * @param urlStr
	 * @param params 请求头信息
	 * @return
	 * @Author:lulei  
	 * @Description: 创建POST请求
	 */
	private HttpPost createPostMethod(String urlStr, HashMap<String, String> params) {
		HttpPost httppost = new HttpPost(urlStr);
		for(Object key : params.keySet()) {
			httppost.addHeader((String) key, (String) params.get(key));
		}
		return httppost;
	}
	
	/**
	 * @return String
	 * @Author: lulei  
	 * @Description: 获取网页源代码
	 */
	public String getPageSourceCode(){
		return pageSourceCode;
	}
	
	/**
	 * @return Header[]
	 * @Author: lulei  
	 * @Description: 获取网页返回头信息
	 */
	public Header[] getHeader(){
		return reponseHeaders;
	}
//	
//	/**
//	 * @param timeout
//	 * @Author: lulei  
//	 * @Description: 设置连接超时时间
//	 */
//	public void setConnectTimeOut(int timeOut){
//		httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(timeOut);
//		CrawlBase.connectTimeOut = timeOut;
//	}
//	
//	/**
//	 * @param timeout
//	 * @Author: lulei  
//	 * @Description: 设置读取超时时间
//	 */
//	public void setReadTimeOut(int timeOut){
//		httpClient.getHttpConnectionManager().getParams().setSoTimeout(timeOut);
//		CrawlBase.readTimeOut = timeOut;
//	}
	
	/**
	 * @param maxConnectTimes
	 * @Author: lulei  
	 * @Description: 设置最大访问次数，链接失败的情况下使用
	 */
	public static void setMaxConnectTimes(int maxConnectTimes) {
		CrawlBase.maxConnectTimes = maxConnectTimes;
	}

//	/**
//	 * @param connectTimeout
//	 * @param readTimeout
//	 * @Author: lulei  
//	 * @Description: 设置连接超时时间和读取超时时间
//	 */
//	public void setTimeout(int connectTimeout, int readTimeout){
//		setConnectTimeOut(connectTimeout);
//		setReadTimeOut(readTimeout);
//	}

//	/**
//	 * @param charsetName
//	 * @Author: lulei  
//	 * @Description: 设置默认编码方式
//	 */
//	public static void setCharsetName(String charsetName) {
//		CrawlBase.charsetName = charsetName;
//	}

	/**  
	 * @param args
	 * @Author:lulei  
	 * @Description:  
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub  
		
	}

}
