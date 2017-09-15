package com.yuriy.java8.lazy;

import java.util.function.Supplier;

/**
 * Created by Kucya on 07.09.2017.
 */
public class HeavyObjectHolder {

    private Supplier<HeavyObject> heavyObjectSupplier = () -> createAndCacheHeavyObject();

    private synchronized HeavyObject createAndCacheHeavyObject() {
        class HeavyObjectFactory implements Supplier<HeavyObject> {

            private final HeavyObject instance = new HeavyObject("Heavy field");

            @Override
            public HeavyObject get() {
                System.out.println("Getting an instance");
                return instance;
            }
        }

        if(!HeavyObjectFactory.class.isInstance(heavyObjectSupplier)) {
            System.out.println("Creating factory");
            heavyObjectSupplier = new HeavyObjectFactory();
        }

        return heavyObjectSupplier.get();
    }

    public HeavyObject getHeavyObject() {
        System.out.println("Getting heavy object");
        return heavyObjectSupplier.get();
    }

}
