package com.yuriy.java8.method;

/**
 * Created by Kucya on 04.09.2017.
 */
public interface AgreementService {
    default void sign() {
        System.out.println("Agreement has been signed");
    }
}
