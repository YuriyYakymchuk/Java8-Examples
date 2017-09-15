package com.yuriy.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * Created by Kucya on 13.09.2017.
 */
@Data
@RequiredArgsConstructor
public class IntegerHelper {

    private int value;

    public IntegerHelper(int value) {
        this.value = value;
    }
}
