package com.nordea.parser;

import com.nordea.model.Sentence;
import com.nordea.preparator.SentencePreparator;
import com.nordea.preparator.WordPreparator;
import com.nordea.writer.Writer;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Stream;

import static com.nordea.writer.WriterFactory.getWriter;
import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.Files.lines;
import static java.nio.file.Paths.get;

@RequiredArgsConstructor
public class FileParser {

    private final String inputFilePath;
    private final String outputFilePath;

    public void parse() throws Exception {
        final SentencePreparator sentencePreparator = new SentencePreparator();
        final WordPreparator wordPreparator = new WordPreparator();

        try (Writer writer = getWriter(outputFilePath);
             Stream<String> lines = lines(get(inputFilePath), UTF_8)) {
            final Stream<Sentence> sentences = lines
                    .map(sentencePreparator::fetchSentencesFromLine)
                    .flatMap(List::stream)
                    .map(wordPreparator::fetchWordsFromSentence)
                    .map(Sentence::createSentenceWithSortedWords);
            writer.write(sentences);
        }
    }
}
