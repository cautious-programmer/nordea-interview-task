package com.nordea.writer;

import com.nordea.model.Sentence;

import java.util.stream.Stream;

public interface Writer extends AutoCloseable {

    void write(Stream<Sentence> sentences);
}
