package com.yuriy.printer;

import com.yuriy.printer.model.Text;

import java.awt.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by Kucya on 03.09.2017.
 */
public class PrinterMain {

    public static void main(String[] args) {
        final Function<Text, Text> setTextDecorator = text -> text.withText("Text");
        final Function<Text, Text> setColorDecorator = text -> text.withColor(new Color(100, 100, 100));

        final PrinterService printerService = new PrinterService(setTextDecorator, setColorDecorator);
        final Text text = Text.TextBuilder.build();

        final Consumer<Text> printResult = result -> System.out.println("Printed text will look like: " + result.toString());
        final Supplier<String> supplier = () -> "I am suplier";

        System.out.println(supplier.get());

        printResult.accept(printerService.composeText(text));

        printResult.accept(new PrinterService().composeText(text));

    }
}
