package com.yuriy.remit;

/**
 * Created by Kucya on 20.09.2017.
 */
public class SimpleService {

    private int a() {
        throw new RuntimeException();
    }

    public int b() {
        try {
            a();
            return 1;
        } catch (Exception e){
            return 2;
        } finally {
            return 3;
        }

    }
}
