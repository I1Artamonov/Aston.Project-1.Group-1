package com.project.writer;

@FunctionalInterface
public interface Formatter<T> {
    String format(T value);

    static <T> Formatter<T> defaultFormatter() {
        return String::valueOf;
    }
}