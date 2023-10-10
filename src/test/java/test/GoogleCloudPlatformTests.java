package test;

import model.CalculatorSettings;
import model.CalculatorType;
import model.Email;
import org.testng.annotations.Test;
import pagefactory.CalculatorPage;
import pagefactory.GoogleCloudMainPage;
import pagefactory.TempEmailMainPage;
import service.CalculatorSettingReader;
import service.CalculatorTypeCreator;
import service.EmailCreator;
import utils.DataStorage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;


public class GoogleCloudPlatformTests extends BaseTest {

    @Test
    public void calculatorTest() {
        openCalculator();

        configureCalculator();

        openNewTab();

        generateEmail();

        switchToNextTab();

        sendEmail();

        switchToNextTab();

        verifyEmailContent();
    }

    private void openCalculator() {
        CalculatorType calculatorType = CalculatorTypeCreator.withDataFromProperty();

        new GoogleCloudMainPage(driver)
                .openPage()
                .agreePrivacyTerms()
                .fillInSearchField(calculatorType.getGoogleSearchTerm())
                .openSearchResult(calculatorType.getGoogleSearchResult());
    }

    private void configureCalculator() {
        CalculatorSettings settings = CalculatorSettingReader.getCalculatorSettingsCSVFromProperty();
        CalculatorType calculatorType = CalculatorTypeCreator.withDataFromProperty();

        String calculatedValue = new CalculatorPage(driver)
                .switchFrames()
                .selectCalculatorType(calculatorType.getCalculatorType())
                .setNumberOfInstances(settings.getNumberOfInstances())
                .clearInstancesForField()
                .selectOperatingSystem(settings.getOperatingSystem())
                .setProvisioningModel(settings.getProvisioningModel())
                .setMachineFamily(settings.getMachineFamily())
                .setSeries(settings.getSeries())
                .setMachineType(settings.getMachineType())
                .addGPUs(settings.getGpuType(), settings.getGpuCount())
                .setLocalSSD(settings.getSsd())
                .setDatacenterLocation(settings.getLocation())
                .setCommittedUsage(settings.getCommittedUsage())
                .clickAddToEstimateButton()
                .getCalculatorResult();
        DataStorage.addData("calculatedValue", calculatedValue);
    }

    private void generateEmail() {
        Email email = EmailCreator.setEmailSubjectFromProperty();
        email.setEmailAddress(
            new TempEmailMainPage(driver)
                .openPage()
                .acceptPrivacyTerms()
                .generateEmail()
                .getGeneratedEmailAddress());
        DataStorage.addData("email", email);
    }

    private void sendEmail() {
        new CalculatorPage(driver)
                .switchFrames()
                .clickEmailEstimateButton()
                .setEmail(((Email) DataStorage.getData("email")).getEmailAddress())
                .clickSendEmailButton();
    }

    private void verifyEmailContent() {
        String emailValue = new TempEmailMainPage(driver)
                .checkInbox()
                .refreshUntilEmailReceived(((Email) DataStorage.getData("email")).getEmailSubject())
                .getTotalEstimatedMonthlyCost();

        assertThat(DataStorage.getData("calculatedValue").toString(), is(equalTo(emailValue)));
    }
}
