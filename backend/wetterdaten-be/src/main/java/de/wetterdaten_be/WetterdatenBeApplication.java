package de.wetterdaten_be;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class WetterdatenBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(WetterdatenBeApplication.class, args);
		System.out.println("Hello Weather!");
	}

}
