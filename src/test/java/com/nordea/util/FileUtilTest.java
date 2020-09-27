package com.nordea.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FileUtilTest {

    @Test
    @DisplayName("should return file extension")
    void fileExtension() {
        // given
        final String filePath = "C:\\Users\\test\\Desktop\\small.in";
        final String expectedExtension = "in";

        // when
        final String actualExtension = FileUtil.getFileExtension(filePath);

        // then
        assertThat(actualExtension).isEqualTo(expectedExtension);
    }

    @Test
    @DisplayName("should return full path if no extension")
    void noExtension() {
        // given
        final String filePath = "C:\\Users\\test\\Desktop\\small";

        // when
        final String actualExtension = FileUtil.getFileExtension(filePath);

        // then
        assertThat(actualExtension).isEqualTo(filePath);
    }
}
