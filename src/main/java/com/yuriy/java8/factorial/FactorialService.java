package com.yuriy.java8.factorial;

import java.math.BigInteger;

import static com.yuriy.java8.factorial.FactorialCalls.call;
import static com.yuriy.java8.factorial.FactorialCalls.done;
import static com.yuriy.utils.BigIntegerHelper.decrement;
import static com.yuriy.utils.BigIntegerHelper.multiply;

/**
 * Created by Kucya on 09.09.2017.
 */
public class FactorialService {

    public int calculate(final int number) {
        if (number == 1) {
            return number;
        }
        return number * calculate(number - 1);
    }

    public BigInteger calculateWithLambda(final BigInteger number) {
        return calculate(BigInteger.ONE, number).invoke();
    }

    private FactorialInterface<BigInteger> calculate(final BigInteger factorial, final BigInteger number) {
        if(number.equals(BigInteger.ONE)) {
            return done(factorial);
        } else {
            return call(() -> calculate(multiply(number, factorial), decrement(number)));
        }
    }
}
