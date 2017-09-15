package com.yuriy.java8.map.reduce;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Kucya on 11.09.2017.
 */
public class StockPriceService {


    public List<StockInfo> getHigherThan(final int price, final Stream<String> names) {
        return names
                .map(s -> StockUtil.getStockInfo(s))
                .filter(StockUtil.isPriceHigherThan(price))
                .sorted((o1, o2) -> o1.getPrice().compareTo(o2.getPrice()))
                .collect(Collectors.toList());
    }

    public StockInfo getTheHighestUnder(final int price, final Stream<String> names) {
        return names
                .map(s -> StockUtil.getStockInfo(s))
                .filter(stockInfo -> stockInfo.getPrice().compareTo(BigDecimal.valueOf(price)) < 0)
                .reduce(StockUtil::getHigherStockInfo)
                .orElse(new StockInfo("", new BigDecimal(1)));
    }

    public StockInfo getTheLowestAbove(final int price, final Stream<String> names) {
        return names
                .map(StockUtil::getStockInfo)
                .filter(stockInfo -> stockInfo.getPrice().compareTo(BigDecimal.valueOf(price)) > 0)
                .reduce(StockUtil::getLowerStockInfo)
                .get();
    }

}
