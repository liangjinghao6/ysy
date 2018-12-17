package com.sifude.lejane.sanjiu;  

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.sifude.lejane.CrawlListPageBase;
import com.sifude.lejane.sanjiu.db.LeJanDB;
/**
 * @author 梁景皓
 * @version 创建时间：2016年4月1日 上午11:12:07
 * 抓取一个页面上的所有养生保健的信息
 */
public class UpdateCareDetail extends CrawlListPageBase{
	//请求头信息
	private static HashMap<String, String> params;
	
	static {
		params = new HashMap<String, String>();
		params.put("Host", "care.39.net");
		params.put("Referer", "http://care.39.net");
		params.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:45.0) Gecko/20100101 Firefox/45.0");
		params.put("Cookie", "ga=GA1.2.380104105.1457951578; Hm_lvt_ab2e5965345c61109c5e97c34de8026a=1457951578,1458558473,1458876759"
				+ "; _39wt_pk_cookie=bfd313957792d2a70d2cd7271721b1e5-1998452782; _39wt_last_session_cookie=dc1d8189974b397765cd2aa85dea8c92-999819602"
				+ "; _39wt_last_visit_time_cookie=1458877546533; area_info=CN110000|%D6%D0%B9%FA|%B1%B1%BE%A9|-|%B5%E7%D0"
				+ "%C5; tma=202198739.95995098.1457951632995.1458558483656.1458786867371.4; tmd=12.202198739.95995098.1457951632995"
				+ ".; bfd_g=8a28c81f66bd06590000374900070a745535ce8d; Hm_lpvt_ab2e5965345c61109c5e97c34de8026a=1458877527"
				+ "; _39wt_session_cookie=dc1d8189974b397765cd2aa85dea8c92-999819602; _39wt_global_refer_server_cookie=-"
				+ "; _39wt_global_pathid_cookie=-; _39wt_site_refer_server_cookie=care.39.net; _39wt_global_refer_url_md5_cookie"
				+ "=336d5ebc5436534e61d16e63ddfca327; _39wt_site_refer_url_md5_cookie=470ab7bdb1a7dca65492aeb60c2a80ac;"
				+ "_39wt_session_refer_cookie=http%253A%252F%252Fcare.39.net%252Fys%252Fjkjj%252Findex.html; _gat=1");
		
		
	}

	public UpdateCareDetail(String pageUrl) {
		super(pageUrl, "utf-8", params);
	}


	@Override
	public String getUrlRegexStr() {
		return "<a href=\"(.*?)\"";
	}

	@Override
	public int getUrlRegexStrNum() {
		return 1;
	}
	
	/**
	 * @param exceptOther 是否需要排除纵横以外的网址
	 * @return
	 * @Author:lulei  
	 * @Description:
	 */
	public List<String> getPageUrl(boolean exceptOther) {
		List<String> urls = getPageUrl();
		if (exceptOther) {
			List<String> excepUrls = new ArrayList<String>();
			for (String url : urls) {
				//url中是否包含"zongheng"
				if (url.indexOf("care.39.net/a/") > 0 && url.indexOf(".html") > 0) {
					excepUrls.add(url);
				}
			}
			return excepUrls;
		}
		return urls;
	}
	/**  
	 * @param args
	 * @Author:lulei  
	 * @Description:  
	 */
	public static void main(String[] args) {
		UpdateCareDetail updateList = new UpdateCareDetail("http://care.39.net");
		for (String s : updateList.getPageUrl(true)) {
			System.out.println(s);
		}
		LeJanDB db = new LeJanDB();
		db.saveCrawlUrls(updateList.getPageUrl(true), "care", "detail");
	}
}
