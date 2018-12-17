package com.sifude.lejane.task;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.sifude.lejane.dao.IStatActiveDao;

@Component("usrMemberActiveTask")
public class UsrMemberActiveTask {
	
	private static Logger log = LogManager.getLogger(UsrMemberActiveTask.class);
	
	@Resource(name = "statActiveDao")
	private IStatActiveDao statActiveDao;
	
	public synchronized void usrActiveTask(){
		//先删除记录
		log.info("-------先删除记录------");
		statActiveDao.delete();
		/**
		 * 开始统计新数据
		 */
		log.info("-------开始统计新数据------");
		//检测趋势
		statActiveDao.checkStat();
		//心情不好
		statActiveDao.moodStat();
		//打电话给呼叫中心记录
		statActiveDao.feedbackStat();
		//打电话给您的记录
		statActiveDao.callStat();
		//阅读健康消息的记录
		statActiveDao.readStat();
		//查看手机问题的记录
		statActiveDao.checkproblemStat();
	}

}
