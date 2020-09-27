package com.nordea.validator;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.File;

import static com.nordea.util.FileUtil.getFileExtension;
import static java.util.Arrays.asList;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ArgumentValidator {

    public static void validate(final String[] arguments) {
        final int numberOfArguments = arguments.length;
        if (numberOfArguments != 2) {
            throw new RuntimeException("number of arguments is [" + numberOfArguments + "] but should be 2");
        }
        final String inputFilePath = arguments[0];
        if (!new File(inputFilePath).exists()) {
            throw new RuntimeException("path [" + inputFilePath + "] does not exist");
        }
        final String fileExtension = getFileExtension(arguments[1]);
        if (!asList("xml", "csv").contains(fileExtension)) {
            throw new RuntimeException("unsupported output file extension : [" + fileExtension + "]");
        }
    }
}
