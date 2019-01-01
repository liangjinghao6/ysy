package com.orange.ysy.test.thread;
//package com.spy;自己的报名

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.orange.ysy.test.HdJunitTest;

/**
 *  *   * @author Administrator  *利用java线程池技术测试并发  *  
 */
public class ThreadTest extends HdJunitTest {

	ObjectMapper mapper = new ObjectMapper();

	public static void main(String[] args) {
		int count = 1;// 设置并发数量
		// 线程池准备
		CyclicBarrier cyclicBarrier = new CyclicBarrier(count);
		ExecutorService executorService = Executors.newFixedThreadPool(count);
		long now = System.currentTimeMillis();// 开始时间
		for (int i = 0; i < count; i++)
			executorService.execute(new ThreadTest().new Task(cyclicBarrier, i));

		executorService.shutdown();
		while (!executorService.isTerminated()) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		long end = System.currentTimeMillis();// 结束时间
		System.out.println("总共耗时!---------" + (end - now));// 总共耗时
	}

	public class Task implements Runnable {
		private CyclicBarrier cyclicBarrier;
		private int count;

		public Task(CyclicBarrier cyclicBarrier, int count) {
			this.cyclicBarrier = cyclicBarrier;
			this.count = count;
		}

		@Override
		public void run() {
			try {
				// 等待所有任务准备就绪
				cyclicBarrier.await();
				// 测试路径
				findDayShipPlan();
			} catch (Exception e) {
				System.out.println("出现超时的线程" + count);
				e.printStackTrace();
			}
		}

		public void findDayShipPlan() {
			HdQuery hq = new HdQuery();
			hq.setPage(1);
			hq.setRows(10);
		    HashMap m = new HashMap<>();
	        m.put("query", "查询条件");
	        hq.setQuery(m);
			String content = "";
			try {
				System.out.println(mapper.writeValueAsString(hq));
				content = post("http://10.163.200.115:8081/webresources/login/ship/ShipVoyage/find",
						mapper.writeValueAsString(hq));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("-------运行DayShipPlan返回结果：-------");
			System.out.println(content);
		}
	}
}

class HdQuery {
	// ezui get params.
	/**
	 * 显示第几页。
	 */
	private Integer page;
	/**
	 * 一页显示多少行数据。
	 */
	private Integer rows;

	/**
	 * 排序。
	 */
	private String sort;
	/**
	 * 排序。
	 */
	private String order;
	// extension params.

	/**
	 * 个性化数据。
	 */
	private HashMap<?, ?> query;
	private String vueGroupRel = null;
	private static final long serialVersionUID = 1L;
	private String alias = "a";// jpql别名

	public String getStr(String key) {
		if (getQuery() == null) {
			return null;
		}
		String result = (String) getQuery().get(key);
		return result;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public HdQuery() {

	}

	public String getVueGroupRel() {
		return vueGroupRel;
	}

	public void setVueGroupRel(String vueGroupRel) {
		this.vueGroupRel = vueGroupRel;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public HashMap<?, ?> getQuery() {
		return query;
	}

	public void setQuery(HashMap<?, ?> query) {
		this.query = query;
	}
}
