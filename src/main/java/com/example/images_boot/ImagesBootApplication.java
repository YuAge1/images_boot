package com.example.images_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ImagesBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(ImagesBootApplication.class, args);
    }

    @RequestMapping("/hello")
    public String show(){
        return "hello_world";
    }
}
