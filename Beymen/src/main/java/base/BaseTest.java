package base;

import Utilities.StepInit;
import org.testng.annotations.AfterMethod;

import java.time.Duration;

import static base.Driver.setDriver;

public class BaseTest {

    public static void setupTest(String browser) {
        setDriver(browser);
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        StepInit.init();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (Driver.getDriver() != null) {
            Driver.getDriver().quit();
        }


    }


}
