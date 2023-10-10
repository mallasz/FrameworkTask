package test;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import pagefactory.BasePage;
import utils.DataStorage;
import utils.TestListener;

@Listeners({TestListener.class})
public abstract class BaseTest {
    protected WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        driver = DriverSingleton.getDriver();
    }

    @AfterTest
    public void afterTest() {
        DataStorage.clearData();
        DriverSingleton.closeDriver();
    }

    protected void openNewTab() {
        BasePage.openNewTab();
    }

    protected void switchToNextTab() {
        BasePage.switchToNextTab();
    }
}
