package com.hujun.shirodemo02;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.hujun.shirodemo02.mapper")
@ComponentScan(basePackages = {"com.hujun.shirodemo02.*"})
public class Shirodemo02Application {

	public static void main(String[] args) {
		SpringApplication.run(Shirodemo02Application.class, args);
	}

}
