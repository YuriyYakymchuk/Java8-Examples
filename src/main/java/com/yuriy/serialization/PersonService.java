package com.yuriy.serialization;

import com.yuriy.java8.exception.ExceptionService;
import com.yuriy.model.*;

import java.io.*;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by Kucya on 11.09.2017.
 */
public class PersonService {

    public void serializePerson(final BiFunction<Person, String, Boolean> function, final Person person, final String fileName) {
       function.apply(person, fileName);
    }

    public Person deserializePerson(final SerializationFunction<String, Person, IOException, FileNotFoundException, ClassNotFoundException> serializationFunction, final String fileName) {
        try {
            return serializationFunction.apply(fileName);
        } catch (Exception ex) {
            throw new SerializationException(ex);
        }
    }
}
