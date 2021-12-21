package com.example.test.config;

import com.example.test.gateway.ExtMsGatewayService;
import com.example.test.gateway.IExtMsGatewayService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class GatewayConfig {
    @Value("${extMsUrl}")
    private String url;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public IExtMsGatewayService getExtMsGatewayService() {
        return new ExtMsGatewayService(url);
    }
}
