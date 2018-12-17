package com.sifude.lejane.sanjiu;  

import java.util.List;
import java.util.concurrent.TimeUnit;

import com.sifude.lejane.sanjiu.db.LeJanDB;
import com.sifude.lejanel.sanjiu.model.SysCrawlUrl;
import com.sifude.util.CrawlPageStatus;
/**
 * @author 梁景皓
 * @version 创建时间：2016年4月1日 上午11:11:52
 * 抓取数据库中保存健康网页的所有养生保健的信息
 */
public class UpdateCareDetailList extends Thread{
	private boolean flag = false;
	private int frequency;
	
	/**
	* @param name 线程名
	* @param url 更新列表页url
	* @param frequency 采集频率
	 */
	public UpdateCareDetailList(String name, int frequency) {
		super(name);
		this.frequency = frequency;
	}
	

	@Override
	public void run() {
		flag = true;
		LeJanDB db = new LeJanDB();
		while (flag) {
			try {
				SysCrawlUrl crawl = db.selectOneCrawUrl("care", "page", CrawlPageStatus.SUCCESS.getValue());
				db.updateCrawUrlStatus(crawl.getCraId(), CrawlPageStatus.DEALING.getValue());
				
				UpdateCareDetail updatePage = new UpdateCareDetail(crawl.getUrl());
				//获取更新列表页URL信息
				List<String> urls = updatePage.getPageUrl(true);
				db.saveCrawlUrls(urls, "care", "detail");
				
				db.updateCrawUrlStatus(crawl.getCraId(), CrawlPageStatus.FINISH.getValue());
				
				TimeUnit.SECONDS.sleep(this.frequency);
			} catch (Exception e) {
				// TODO Auto-generated catch block  
				e.printStackTrace();
			}
		}
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub  
		UpdateCareDetailList thread = new UpdateCareDetailList("carePage", 30);
		thread.start();
	}

}
