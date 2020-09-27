package com.nordea.integration;

import org.junit.jupiter.api.AfterEach;

import java.io.File;

abstract class AbstractIT {

    final String inputFilePath = "src/test/resources/small.in";
    final String outputCsvFilePath = "src/test/resources/small.csv";
    final String outputXmlFilePath = "src/test/resources/small.xml";

    @AfterEach
    void cleanUp() {
        new File(outputCsvFilePath).delete();
        new File(outputXmlFilePath).delete();
    }
}
