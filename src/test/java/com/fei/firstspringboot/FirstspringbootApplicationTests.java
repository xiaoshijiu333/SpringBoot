package com.fei.firstspringboot;

import com.fei.firstspringboot.test.Student;
import com.fei.mystarter.HelloServices;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FirstspringbootApplicationTests {

	@Autowired
	private Student student;

	@Autowired
	private HelloServices helloServices;

	@Test
	public void contextLoads() {
		System.out.println(student);
	}

	/**
	 * 自定义Starter测试
	 * HelloServices已经自动注入
	 */
	@Test
	public void myStarter(){
		helloServices.sayHello();
	}

}
