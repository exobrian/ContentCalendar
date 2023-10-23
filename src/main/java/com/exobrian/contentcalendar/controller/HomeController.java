package com.exobrian.contentcalendar.controller;

import com.exobrian.contentcalendar.config.ContentCalendarProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    /*
    // Use this commented out block for simple env variables or accessing properties.
    @Value("${cc.welcomeMessage: Hello! 👋👋}")
    private String welcomeMessage;

    @Value("${cc.aboutMessage: I'm Brian.}")
    private String aboutMessage;

    @GetMapping("/")
    public Map<String, String> home(){
        return Map.of("welcomeMessage", welcomeMessage,
                "aboutMessage", aboutMessage
        );
    }
    */

    private final ContentCalendarProperties properties;

    public HomeController(ContentCalendarProperties properties){
        this.properties = properties;
    }

    @GetMapping("/")
    public ContentCalendarProperties home(){
        return properties;
    }


}
