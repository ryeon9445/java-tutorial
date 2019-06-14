package com.cbr.java.algorithm;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

public class WikiNodeTest {

    @Test
    public void testWikiNode() throws IOException {
        String url = "https://en.wikipedia.org/wiki/Java_(programming_language)";

        Connection connection = Jsoup.connect(url);
        Document document = connection.get();

        Element content = document.getElementById("mw-content-text");

        Elements parse = content.select("p");
        Element firstPara = parse.get(0);

        recursiveDFS(firstPara);
        System.out.println();

        iterativeDFS(firstPara);
        System.out.println();

        Iterable<Node> iter = new WikiNodeIterable(firstPara);
        for (Node node: iter) {
            if (node instanceof TextNode) {
                System.out.println(node);
            }
        }
    }

    private static void iterativeDFS(Node root) {
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (node instanceof TextNode) {
                System.out.print(node);
            }

            List<Node> nodes = new ArrayList<>(node.childNodes());
            Collections.reverse(nodes);

            for (Node child : nodes) {
                stack.push(child);
            }
        }
    }

    private static void recursiveDFS(Node node) {
        if (node instanceof TextNode) {
            System.out.print(node);
        }

        for (Node child : node.childNodes()) {
            recursiveDFS(child);
        }
    }
}