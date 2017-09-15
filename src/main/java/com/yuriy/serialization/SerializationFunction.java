package com.yuriy.serialization;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Kucya on 11.09.2017.
 */
@FunctionalInterface
public interface SerializationFunction <T,U, X extends IOException, Y extends FileNotFoundException, Z extends ClassNotFoundException> {

    U apply(T t) throws X, Y, Z;
}
