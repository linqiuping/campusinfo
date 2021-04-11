package com.example.campusinfo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 爬虫控制器
 */
@RestController
@RequestMapping("/api/page/")
public class PageController {

    @RequestMapping("downloadWebpage")
    public String  downloadWebpage(){

        return "hi";
    }

}
