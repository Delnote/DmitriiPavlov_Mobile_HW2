package scenarios.hooks;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import setup.DriverSetup;

@Test
public class Hooks extends DriverSetup {

    @BeforeGroups("native")
    public void setUpNative() throws Exception {
        driverSetUp("native");
        prepareDriver();
        System.out.println("Driver prepared");
    }

    @BeforeGroups("web")
    public void setUpWeb() throws Exception {
        driverSetUp("web");
        prepareDriver();
        System.out.println("Driver prepared");
    }

    @AfterClass(description = "Close driver on all tests completion", groups = {"web", "native"})
    public void tearDown() throws Exception {
        driver().quit();
        System.out.println("Driver closed");
    }
}