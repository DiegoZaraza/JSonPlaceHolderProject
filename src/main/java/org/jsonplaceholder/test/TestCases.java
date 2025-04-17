package org.jsonplaceholder.test;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestCases extends BaseClass {

    private static final String POSTS_ENDPOINT = "posts";
    private static final String POST_ID_ENDPOINT = "posts/1";

    private Response response;

    /**
     * Validates through the response schema if the id field is numeric.
     */
    @Test(priority = 1)
    public void getPostUser() {
        Reporter.log("Test Cases - Get Post User", true);
        setResponse(apiUtilities.sendGetRequestWithQuery(POSTS_ENDPOINT, "userId", String.valueOf(getPosts().getUserId()), "PostUserSchema.json"));
        Assert.assertEquals(getResponse().statusCode(), 200);
    }

    /**
     * Sends a POST request to register a new publication with random data.
     */
    @Test(priority = 2)
    public void postNewPost() {
        Reporter.log("Test Cases - Post New Post", true);

        Faker faker = new Faker();
        getPosts().setTitle(faker.book().title());
        getPosts().setBody(faker.book().author());

        setResponse(apiUtilities.sendPostRequest(new Gson().toJson(getPosts()), POSTS_ENDPOINT));
        Assert.assertEquals(getResponse().statusCode(), 201);
        Assert.assertEquals(getResponse().jsonPath().getString("userId"), String.valueOf(getPosts().getUserId()));
    }

    /**
     * Sends a PUT request to update an existing post.
     */
    @Test(priority = 3)
    public void putPost() {
        Reporter.log("Test Cases - Put Post", true);

        Faker faker = new Faker();
        getPosts().setTitle(faker.book().title());
        getPosts().setBody(faker.book().author());

        setResponse(apiUtilities.sendPutRequest(new Gson().toJson(getPosts()), POST_ID_ENDPOINT));
        Assert.assertEquals(getResponse().statusCode(), 200);
        Assert.assertEquals(getResponse().jsonPath().getString("userId"), String.valueOf(getPosts().getUserId()));
    }

    /**
     * Sends a DELETE request to remove a post.
     */
    @Test(priority = 4)
    public void deletePost() {
        Reporter.log("Test Cases - Delete Post", true);

        setResponse(apiUtilities.sendDeleteRequest(POST_ID_ENDPOINT));
        Assert.assertEquals(getResponse().statusCode(), 200);
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}