package com.cbr.java.algorithm;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class WikiFetcher {

    private long lastRequestTime = -1;
    private long minInterval = 1000;

    public Elements fetchWikipedia(String url) throws IOException {
        sleepIfNeeded();

        Connection connection = Jsoup.connect(url);
        Document document = connection.get();

        Element content = document.getElementById("mw-content-text");
        Elements paras = content.select("p");
        return paras;
    }

    public Elements readWikipedia(String url) throws IOException {
        URL realURL = new URL(url);

        String slash = File.separator;
        String filename = "resources" + slash + realURL.getHost() + realURL.getPath();

        InputStream stream = WikiFetcher.class.getClassLoader().getResourceAsStream(filename);
        Document document = Jsoup.parse(stream, "UTF-8", filename);

        Element content = document.getElementById("mw-content-text");
        Elements paras = content.select("p");
        return paras;
    }

    private void sleepIfNeeded() {
        if (lastRequestTime != -1) {
            long currentTime = System.currentTimeMillis();
            long nextRequestTime = lastRequestTime + minInterval;
            if (currentTime < nextRequestTime) {
                try {
                    Thread.sleep(nextRequestTime - currentTime);
                } catch (InterruptedException e) {
                    System.err.println("Warning: sleep interrupted in fetchWikipedia.");
                }
            }
        }
        lastRequestTime = System.currentTimeMillis();
    }
}