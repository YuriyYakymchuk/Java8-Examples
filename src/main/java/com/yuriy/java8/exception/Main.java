package com.yuriy.java8.exception;

import com.yuriy.model.Figure;

import java.io.File;
import java.io.IOException;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Created by Kucya on 30.08.2017.
 */
public class Main {

    private static final CalculationService calculationService = new CalculationService(
            figure -> figure.getType() == Figure.TYPE.DOUBLE ? 2.0 : 1.0
    );

    public static void main(String[] args) throws IOException, InterruptedException {
        final Figure figure = new Figure(2.0, 3.0, Figure.TYPE.SINGLE.SINGLE);
        final Function<Figure.TYPE, Double> ratio = figureType -> figureType == Figure.TYPE.DOUBLE.DOUBLE ? 2.0 : 1.0;

        final double result = calculationService.calculateSquare(figure);

        System.out.println(result);

        Stream.of(".")
                .map(path -> {
                    try {
                        return new File(path).getCanonicalPath();
                    } catch (IOException io) {
                        return io;
                    }
                })
                .forEach(System.out::println);

    }

 }
