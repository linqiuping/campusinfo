package com.example.campusinfo.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;


@Service
public class DownloadingWebpage {
    public  String getContentFormPage(String urlStr)throws Throwable{
        URL url = new URL(urlStr);
        URLConnection con  = url.openConnection();

        InputStream in = con.getInputStream();

        BufferedInputStream bin = new BufferedInputStream(in);

        byte[] buffer = new byte[1024];

        int len = 0;

        StringBuilder builder = new StringBuilder();

        while(-1 != (len = bin.read(buffer))){
            builder.append(new String(buffer,0,len));

        }

        System.out.println(builder);
//        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
//        String content="";
//        String line;
//        while ((line = reader.readLine()) != null) {
//            content+=line;
//        }
//        reader.close();
        return builder.toString();
    }

    public String getPageContentBySelenium( String url){
        System.setProperty("webdriver.chrome.driver","/Users/linqiuping/dev/campusinfo/mac/chromedriver");
        // 的是FirefoxDriver的驱动
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(Boolean.TRUE);
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--no-headless");
        WebDriver driver = new ChromeDriver(chromeOptions); // 新建一个WebDriver 的对象，但是new
        driver.get(url);// 打开指定的网站
        String content=driver.getPageSource();
        driver.close();
        return content;
    }
}
