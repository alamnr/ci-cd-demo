package org.example.cicd.cicd_demo;

import org.springframework.boot.SpringApplication;

public class TestCicdDemoApplication {

	public static void main(String[] args) {
		SpringApplication.from(CicdDemoApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
