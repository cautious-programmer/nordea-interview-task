package com.nordea.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
@JacksonXmlRootElement(localName = "sentence")
public class Sentence {

    private static long index;
    @JsonProperty("word")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<String> words;

    public Sentence(List<String> words) {
        index++;
        this.words = words;
    }

    @JsonIgnore
    public long getIndex() {
        return index;
    }

    public static Sentence createSentenceWithSortedWords(final List<String> words) {
        Collections.sort(words, String::compareToIgnoreCase);
        return new Sentence(words);
    }
}
