package com.yuriy.java8.map.reduce;

import com.google.common.collect.Maps;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.util.Map;

/**
 * Created by Kucya on 11.09.2017.
 */
public class YahooFinance {

    private static Map<String, BigDecimal> stockPrices = Maps.newHashMap();

    static {
        stockPrices.put("AAPL", new BigDecimal(390));
        stockPrices.put("AMD", new BigDecimal(120));
        stockPrices.put("HPQ", new BigDecimal(190));
        stockPrices.put("IBM", new BigDecimal(270));
        stockPrices.put("TXN", new BigDecimal(210));
        stockPrices.put("XRX", new BigDecimal(220));
        stockPrices.put("ADBE", new BigDecimal(325));
        stockPrices.put("AMZN", new BigDecimal(370));
        stockPrices.put("CRAY", new BigDecimal(120));
        stockPrices.put("CSCO", new BigDecimal(320));
        stockPrices.put("GOOG", new BigDecimal(450));
        stockPrices.put("YHOO", new BigDecimal(250));
    }

    public static BigDecimal getPrice(final String ticker) {
        return stockPrices.get(ticker);
       /* try {
            final URL url = new URL("https://ichart.finance.yahoo.com/table.csv?s=" + ticker);

            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));

            final String data = bufferedReader.lines().skip(1).findFirst().get();
            final String[] dataItems = data.split(",");
            return new BigDecimal(dataItems[dataItems.length - 1]);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }*/
    }
}