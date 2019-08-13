package setup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class DriverSetup extends TestProperties {

    protected AppiumDriver driverSingle = null;
    protected DesiredCapabilities capabilities;
    private WebDriverWait waitSingle;

    // properties to be read from properties
    private String AUT;
    protected String SUT;
    private String TEST_PLATFORM;
    private String DRIVER;
    private String DEVICE;

    // constructor initializes properties on driver creation
    protected void driverSetUp(String type) throws IOException {
        AUT = getProp(type, "aut");
        String t_sut = getProp(type, "sut");
        SUT = t_sut == null ? null : "http://" + t_sut;
        TEST_PLATFORM = getProp(type, "platformName");
        DRIVER = getProp(type, "driver");
        DEVICE = getProp(type, "deviceName");
    }

    // initialize driver with appropriate capabilities depending on platform and application
    protected void prepareDriver() throws Exception {
        capabilities = new DesiredCapabilities();
        String browserName;

        // setup test platform: Android or iOS. Browser also depends on a platform.
        switch(TEST_PLATFORM){
            case "Android":
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,DEVICE);
                browserName = "Chrome";
                break;
            case "iOS":
                browserName = "Safari";
                break;
            default:
                throw new Exception("Unknown mobile platform");
        }
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, TEST_PLATFORM);

        // setup type of application: mobile / web (or hybrid)
        if (AUT != null && SUT == null) {
            // Native
            File app = new File(AUT);
            capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        } else if (SUT != null && AUT == null) {
            // Web
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);
        } else {
            throw new Exception("Unclear type of mobile app");
        }

        // init driver for local Appium server with set capabilities have been set
        if (driverSingle == null) {
            driverSingle = new AppiumDriver(new URL(DRIVER), capabilities);
        }
        // set an object to handle timeouts
        if (waitSingle == null) {
            waitSingle = new WebDriverWait(driver(), 10);
        }
    }

    protected AppiumDriver driver() throws Exception {
        if (driverSingle == null) {
            prepareDriver();
        }
        return driverSingle;
    }

    protected WebDriverWait driverWait() {
        return waitSingle;
    }
}

