package com.example.bus.testmanual;

import com.example.bus.reader.FileReaderUtil;

public class ReaderTest {

    public static void main(String[] args) {
        FileReaderUtil reader = new FileReaderUtil();
        reader.readLines("buses.txt")
                .forEach(System.out::println);
    }
}
