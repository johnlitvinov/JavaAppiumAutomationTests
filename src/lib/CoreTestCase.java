package lib;

import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import lib.ui.WelcomePageObject;
import org.openqa.selenium.ScreenOrientation;

public class CoreTestCase extends TestCase {

    protected AppiumDriver driver;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        driver = Platform.getInstance().getDriver();
        this.rotateScreenToPortrait();
        this.skipWelcomeScreensForIOSapp();
    }

    @Override
    protected void tearDown() throws Exception {
        driver.quit();
        super.tearDown();
    }

    protected void rotateScreenToPortrait() {
        driver.rotate(ScreenOrientation.PORTRAIT);
    }

    private void skipWelcomeScreensForIOSapp() throws InterruptedException {
        if (Platform.getInstance().isIOS()) {
            WelcomePageObject welcomePageObject = new WelcomePageObject(driver);
            welcomePageObject.goThroughWelcomePages();
        }
    }
}//end class
