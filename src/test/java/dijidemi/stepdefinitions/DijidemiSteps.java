package dijidemi.stepdefinitions;

import dijidemi.pages.*;
import dijidemi.utilities.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.*;

import java.util.List;
import java.util.Map;

import static dijidemi.utilities.ReusableMethods.*;
import static org.junit.Assert.*;

public class DijidemiSteps {

    private static final Logger log = LoggerFactory.getLogger(DijidemiSteps.class);

    HomePage homePage=new HomePage();
    LoginPage loginPage=new LoginPage();
    StaffPage staffPage=new StaffPage();

    @Given("user goes to dijidemi url")
    public void user_goes_to_dijidemi_url() {
        Driver.getDriver().get(ConfigReader.getProperty("dijidemiUrl"));
    }

    @When("^user should (not login|be login) with (invalid|valid) credentials$")
    public void user_should_not_login_with_invalid_credential(String status, String input) {
        homePage.loginLink.click();
        assertEquals(ConfigReader.getProperty("loginPage"), Driver.getDriver().getCurrentUrl());

        if (status.equalsIgnoreCase("not login")){
            if (input.equalsIgnoreCase("invalid")){
                loginPage.username.sendKeys(ConfigReader.getProperty("invalidUsername"));
                loginPage.password.sendKeys(ConfigReader.getProperty("invalidPassword"));
            }
        } else if (status.equalsIgnoreCase("be login")) {
            if (input.equalsIgnoreCase("valid")) {
                loginPage.username.sendKeys(ConfigReader.getProperty("validUsername"));
                loginPage.password.sendKeys(ConfigReader.getProperty("validPassword"));
            }
        }
        loginPage.loginButton.click();

    }


    @When("user clicks on icerik tab and validates that is navigated icerikler")
    public void user_clicks_on_icerik_tab_and_validates_that_is_navigated_icerikler() {
        waitForVisibility(staffPage.icerikButton, 5);
        assertEquals(ConfigReader.getProperty("personelPage"), Driver.getDriver().getCurrentUrl());

        staffPage.icerikButton.click();
        assertTrue(staffPage.iceriklerLeftSideLink.isDisplayed());


        try{
            int numOfImages=staffPage.images.size();
            System.out.println("numofimages :"+numOfImages);
            for (int i = 0; i <numOfImages ; i++) {
                staffPage.images.get(i).isDisplayed();
            }

        }catch(IndexOutOfBoundsException e){
            log.error(String.format("Error occurred when doing the page loading: %s", e));
            log.error(String.format("Error occurred when doing the page loading: %s", e.getMessage()));
        }

    }
    @Then("user clicks on the {int} st content and validates that it is loaded")
    public void user_clicks_on_the_st_content_and_validates_that_it_is_loaded(Integer num) {
        int orderOfContent=num-1;
        staffPage.gosterButton.get(orderOfContent).click();
        switchToIframe(staffPage.iframe);

        try{
            assertTrue(staffPage.pdfTextLayer.isDisplayed());
        }catch(NoSuchElementException e){
            log.error(String.format("Error occurred when doing the layer loading: %s", e));
            log.error(String.format("Error occurred when doing the layer loading: %s", e.getMessage()));
        }


    }


    @Then("validate that user is warned {string} message")
    public void validateThatUserIsWarnedMessage(String message) {
        assertTrue(loginPage.alertMessage.getText().contains(message));
    }
}
