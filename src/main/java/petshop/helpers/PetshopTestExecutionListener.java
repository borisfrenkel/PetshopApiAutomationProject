package petshop.helpers;

import org.springframework.core.Ordered;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListener;

public class PetshopTestExecutionListener implements TestExecutionListener, Ordered {
    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public void beforeTestClass(TestContext testContext) throws Exception {
        TestExecutionListener.super.beforeTestClass(testContext);
    }

    @Override
    public void prepareTestInstance(TestContext testContext) throws Exception {
        TestExecutionListener.super.prepareTestInstance(testContext);
    }

    @Override
    public void beforeTestMethod(TestContext testContext) throws Exception {
        TestExecutionListener.super.beforeTestMethod(testContext);
    }

    @Override
    public void beforeTestExecution(TestContext testContext) throws Exception {
        TestExecutionListener.super.beforeTestExecution(testContext);
    }

    @Override
    public void afterTestExecution(TestContext testContext) throws Exception {
        TestExecutionListener.super.afterTestExecution(testContext);
    }

    @Override
    public void afterTestMethod(TestContext testContext) throws Exception {
        TestExecutionListener.super.afterTestMethod(testContext);
    }

    @Override
    public void afterTestClass(TestContext testContext) throws Exception {
        TestExecutionListener.super.afterTestClass(testContext);
    }
}
