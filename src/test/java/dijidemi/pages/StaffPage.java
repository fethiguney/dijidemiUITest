package dijidemi.pages;

import dijidemi.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class StaffPage {

    @FindBy (css = "div#dashIcerik")
    public WebElement icerikButton;

    @FindBy (css = ".btn.renk.yesil")
    public List<WebElement> gosterButton;

    @FindBy (xpath = "(//div[@class='textLayer'])[1]")
    public WebElement pdfTextLayer;

    @FindBy (xpath = "(//span[@id='LftIcerikler'])[2]")
    public WebElement iceriklerLeftSideLink;

    @FindBy (xpath = "//iframe")
    public WebElement iframe;

    @FindBy (tagName = "img")
    public List<WebElement> images;





    public StaffPage() {PageFactory.initElements(Driver.getDriver(), this);}
}
