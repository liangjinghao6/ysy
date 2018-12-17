package com.sifude.lejane.sanjiu;  

import java.util.List;
import java.util.concurrent.TimeUnit;

import com.sifude.lejane.sanjiu.db.LeJanDB;
import com.sifude.lejanel.sanjiu.model.SysCrawlUrl;
import com.sifude.util.CrawlPageStatus;
  
/**  
 * @author 梁景皓
 * @version 创建时间：2016年4月1日 上午11:11:23
 * 抓取某个网页所有相关联的page列表保存到数据库
 */
public class UpdateCarePageThread extends Thread{
	private boolean flag = false;
	private int frequency;
	
	/**
	* @param name 线程名
	* @param url 更新列表页url
	* @param frequency 采集频率
	 */
	public UpdateCarePageThread(String name, int frequency) {
		super(name);
		this.frequency = frequency;
	}
	

	@Override
	public void run() {
		flag = true;
		LeJanDB db = new LeJanDB();
		while (flag) {
			try {
				SysCrawlUrl crawl = db.selectOneCrawUrl("care", "page", CrawlPageStatus.NORMAL.getValue());
				db.updateCrawUrlStatus(crawl.getCraId(), CrawlPageStatus.DEALING.getValue());
				
				UpdateCarePage updatePage = new UpdateCarePage(crawl.getUrl());
				//获取更新列表页URL信息
				List<String> urls = updatePage.getPageUrl(true);
				db.saveCrawlUrls(urls, "care", "page");
				
				db.updateCrawUrlStatus(crawl.getCraId(), CrawlPageStatus.SUCCESS.getValue());
				
				TimeUnit.SECONDS.sleep(this.frequency);
			} catch (Exception e) {
				// TODO Auto-generated catch block  
				e.printStackTrace();
			}
		}
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub  
		UpdateCarePageThread thread = new UpdateCarePageThread("carePage", 30);
		thread.start();
	}

}
