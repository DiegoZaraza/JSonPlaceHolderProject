package org.jsonplaceholder.utility;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

public class PropertiesRead {
    private static final String FILE_NOT_FOUND_ERROR = "Properties file not found: ";
    private static final String FILE_LOADING_ERROR = "Error loading properties file: ";
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
        try (InputStream inputEnvironment = getClass().getClassLoader().getResourceAsStream(propertiesURL)) {
            if (inputEnvironment == null) {
                throw new IllegalArgumentException(FILE_NOT_FOUND_ERROR + propertiesURL);
            }
            environment.load(inputEnvironment);
        } catch (IOException exc) {
            throw new RuntimeException(FILE_LOADING_ERROR + propertiesURL, exc);
        }
    }

    /**
     * Returns the value of the specified property key.
     *
     * @param key the property key
     * @return the property value
     */
    public String returnProperties(String key) {
        return Optional.ofNullable(environment.getProperty(key))
                .orElseThrow(() -> new IllegalArgumentException("Property not found: " + key));
    }
}