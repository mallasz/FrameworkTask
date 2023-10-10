package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorPage extends BasePage{
    @FindBy(css = "#cloud-site > devsite-iframe > iframe")
    private WebElement outerFrame;

    @FindBy(css = "#myFrame")
    private WebElement innerFrame;

    @FindBy(id = "input_98")
    private WebElement numberOfInstancesField;

    @FindBy(id = "input_99")
    private WebElement instancesForField;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_90']//div[@class='md-text']")
    private WebElement operatingSystemField;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_91']//div[normalize-space(text())='Regular']")
    private WebElement provisioningModelField;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_92']//div[normalize-space(text())='General purpose']")
    private WebElement machineFamilyField;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_93']")
    private WebElement seriesField;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_94']//div")
    private WebElement machineTypeField;

    @FindBy(xpath = "//div[@class='md-label' and contains(text(),'Add GPUs.')]/preceding-sibling::div[contains(@class,'md-container md-ink-ripple')]")
    private WebElement addGPUsCheckbox;

    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    private WebElement gpuTypeField;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_504']//div[@class='md-text ng-binding']")
    private WebElement numberOfGPUsField;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_463']//div[@class='md-text ng-binding']")
    private WebElement localSSDField;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_96']//div[@class='md-text ng-binding']")
    private WebElement datacenterLocationField;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_97']//div[@class='md-text']")
    private WebElement committedUsageField;

    @FindBy(xpath = "//button[contains(text(),'Add to Estimate')]")
    private WebElement addToEstimateButton;

    @FindBy(xpath = "//button[@id='Email Estimate']")
    private WebElement emailEstimateButton;

    @FindBy(xpath = "//b[contains(.,'Total Estimated Cost')]")
    private WebElement calculatorResult;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailField;

    @FindBy(xpath = "//button[contains(.,'Send Email')]")
    private WebElement sendEmailButton;

    private static final Pattern TOTAL_ESTIMATED_COST_PATTERN = Pattern.compile("Total Estimated Cost:\s+(.*)\s+per");

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected CalculatorPage openPage() {
        return null;
    }

    public CalculatorPage switchFrames() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(outerFrame));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(innerFrame));
        return this;
    }

    public CalculatorPage selectCalculatorType(String buttonText) {
        waitForWebElementLocatedBy(String.format("//md-pagination-wrapper//span[contains(.,'%s')]", buttonText)).click();
        return this;
    }

    public CalculatorPage setNumberOfInstances(String value) {
        waitForWebElement(numberOfInstancesField).sendKeys(value);
        return this;
    }

    public CalculatorPage clearInstancesForField() {
        waitForWebElement(instancesForField).clear();
        return this;
    }

    public CalculatorPage selectOperatingSystem(String value) {
        waitForWebElement(operatingSystemField).click();
        waitForWebElementLocatedBy(String.format("//md-option[@id='select_option_100']/div[normalize-space(text())='%s']", value)).click();
        return this;
    }

    public CalculatorPage setProvisioningModel(String value) {
        waitForWebElement(provisioningModelField).click();
        waitForWebElementLocatedBy(String.format("//md-option[@id='select_option_113']//div[normalize-space(text())='%s']", value)).click();
        return this;
    }

    public CalculatorPage setMachineFamily(String value) {
        waitForWebElement(machineFamilyField).click();
        waitForWebElementLocatedBy(String.format("//md-option[@id='select_option_117']//div[normalize-space(text())='%s']", value)).click();
        return this;
    }

    public CalculatorPage setSeries(String value) {
        waitForWebElement(seriesField).click();
        waitForWebElementLocatedBy(String.format("//md-option[@id='select_option_220']/div[text()[contains(.,'%s')]]", value)).click();
        return this;
    }

    public CalculatorPage setMachineType(String value) {
        waitForWebElement(machineTypeField).click();
        waitForWebElementLocatedBy(String.format("//*[@id='select_option_469']/div[@class='md-text ng-binding' and normalize-space(text())='%s']", value)).click();
        return this;
    }

    public CalculatorPage addGPUs(String type, String count) {
        waitForWebElement(addGPUsCheckbox).click();

        waitForWebElement(gpuTypeField).click();
        waitForWebElementLocatedBy(String.format("//div[@class='md-text ng-binding' and contains(text(),'%s')]", type)).click();

        waitForWebElement(numberOfGPUsField).click();
        waitForWebElementLocatedBy(String.format("//md-option[@id='select_option_515']//div[contains(text(),'%s')]", count)).click();
        return this;
    }

    public CalculatorPage setLocalSSD(String value) {
        waitForWebElement(localSSDField).click();
        waitForWebElementLocatedBy(String.format("//md-option/div[contains(text(),'%s')]", value)).click();
        return this;
    }

    public CalculatorPage setDatacenterLocation(String value) {
        waitForWebElement(datacenterLocationField).click();
        waitForWebElementLocatedBy(String.format("//md-option[@id='select_option_263']//div[contains(text(),'%s')]", value)).click();
        return this;
    }

    public CalculatorPage setCommittedUsage(String value) {
        waitForWebElement(committedUsageField).click();
        waitForWebElementLocatedBy(String.format("//md-option[@id='select_option_136']//div[contains(text(),'%s')]", value)).click();
        return this;
    }

    public CalculatorPage clickAddToEstimateButton() {
        waitForWebElement(addToEstimateButton).click();
        return this;
    }

    public CalculatorPage clickEmailEstimateButton() {
        waitForWebElement(emailEstimateButton).click();
        return this;
    }

    public String getCalculatorResult() {;
        String result = waitForWebElement(calculatorResult).getText();
        Matcher m = TOTAL_ESTIMATED_COST_PATTERN.matcher(result);
        return m.find() ? m.group(1) : null;
    }

    public CalculatorPage setEmail(String email) {
        waitForWebElement(emailField).sendKeys(email);
        return this;
    }

    public CalculatorPage clickSendEmailButton() {
        waitForWebElement(sendEmailButton).click();
        return this;
    }
}
