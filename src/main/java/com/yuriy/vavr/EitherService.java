package com.yuriy.vavr;

import com.yuriy.model.Figure;
import com.yuriy.model.ObjectType;
import com.yuriy.model.Person;
import io.vavr.control.Either;

/**
 * Created by Kucya on 15.09.2017.
 */
public class EitherService {

    public Either<Person, Figure> getObject(final ObjectType type) {
        switch (type) {
            case PERSON:
                return Either.left(new Person("Yuriy", 28, Person.SEX.MALE));
            case FIGURE:
                return Either.right(new Figure(2.0, 3.4, Figure.TYPE.SINGLE));
            default:
                return Either.left(null);
        }
    }
}
