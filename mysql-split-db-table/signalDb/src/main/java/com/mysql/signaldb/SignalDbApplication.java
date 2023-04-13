package com.mysql.signaldb;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackages = {"com.mysql"}, exclude = {DataSourceAutoConfiguration.class, DruidDataSourceAutoConfigure.class})
public class SignalDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SignalDbApplication.class, args);
	}

}
