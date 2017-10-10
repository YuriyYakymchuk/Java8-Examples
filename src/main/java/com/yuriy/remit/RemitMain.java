package com.yuriy.remit;

/**
 * Created by Kucya on 20.09.2017.
 */
public class RemitMain {

    private static final SimpleService simpleService = new SimpleService();

    public static void main(String[] args) {
        System.out.println(simpleService.b());
    }
}
