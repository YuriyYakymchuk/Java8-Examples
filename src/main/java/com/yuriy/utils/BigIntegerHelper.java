package com.yuriy.utils;

import java.math.BigInteger;

/**
 * Created by Kucya on 09.09.2017.
 */
public class BigIntegerHelper {

    public static BigInteger THIRTY_FIVE = new BigInteger("35");
    public static BigInteger FIVE = new BigInteger("5");

    public static BigInteger multiply(final BigInteger number1, final BigInteger number2) {
        return number1.multiply(number2);
    }

    public static BigInteger decrement(final BigInteger number) {
        return number.subtract(BigInteger.ONE);
    }
}
