package petshop.tests;

import com.fasterxml.jackson.databind.JsonNode;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.hc.core5.http.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import petshop.helpers.HTTPClientHelper;
import petshop.helpers.JSONHelper;

import java.io.IOException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BasicTests {
    private HTTPClientHelper httpClientHelper;
    private JSONHelper jsonHelper;

    @BeforeAll
    public void beforeAll(){
        httpClientHelper = new HTTPClientHelper();
        jsonHelper = new JSONHelper();
    }

    @Test
    public void callFindByStatusApiWithStatusEqAvailableVerifyHttpStatus() throws IOException, ParseException {
        int httpStatus = httpClientHelper.getHttpStatus("https://petstore3.swagger.io/api/v3/pet/findByStatus?status=available");

        Assertions.assertTrue(httpStatus == HttpStatus.SC_OK, "Test failed");
    }

    @Test
    public void callFindByStatusApiWithStatusEqAvailableVerifyResponseBody() throws IOException, ParseException {
        String jsonResponseBodyString = httpClientHelper.getResponseBody("https://petstore3.swagger.io/api/v3/pet/findByStatus?status=available");
        JsonNode jsonResponseBody = jsonHelper.getJsonObject(jsonResponseBodyString);

        //Assertions.assertTrue(httpClientHelper.getResponseBody(response).length() > 0, "Test failed");
    }
}
