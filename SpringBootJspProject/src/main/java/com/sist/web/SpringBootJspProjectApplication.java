package com.sist.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// properties에서 자바버전/다이나믹 웹버전 변경(6.0)
// 스프링 3.5이상에서는 mybatis가 비활성화 된다 
@SpringBootApplication
public class SpringBootJspProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJspProjectApplication.class, args);
	}

}
