 /**  
 *@Description:     
 */ 
package com.sifude.lejane.sanjiu;  

import java.sql.Timestamp;
import java.util.HashMap;

import com.sifude.lejane.CrawlListPageBase;
import com.sifude.lejanel.sanjiu.model.SysInformation;
import com.sifude.util.JsonUtil;
import com.sifude.util.RegexUtil;
/**
 * @author 梁景皓
 * @version 创建时间：2016年4月1日 上午11:12:41
 * 抓取一个养生保健的文章
 */
public class GrabCareDetail extends CrawlListPageBase{

	private String url;
	//书名信息正则
	
	private static final String TITLE = "<title>(.*?)</title>";
	//关键词正则表达试
	private static final String KEYWORDS = "<meta name=\"Keywords\" content=\"(.*?)\" />";
	//简介信息正则
	private static final String DESC = "<meta name=\"Description\" content=\"(.*?)\" />";
	//private static final String CONTENT = "(<div class=\"art_con\" id=\"contentText\">|<div id=\"contentText\" class=\"art_con\">)(.*?)(</div>) ";
	
	private static final String CONTENT = "(<div class=\"art_con\" id=\"contentText\">|<div id=\"contentText\" class=\"art_con\">)"
			+ "((?<nesteddiv>div[^>]*>.*</div>)|.*?)"
			+ "(</div>)";
	
	private static final String CONTENT_FLITER = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>";
	//创建时间
	private static final String TIME = "<div class=\"date\"><em>(.*?)</em><em>.*</em><em>.*</em></div>";
	//作者
	private static final String AUTHER = "<div class=\"date\"><em>.*</em><em>.*</em><em>(.*?)</em></div>";
	//分类
	private static final String SOURCE = "<div class=\"date\"><em>.*</em><em>(.*?)</em><em>.*</em></div>";
	
	private static final String HTML_FLITER = "<[\\s]*?[^>]*?>";
	//图片
	private static final String IMAGE = "<[iI][mM][gG] .* src=\"(.*?)\"";

	//请求头信息
	private static HashMap<String, String> params;
	
	static {
		params = new HashMap<String, String>();
		params.put("Host", "care.39.net");
		params.put("Referer", "http://care.39.net");
		params.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:45.0) Gecko/20100101 Firefox/45.0");
//		params.put("Cookie", "ga=GA1.2.380104105.1457951578; Hm_lvt_ab2e5965345c61109c5e97c34de8026a=1457951578,1458558473,1458876759"
//				+ "; _39wt_pk_cookie=bfd313957792d2a70d2cd7271721b1e5-1998452782; _39wt_last_session_cookie=dc1d8189974b397765cd2aa85dea8c92-999819602"
//				+ "; _39wt_last_visit_time_cookie=1458877546533; area_info=CN110000|%D6%D0%B9%FA|%B1%B1%BE%A9|-|%B5%E7%D0"
//				+ "%C5; tma=202198739.95995098.1457951632995.1458558483656.1458786867371.4; tmd=12.202198739.95995098.1457951632995"
//				+ ".; bfd_g=8a28c81f66bd06590000374900070a745535ce8d; Hm_lpvt_ab2e5965345c61109c5e97c34de8026a=1458877527"
//				+ "; _39wt_session_cookie=dc1d8189974b397765cd2aa85dea8c92-999819602; _39wt_global_refer_server_cookie=-"
//				+ "; _39wt_global_pathid_cookie=-; _39wt_site_refer_server_cookie=care.39.net; _39wt_global_refer_url_md5_cookie"
//				+ "=336d5ebc5436534e61d16e63ddfca327; _39wt_site_refer_url_md5_cookie=470ab7bdb1a7dca65492aeb60c2a80ac;"
//				+ "_39wt_session_refer_cookie=http%253A%252F%252Fcare.39.net%252Fys%252Fjkjj%252Findex.html; _gat=1");
		
		
	}

	public GrabCareDetail(String pageUrl) {
		super(pageUrl, "utf-8", params);
		this.url = pageUrl;
	}


	@Override
	public String getUrlRegexStr() {
		return "<a href=\"(.*?)\"";
	}

	@Override
	public int getUrlRegexStrNum() {
		return 1;
	}
	
	private String getTitle() {
		return RegexUtil.getFirstString(getPageSourceCode(), TITLE, 1);
	}
	
	private String getKeywords() {
		return RegexUtil.getFirstString(getPageSourceCode(), KEYWORDS, 1);
	}
	
	private String getDesc() {
		return RegexUtil.getFirstString(getPageSourceCode(), DESC, 1);
	}

	private String getAuther() {
		return RegexUtil.getFirstString(getPageSourceCode(), AUTHER, 1);
	}
	private String getSource() {
		return RegexUtil.removeString(RegexUtil.getFirstString(getPageSourceCode(), SOURCE, 1), HTML_FLITER);
	}
	private String getContent() {
		String content = RegexUtil.getFirstString(getPageSourceCode(), CONTENT, 2);
		return RegexUtil.removeString(content, CONTENT_FLITER);
	}
	private String getImage() {
		return RegexUtil.getFirstString(getContent(), IMAGE, 1);
	}
	private String getTime() {
		return RegexUtil.getFirstString(getPageSourceCode(), TIME, 1);
	}
	public SysInformation analyzer() {
		SysInformation bean = new SysInformation();
	
		bean.setInfoUrl(url);
		bean.setContent(getContent());
		bean.setCreateTime(new Timestamp(System.currentTimeMillis()));
		bean.setDescription(getDesc());
		bean.setImage(getImage());
		bean.setInfoTime(getTime());
		bean.setInfoType("养生保健");
		bean.setSource(getSource());
		bean.setTitle(getTitle());
		bean.setKeywords(getKeywords());
		bean.setAuther(getAuther());
		return bean;
	}

	/**  
	 * @param args
	 * @Author:lulei  
	 * @Description:  
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub  
		GrabCareDetail grab = new GrabCareDetail("http://care.39.net/a/201189/1772295.html");
		
		System.out.println(JsonUtil.parseJson(grab.analyzer()));
	}
}
