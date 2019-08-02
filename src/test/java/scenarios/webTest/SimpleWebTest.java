package scenarios.webTest;

import io.restassured.RestAssured;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import scenarios.hooks.Hooks;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

@Test(groups = "web")
public class SimpleWebTest extends Hooks {

    public SimpleWebTest() throws IOException {
        super("web");
    }

    public void webTest() throws Exception{
        driver().get(SUT);
        driverWait().until(ExpectedConditions.urlToBe(SUT + "/"));
        assertEquals(RestAssured.get("http://www.iana.org/").getStatusCode(), 200, "Status code error (not 200)");
        assertEquals(driver().getTitle(), "Internet Assigned Numbers Authority", "Site title error");
        assertEquals(driver().getCurrentUrl(), "http://www.iana.org/", "Site full url error");
        System.out.println("Site opening done");
    }
}
