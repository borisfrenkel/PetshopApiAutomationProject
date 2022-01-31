package petshop.tests;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class PetshopAfterTestExecutionCallback implements AfterTestExecutionCallback {
    @Override
    public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
        if(extensionContext.getExecutionException().isPresent()){
            System.out.println("Test " + extensionContext.getDisplayName() + " failed with " + extensionContext.getExecutionException());
        }
        else {
            System.out.println("Test " + extensionContext.getDisplayName() + " succeeded");
        }
    }
}
