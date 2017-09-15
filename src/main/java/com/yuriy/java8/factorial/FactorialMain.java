package com.yuriy.java8.factorial;

import com.yuriy.utils.BigIntegerHelper;

import java.math.BigInteger;

/**
 * Created by Kucya on 09.09.2017.
 */
public class FactorialMain {

    private static final FactorialService factorialService = new FactorialService();

    public static void main(String[] args) {
        final BigInteger result = factorialService.calculateWithLambda(BigIntegerHelper.FIVE);

        System.out.println(result);
    }
}
