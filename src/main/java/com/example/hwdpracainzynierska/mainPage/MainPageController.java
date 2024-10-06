package com.example.hwdpracainzynierska.mainPage;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainPageController {

    @GetMapping("/")
    public String mainPage(){
        return "Main Page";
    }

}
