package com.yuriy.java8.method;

/**
 * Created by Kucya on 04.09.2017.
 */
public interface FastSellService extends SellService{
    default void sell () {
        System.out.println("FastSellService:sell");
    }
}
