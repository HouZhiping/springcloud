package com.hou.cd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CdApplication {

	public static void main(String[] args) {
		SpringApplication.run(CdApplication.class, args);
	}

}
