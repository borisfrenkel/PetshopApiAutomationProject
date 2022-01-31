package petshop.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import petshop.helpers.HTTPClientHelper;
import petshop.helpers.JSONHelper;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseTest implements AfterTestExecutionCallback {
    protected HTTPClientHelper httpClientHelper;
    protected JSONHelper jsonHelper;
    // assumes the current class is called MyLogger
    protected static Logger LOGGER = null;

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

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
        if(extensionContext.getExecutionException().isPresent()){
            LOGGER.log(Level.INFO, "Test " + extensionContext.getDisplayName() + " failed with " + extensionContext.getExecutionException());
        }
        else {
            LOGGER.log(Level.INFO, "Test " + extensionContext.getDisplayName() + " succeeded");
        }
    }
}
