package com.neuedu.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.neuedu.demo.controller.StudentController;

@SpringBootApplication
public class DemoApplication {
	private static String username="得克萨斯做得到吗";
	private static String password="123456";
	private static String image="C:\\Users\\admin\\Desktop\\HIT\\大三\\移动互联网\\images\\logo.png";
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println(username);
	}

}
