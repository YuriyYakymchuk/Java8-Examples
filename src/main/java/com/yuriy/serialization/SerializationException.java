package com.yuriy.serialization;

/**
 * Created by Kucya on 11.09.2017.
 */
public class SerializationException extends RuntimeException {

    public SerializationException(final String message) {
        super(message);
    }

    public SerializationException(final Throwable ex) {
        super(ex);
    }
}
