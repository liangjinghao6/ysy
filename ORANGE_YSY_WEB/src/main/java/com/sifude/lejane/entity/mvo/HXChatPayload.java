package com.sifude.lejane.entity.mvo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author 梁景皓
 * @version 创建时间：2015年9月25日 下午3:38:01 类说明
 */
@JsonInclude(Include.NON_NULL)
public class HXChatPayload {
	private List<HXChatBody> bodies;
	
	private Ext ext;
	
	public class Ext {
		private Boolean isPlayed;

		public Boolean getIsPlayed() {
			return isPlayed;
		}

		public void setIsPlayed(Boolean isPlayed) {
			this.isPlayed = isPlayed;
		}
		
		
	}
	
	public Ext getExt() {
		return ext;
	}

	public void setExt(Ext ext) {
		this.ext = ext;
	}

	public List<HXChatBody> getBodies() {
		return bodies;
	}

	public void setBodies(List<HXChatBody> bodies) {
		this.bodies = bodies;
	}
	
}
