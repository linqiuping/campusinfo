package com.example.campusinfo.controller;

import com.example.campusinfo.service.ZjutCrawler;
import com.example.campusinfo.unit.Job;
import com.example.campusinfo.service.DownloadingWebpage;
import com.example.campusinfo.service.ResolveWebPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    @Autowired
    ZjutCrawler zjutCrawler;


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

    @RequestMapping("getWebJobTable")
    public  String getWebJobTable(@RequestParam String  url) {
        try {
            String content = downloadingWebpage.getPageContentBySelenium(url);
            String jobTable = resolveWebPage.getTable(content);
            return jobTable;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return "get job table error";

        }
    }

    @RequestMapping("getJobList")
    public List<Job> getJobList(@RequestParam String  url) {
        try {
            String content = downloadingWebpage.getPageContentBySelenium(url);
            return resolveWebPage.getJobList(content);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }
    }

    @RequestMapping("getAllJob")
    public String getAllJob() {
        for (int i = 1; i < 31; i++) {
            try {
                zjutCrawler.download("http://zjut.jysd.com/job/search?d_category=0&page="+i);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
        return "finish";
    }





    @RequestMapping("getDivContent")
    public  String getDivContent(@RequestParam String  url) {
        try {
            return downloadingWebpage.getPageContentBySelenium(url);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return "get job table error";

        }
    }

}
