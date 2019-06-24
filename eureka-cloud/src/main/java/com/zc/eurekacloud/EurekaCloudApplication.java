package com.zc.eurekacloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author zhouchao
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaCloudApplication.class, args);
	}

}

