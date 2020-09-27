package com.nordea.writer;

import com.nordea.model.Sentence;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

@Slf4j
public class CsvWriter implements Writer {

    private final FileWriter fileWriter;
    private final BufferedWriter bufferedWriter;

    public CsvWriter(String fileName) throws IOException {
        fileWriter = new FileWriter(fileName, StandardCharsets.UTF_8, true);
        bufferedWriter = new BufferedWriter(fileWriter);
        log.info("writing to CSV file : [{}]", fileName);
    }

    @Override
    public void write(final Stream<Sentence> sentences) {
        sentences.map(this::toCsv).forEach(this::writeText);
    }

    private String toCsv(final Sentence sentence) {
        return "sentence" + sentence.getIndex() + "," + String.join(",", sentence.getWords()) + "\n";
    }

    private void writeText(final String text) {
        try {
            bufferedWriter.write(text);
        } catch (IOException ex) {
            throw new RuntimeException("exception has occurred while writing text : [" + text + "]", ex);
        }
    }

    @Override
    public void close() throws IOException {
        bufferedWriter.close();
        fileWriter.close();
    }
}
