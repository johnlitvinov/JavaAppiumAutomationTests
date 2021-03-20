import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
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


public class Ex5 {

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
    public void ex5()
    {
        // SEARCH FIRST ITEM AND ADD IT TO THE FOLDER
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
                "Can't find 'Kotlin Island'",
                10
        );

        WebElement element1 = waitForElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Can't find title 'Kotlin Island'",
                10
        );

        //Assert
        String title1 = element1.getAttribute("text");
        Assert.assertEquals(
                "We see unexpected text",
                "Kotlin Island",
                title1
        );


        waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc=\"More options\"]"),
                "Can't find text 'Add to reading list'",
                5
        );


        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Add to reading list')]"),
                "Can't find text 'Add to reading list'",
                5
        );

        waitForElementAndClick(
                By.id("org.wikipedia:id/onboarding_button"),
                "Can't find 'Got it' button ",
                10
        );

        waitForElementAndClear(
                By.id("org.wikipedia:id/text_input"),
                "Can't clear text",
                10
        );

        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/text_input"),
                "Kotlin_folder",
                "Can't input text",
                10
        );

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'OK')]"),
                "Can't find button 'OK'",
                5
        );

        waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Can't find button 'X'",
                5
        );

        waitForElementAndClick(
                By.xpath("//android.widget.FrameLayout[@content-desc=\"My lists\"]/android.widget.ImageView"),
                "Can't find button 'MyList'",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Kotlin_folder')]"),
                "Can't find folder 'Kotlin_folder'",
                5
        );

        WebElement element2 =  waitForElementPresent(
                By.xpath("//*[contains(@text,'Kotlin Island')]"),
                "Can't find text 'Kotlin Island'",
                5
        );

        //Assert
        String title2 = element2.getAttribute("text");
        Assert.assertEquals(
                "We see unexpected text",
                "Kotlin Island",
                title2
        );

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Kotlin_folder')]"),
                "Can't find folder 'Kotlin_folder'",
                5
        );

        driver.navigate().back();

        waitForElementAndClick(
                By.xpath("//android.widget.FrameLayout[@content-desc=\"Explore\"]/android.widget.ImageView"),
                "Can't find button 'Explore'",
                5
        );


        // SEARCH SECOND ITEM AND ADD IT TO THE FOLDER
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
                By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[6]/android.widget.LinearLayout/android.widget.TextView[1]"),
                "Kotline",
                10
        );


        WebElement element3 = waitForElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Can't find title 'Kotline'",
                10
        );

        //Assert
        String title3 = element1.getAttribute("text");
        Assert.assertEquals(
                "We see unexpected text",
                "Kotline",
                title3
        );



        waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc=\"More options\"]"),
                "Can't find text 'Add to reading list'",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Add to reading list')]"),
                "Can't find text 'Add to reading list'",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Kotlin_folder')]"),
                "Can't find text 'Kotlin_folder'",
                5
        );

        waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Can't find button 'X'",
                5
        );

        waitForElementAndClick(
                By.xpath("//android.widget.FrameLayout[@content-desc=\"My lists\"]/android.widget.ImageView"),
                "Can't find button 'MyList'",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Kotlin_folder')]"),
                "Can't find folder 'Kotlin_folder'",
                15
        );



        //CHECK ITEMS IN THE FOLDER

        WebElement element4 =  waitForElementPresent(
                By.xpath("//*[contains(@text,'Kotlin Island')]"),
                "Can't find text 'Kotlin Island'",
                10
        );
        //Assert
        String title4 = element4.getAttribute("text");
        Assert.assertEquals(
                "We see unexpected text",
                "Kotlin Island",
                title4
        );


        WebElement element5 =  waitForElementPresent(
                By.xpath("//*[contains(@text,'Kotline')]"),
                "Can't find text 'Kotline'",
                10
        );

        //Assert
        String title5 = element5.getAttribute("text");
        Assert.assertEquals(
                "We see unexpected text",
                "Kotline",
                title5
        );

        swipeElementToLeft(
                By.xpath("//*[contains(@text,'Kotline')]"),
                "Can't delete  text 'Kotline'"
        );

        waitForElementNotPresent(
                By.xpath("//*[contains(@text,'Kotline')]"),
                "Can't delete 'Kotline'",
                15
        );


        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Kotlin Island')]"),
                "Can't find 'Kotlin Island'",
                10
        );

        WebElement element6 = waitForElementPresent(
                By.xpath("//*[contains(@text,'Kotlin Island')]"),
                "Can't find title 'Kotlin Island'",
                10
        );

        //Assert
        String title6 = element6.getAttribute("text");
        Assert.assertEquals(
                "We see unexpected text",
                "Kotlin Island",
                title6
        );

    }// end test






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

    protected void swipeElementToLeft(By by, String error_message){

        WebElement element = waitForElementPresent(
                by,
                error_message,
                10
        );

        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_y) / 2;


        TouchAction action = new TouchAction(driver);
        action .press(right_x, middle_y)
                .waitAction(150)
                .moveTo(left_x,middle_y)
                .release()
                .perform();
    }
} //end class

