package com.nordea.preparator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class WordPreparatorTest {

    private static WordPreparator wordPreparator;

    @BeforeAll
    static void setUp() {
        wordPreparator = new WordPreparator();
    }

    @Test
    @DisplayName("should return only words in the given sentence")
    void onlyWords() {
        // given
        final List<String> expectedWords = asList("Whoever", "is", "happy", "will", "make", "others", "happy", "too");
        final String sentence = "   Whoever: !is! @#$happy  \n      will,make others happy too.";

        // when
        final List<String> actualWords = wordPreparator.fetchWordsFromSentence(sentence);

        // then
        assertThat(actualWords).isEqualTo(expectedWords);
    }

    @Test
    @DisplayName("should return empty list when no words in the sentence")
    void noWords() {
        // given
        final String sentence = "  @#$,!! !!....";

        // when
        final List<String> actualWords = wordPreparator.fetchWordsFromSentence(sentence);

        // then
        assertThat(actualWords).isEmpty();
    }
}
