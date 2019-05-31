package com.cbr.java.lambda;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @Test
    public void testFileList() {
        List<File> files = new ArrayList<>();

        File[] filesInCurrentDir = new File(".").listFiles();
        for (File file : filesInCurrentDir) {
            File[] filesInSubDir = file.listFiles();
            if (filesInSubDir != null) {
                files.addAll(Arrays.asList(filesInSubDir));
            } else {
                files.add(file);
            }
        }

        List<File> files2 = Stream.of(new File(".").listFiles())
                .flatMap(file -> file.listFiles() == null ? Stream.of(file) : Stream.of(file.listFiles()))
                .collect(Collectors.toList());


        Assert.assertEquals(files.size(), files2.size());
    }
}