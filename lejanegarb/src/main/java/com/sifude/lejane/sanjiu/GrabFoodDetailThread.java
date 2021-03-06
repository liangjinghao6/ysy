 package com.sifude.lejane.sanjiu;  

import java.util.concurrent.TimeUnit;

import com.sifude.lejane.sanjiu.db.LeJanDB;
import com.sifude.lejanel.sanjiu.model.SysCrawlUrl;
import com.sifude.lejanel.sanjiu.model.SysInformation;
import com.sifude.util.CrawlPageStatus;
/**
 * @author 梁景皓
 * @version 创建时间：2016年4月1日 上午11:12:23
 * 抓取数据库中所有健康饮食的文章
 */
public class GrabFoodDetailThread extends Thread{
	private boolean flag = false;
	
	public GrabFoodDetailThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		flag = true;
		try {
			LeJanDB db = new LeJanDB();
			while (flag) {
				SysCrawlUrl crawl = db.selectOneCrawUrl("food", "detail", CrawlPageStatus.NORMAL.getValue());
				db.updateCrawUrlStatus(crawl.getCraId(), CrawlPageStatus.DEALING.getValue());
	
				if (crawl.getUrl() != null) {
					GrabFoodDetail crawlDetail = new GrabFoodDetail(crawl.getUrl());
					//获取简介页信息
					SysInformation bean = crawlDetail.analyzer();
					if (bean != null) {
						db.saveInformation(bean);
					}
					TimeUnit.MILLISECONDS.sleep(500);
				} else {
					TimeUnit.MILLISECONDS.sleep(1000);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block  
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub  
		GrabFoodDetailThread thread = new GrabFoodDetailThread("information");
		thread.start();
	}

}
