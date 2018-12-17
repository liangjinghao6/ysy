package com.sifude.lejane.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * 线程管理器
 * 
 * @author ziyu.wei
 *
 */
public class ThreadUtil {
	@SuppressWarnings("unused")
	private static Logger log = LoggerFactory.getLogger(ThreadUtil.class);


	private ThreadPoolTaskExecutor threadPoolTaskExecutor;

	public ThreadPoolTaskExecutor getThreadPoolTaskExecutor() {
		return threadPoolTaskExecutor;
	}

	public void setThreadPoolTaskExecutor(ThreadPoolTaskExecutor threadPoolTaskExecutor) {
		this.threadPoolTaskExecutor = threadPoolTaskExecutor;
	}
	
	/**
	 * 指定线程
	 * @param runnable
	 */
	public void execute(Runnable runnable) {
		threadPoolTaskExecutor.execute(runnable);
	}
	
	public void destroy() {
		threadPoolTaskExecutor.destroy();
	}
}
