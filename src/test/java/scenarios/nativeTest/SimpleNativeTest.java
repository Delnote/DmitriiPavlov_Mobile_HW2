package scenarios.nativeTest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import scenarios.hooks.Hooks;

import java.io.IOException;

import static enums.AppLocators.*;
import static org.testng.Assert.assertTrue;

@Test(groups = "native")
public class SimpleNativeTest extends Hooks {

    private String appPackageName = "com.example.android.contactmanager:id/";

    @Test(description = "example of simple native test", groups = "native")
    public void nativeTest() {

        driverSingle.findElement(By.id(appPackageName + ADD_CONTACT_BUTTON.getLocator())).click();

        assertTrue(elementIsDisplayed(TARGET_ACCOUNT.getLocator()));
        assertTrue(elementIsDisplayed(CONTACT_NAME.getLocator()));
        assertTrue(elementIsDisplayed(CONTACT_PHONE.getLocator()));
        assertTrue(elementIsDisplayed(CONTACT_PHONE_TYPE.getLocator()));
        assertTrue(elementIsDisplayed(CONTACT_EMAIL.getLocator()));
        assertTrue(elementIsDisplayed(CONTACT_EMAIL_TYPE.getLocator()));
        assertTrue(elementIsDisplayed(CONTACT_SAVE_BUTTON.getLocator()));

        System.out.println("Simplest Appium test done");
    }

    public boolean elementIsDisplayed(String locator) {
        return driverSingle.findElement(By.id(appPackageName + locator)).isDisplayed();
    }

}
