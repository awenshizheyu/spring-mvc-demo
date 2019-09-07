package com.ustcinfo.ishare.eip.base;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/test/resources/spring-context.xml"})
public class SpringBasicJunitRunTest {
	
	protected static Logger logger = LoggerFactory.getLogger(SpringBasicJunitRunTest.class);

	@Test
	public void test00() throws Exception {
		logger.info("=============== 华丽的分割线 ====================");
		logger.info("测试 " + new Exception().getStackTrace()[0].getMethodName() + " 方法。：示例测试。");
	}

	/**
	 * 获取一个UUID
	 */
	protected static String getRandomId() {
		return UUID.randomUUID().toString();
	}
	
	/**
	 * 随机获取长度为10的字符串
	 */
	protected static String getRandomString() {
		return getRandomString(10);
	}
	
	/**
	 * 随机获取任何长度的字符串
	 */
	protected static String getRandomString(int len) {
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        int randomNum;
        char randomChar;
        Random random = new Random();
        // StringBuffer类型的可以append增加字符
        StringBuffer str = new StringBuffer();
 
        for (int i = 0; i < len; i++) {
            // 可生成[0,n)之间的整数，获得随机位置
            randomNum = random.nextInt(base.length());
            // 获得随机位置对应的字符
            randomChar = base.charAt(randomNum);
            // 组成一个随机字符串
            str.append(randomChar);
        }
        return str.toString();
	}
	
	/**
	 * 获取随机10个中文字符
	 */
	protected static String getRandomChaniese() {
		return getRandomChaniese(10);
	}
	
	/**
	 * 随机获取任意长度的中文字符
	 */
	protected static String getRandomChaniese(int len) {
		String result = "";
		if(len < 0) {
			return result;
		}
		for(int i = 0; i < len; i++) {
			result += getRandomChar();
		}
		return result;
	}
	
	protected static <T  extends Enum<T>> T getRandomEnum(Class<T> clazz) {
		if(clazz.isEnum()) {
			T[] enumConstants = clazz.getEnumConstants();
			return enumConstants[new Random().nextInt(enumConstants.length)];
		} else {
			return null;
		}
	}
	
	protected static long getRandomLong() {
		return new Random().nextLong();
	}
	
	protected static int getRandomInteger() {
		return new Random().nextInt();
	}
	
	protected static int getRandomInteger(int max) {
		return new Random().nextInt(max);
	}
	
	protected static double getRandomDouble() {
		return new Random().nextDouble();
	}
	
	protected static float getRandomFloat() {
		return new Random().nextFloat();
	}
	
	protected static boolean getRandomBoolean() {
		return new Random().nextBoolean();
	}
	
	protected static Date getRandomDate() {
		String beginDate = "2000-01-01";
		String endDate = "2099-12-31";
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date start = format.parse(beginDate);// 构造开始日期
			Date end = format.parse(endDate);// 构造结束日期
			// getTime()表示返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
			if (start.getTime() >= end.getTime()) {
				return null;
			}
			long date = random(start.getTime(), end.getTime());
			return new Date(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static long random(long begin, long end) {  
        long rtn = begin + (long) (Math.random() * (end - begin));  
        // 如果返回的是开始时间和结束时间，则递归调用本函数查找随机值  
        if (rtn == begin || rtn == end) {  
            return random(begin, end);  
        }  
        return rtn;  
    } 
	
	private static char getRandomChar() {
        String str = "";
        int hightPos; //
        int lowPos;

        Random random = new Random();

        hightPos = (176 + Math.abs(random.nextInt(39)));
        lowPos = (161 + Math.abs(random.nextInt(93)));

        byte[] b = new byte[2];
        b[0] = (Integer.valueOf(hightPos)).byteValue();
        b[1] = (Integer.valueOf(lowPos)).byteValue();

        try {
            str = new String(b, "GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            System.out.println("错误");
        }

        return str.charAt(0);
    }
	
	
}