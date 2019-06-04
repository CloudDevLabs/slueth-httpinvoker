package com.cdl.sleuthhttpinvoker.randomservice;

import com.cdl.sleuthhttpinvoker.randomservice.model.RandomReply;
import com.cdl.sleuthhttpinvoker.randomservice.model.RandomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;

import java.util.Random;

@Configuration
public class HttpInvokerConfiguration {

    private static Logger log = LoggerFactory.getLogger(HttpInvokerConfiguration.class);

    @Bean(name = "/invoker")
    public HttpInvokerServiceExporter accountService() {
        HttpInvokerServiceExporter exporter = new HttpInvokerServiceExporter();
        exporter.setService( new RandomServiceImpl() );
        exporter.setServiceInterface(RandomService.class );
        return exporter;
    }

    public static class RandomServiceImpl implements RandomService {
        @Override
        public RandomReply random() {
            int randomInt = new Random().nextInt(10000);
            log.info("Returning random result via HttpInvoker " + randomInt);
            return new RandomReply(randomInt);
        }
    }
}
