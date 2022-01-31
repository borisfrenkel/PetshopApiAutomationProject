package petshop.tests;

import com.fasterxml.jackson.databind.JsonNode;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.hc.core5.http.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import java.io.IOException;
import java.util.ArrayList;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(PetshopAfterTestExecutionCallback.class)
public class FindByStatusTests extends BaseTest {
    @Test
    public void callFindByStatusApiWithStatusEqAvailableVerifyHttpStatus() throws IOException, ParseException {
        CloseableHttpResponse response = httpClientHelper.Get("https://petstore3.swagger.io/api/v3/pet/findByStatus", "status=available");

        Assertions.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getCode(), "Test failed");
    }

    @Test
    public void callFindByStatusApiWithStatusEqPendingVerifyHttpStatus() throws IOException, ParseException {
        CloseableHttpResponse response = httpClientHelper.Get("https://petstore3.swagger.io/api/v3/pet/findByStatus", "status=pending");

        Assertions.assertEquals(HttpStatus.SC_OK, response.getCode(), "Test failed");
    }

    @Test
    public void callFindByStatusApiWithStatusEqSoldVerifyHttpStatus() throws IOException, ParseException {
        CloseableHttpResponse response = httpClientHelper.Get("https://petstore3.swagger.io/api/v3/pet/findByStatus", "status=sold");

        Assertions.assertEquals(HttpStatus.SC_OK, response.getCode(), "Test failed");
    }

    @Test
    public void callFindByStatusApiWithInputParameterEqNullVerifyHttpStatus() throws IOException, ParseException {
        CloseableHttpResponse response = httpClientHelper.Get("https://petstore3.swagger.io/api/v3/pet/findByStatus", null);

        Assertions.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getCode(), "Test failed");
    }

    @Test
    public void callFindByStatusApiWithStatusEqAvailableVerifyResponseBody() throws IOException, ParseException {
        String jsonResponseBodyString = httpClientHelper.getResponseBody("https://petstore3.swagger.io/api/v3/pet/findByStatus", "status=available");
        ArrayList<JsonNode> lionsList = jsonHelper.getJsonObjectFilteredByName(jsonResponseBodyString, "Lion");

        Assertions.assertTrue(lionsList.size() > 0, "Test failed");
    }
}
