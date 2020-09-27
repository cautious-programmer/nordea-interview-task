package com.nordea;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CornerCases {

    private static final List<String> CORNER_CASES = new ArrayList<>();

    static {
        CORNER_CASES.add("Mr.");
    }

    public static boolean isCornerCase(final String sentence) {
        return CORNER_CASES.stream().anyMatch(sentence::endsWith);
    }
}
