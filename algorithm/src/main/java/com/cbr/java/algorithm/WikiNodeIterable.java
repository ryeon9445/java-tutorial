package com.cbr.java.algorithm;

import org.jsoup.nodes.Node;

import java.util.*;

public class WikiNodeIterable implements Iterable<Node> {

    private Node root;

    public WikiNodeIterable(Node root) {
        this.root = root;
    }

    public Iterator<Node> iterator() {
        return new WikiNodeIterator(root);
    }

    private class WikiNodeIterator implements Iterator<Node> {

        Deque<Node> stack;

        public WikiNodeIterator(Node node) {
            stack = new ArrayDeque<>();
            stack.push(root);
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public Node next() {
            if (stack.isEmpty()) {
                throw new NoSuchElementException();
            }

            Node node = stack.pop();

            List<Node> nodes = new ArrayList<>(node.childNodes());
            Collections.reverse(nodes);
            for (Node child : nodes) {
                stack.push(child);
            }
            return node;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}