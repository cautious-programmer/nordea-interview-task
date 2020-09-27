package com.nordea;

import com.nordea.parser.FileParser;

import static com.nordea.validator.ArgumentValidator.validate;

public class Application {

    public static void main(String[] args) {
        validate(args);
        new FileParser(args[0], args[1]);
    }
}
