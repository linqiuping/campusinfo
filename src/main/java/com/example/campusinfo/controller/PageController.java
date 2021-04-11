package com.example.campusinfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 爬虫控制器
 */
@RestController
@RequestMapping("/api/page/")
public class PageController {

    @Autowired
    DownloadingWebpage downloadingWebpage;

    @RequestMapping("downloadWebpage")
    public String  downloadWebpage(@RequestParam String url){
        try {
            return downloadingWebpage.getContentFormPage(url);
        }catch (Throwable throwable){
            throwable.printStackTrace();
            return "url error";
        }

    }

}
