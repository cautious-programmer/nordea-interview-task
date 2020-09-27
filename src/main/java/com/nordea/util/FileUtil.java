package com.nordea.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FileUtil {

    public static String getFileExtension(final String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }
}
