package com.sifude.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * 工具类（Stream流）
 * @author Sunny
 * 
 */
public class StreamUtil {
	/**
	 * [私有]缓冲值
	 */
	private static int _buffer_size = 1024;
	/**
	 * URI中传入的字节数组解码
	 * @param inByte inByte数组
	 * @return 字节数组
	 */
	public static byte[]  uriByte2byte(byte[] inByte,String code){
		String str="";
		try {
			str = URLDecoder.decode(new String(inByte),code);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str.getBytes();
	}
	/**
	 * InputStream流转换成String字符串
	 * @param inStream InputStream流
	 * @return String字符串
	 */
	public static String inputStream2String(InputStream inStream){
		return inputStream2String(inStream, Configs.DefaultEncoding);
	}
	/**
	 * InputStream流转换成String字符串
	 * @param inStream InputStream流
	 * @param encoding 编码格式
	 * @return String字符串
	 */
	public static String inputStream2String(InputStream inStream, String encoding){
		String result = null;
		try {
			if(inStream != null){
				ByteArrayOutputStream outStream = new ByteArrayOutputStream();
				byte[] tempBytes = new byte[_buffer_size];
				int count = -1;
				while((count = inStream.read(tempBytes, 0, _buffer_size)) != -1){
				    outStream.write(tempBytes, 0, count);
				}
				tempBytes = null;
				outStream.flush();
				result = new String(outStream.toByteArray(), encoding);
			}
		} catch (Exception e) {
			result = null;
		}
		return result;
	}
	/**
	 * String字符串转换成InputStream流
	 * @param str String字符串
	 * @return InputStream流
	 */
	public static InputStream string2InputStream(String str) {
		return string2InputStream(str, Configs.DefaultEncoding);
	}
	/**
	 * String字符串转换成InputStream流
	 * @param str String字符串
	 * @param encoding 编码格式
	 * @return InputStream流
	 */
	public static InputStream string2InputStream(String str, String encoding) {
		ByteArrayInputStream result = null;
		try {
			if(str != null){
				result = new ByteArrayInputStream(str.getBytes(encoding));
			}
		} catch (Exception e) {
			result = null;
		}
		return result;
	}
	/**
	 * Reader转换成String字符串
	 * @param inReader Reader
	 * @return String字符串
	 */
	public static String reader2String(Reader inReader){
		String result = null;
		try {
			if(inReader != null){
				CharArrayWriter outCharArray = new CharArrayWriter();
				char[] tempChars = new char[_buffer_size];
				int count = -1;
				while((count = inReader.read(tempChars, 0, _buffer_size)) != -1){
					outCharArray.write(tempChars, 0, count);
				}
				tempChars = null;
				outCharArray.flush();
				result = new String(outCharArray.toCharArray());
			}
		} catch (Exception e) {
			result = null;
		}
		return result;
	}
	/**
	 * InputStream流转换成byte[]数组
	 * @param inStream InputStream流
	 * @return byte[]数组
	 */
	public static byte[] inputStream2Bytes(InputStream inStream){
		byte[] result = new byte[0];
		try {
			if(inStream != null){
				ByteArrayOutputStream outStream = new ByteArrayOutputStream();
				byte[] tempBytes = new byte[_buffer_size];
				int count = -1;
				while((count = inStream.read(tempBytes, 0, _buffer_size)) != -1){
				    outStream.write(tempBytes, 0, count);
				}
				tempBytes = null;
				outStream.flush();
				result = outStream.toByteArray();
			}
		} catch (Exception e) {
			result = new byte[0];
		}
		return result;
	}
	/**
	 * InputStream流转换成char[]数组
	 * @param inStream InputStream流
	 * @return char[]数组
	 */
	public static char[] inputStream2Chars(InputStream inStream){
		char[] result = new char[0];
		try {
			if(inStream != null){
				InputStreamReader inReader = new InputStreamReader(inStream);
				CharArrayWriter outCharArray = new CharArrayWriter();
				char[] tempChars = new char[_buffer_size];
				int count = -1;
				while((count = inReader.read(tempChars, 0, _buffer_size)) != -1){
					outCharArray.write(tempChars, 0, count);
				}
				tempChars = null;
				outCharArray.flush();
				result = outCharArray.toCharArray();
			}
		} catch (Exception e) {
			result = new char[0];
		}
		return result;
	}
	/**
	 * byte[]数组转换成InputStream流
	 * @param bytes byte[]数组
	 * @return InputStream流
	 */
	public static InputStream bytes2InputStream(byte[] bytes) {
		ByteArrayInputStream result = null;
		try {
			if(bytes != null && bytes.length > 0){
				result = new ByteArrayInputStream(bytes);
			}
		} catch (Exception e) {
			result = null;
		}
		return result;
	}
	/**
	 * byte[]数组转换成String字符串
	 * @param bytes byte[]数组
	 * @return String字符串
	 */
	public static String bytes2String(byte[] bytes){
		return bytes2String(bytes, Configs.DefaultEncoding);
	}
	/**
	 * byte[]数组转换成String字符串
	 * @param bytes byte[]数组
	 * @param encoding 编码格式
	 * @return String字符串
	 */
	public static String bytes2String(byte[] bytes, String encoding){
		String result = null;
		try {
			result = new String(bytes, encoding);
		} catch (Exception e) {
			result = null;
		}
		return result;
	}
	/**
	 * String字符串转换成byte[]数组
	 * @param str String字符串
	 * @return byte[]数组
	 */
	public static byte[] string2Bytes(String str){
		return string2Bytes(str, Configs.DefaultEncoding);
	}
	/**
	 * String字符串转换成byte[]数组
	 * @param str String字符串
	 * @param encoding 编码格式
	 * @return byte[]数组
	 */
	public static byte[] string2Bytes(String str, String encoding){
		byte[] result = new byte[0];
		try {
			result = str.getBytes(encoding);
		} catch (UnsupportedEncodingException e) {
			result = new byte[0];
		}
		return result;
	}
	/**
	 * String字符串转换成char[]数组
	 * @param str String字符串
	 * @param encoding 编码格式
	 * @return char[]数组
	 */
	public static char[] string2Chars(String str, String encoding){
		char[] result = new char[0];
		try {
			result = str.toCharArray();
		} catch (Exception e) {
			result = new char[0];
		}
		return result;
	}
	/**
	 * char[]数组转换成String字符串
	 * @param chars char[]数组
	 * @return String字符串
	 */
	public static String chars2String(char[] chars){
		String result = null;
		try {
			result = new String(chars);
		} catch (Exception e) {
			result = null;
		}
		return result;
	}
}
