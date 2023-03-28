package dijidemi.pages;

import dijidemi.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.WeakHashMap;

public class HomePage {

    @FindBy (xpath = "(//a[@href='/Login'])[2]")
    public WebElement loginLink;






    public HomePage() {PageFactory.initElements(Driver.getDriver(), this);}
}
