package com.safety.lejane.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReaderTest {
	
	public static String reader(String file) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(ReaderTest.class.getClassLoader().getResourceAsStream(file)));
			
			StringBuilder sb = new StringBuilder();
			
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line.trim());
			}
			
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != br) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return null;
	}

}
