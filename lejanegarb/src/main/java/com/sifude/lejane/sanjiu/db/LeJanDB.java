 /**  
 *@Description:     
 */ 
package com.sifude.lejane.sanjiu.db;  

import java.sql.ResultSet;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.sifude.db.manager.DBServer;
import com.sifude.lejanel.sanjiu.model.SysCrawlUrl;
import com.sifude.lejanel.sanjiu.model.SysInformation;
import com.sifude.util.CrawlPageStatus;
  
public class LeJanDB {
	//数据库连接池的别名
	private static final String POOLNAME = "proxool.lecanbo";
	
	public void saveCrawlUrl(String url, String type,
			String attribute) {
		DBServer dbServer = new DBServer(POOLNAME);
		try {
			HashMap<Integer, Object> params = new HashMap<Integer, Object>();
			int i = 1;
			params.put(i++, url);
			params.put(i++, type);
			params.put(i++, attribute);
			params.put(i++, CrawlPageStatus.NORMAL.getValue());
			params.put(i++, new Date(System.currentTimeMillis()));
			
			dbServer.insert("tbl_sys_crawl_url", "url,type,attribute,status,create_time", params);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbServer.close();
		}
	}

	public void saveCrawlUrls(List<String> urls, String type,
			String attribute) {
		if(urls == null || urls.size() < 1) {
			return;
		}
		for (String url : urls) {
			if (!haveCrawlUrl(url)) {
				saveCrawlUrl(url, type, attribute);
			}
		}
	}

	private boolean haveCrawlUrl(String url) {
		DBServer dbServer = new DBServer(POOLNAME);
		try {
			String sql = "select sum(1) as count from tbl_sys_crawl_url where url='" + url + "'";
			ResultSet rs = dbServer.select(sql);
			if (rs.next()) {
				int count = rs.getInt("count");
				return count > 0;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbServer.close();
		}
		return true;
	}

	public SysCrawlUrl selectOneCrawUrl(String type, String attribute, int status) {
			DBServer dbServer = new DBServer(POOLNAME);
		try {
			String sql = "select * from tbl_sys_crawl_url where `type` = '" + type
					+ "' and attribute = '" + attribute
					+ "' and status = '" + status + "' limit 0,1";
			ResultSet rs = dbServer.select(sql);
			if(rs.next()) {
				SysCrawlUrl crawl = new SysCrawlUrl();
				crawl.setCraId(rs.getLong("cra_id"));
				crawl.setAttribute(rs.getString("attribute"));
				crawl.setCreateTime(rs.getTimestamp("create_time"));
				crawl.setStatus(rs.getInt("status"));
				crawl.setType(rs.getString("type"));
				crawl.setUrl(rs.getString("url"));
				return crawl;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbServer.close();
		}
		return null;
	}

	public void updateCrawUrlStatus(Long id, Integer status) {
		DBServer dbServer = new DBServer(POOLNAME);
	
		try {
			String sql = "update tbl_sys_crawl_url set `status`='" + status + "' where cra_id = '" + id + "'";
			dbServer.update(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbServer.close();
		}
	}

	public void saveInformation(SysInformation bean) {
		DBServer dbServer = new DBServer(POOLNAME);
		try {
			HashMap<Integer, Object> params = new HashMap<Integer, Object>();
			int i = 1;
			
			params.put(i++, bean.getTitle());
			params.put(i++, bean.getSource());
			params.put(i++, bean.getInfoType());
			params.put(i++, bean.getInfoTime());
			params.put(i++, bean.getInfoUrl());
			params.put(i++, bean.getImage());
			params.put(i++, bean.getContent());
			params.put(i++, bean.getCreateTime());
			
			System.out.println(bean.getTitle());
			
			dbServer.insert("tbl_sys_information", "title,source,info_type,info_time,info_url,image,content,create_time", params);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbServer.close();
		}
	}

}
