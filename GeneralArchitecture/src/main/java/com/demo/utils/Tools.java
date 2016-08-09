package com.demo.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import sun.misc.BASE64Encoder;

@SuppressWarnings("restriction")
public class Tools {
	//MD5加密
	public static String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		 //确定计算方法
		  MessageDigest md5=MessageDigest.getInstance("MD5");
		  BASE64Encoder base64en = new BASE64Encoder();
		 //加密后的字符串
		  String newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
		  return newstr;
	}
	//SHA加密
	 public static String EncrypSHA(String info) throws NoSuchAlgorithmException{  
	        MessageDigest sha = MessageDigest.getInstance("SHA");  
	        byte[] srcBytes = info.getBytes();  
	        //使用srcBytes更新摘要  
	        sha.update(srcBytes);  
	        //完成哈希计算，得到result  
	        byte[] resultBytes = sha.digest();
	        return resultBytes.toString();  
	   }  
	//用于消除Mongodb中8个小时的时间误差
	public static Date changeToLocalChina(Date datetime)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(datetime);
		calendar.add(Calendar.HOUR, 8);
		datetime = calendar.getTime();
		return datetime;
	}
	//Date转为String
	public static String dateToString(Date datetime)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(datetime);
	}
	//String转为Date
	public static Date stringToDate(String datetime)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return sdf.parse(datetime);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	//把字符串转化为东8区世家
	public static Date changeToDate8(String timestamp)
	{
		if(timestamp==null||timestamp.equals("")||timestamp.equals("null")) return null;
		timestamp = timestamp.replace("T", " ");//将里面的T替换成空格
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse(timestamp);
			date = changeToLocalChina(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	//得到当前的东8区时间
	public static Date getNowDate8()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return sdf.parse(sdf.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		/*try {
			System.out.println(EncrypSHA("easicloudjljajdfio324jll38hl3"));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			System.out.println(sdf.format(new Date()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}*/
		System.out.println(getNowDate8());
	}
	
}
