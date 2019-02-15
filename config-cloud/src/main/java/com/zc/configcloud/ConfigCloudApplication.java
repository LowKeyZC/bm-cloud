package com.zc.configcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigCloudApplication {

	public static void main(String[] args) {
		System.out.println("commit test");
		SpringApplication.run(ConfigCloudApplication.class, args);
	}

}

