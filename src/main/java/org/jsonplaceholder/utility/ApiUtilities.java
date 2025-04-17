package org.jsonplaceholder.utility;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

import java.io.InputStream;

import static io.restassured.RestAssured.given;

public class ApiUtilities {

    public ApiUtilities(PropertiesRead propertiesRead) {
        // Constructor logic if needed
    }

    private static io.restassured.specification.RequestSpecification configureRequest() {
        return given().contentType(ContentType.JSON);
    }

    /**
     * Sends a POST request with the given body and URL.
     */
    public Response sendPostRequest(String bodyRequest, String url) {
        return configureRequest()
                .body(bodyRequest)
                .post(url)
                .then()
                .extract()
                .response();
    }

    /**
     * Sends a GET request to the given URL.
     */
    public Response sendGetRequest(String url) {
        return configureRequest()
                .get(url)
                .then()
                .extract()
                .response();
    }

    /**
     * Sends a GET request with query parameters and validates the response schema.
     */
    public Response sendGetRequestWithQuery(String url, String key, String value, String schemaFile) {
        InputStream schema = getClass().getClassLoader().getResourceAsStream(schemaFile);
        if (schema == null) {
            throw new IllegalArgumentException("Schema file not found: " + schemaFile);
        }

        return configureRequest()
                .param(key, value)
                .get(url)
                .then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(schema))
                .extract()
                .response();
    }

    /**
     * Sends a PUT request with the given body and URL.
     */
    public Response sendPutRequest(String bodyRequest, String url) {
        return configureRequest()
                .body(bodyRequest)
                .put(url)
                .then()
                .extract()
                .response();
    }

    /**
     * Sends a DELETE request to the given URL.
     */
    public Response sendDeleteRequest(String url) {
        return configureRequest()
                .delete(url)
                .then()
                .extract()
                .response();
    }
}