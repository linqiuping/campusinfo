package com.example.campusinfo.service;

import com.example.campusinfo.repository.JobRepository;
import com.example.campusinfo.unit.Constant;
import com.example.campusinfo.unit.Job;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResolveWebPage {

    @Autowired
    JobRepository jobRepository;

    public String getTitle(String content){
        Document document = Jsoup.parse(content);
        return document.getElementsByTag("title").first().text();
    }

    public String getTable(String content){
        Document document = Jsoup.parse(content);
        Elements elements =document.getElementsByClass("job-box");

        return elements.first().html();
    }

    public List<Job> getJobList(String content){
        Document document = Jsoup.parse(content);
        Elements elements =document.getElementsByClass("job-box");
        Element element=elements.first();
        Elements elementslist= element.getElementsByTag("li");
        List<Job> list=new ArrayList<>();
        for (Element e:elementslist
        ) {
            try {
                Job job=new Job();
                Element jobElement=e.getElementsByClass("job").first();
                if (null==jobElement){
                    continue;
                }
                /**
                 * 设置公司名称
                 */
                Element companyElement=jobElement.getElementsByClass("company").first();
                Element aElement=companyElement.getElementsByTag("a").first();
                job.setCompany(aElement.text());
                /**
                 * 获取工作名／工作详情链接／发布时间
                 */
                Element nameElement=jobElement.getElementsByClass("name").first();
                Element aNameElement=nameElement.getElementsByTag("a").first();
                job.setName(aNameElement.text());
                job.setJobUrl("http://zjut.jysd.com/"+aNameElement.attr("href"));
                job.setPublishTime(nameElement.getElementsByTag("span").first().text());
                /**
                 * 获取待遇
                 */
                Element salaryElement=jobElement.getElementsByClass("salary").first();
//                job.setSalary(salaryElement.getElementsByClass("p").first().text());
//                job.setAddress(salaryElement.getElementsByClass("ul").text());
                jobRepository.save(job);
                job.setSchool_type(Constant.school_type_zjut);
                list.add(job);
            }catch (Throwable throwable){
                System.out.println("error:"+e.html());
            }
        }
        return list;
    }

    public String getJob(String content){
        Document document = Jsoup.parse(content);
        Elements elements =document.getElementsByClass("job-box");
        Element element=elements.first();
        return element.text();
    }

    public String getDivConten(String content, String div){
        Document document = Jsoup.parse(content);
        Element element=document.getElementById(div);
//        Element element=elements.first();
        return element.text();
    }


}
