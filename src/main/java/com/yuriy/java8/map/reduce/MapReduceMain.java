package com.yuriy.java8.map.reduce;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Kucya on 11.09.2017.
 */
public class MapReduceMain {

    private static final List<String> names = Arrays.asList( "GOOG", "AAPL", "AMZN", "YHOO", "CSCO", "CRAY", "TXN", "IBM",
            "ADBE", "HPQ", "AMD","XRX");


    private static final int stockPrice = 300;

    private static StockPriceService stockPriceService = new StockPriceService();


    public static void main(String[] args) {

        getTheLowestAbove(300);

    }

    private static void getTheLowestAbove(final int price) {
        final StockInfo theLowest = stockPriceService.getTheLowestAbove(price, names.stream());

        System.out.println("The lowest above the price: " + price);
        System.out.println(theLowest);
    }

    private static void getHigherStocksThan(final int price) {
        final List<StockInfo> result = stockPriceService.getHigherThan(price, names.stream());

        System.out.println("Stocks higher than: " + price);
        result.stream()
                .forEach(System.out::println);

    }

    private static void getTheHighestUnder(final int price) {

        System.out.println("The least stock under: " + price);
        final long startTime = System.currentTimeMillis();
        final StockInfo theLeastStock = stockPriceService.getTheHighestUnder(price, names.stream());
        System.out.println("Time execution of normal stream: " + (System.currentTimeMillis() - startTime));
        System.out.println(theLeastStock);

        System.out.println("");
        final long startTimeParalelStream = System.currentTimeMillis();
        final StockInfo theLeastParalelStream = stockPriceService.getTheHighestUnder(price, names.parallelStream());
        System.out.println("Time execution of paralel stream: " + (System.currentTimeMillis() - startTimeParalelStream));
        System.out.println(theLeastParalelStream);

    }
}
