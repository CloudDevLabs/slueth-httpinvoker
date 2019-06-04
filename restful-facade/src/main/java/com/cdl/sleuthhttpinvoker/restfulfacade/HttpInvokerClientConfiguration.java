package com.cdl.sleuthhttpinvoker.restfulfacade;

import com.cdl.sleuthhttpinvoker.randomservice.model.RandomService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

@Configuration
public class HttpInvokerClientConfiguration {

    @Bean
    public HttpInvokerProxyFactoryBean invoker() {
        HttpInvokerProxyFactoryBean invoker = new HttpInvokerProxyFactoryBean();
        invoker.setServiceUrl("http://localhost:8081/invoker");
        invoker.setServiceInterface(RandomService.class);
        return invoker;
    }
}
