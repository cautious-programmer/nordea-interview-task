package com.nordea.preparator;

import lombok.extern.slf4j.Slf4j;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Character.isLetterOrDigit;
import static java.text.BreakIterator.DONE;

@Slf4j
public class WordPreparator {

    private final BreakIterator breakIterator;

    public WordPreparator() {
        breakIterator = BreakIterator.getWordInstance();
    }

    public List<String> fetchWordsFromSentence(final String sentence) {

        final List<String> words = new ArrayList<>();
        breakIterator.setText(sentence);
        int lastIndex = breakIterator.first();

        while (lastIndex != DONE) {
            final int firstIndex = lastIndex;
            lastIndex = breakIterator.next();
            if (lastIndex != DONE && isLetterOrDigit(sentence.charAt(firstIndex))) {
                words.add(sentence.substring(firstIndex, lastIndex));
            }
        }
        log.debug("found [{}] words in [{}]", words.size(), sentence);

        return words;
    }
}
