package com.nordea.preparator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SentencePreparatorTest {

    private SentencePreparator sentencePreparator;

    @BeforeEach
    void setUp() {
        sentencePreparator = new SentencePreparator();
    }

    @Test
    @DisplayName("should return sentences for corner cases")
    void cornerCase() {
        // given
        final String firstExpectedSentence = "My name is Mr. Robot.";
        final String secondExpectedSentence = "And name is Mr. Flesh!";
        final String line = firstExpectedSentence + " " + secondExpectedSentence;

        // when
        final List<String> actualSentences = sentencePreparator.fetchSentencesFromLine(line);

        // then
        assertThat(actualSentences).containsExactly(firstExpectedSentence, secondExpectedSentence);
    }

    @Test
    @DisplayName("should return sentences from the line")
    void sentences() {
        // given
        final String expectedFirstSentence = "This is first sentence.";
        final String expectedSecondSentence = "This is second sentence!";
        final String expectedThirdSentence = "This is third sentence?";
        final String line = expectedFirstSentence + " " + expectedSecondSentence + " " + expectedThirdSentence;

        // when
        final List<String> actualSentences = sentencePreparator.fetchSentencesFromLine(line);

        // then
        assertThat(actualSentences)
                .containsExactly(expectedFirstSentence, expectedSecondSentence, expectedThirdSentence);
    }

    @Test
    @DisplayName("should return empty list when no sentence in line")
    void noSentences() {
        // given
        final String line = "This is not a sentence";

        // when
        final List<String> actualSentences = sentencePreparator.fetchSentencesFromLine(line);

        // then
        assertThat(actualSentences).isEmpty();
    }
}
