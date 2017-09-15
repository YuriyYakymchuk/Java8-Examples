package com.yuriy.java8.exception;

import com.yuriy.exception.ExceptionTestHelper;
import org.junit.Test;

/**
 * Created by Kucya on 06.09.2017.
 */

public class ExceptionServiceTest {

    @Test
    public void checkArgumentTest() {
        ExceptionTestHelper.checkException(IllegalArgumentException.class, exceptionService -> exceptionService.checkArgument(-1));
    }
}
