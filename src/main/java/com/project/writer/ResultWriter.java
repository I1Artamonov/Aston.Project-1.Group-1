package com.project.writer;

import java.io.IOException;

public interface ResultWriter<T> {
    void write(Iterable<T> data) throws IOException;
}