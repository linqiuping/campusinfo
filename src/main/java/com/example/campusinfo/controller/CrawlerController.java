package com.example.campusinfo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 爬虫控制器
 */
@RestController
@RequestMapping("/api/crawler/")
public class CrawlerController {

    @RequestMapping("sayhi")
    public String  sayHi(){
        return "hi";
    }

    @RequestMapping("sayHello")
    public String  sayHello(){
        return "hello wenlong";
    }
}
