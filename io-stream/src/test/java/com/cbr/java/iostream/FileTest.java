package com.cbr.java.iostream;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileTest {

    @Test
    public void testRandomAccessFile() throws IOException {
        RandomAccessFile file = new RandomAccessFile("data.txt", "rw");
        Assert.assertEquals(0, file.getFilePointer());
        file.writeInt(20);
        Assert.assertEquals(4, file.getFilePointer());
        file.getFilePointer();
        file.seek(10);
        Assert.assertEquals(10, file.getFilePointer());
    }
}