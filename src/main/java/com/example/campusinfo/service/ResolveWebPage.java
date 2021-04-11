package com.example.campusinfo.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

@Service
public class ResolveWebPage {

    public String getTitle(String content){
        Document document = Jsoup.parse(content);
        return document.getElementsByTag("title").first().text();
    }

//    public String getTable(String content){
//        Document document = Jsoup.parse(content);
//        return document.getElementsByClass("bootstrap-table").first().text();
//    }


}
