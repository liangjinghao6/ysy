package com.sifude.lejane.sanjiu;  

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.sifude.lejane.CrawlListPageBase;
import com.sifude.lejane.sanjiu.db.LeJanDB;
/**
 * @author 梁景皓
 * @version 创建时间：2016年4月1日 上午11:11:13
 * 抓取某个网页所有健康饮食的信息
 */
public class UpdateFoodDetail extends CrawlListPageBase{
	//请求头信息
	private static HashMap<String, String> params;
	
	static {
		params = new HashMap<String, String>();
		params.put("Host", "food.39.net");
		params.put("Referer", "http://food.39.net");
		params.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:45.0) Gecko/20100101 Firefox/45.0");
		
	}

	public UpdateFoodDetail(String pageUrl) {
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
				if (url.indexOf("food.39.net/a/") > 0 && url.indexOf(".html") > 0) {
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
		UpdateFoodDetail updateList = new UpdateFoodDetail("http://food.39.net");
		for (String s : updateList.getPageUrl(true)) {
			System.out.println(s);
		}
		LeJanDB db = new LeJanDB();
		db.saveCrawlUrls(updateList.getPageUrl(true), "food", "detail");
	}
}
