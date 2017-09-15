package com.yuriy.java8.locking;

import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Kucya on 06.09.2017.
 */
public class LockerService {

    private final Lock lock = new ReentrantLock();

    public void doRead() throws Exception{
        LockHelper.executeOperationWithLocking(lock, () -> {
            System.out.println("Reading from file");
        });
    }

    public void doWrite() throws Exception{
        LockHelper.executeOperationWithLocking(lock, () -> {
            System.out.println("Writing to file");
        });
    }
}
