package com.yuriy.java8.locking;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Kucya on 06.09.2017.
 */
public class ReadLockService implements Runnable {

    private final Lock lock = new ReentrantLock();

    @Override
    public void run() {
        LockHelper.executeOperationWithLocking(lock, () -> {
            System.out.println("Reading from file thread - " + Thread.currentThread().getName());
        });
    }
}
