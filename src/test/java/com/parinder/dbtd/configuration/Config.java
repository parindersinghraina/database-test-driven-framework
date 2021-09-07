package com.parinder.dbtd.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

    protected Properties properties;

    public Config() throws IOException {
        this.properties = new Properties();

        // LOAD TARGET ENVIRONMENT CONFIG FILE
        String targetEnvironmentConfigFilePath = "configuration/environment.config.properties";
        this.loadPropertiesFile(targetEnvironmentConfigFilePath);
    }

    public void loadPropertiesFile(String filePath) throws IOException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        File file = new File(classLoader.getResource(filePath).getFile());
        FileInputStream fileInputStream = new FileInputStream(file);
        this.properties.load(fileInputStream);
        fileInputStream.close();
    }

    public String getProperty(String propertyName) {
        return properties.getProperty(propertyName);
    }
}
