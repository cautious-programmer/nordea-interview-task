package com.nordea.holder;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class XmlMapperHolder {

    private static final XmlMapper XML_MAPPER = new XmlMapper();

    public static XmlMapper get() {
        return XML_MAPPER;
    }
}
