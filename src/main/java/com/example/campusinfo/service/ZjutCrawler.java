package com.example.campusinfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZjutCrawler {
    @Autowired
    DownloadingWebpage downloadingWebpage;
    @Autowired
    ResolveWebPage resolveWebPage;

    public void download(String url){
        resolveWebPage.getJobList(downloadingWebpage.getPageContentBySelenium(url));
    }

    public void downloadAll() {
        for (int i = 1; i < 31; i++) {
            try {
                download("http://zjut.jysd.com/job/search?d_category=0&page=" + i);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }
}
