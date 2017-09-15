package com.yuriy.java8.method.main;

import com.yuriy.java8.method.impl.RealtorServiceImpl;

/**
 * Created by Kucya on 04.09.2017.
 */
public class MethodMain {

    public static void main(String[] args) {
        final RealtorServiceImpl realtorService = new RealtorServiceImpl(null, null, null);

      /*  realtorService.buy();
        realtorService.sell();
        realtorService.sign();
*/
        RealtorServiceImpl.signAgreement
                (
                        realtor -> realtor.fillAddress("AAA123")
                                          .fillBuyer("BBB")
                                          .fillSeller("CCC")
                                          .sign()
                );
    }
}
