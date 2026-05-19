package com.jmgr.batch_sheduler_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BatchShedulerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatchShedulerApiApplication.class, args);
	}

}
