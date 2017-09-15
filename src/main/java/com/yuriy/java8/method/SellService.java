package com.yuriy.java8.method;

/**
 * Created by Kucya on 04.09.2017.
 */
public interface SellService {

    default void sell() {
        System.out.println("SellService:sell");
    }
    default void buy() {
        System.out.println("SellService:buy");
    }
    default void sign() {
        System.out.println("SellService:sign");
    }
}
