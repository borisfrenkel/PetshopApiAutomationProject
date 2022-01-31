package petshop.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import petshop.helpers.HTTPClientHelper;
import petshop.helpers.JSONHelper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseTest implements AfterTestExecutionCallback {
    protected HTTPClientHelper httpClientHelper;
    protected JSONHelper jsonHelper;
    protected static Logger LOGGER = null;
    protected String URL;

    @BeforeAll
    public void beforeAll() throws IOException {
        LOGGER = Logger.getLogger(this.getClass().getName());
        httpClientHelper = new HTTPClientHelper(LOGGER);
        jsonHelper = new JSONHelper();

        final String dir = System.getProperty("user.dir");
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/main/resources/config.properties");
        properties.load(fileInputStream);
        URL = properties.getProperty("URL");
    }

    @BeforeEach
    public void beforeEach(TestInfo testInfo){
        LOGGER.log(Level.INFO, "Test " + testInfo.getDisplayName() + " is started");
    }

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
        if(extensionContext.getExecutionException().isPresent()){
            LOGGER.log(Level.WARNING, "Test " + extensionContext.getDisplayName() + " failed with " + extensionContext.getExecutionException());
        }
        else {
            LOGGER.log(Level.INFO, "Test " + extensionContext.getDisplayName() + " succeeded");
        }
    }
}
