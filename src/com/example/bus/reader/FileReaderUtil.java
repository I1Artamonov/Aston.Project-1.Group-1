package com.example.bus.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderUtil {

    public List<String> readLines(String path) {
        try {
            return Files.lines(Path.of(path))
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения файла", e);
        }
    }
}
