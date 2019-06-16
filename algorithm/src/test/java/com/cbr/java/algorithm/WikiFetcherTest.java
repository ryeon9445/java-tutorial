package com.cbr.java.algorithm;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;

public class WikiFetcherTest {

    @Test
    public void testWikiFetch() throws IOException {
        WikiFetcher wikiFetcher = new WikiFetcher();
        String url = "https://en.wikipedia.org/wiki/Java_(programming_language)";
        Elements paragraphs = wikiFetcher.readWikipedia(url);

        for (Element paragraph : paragraphs) {
            System.out.println(paragraph);
        }
    }
}