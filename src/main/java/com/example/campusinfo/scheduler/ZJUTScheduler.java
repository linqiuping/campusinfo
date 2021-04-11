package com.example.campusinfo.scheduler;

import com.example.campusinfo.service.ZjutCrawler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ZJUTScheduler {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    @Autowired
    ZjutCrawler zjutCrawler;
    //每天3：05执行
    @Scheduled(cron = "0 30 01 ? * *")
    public void zjutTasks() {
        System.out.println("定时任务执行时间：" + dateFormat.format(new Date()));
        zjutCrawler.downloadAll();
    }
}
