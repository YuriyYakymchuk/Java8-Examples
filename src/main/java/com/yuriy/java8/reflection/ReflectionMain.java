package com.yuriy.java8.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

/**
 * Created by Kucya on 12.09.2017.
 */
public class ReflectionMain {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException {
        createSingleton();
    }

    private static void createSingleton() throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        final Class singleton = Class.forName("com.yuriy.java8.reflection.SingletonService");
        final Constructor constructor = singleton.getDeclaredConstructors()[0];
        constructor.setAccessible(true);

        Stream.of(singleton.getDeclaredMethods()).forEach(System.out::println);

        SingletonService fistInstance = (SingletonService) constructor.newInstance("Name 1");
        SingletonService secondInstance = (SingletonService) constructor.newInstance("Name 2");

        System.out.println(fistInstance.getName());
        System.out.println(secondInstance.getName());

    }
}
