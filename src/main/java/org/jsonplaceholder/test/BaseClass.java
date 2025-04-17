package org.jsonplaceholder.test;

import io.restassured.RestAssured;
import org.jsonplaceholder.models.Posts;
import org.jsonplaceholder.utility.ApiUtilities;
import org.jsonplaceholder.utility.PropertiesRead;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {

    protected static final String CONFIG_FILE = "config.properties";
    protected static final String URL_KEY = "URL";
    protected static final String TIME_RESPONSE_KEY = "TIME_RESPONSE";

    protected static String baseURL;
    protected static long timeResponse;
    protected static ApiUtilities apiUtilities;
    protected static PropertiesRead propertiesRead;
    private Posts posts;

    /**
     * Sets up the application before running tests.
     */
    @BeforeClass
    public void setupApplication() {
        Reporter.log("=====Base Class Setup Started=====", true);
        propertiesRead = new PropertiesRead();
        apiUtilities = new ApiUtilities(propertiesRead);
        propertiesRead.getPropertiesFile(CONFIG_FILE);

        RestAssured.baseURI = propertiesRead.returnProperties(URL_KEY);
        timeResponse = Long.parseLong(propertiesRead.returnProperties(TIME_RESPONSE_KEY));
        posts = new Posts();
        Reporter.log("=====Base Class Setup Complete=====", true);
    }

    /**
     * Cleans up after tests are completed.
     */
    @AfterClass
    public void closeApplication() {
        Reporter.log("=====Session End=====", true);
    }

    public Posts getPosts() {
        return posts;
    }

    public void setPosts(Posts posts) {
        this.posts = posts;
    }
}