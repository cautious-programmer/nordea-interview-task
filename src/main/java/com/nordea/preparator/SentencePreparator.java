package com.nordea.preparator;

import lombok.extern.slf4j.Slf4j;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

import static com.nordea.CornerCases.isCornerCase;

@Slf4j
public class SentencePreparator {

    private final BreakIterator breakIterator;
    private final StringBuilder stringBuilder;

    public SentencePreparator() {
        breakIterator = BreakIterator.getSentenceInstance();
        stringBuilder = new StringBuilder();
    }

    public List<String> fetchSentencesFromLine(final String nextLine) {

        final List<String> sentences = new ArrayList<>();
        breakIterator.setText(nextLine);
        int start = breakIterator.first();

        for (int end = breakIterator.next();
             end != BreakIterator.DONE;
             start = end, end = breakIterator.next()) {

            final String sentence = nextLine.substring(start, end).trim();

            if (isCornerCase(sentenceWithoutSpaces(sentence))) {
                log.debug("corner case sentence [{}], will continue in next line", sentence);
                stringBuilder.append(" ").append(sentence);
            } else if (isEndOfSentence(sentence)) {
                sentences.add(stringBuilder.append(" ").append(sentence).toString().trim());
                stringBuilder.setLength(0);
            } else {
                log.debug("[{}] is not complete sentence, will continue in next line", sentence);
                stringBuilder.append(" ").append(sentence);
            }
        }

        return sentences;
    }

    private String sentenceWithoutSpaces(String sentence) {
        return sentence.replace(" ", "");
    }

    private boolean isEndOfSentence(final String sentence) {
        return sentence.endsWith(".") || sentence.endsWith("?") || sentence.endsWith("!");
    }
}
