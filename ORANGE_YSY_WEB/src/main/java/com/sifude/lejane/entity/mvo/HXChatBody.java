package com.sifude.lejane.entity.mvo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author 梁景皓
 * @version 创建时间：2015年9月25日 下午3:38:01 类说明
 */
@JsonInclude(Include.NON_NULL)
public class HXChatBody {
	/**
	 * "hhhhhh"
	 * 消息内容
	 */
	private String msg;
	/**
	 * "txt"
	 * 消息类型。txt:文本消息, img:图片, loc：位置, audio：语音
	 */
	private String type;
	/**
	 * 3
	 * 语音时长，单位为秒，这个属性只有语音消息有
	 */
	private String length;
	/**
	 * 图片语音等文件的网络url，图片和语音消息有这个属性
	 */
	private String url;
	/**
	 * "22.png"
	 * 文件名字，图片和语音消息有这个属性
	 */
	private String filename;
	/**
	 * "pCY80PdfEeO4Jh9URCOfMQWU9QYsJytynu4n-yhtvAhmt1g9",
	 * 获取文件的secret，图片和语音消息有这个属性
	 */
	private String secret;
	/**
	 * 39.983805
	 * 发送的位置的纬度，只有位置消息有这个属性
	 */
	private String lat;
	/**
	 * 116.307417
	 * 位置经度，只有位置消息有这个属性
	 */
	private String lng;
	/**
	 * "北京市海淀区北四环西路66号"
	 * 位置消息详细地址，只有位置消息有这个属性
	 */
	private String addr;
	
	private Size size;
	
	private String file_length;
	
	private String thumb;
	
	private String thumb_secret;
	
	public String getThumb() {
		return thumb;
	}
	public void setThumb(String thumb) {
		this.thumb = thumb;
	}
	public String getThumb_secret() {
		return thumb_secret;
	}
	public void setThumb_secret(String thumb_secret) {
		this.thumb_secret = thumb_secret;
	}
	public String getFile_length() {
		return file_length;
	}
	public void setFile_length(String file_length) {
		this.file_length = file_length;
	}
	public class Size {
		private Double width;
		private Double height;
		public Double getWidth() {
			return width;
		}
		public void setWidth(Double width) {
			this.width = width;
		}
		public Double getHeight() {
			return height;
		}
		public void setHeight(Double height) {
			this.height = height;
		}
		
	}
	
	public Size getSize() {
		return size;
	}
	public void setSize(Size size) {
		this.size = size;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg
			) {
		this.msg = msg;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "HXChatBody [msg=" + msg + ", type=" + type + ", length="
				+ length + ", url=" + url + ", filename=" + filename
				+ ", secret=" + secret + ", lat=" + lat + ", lng=" + lng
				+ ", addr=" + addr + ", size=" + size + ", file_length="
				+ file_length + ", thumb=" + thumb + ", thumb_secret="
				+ thumb_secret + "]";
	}
	
	
}
