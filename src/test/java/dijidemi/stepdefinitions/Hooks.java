package dijidemi.stepdefinitions;


import dijidemi.utilities.Driver;
import io.cucumber.java.*;
import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.slf4j.*;



public class Hooks {

    private static final Logger log = LoggerFactory.getLogger(Hooks.class);
    private static boolean setUpIsDone = false;

    @Before(order=1)
    public void setup1(Scenario scenario) {

        if (setUpIsDone) {
        } else {
            log.info("===============================================================");
            log.info("|          Test is Starting...");
            log.info("|          Operating System : " + System.getProperty("os.name"));
            log.info("===============================================================\n");
            setUpIsDone = true;
        }
    }

    @Before(order=2)
    public void setup2(Scenario scenario) {
        log.info("===============================================================");
        log.info("|          Scenario Name: " + scenario.getName());
        log.info("===============================================================");
    }





    @After
    public void tearDown(Scenario scenario){ final byte[]screenshot=((TakesScreenshot)
        Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        if (scenario.isFailed()){
        scenario.attach(screenshot,"image/png","screenshots");
    }
        Driver.closeDriver();
    }
}
