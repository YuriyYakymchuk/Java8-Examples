package com.yuriy.remit;

import static org.mockito.Mockito.*;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

/**
 * Created by Kucya on 20.09.2017.
 */
public class WorkerTest {

    @Mock
    private Worker worker;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void testGet() {
        when(worker.get()).thenReturn(true);
        Boolean result = worker.get();
        verify(worker).get();
        System.out.println(result);
    }
}
