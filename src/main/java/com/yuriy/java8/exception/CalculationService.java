package com.yuriy.java8.exception;

import com.yuriy.model.Figure;
import lombok.RequiredArgsConstructor;

import java.util.function.Function;

/**
 * Created by Kucya on 03.09.2017.
 */
@RequiredArgsConstructor
public class CalculationService {

    private final Function<Figure, Double> ratioDecider;

    public double calculateSquare(final Figure figure) {
        return figure.getLength() * figure.getWidth() * ratioDecider.apply(figure);
    }
}
