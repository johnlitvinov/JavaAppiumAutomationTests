import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.URL;

public class Ex2 {

    private AppiumDriver driver;

    @Before
    public void setUp()throws Exception
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platforName","Android");
        capabilities.setCapability("deviceName","Pixel");
        capabilities.setCapability("platformVersion","11");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("appPackage","org.wikipedia");
        capabilities.setCapability("appActivity",".main.MainActivity");
        capabilities.setCapability("app","/Users/apple/Desktop/JavaAppiumAutomationTests/apks/org.wikipedia.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }

    @Test
    public void checkText() {
        WebElement title_element = assertElementHasText(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Can't find text 'Search Wikipedia'",
                3
        );

        String article_title = title_element.getAttribute("text");

        Assert.assertEquals(
                "We don't see expected text",
                "Search Wikipedia",
                article_title
        );
    }

    private WebElement assertElementHasText(By by, String error_message, long timeoutInSec)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSec);
        wait.withMessage(error_message + "\n");
        return  wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }
}//end class
