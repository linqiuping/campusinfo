package com.example.campusinfo.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;

public class DownloadingWebpage {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://zjut.jysd.com/job/search?d_category=0");
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        BufferedWriter writer = new BufferedWriter(new FileWriter("save2yiibai-index.html"));
        String line;

        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            writer.write(line);
            writer.newLine();
        }
        reader.close();
        writer.close();
    }
}
