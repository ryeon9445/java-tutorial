package com.cbr.java.lambda;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileTest {

    @Test
    public void testFile() throws IOException {
        Files.list(Paths.get("."))
                .forEach(System.out::println);
    }

    @Test
    public void testFileFilter() throws IOException {
        Files.list(Paths.get("."))
                .filter(Files::isDirectory)
//                .filter(path -> !Files.isDirectory(path))
                .forEach(System.out::println);
    }

    @Test
    public void testFindFile() throws IOException {
        Files.newDirectoryStream(
                Paths.get("./src/test/java/com/cbr/java/lambda"), path -> path.toString().endsWith(".java"))
                .forEach(System.out::println);
    }

    @Test
    public void testFileOfHidden() {
        final File[] files = new File(".").listFiles(File::isHidden);
        Arrays.stream(files).forEach(System.out::println);
    }
}