package petshop.helpers;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HTTPClientHelper {
    protected Logger LOGGER;

    public HTTPClientHelper(Logger logger) {
        LOGGER = logger;
    }

    public CloseableHttpResponse Get(String URL, String inputParameters) throws IOException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            final HttpGet httpGet = new HttpGet(URL + "?" + inputParameters);

            long startTime = System.nanoTime();
            CloseableHttpResponse response = httpClient.execute(httpGet);
            long elapsedTime = System.nanoTime() - startTime;
            double elapsedTimeInSecond = (double) elapsedTime / 1_000_000_000;

            LOGGER.log(Level.INFO, "This REST API response time is " + elapsedTimeInSecond + " seconds");

            return response;
        }
    }

    public String getResponseBody(String URL, String inputParameters) throws IOException, ParseException {
        try(CloseableHttpResponse response = Get(URL, inputParameters)){
            return EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
        }
    }
}