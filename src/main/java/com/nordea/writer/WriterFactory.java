package com.nordea.writer;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;

import static com.nordea.util.FileUtil.getFileExtension;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WriterFactory {

    public static Writer getWriter(final String filePath) throws IOException, XMLStreamException {
        return getFileExtension(filePath).equals("xml")
                ? new XmlWriter(filePath)
                : new CsvWriter(filePath);
    }
}
