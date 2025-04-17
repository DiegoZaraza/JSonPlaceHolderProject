package org.jsonplaceholder.utility;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesRead {
    private final Properties environment;

    public PropertiesRead() {
        this.environment = new Properties();
    }

    /**
     * Loads the properties file from the given path.
     *
     * @param propertiesURL the path to the properties file
     */
    public void getPropertiesFile(String propertiesURL) {
        ClassLoader loader = getClass().getClassLoader();
        try (InputStream inputEnvironment = loader.getResourceAsStream(propertiesURL)) {
            if (inputEnvironment == null) {
                throw new IllegalArgumentException("Properties file not found: " + propertiesURL);
            }
            environment.load(inputEnvironment);
        } catch (IOException exc) {
            throw new RuntimeException("Error loading properties file: " + propertiesURL, exc);
        }
    }

    /**
     * Returns the value of the specified property key.
     *
     * @param key the property key
     * @return the property value
     */
    public String returnProperties(String key) {
        return environment.getProperty(key);
    }
}