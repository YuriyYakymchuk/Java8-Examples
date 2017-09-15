package com.yuriy.java8.locking;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

/**
 * Created by Kucya on 06.09.2017.
 */
public class LockMain {

    private static ReadLockService readLockService = new ReadLockService();
    private static WriteLockService writeLockService = new WriteLockService();

    public static void main(String[] args) throws Exception{

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for(int i = 0; i < 10; i++) {
            executorService.submit(readLockService);
            executorService.submit(writeLockService);
        }

        final LockerService lockerService = new LockerService();
        lockerService.doWrite();
        lockerService.doRead();
    }
}
