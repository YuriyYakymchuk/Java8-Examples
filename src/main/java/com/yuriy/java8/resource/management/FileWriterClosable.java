package com.yuriy.java8.resource.management;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Kucya on 06.09.2017.
 */
public class FileWriterClosable implements AutoCloseable {

    private final FileWriter fileWriter;

    public FileWriterClosable(final String fileName) throws IOException{
        fileWriter = new FileWriter(fileName);
    }

    public void writeToFile(final String message) throws IOException{
        fileWriter.write(message);
    }

    @Override
    public void close() throws IOException {
        System.out.println("Closing file");
        fileWriter.close();
    }
}
