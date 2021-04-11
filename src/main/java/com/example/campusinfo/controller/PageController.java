package com.example.campusinfo.controller;

import com.example.campusinfo.service.DownloadingWebpage;
import com.example.campusinfo.service.ResolveWebPage;
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
    @Autowired
    ResolveWebPage resolveWebPage;


    @RequestMapping("downloadWebpage")
    public String  downloadWebpage(@RequestParam String url){
        try {
            return downloadingWebpage.getContentFormPage(url);
        }catch (Throwable throwable){
            throwable.printStackTrace();
            return "url error";
        }

    }

    @RequestMapping("getWebTitle")
    public String getWebTitle(@RequestParam String url){
        try {
            String content=downloadingWebpage.getContentFormPage(url);
            String title=resolveWebPage.getTitle(content);
            return title;
        }catch (Throwable throwable){
            throwable.printStackTrace();
            return "get title error";
        }

    }

}
