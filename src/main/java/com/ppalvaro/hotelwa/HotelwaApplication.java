package com.ppalvaro.hotelwa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"com.ppalvaro.hotelwa"})
public class HotelwaApplication {

	public static void main(String[] args) {
		final Logger log = LoggerFactory.getLogger(HotelwaApplication.class);
		log.info("Empezo");
		SpringApplication.run(HotelwaApplication.class, args);
		log.info("Termino");
	}
}
