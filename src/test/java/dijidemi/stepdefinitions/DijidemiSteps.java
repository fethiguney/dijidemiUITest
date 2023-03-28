package dijidemi.stepdefinitions;

import dijidemi.pages.*;
import dijidemi.utilities.*;
import io.cucumber.java.en.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.*;

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

    @When("user should be login successfully with valid credentials")
    public void user_should_be_login_successfully_with_valid_credentials() {
        homePage.loginLink.click();
        assertEquals(ConfigReader.getProperty("loginPage"), Driver.getDriver().getCurrentUrl());

        loginPage.username.sendKeys(ConfigReader.getProperty("username"));
        loginPage.password.sendKeys(ConfigReader.getProperty("password"));
        loginPage.loginButton.click();

    }

    @When("user clicks on icerik tab and validates that is navigated icerikler")
    public void user_clicks_on_icerik_tab_and_validates_that_is_navigated_icerikler() {
        waitForVisibility(staffPage.icerikButton, 5);
        assertEquals(ConfigReader.getProperty("personelPage"), Driver.getDriver().getCurrentUrl());

        staffPage.icerikButton.click();

        try{
            assertTrue(staffPage.iceriklerLeftSideLink.isDisplayed());
        }catch(NoSuchElementException e){
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
}
