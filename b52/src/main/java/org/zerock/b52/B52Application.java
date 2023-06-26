package org.zerock.b52;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"org.zerock.b52.**.mappers"})
public class B52Application {

	public static void main(String[] args) {
		SpringApplication.run(B52Application.class, args);
	}

}
