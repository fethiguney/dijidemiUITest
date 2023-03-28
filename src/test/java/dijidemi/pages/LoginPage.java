package dijidemi.pages;

import dijidemi.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy (css = "input#txtUserName")
    public WebElement username;

    @FindBy (css = "input#txtPassword")
    public WebElement password;

    @FindBy (css = "a#btnLogin")
    public WebElement loginButton;


    public LoginPage() {PageFactory.initElements(Driver.getDriver(), this); }
}
