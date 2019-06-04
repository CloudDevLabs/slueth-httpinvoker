package com.cdl.sleuthhttpinvoker.restfulfacade;

import com.cdl.sleuthhttpinvoker.randomservice.model.RandomReply;
import com.cdl.sleuthhttpinvoker.randomservice.model.RandomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class RestfulFacadeApplication {

	private static Logger log = LoggerFactory.getLogger(RestfulFacadeApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RestfulFacadeApplication.class, args);
	}

	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate restTemplate() {
		// sleuth wil automatically add interceptors
		return new RestTemplate();
	}

	@RequestMapping("/")
	public String home() {
		log.info("Handling home");
		return "Hello World";
	}

	@RequestMapping("/random-proxy-rest")
	public String randomProxyRest() {
		String resultFromRandomService = restTemplate.getForObject("http://localhost:8081/random", String.class);
		String reply = "Result from random service via REST is " + resultFromRandomService;
		log.info(reply);
		return reply;
	}

	@Autowired
	private RandomService randomService;

	@RequestMapping("/random-proxy-invoker")
	public String randomProxyInvoker() {
		RandomReply random = randomService.random();
		String reply = "Result from random service via HttpInvoker is " + random;
		log.info(reply);
		return reply;
	}

}
