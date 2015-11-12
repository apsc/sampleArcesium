package com.arcesium.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by amanpsc on 12/11/15.
 */
public class DataSourceProperties extends Properties {
    public DataSourceProperties (String fileName) throws IOException {
        super();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
        load(inputStream);
    }
}
