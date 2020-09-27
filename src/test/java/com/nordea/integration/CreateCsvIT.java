package com.nordea.integration;

import com.nordea.parser.FileParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

class CreateCsvIT extends AbstractIT {

    @Test
    @DisplayName("should create csv file")
    void createCsv() throws Exception {
        // given
        final String expectedCsv =
                "sentence1,a,because,Chinese,couldn't,I,isn't,mother,my,perhaps,tongue,understand,word\n" +
                        "sentence2,around,furious,he,I,just,marching,Mr,standing,there,was,was,watching,Young\n";

        // when
        new FileParser(inputFilePath, outputCsvFilePath).parse();

        // then
        final String actualCsv = Files.readString(Paths.get(outputCsvFilePath));
        assertThat(actualCsv).isEqualTo(expectedCsv);
    }
}
