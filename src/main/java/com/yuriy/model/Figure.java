package com.yuriy.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Created by Kucya on 03.09.2017.
 */
@Data
@RequiredArgsConstructor
public class Figure {

    public enum TYPE {SINGLE, DOUBLE}

    private final double width;
    private final double length;
    private final TYPE type;
}
