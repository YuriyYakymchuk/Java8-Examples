package com.yuriy.java8.locking;

import java.util.concurrent.locks.Lock;

/**
 * Created by Kucya on 06.09.2017.
 */
public class LockHelper {

    public static void executeOperationWithLocking(final Lock lock, final Runnable runnable) {
        lock.lock();
        try {
            runnable.run();
            for (int i = 0; i < 1000000; i++) {
                int k = 2+4;
            }
        } finally {
            lock.unlock();
        }
    }
}
