package dijidemi.utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Q {

    public static void main(String[] args) {

        WebDriver driver=new ChromeDriver();
        driver.get("chrome://settings/clearBrowserData");

        JavascriptExecutor js= (JavascriptExecutor) driver;

        WebElement shadowHost=driver.findElement(By.cssSelector("settings-ui"));
        SearchContext shadowRoot1= (SearchContext) js.executeScript("return arguments[0].shadowRoot", shadowHost);
        WebElement shadowContent1=shadowRoot1.findElement(By.cssSelector("settings-main"));

        SearchContext shadowRoot2= (SearchContext) js.executeScript("return arguments[0].shadowRoot", shadowContent1);
        WebElement shadowContent2=shadowRoot2.findElement(By.cssSelector("settings-basic-page"));

        SearchContext shadowRoot3= (SearchContext) js.executeScript("return arguments[0].shadowRoot", shadowContent2);
        WebElement shadowContent3=shadowRoot3.findElement(By.cssSelector("settings-privacy-page"));

        SearchContext shadowRoot4= (SearchContext) js.executeScript("return arguments[0].shadowRoot", shadowContent3);
        WebElement shadowContent4=shadowRoot4.findElement(By.cssSelector("settings-clear-browsing-data-dialog"));

        SearchContext shadowRoot5= (SearchContext) js.executeScript("return arguments[0].shadowRoot", shadowContent4);
        WebElement clearDataButton=shadowRoot5.findElement(By.cssSelector("#clearBrowsingDataConfirm"));

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(clearDataButton));

        clearDataButton.click();

    }
}
