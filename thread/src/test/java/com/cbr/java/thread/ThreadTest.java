package com.cbr.java.thread;

import org.junit.Test;

public class ThreadTest {

    @Test
    public void testThread() {
        Thread thread = new ThreadClass();
        thread.start();
    }

    @Test
    public void testRunnable() {
        Thread thread = new Thread(new RunnableClass());
        thread.start();
    }

    class ThreadClass extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(getName());
            }
        }
    }

    class RunnableClass implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName());
            }
        }
    }
}