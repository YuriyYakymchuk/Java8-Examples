package com.yuriy.java8.resource.management.main;

import com.yuriy.java8.resource.management.FileWriterClosable;
import com.yuriy.java8.resource.management.TransactionManager;

import java.io.IOException;

/**
 * Created by Kucya on 06.09.2017.
 */
public class ResourceMain {

    public static void main(String[] args) throws IOException{
        final String message = "My message";
        final String fileName = "c:\\Temp\\Message.txt";

        TransactionManager.doJob(fileName, transactionManager -> transactionManager.writeToFile(message));

     /*   try (final FileWriterClosable fileWriterClosable = new FileWriterClosable("c:\\Temp\\Message.txt")) {
            fileWriterClosable.writeToFile(message);
            System.out.println(String.format("Message \"%s\" has been writen", message));
        }*/
    }
}
