/**
 * Project Name	: eip-ai-talk-common
 * File Name	: DemoTest.java
 * Package Name	: com.ustcinfo.ishare.eip.ai.talk.common.base
 * Date			: 2018年6月15日下午2:52:46
 * Author 		: fan.wenbin  
 * Copyright (c) 2018, fan.wenbin@ustcinfo.com All Rights Reserved.
 * 
 *                    .----.
 *                 _.'__    `.
 *             .--(#)(##)---/#\\
 *           .' @          /###\\
 *           :         ,   #####
 *            `-..__.-' _.-\\###/
 *                  `;_:    `\"'
 *                  .'\"\"\"\"\"`.
 *                 /,  牛仔, \\
 *                //  很忙!  \\\\
 *                `-._______.-'
 *                ___`. | .'___
 *               (______|______)
 * 
 */

package com.ustcinfo.ishare.eip.base;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**  
 * @ClassName	DemoTest
 * @Function	
 * @CreateTime	2018年6月15日下午2:52:46
 * @author		fan.wenbin
 * @version		1.0
 * @since		JDK 1.7
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DemoTest extends SpringBasicJunitRunTest {
	
	@Test
	public void test00() throws Exception {
		logger.info("=============== 华丽的分割线 ====================");
		logger.info("测试 " + new Exception().getStackTrace()[0].getMethodName() + " 方法。：示例测试。");
	}
	
	@Test
	public void test01() throws Exception {
		logger.info("=============== 华丽的分割线 ====================");
		logger.info("测试 " + new Exception().getStackTrace()[0].getMethodName() + " 方法。：示例测试。");
	}
	
	static enum Type {
		AA, BB, CC, DD, EE, FF;
	}
	
	@Test
	public void test02() throws Exception {
		logger.info("=============== 华丽的分割线 ====================");
		logger.info("测试 " + new Exception().getStackTrace()[0].getMethodName() + " 方法。：测试随机获取一个枚举类的元素。");
		for(int i = 0; i < 1000; i++) {
			if(!(getRandomEnum(Type.class) instanceof Type)) {
				throw new Exception("测试随机获取一个枚举类的元素失败");
			}
		}
	}
	
	@Test
	public void test03() throws Exception {
		logger.info("=============== 华丽的分割线 ====================");
		logger.info("测试 " + new Exception().getStackTrace()[0].getMethodName() + " 方法。：测试随机取任意长度的中文字符。");
		for(int i = 0; i < 1000; i++) {
			if(!(getRandomEnum(Type.class) instanceof Type)) {
				throw new Exception("测试随机获取一个枚举类的元素失败");
			}
		}
	}
}
  
