package com.yuriy.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Kucya on 01.09.2017.
 */
@Data
public class Person implements Serializable{

    private static final long serialVersionUID = -5217965838535990254L;

    @java.beans.ConstructorProperties({"name", "age", "sex"})
    public Person(String name, int age, SEX sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public enum SEX {MALE, FEMALE};

    private final String name;

    private final int age;

    private final SEX sex;

    private String city;
}
