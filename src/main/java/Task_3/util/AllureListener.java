package Task_3.util;

import io.qameta.allure.junit4.AllureJunit4;
import Task_3.steps.BaseSteps;
import org.junit.runner.notification.Failure;

public class AllureListener extends AllureJunit4 {

    @Override
    public void testFailure(Failure failure){
        BaseSteps.takeScreenshot();
        super.testFailure(failure);
    }
}