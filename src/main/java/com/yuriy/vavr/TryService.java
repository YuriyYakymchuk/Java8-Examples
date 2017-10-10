package com.yuriy.vavr;

import com.yuriy.model.Person;
import io.vavr.control.Try;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by Kucya on 15.09.2017.
 */
public class TryService {

    public Try<List<Person>> getPersons(final String department) {
        if(department == null) {
            return Try.failure(new IllegalArgumentException("Department is null"));
        }
        return Try.of(() -> Arrays.asList(new Person("Yuriy", 28, Person.SEX.MALE), new Person("Halya", 31, Person.SEX.FEMALE)));
    }
}
