package com.nordea;

import com.nordea.parser.FileParser;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

import static com.nordea.validator.ArgumentValidator.validate;

@Slf4j
public class Application {

    public static void main(String[] args) throws Exception {
        log.info("application has started");
        validate(args);
        log.info("passed application parameters are : [{}]", Arrays.toString(args));
        new FileParser(args[0], args[1]).parse();
        log.info("application has finished");
    }
}
