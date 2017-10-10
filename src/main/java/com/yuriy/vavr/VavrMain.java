package com.yuriy.vavr;

import com.yuriy.model.Figure;
import com.yuriy.model.ObjectType;
import com.yuriy.model.Person;
import io.vavr.control.Either;
import io.vavr.control.Try;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Kucya on 15.09.2017.
 */
public class VavrMain {

    private static TryService tryService = new TryService();
    private static EitherService eitherService = new EitherService();
    private static LamdaService lamdaService = new LamdaService();

    public static void main(String[] args) {
        lambdaMethod();
    }

    private static void lambdaMethod() {
        final Try<String> result = lamdaService.functionalMethod(() -> "A");
        System.out.println("Result is: " + result.getOrElseThrow(() -> new RuntimeException("Wrong")));
    }

    private static void eitherMethod() {
        Either<Person, Figure> result = eitherService.getObject(ObjectType.PERSON);

        if(result.isRight()) {
            System.out.println("Right result is: " + result.get());
        } else {
            System.out.println("Left result is: " + result.getLeft());
        }
    }

    private static void tryMethod() {
        Try<List<Person>> result = tryService.getPersons("Aaa");

        if(result.isFailure()) {
            System.err.println("Something went wrong: " + result.getCause().getMessage());
        } else {
            System.out.println(result.getOrElse(() -> {return Arrays.asList();}));
        }
    }
}
