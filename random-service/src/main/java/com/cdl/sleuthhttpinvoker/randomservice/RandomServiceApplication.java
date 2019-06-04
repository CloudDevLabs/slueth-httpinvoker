package com.cdl.sleuthhttpinvoker.randomservice;

import com.cdl.sleuthhttpinvoker.randomservice.model.RandomReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@SpringBootApplication
@RestController
public class RandomServiceApplication {

	private static Logger log = LoggerFactory.getLogger(RandomServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RandomServiceApplication.class, args);
	}

	@RequestMapping("/random")
	public RandomReply random() {
		int randomInt = new Random().nextInt(10000);
		log.info("Returning random result via REST " + randomInt);
		return new RandomReply(randomInt);
	}

}
