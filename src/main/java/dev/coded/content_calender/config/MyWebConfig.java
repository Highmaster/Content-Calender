package dev.coded.content_calender.config;


import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration // when you want to define a bean, you need to do so inside a configuration class
public class MyWebConfig {

    @Bean // method level annotation, we can't use @component bcuz it is a class level annotation
    public RestTemplate restTemplate(){      //RestTemplate is template that spring provides,it is a client that you can use to call out to a public API or service within your organization
        return new RestTemplateBuilder().build();

    }
}
