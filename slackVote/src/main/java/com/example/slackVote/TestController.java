package com.example.slackVote;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String home() {
        return "Slack Schedule Bot is running!";
    }

    @GetMapping("/test")
    public String test() {
        return "Hello from Slack Bot!";
    }
}
