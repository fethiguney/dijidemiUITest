package dijidemi.utilities;

import dijidemi.ClickType;
import dijidemi.stepdefinitions.DijidemiSteps;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertTrue;


public class ReusableMethods {

   static Actions actions=new Actions(Driver.getDriver());
   static JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

   public static void click(WebElement element, ClickType clickType){
       switch (clickType) {
           case DEFAULT:
               element.click();
               break;
           case ACTIONS:
               actions.moveToElement(element).click().perform();
               break;
           case JSEXECUTOR:
               js.executeScript("arguments[0].scrollIntoView(true);", element);
               js.executeScript("arguments[0].click()", element);
       }
   }
   //sample of usage click(submitButton, ClickType.ACTIONS);



    public static void switchToIframe(WebElement webElement) {
        Driver.getDriver().switchTo().frame(webElement);
    }

    public static String getScreenshot(String name) throws IOException {
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        String target = System.getProperty("user.dir") + "/target/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        FileUtils.copyFile(source, finalDestination);
        return target;
    }

    public static WebElement waitForVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }


}
