package dijidemi.pages;

import dijidemi.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {

    @FindBy (xpath = "//div[starts-with (@class, 'header-button d-none')]//a[@href='/Login']")
    public WebElement loginLink;






    public HomePage() {PageFactory.initElements(Driver.getDriver(), this);}
}
