package com.yuriy.java8.reflection;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Kucya on 12.09.2017.
 */
@Data
@Setter
public class SingletonService {

    private static SingletonService instance;

    private final String name;

    private SingletonService(final String name){
        this.name = name;
    }

    public static SingletonService getInstance() {
        return instance == null ? new SingletonService("Instance") : instance;
    }
}
