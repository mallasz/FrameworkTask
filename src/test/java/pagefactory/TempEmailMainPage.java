package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class TempEmailMainPage extends BasePage {
    private static final String PAGE_URL = "https://yopmail.com/";

    @FindBy(xpath = "//button[@id='accept']")
    private WebElement acceptButton;

    @FindBy(xpath = "//a[@title='Generate a random email address']")
    private WebElement generateEmailButton;

    @FindBy(id = "geny")
    private WebElement generatedEmail;

    @FindBy(xpath = "//button/span[text()='Check Inbox']")
    private WebElement checkInboxButton;

    public TempEmailMainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public TempEmailMainPage openPage() {
        driver.get(PAGE_URL);
        return this;
    }

    public TempEmailMainPage acceptPrivacyTerms() {
        waitForWebElement(acceptButton).click();
        return this;
    }

    public TempEmailMainPage generateEmail() {
        boolean retry = true;
        while(retry) {
            waitForWebElement(generateEmailButton).click();
            //Check if the page was redirected (possibly to an advertisement page)
            if(isRedirected()) {
                driver.navigate().back();
            }
            else
                retry = false;
        }
        return this;
    }

    public String getGeneratedEmailAddress() {
        return waitForWebElement(generatedEmail).getText();
    }

    public TempEmailInboxPage checkInbox() {
        waitForWebElement(checkInboxButton).click();
        return new TempEmailInboxPage(driver);
    }

    private boolean isRedirected() {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(driver.getCurrentUrl()).openConnection();
            connection.setRequestMethod("HEAD");
            connection.setInstanceFollowRedirects(false);
            connection.connect();

            int responseCode = connection.getResponseCode();
            return responseCode >= 300 && responseCode < 400;
        } catch (IOException e) {
            System.err.println("Error checking redirection: " + e.getMessage());
            return false;
        }
    }
}
