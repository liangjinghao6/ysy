package com.orange.ysy.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Class Name MD5Util
 * @Author jinghao.liang
 * @Create In 2013-12-17
 */
public class MD5Util {
	private static Logger log = LoggerFactory.getLogger(MD5Util.class);

	protected static MessageDigest messagedigest = null;
	static {
		try {
			messagedigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {

		}
	}

	public static void main(String[] args) {
		System.out.println(MD5Util.GetMD5Code("626830", false, false));
		System.out.println(MD5Util.GetMD5Code("ysy@2018!!!", null, null));
	}

	// 全局数组
	private final static String[] strDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
			"e", "f" };

	public MD5Util() {
	}

	/**
	 * 
	 * @Methods Name validateMD5Code
	 * @Create In 2013-12-17 By hongliang.gao
	 * @param password
	 *            MD5加密字符
	 * @param inputString
	 *            未加密字符
	 * @param hexBit
	 *            是否验证16位。true: 验证16位; false或者null 验证32位;
	 * @param upperCase
	 *            验证字母是否为大写字母。true: 大写加密字母; false或者null 小写加密字母;
	 * @return boolean
	 */
	public static boolean validateMD5Code(String password, String inputString, Boolean hexBit, Boolean upperCase) {
		if (password.equals(GetMD5Code(inputString, hexBit, upperCase))) {
			return true;
		} else {
			return false;
		}
	}

	// 返回形式为数字跟字符串
	private static String byteToArrayString(byte bByte) {
		// System.out.println("iRet="+iRet);

		int iD1 = 0;
		int iD2 = 0;
		/**
		 * 十进制运算 int iRet = bByte; if (iRet < 0) { iRet += 256; } int iD1 = iRet
		 * / 16; int iD2 = iRet % 16;
		 */

		// 位运算
		iD1 = bByte >>> 4 & 0xf;
		iD2 = bByte & 0xf;

		return strDigits[iD1] + strDigits[iD2];
	}

	// 返回形式只为数字
	@SuppressWarnings("unused")
	private static String byteToNum(byte bByte) {
		int iRet = bByte;
		// System.out.println("iRet1=" + iRet);
		if (iRet < 0) {
			iRet += 256;
		}
		return String.valueOf(iRet);
	}

	// 转换字节数组为16进制字串
	private static String byteToString(byte[] bByte) {
		// System.out.println("bByte=" + bByte);
		StringBuffer sBuffer = new StringBuffer();
		for (int i = 0; i < bByte.length; i++) {
			sBuffer.append(byteToArrayString(bByte[i]));
			// sBuffer.append(byteToNum(bByte[i]));
		}
		return sBuffer.toString();
	}

	/**
	 * 获取MD5加密字符
	 * 
	 * @Methods Name GetMD5Code
	 * @Create In 2013-12-17 By hongliang.gao
	 * @param strObj
	 *            原字符串
	 * @param hexBit
	 *            是否返回8位。true: 返回16位; false或者null 返回32位;
	 * @param upperCase
	 *            是否返回大写字母。true: 返回大写加密字母; false或者null 返回小写加密字母;
	 * @return String
	 */
	public static String GetMD5Code(String strObj, Boolean hexBit, Boolean upperCase) {
		String resultString = null;
		try {
			resultString = new String(strObj);
			MessageDigest md = MessageDigest.getInstance("MD5");
			// md.digest() 该函数返回值为存放哈希值结果的byte数组
			resultString = byteToString(md.digest(strObj.getBytes()));

			if (hexBit != null && hexBit && resultString.length() >= 32) {
				resultString = resultString.substring(8, 24);
			}

			if (upperCase != null && upperCase) {
				resultString = resultString.toUpperCase();
			}

		} catch (NoSuchAlgorithmException ex) {
			log.error(ex.getMessage(), ex);
		}
		return resultString;
	}

	public static String getFileMD5String(File file) {
		String md5 = "";// "12345";
		FileInputStream in = null;
		FileChannel ch = null;
		MappedByteBuffer byteBuffer = null;
		try {
			in = new FileInputStream(file);
			ch = in.getChannel();
			byteBuffer = ch.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
			messagedigest.update(byteBuffer);
			md5 = bufferToHex(messagedigest.digest());
		} catch (FileNotFoundException e) {
			log.error("文件不存在");
			log.error(e.getMessage(), e);
		} catch (IOException e) {
			log.error("获取文件的md5失败");
			log.error(e.getMessage(), e);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					log.error(e.getMessage(), e);
				}
			}
			if (ch != null) {
				try {
					ch.close();
				} catch (IOException e) {
					log.error(e.getMessage(), e);
				}
			}
			if (byteBuffer != null) {
				byteBuffer = null;
				System.gc();
			}
		}
		return md5;
	}

	public static String streamToMd5(InputStream inputStream) {
		try {
			MessageDigest mTemp = MessageDigest.getInstance("MD5");
			byte[] buffer = new byte[1024];
			int numRead = 0;
			while ((numRead = inputStream.read(buffer)) > 0) {
				mTemp.update(buffer, 0, numRead);
			}
			return bufferToHex(mTemp.digest());
		} catch (NoSuchAlgorithmException e) {
			log.error(e.getMessage(), e);
		} catch (IOException e) {
			log.error("获取文件的md5失败");
			log.error(e.getMessage(), e);
		}
		return null;
	}

	private static String bufferToHex(byte bytes[], int m, int n) {
		StringBuffer stringbuffer = new StringBuffer(2 * n);
		int k = m + n;
		for (int l = m; l < k; l++) {
			appendHexPair(bytes[l], stringbuffer);
		}
		return stringbuffer.toString();
	}

	private static void appendHexPair(byte bt, StringBuffer stringbuffer) {
		String c0 = strDigits[(bt & 0xf0) >> 4];
		String c1 = strDigits[bt & 0xf];
		stringbuffer.append(c0);
		stringbuffer.append(c1);
	}

	private static String bufferToHex(byte bytes[]) {
		return bufferToHex(bytes, 0, bytes.length);
	}

}
