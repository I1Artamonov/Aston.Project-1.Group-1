package com.project.writer;

import java.io.IOException;
import java.io.PrintStream;

public class ConsoleWriter<T> extends AbstractWriter<T> {

    private final PrintStream out;

    public ConsoleWriter() {
        this(System.out, Formatter.defaultFormatter());
    }

    public ConsoleWriter(PrintStream out, Formatter<T> formatter) {
        super(formatter);
        this.out = out;
    }

    @Override
    protected void writeLine(String line) throws IOException {
        out.println(line);
    }
}
