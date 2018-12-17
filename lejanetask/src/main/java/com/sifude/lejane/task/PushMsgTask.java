package com.sifude.lejane.task;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component("pushMsgTask")
public class PushMsgTask {
	
	private static Logger log = LogManager.getLogger(UsrMemberActiveTask.class);
	
	public void pushMsg(){
		log.info("开始推送消息...");
	}
}
