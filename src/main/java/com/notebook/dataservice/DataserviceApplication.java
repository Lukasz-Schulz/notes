package com.notebook.dataservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataserviceApplication {

	private static Logger LOG = LoggerFactory
			.getLogger(DataserviceApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(DataserviceApplication.class, args);


	}

}
