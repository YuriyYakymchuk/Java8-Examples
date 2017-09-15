package com.yuriy.java8.method.impl;

import com.yuriy.java8.method.AgreementService;
import com.yuriy.java8.method.BuyService;
import com.yuriy.java8.method.FastSellService;
import com.yuriy.java8.method.SellService;
import lombok.AllArgsConstructor;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created by Kucya on 04.09.2017.
 */
public class RealtorServiceImpl extends BuyService implements SellService, AgreementService {

    final private String address;
    final private String buyer;
    final private String seller;

    public RealtorServiceImpl(String address, String buyer, String seller) {
        this.address = address;
        this.buyer = buyer;
        this.seller = seller;
    }

    public RealtorServiceImpl fillAddress(final String address) {
        return new RealtorServiceImpl(address, this.buyer, this.seller);
    }

    public RealtorServiceImpl fillBuyer(final String buyer) {
        return new RealtorServiceImpl(this.address, buyer, this.seller);
    }

    public RealtorServiceImpl fillSeller( final String seller) {
        return new RealtorServiceImpl(this.address, this.buyer, seller);
    }

    @Override
    public void sign() {
        SellService.super.sign();
        System.out.println(this.address);
    }

    public static void signAgreement(final Consumer<RealtorServiceImpl> consumer) {

        RealtorServiceImpl realtorService = new RealtorServiceImpl(null, null, null);

        consumer.accept(realtorService);

        System.out.println("Done");
    }
}
