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


public class Ex3 {

    private AppiumDriver driver;

    @Before
    public void setUp()throws Exception
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","Pixel");
        capabilities.setCapability("platformVersion","11");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("appPackage","org.wikipedia");
        capabilities.setCapability("appActivity",".main.MainActivity");
        capabilities.setCapability("app","/Users/apple/Desktop/JavaAppiumAutomationTests/apks/org.wikipedia.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown()throws Exception
    {
        driver.quit();
    }

    @Test
    public void ex3() throws Exception {
        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Can't find text 'Search Wikipedia'",
                5
        );

        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                "Kotlin",
                "",
                10
        );

        waitForElementAndClick(
                By.id("org.wikipedia:id/view_card_header_title"),
                "Kotlin (programming language)",
                10
        );

        WebElement element = waitForElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Can't find title 'Kotlin (programming language)'",
                10
        );

        //Assert
        String title = element.getAttribute("text");
        Assert.assertEquals(
                "We see unexpected text",
                "Kotlin (programming language)",
                title
        );


        driver.navigate().back();

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Can't find text 'Search Wikipedia'",
                5
        );

        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                "Kotlin",
                "",
                10
        );

        waitForElementAndClick(
                By.id("org.wikipedia:id/horizontal_scroll_list_item_text"),
                "Kotlin Island",
                10
        );


        WebElement element2 = waitForElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Can't find title 'Kotlin Island'",
                10
        );

        //Assert
        String title2 = element.getAttribute("text");
        Assert.assertEquals(
                "We see unexpected text",
                "Kotlin Island",
                title2
        );

        driver.navigate().back();

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Can't find text 'Search Wikipedia'",
                5
        );

        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                "Kotlin",
                "",
                10
        );

        waitForElementAndClear(
                By.id("org.wikipedia:id/search_src_text"),
                "Can't clear text",
                10
        );


        waitForElementAndClick(
                By.id("org.wikipedia:id/search_close_btn"),
                "Can't find Find X 'button'",
                5
        );

        waitForElementNotPresent(
                By.id("org.wikipedia:id/search_close_btn"),
                "Find X 'button'",
                5
        );
    }// test end



    private WebElement waitForElementPresent(By by, String error_message, long timeoutSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    private WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.click();
        return element;
    }

    private WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }

    private boolean waitForElementNotPresent(By by, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );
    }

    private WebElement waitForElementAndClear(By by, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.clear();
        return element;
    }
} //end class

