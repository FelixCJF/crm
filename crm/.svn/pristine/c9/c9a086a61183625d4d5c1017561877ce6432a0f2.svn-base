package com.itheima.crm.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MyStringUtils {

	/**
	 * 将提供的数据进行md5加密
	 * * 理论上不可逆的
	 * * JDK提供工具进行 消息摘要算法（加密）
	 * @param value
	 * @return
	 */
	public static String getMD5Value(String value){
		try {
			//1 获得工具类
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			//2 加密，加密结果为10进制
			byte[] md5ValueByteArray = messageDigest.digest(value.getBytes());
			//3 将10机制转换成16进制
			BigInteger bigInteger = new BigInteger(1 ,  md5ValueByteArray);
			//4 转换
			return bigInteger.toString(16);
		} catch (Exception e) {
			//如果有异常，不加密
			return value;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(getMD5Value("1234"));
	}
}
