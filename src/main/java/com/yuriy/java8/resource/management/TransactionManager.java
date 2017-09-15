package com.yuriy.java8.resource.management;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Kucya on 06.09.2017.
 */
public class TransactionManager {

    public enum STATUS{SUCCESSFUL, FAILED}

    private final FileWriter fileWriter;

    private TransactionManager(final String fileName) throws IOException{
        this.fileWriter = new FileWriter(fileName);
    }

    private void close() throws IOException{
        fileWriter.close();
        System.out.println("Stream has been closed.");
    }

    public STATUS writeToFile(final String message) throws IOException {
        try {
            fileWriter.write(message);
            System.out.println("Message \"" + message + "\" has been written to the file.");
            return STATUS.SUCCESSFUL;
        } catch (IOException io) {
            return STATUS.FAILED;
        }
    }

    public static void doJob(final String fileName, final TransactionFunction<TransactionManager, STATUS, IOException> transactionFunction) throws IOException{
        final TransactionManager transactionManager = new TransactionManager(fileName);
        try {
            final STATUS result = transactionFunction.accept(transactionManager);
            System.out.println("Result: " + result);
        } finally {
            transactionManager.close();
        }
    }
}
