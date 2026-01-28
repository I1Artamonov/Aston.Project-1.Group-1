package com.project.writer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Objects;

public class TextFileWriter<T> extends AbstractWriter<T> {

    private final Path file;
    private final Charset charset;
    private BufferedWriter writer;

    public TextFileWriter(Path file) {
        this(file, Charset.forName("UTF-8"), Formatter.defaultFormatter());
    }

    public TextFileWriter(Path file, Charset charset, Formatter<T> formatter) {
        super(formatter);
        this.file = Objects.requireNonNull(file);
        this.charset = Objects.requireNonNull(charset);
    }

    @Override
    protected void beforeWrite() throws IOException {
        writer = Files.newBufferedWriter(
                file,
                charset,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
        );
    }

    @Override
    protected void writeLine(String line) throws IOException {
        writer.write(line);
        writer.newLine();
    }

    @Override
    protected void close() throws IOException {
        if (writer != null) {
            writer.close();
        }
    }
}
