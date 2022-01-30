package petshop.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import petshop.helpers.HTTPClientHelper;
import petshop.helpers.JSONHelper;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseTest {
    protected HTTPClientHelper httpClientHelper;
    protected JSONHelper jsonHelper;
    // assumes the current class is called MyLogger
    protected Logger LOGGER = null;

    @BeforeAll
    public void beforeAll(){
        LOGGER = Logger.getLogger(this.getClass().getName());
        httpClientHelper = new HTTPClientHelper(LOGGER);
        jsonHelper = new JSONHelper();
    }

    @BeforeEach
    public void beforeEach(TestInfo testInfo){
        LOGGER.log(Level.INFO, "Test " + testInfo.getDisplayName() + " is started");
    }

    @AfterEach
    public void afterEach(TestInfo testInfo){
        LOGGER.log(Level.INFO, "Test " + testInfo.getDisplayName() + " is started");
    }

}
