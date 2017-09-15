package com.yuriy.exception;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;
import com.yuriy.java8.exception.ExceptionService;

import java.util.function.Consumer;

import static org.junit.Assert.*;

/**
 * Created by Kucya on 06.09.2017.
 */
public class ExceptionTestHelper {

    public static <X extends Throwable> void checkException(final Class<X> x, final Consumer<ExceptionService> runnable) {
        ExceptionService exceptionService = new ExceptionService();
        try {
            runnable.accept(exceptionService);
            fail("No exception has been thrown");
        } catch (Exception ex) {
            assertTrue("Wrong exception has been thrown", x.isInstance(ex));
        }
    }
}
