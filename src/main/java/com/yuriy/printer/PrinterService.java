package com.yuriy.printer;

import com.yuriy.printer.model.Text;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Created by Kucya on 03.09.2017.
 */
public class PrinterService {

    private final Function<Text, Text> filter;

    public PrinterService(final Function<Text, Text> ... decorators) {
        filter = setDecorators(decorators);
    }

    private Function<Text, Text> setDecorators(final Function<Text, Text> ... decorators) {
        return Stream.of(decorators)
                .reduce((textTextFunction, textTextFunction2) -> textTextFunction.andThen(textTextFunction2))
                .orElse(text -> new Text("AAAA", null, -1, -4));
    }

    public Text composeText(final Text text) {
        return filter.apply(text);
    }
}
