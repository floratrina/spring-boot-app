package com.studentInfoService.studentinfoservices.Rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Messages {

    @RequestMapping("/messages")
    public List<String> getMessages() {
        List<String> list = new ArrayList<>();
        list.add("This is spring boot!");
        list.add("The app is about student info services");
        return list;
    }
}
