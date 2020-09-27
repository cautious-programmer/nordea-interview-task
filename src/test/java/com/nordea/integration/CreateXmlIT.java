package com.nordea.integration;

import com.nordea.parser.FileParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

class CreateXmlIT extends AbstractIT {

    @Test
    @DisplayName("should create xml file")
    void createXml() throws Exception {
        // given
        final String expectedXml =
                "<?xml version='1.0' encoding='UTF-8'?><text><sentence><word>a</word><word>because</word><word>Chines" +
                        "e</word><word>couldn't</word><word>I</word><word>isn't</word><word>mother</word><word>my</wo" +
                        "rd><word>perhaps</word><word>tongue</word><word>understand</word><word>word</word></sentence" +
                        "><sentence><word>around</word><word>furious</word><word>he</word><word>I</word><word>just</w" +
                        "ord><word>marching</word><word>Mr</word><word>standing</word><word>there</word><word>was</wo" +
                        "rd><word>was</word><word>watching</word><word>Young</word></sentence></text>";

        // when
        new FileParser(inputFilePath, outputXmlFilePath).parse();

        // then
        final String actualXml = Files.readString(Paths.get(outputXmlFilePath));
        assertThat(actualXml).isEqualTo(expectedXml);
    }
}
