package dev.coded.content_calender.controller;

import dev.coded.content_calender.config.ContentCalendarProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HomeController {

    @Value("${cc.welcomeMessage: Default Welcome Message}")
    private String welcomeMessage;


    @Value("${cc.about}")
    private String about;


    @GetMapping("/")
    public Map<String, String> home() {
        return Map.of("welcomeMessage", welcomeMessage, "about", about);
    }

//  private final ContentCalendarProperties properties;
//
//    public HomeController(ContentCalendarProperties properties) {
//        this.properties = properties;
//    }
//
//    @GetMapping("/")
//    public ContentCalendarProperties home(){
//        return properties;
//    }
}
