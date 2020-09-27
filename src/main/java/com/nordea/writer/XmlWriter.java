package com.nordea.writer;

import com.nordea.holder.XmlMapperHolder;
import com.nordea.model.Sentence;
import lombok.extern.slf4j.Slf4j;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

@Slf4j
public class XmlWriter implements Writer {

    private final FileWriter fileWriter;
    private final XMLStreamWriter xmlStreamWriter;

    public XmlWriter(String fileName) throws IOException, XMLStreamException {
        fileWriter = new FileWriter(fileName, StandardCharsets.UTF_8, true);
        final XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newFactory();
        xmlStreamWriter = xmlOutputFactory.createXMLStreamWriter(fileWriter);
        log.info("writing to XML file : [{}]", fileName);
    }

    @Override
    public void write(final Stream<Sentence> sentences) {
        try {
            xmlStreamWriter.writeStartDocument();
            xmlStreamWriter.writeStartElement("text");
            sentences.forEach(this::writeValue);
            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeEndDocument();
        } catch (XMLStreamException ex) {
            throw new RuntimeException("exception has occurred while creating xml template", ex);
        }
    }

    private void writeValue(final Sentence sentence) {
        try {
            XmlMapperHolder.get().writeValue(xmlStreamWriter, sentence);
        } catch (IOException ex) {
            throw new RuntimeException("exception has occurred while writing sentence : [" + sentence + "]", ex);
        }
    }

    @Override
    public void close() throws Exception {
        xmlStreamWriter.close();
        fileWriter.close();
    }
}
