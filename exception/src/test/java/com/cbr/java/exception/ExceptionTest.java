package com.cbr.java.exception;

import com.oracle.javafx.jmx.json.JSONException;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

public class ExceptionTest {

    @Test
    public void testException01() throws IOException {
        byte[] list = {'a', 'b', 'c'};
        System.out.write(list);
    }

    @Test
    public void testExceptioArithmeticExceptionn02() {
        byte[] list = {'a', 'b', 'c'};
        try {
            System.out.write(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testException03() {
        byte[] list = {'a', 'b', 'c'};
        try {
            System.out.write(list);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = NullPointerException.class)
    public void testException04() throws IOException, NullPointerException{
        System.out.write(null);
    }

    @Test
    public void testException05() {
        try {
            System.out.write(null);
        } catch (IOException ignored) {
            Assert.fail();
        } catch (NullPointerException ignored) {
        } catch (Exception ignored) {
            Assert.fail();
        }
    }

    @Test(expected = Exception.class)
    public void testException06() throws Exception {
        throw new Exception();
    }

    @Test(expected = MyException.class)
    public void testException07() {
        throw new MyException("exception test");
    }

    @Test(expected = NullPointerException.class)
    public void testException08() throws IOException, NullPointerException {
        try (BufferedReader bufferedReader = new BufferedReader(null)){
            System.out.println(bufferedReader.readLine());
        }
    }

    class MyException extends RuntimeException {
        public MyException(String message) {
            super(message);
        }
    }
}