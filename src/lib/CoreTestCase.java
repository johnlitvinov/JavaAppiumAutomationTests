package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

public class CoreTestCase extends TestCase {

    protected AppiumDriver driver;
    private static String AppiumURL = "http://127.0.0.1:4723/wd/hub";
    private static final String PLATFORM_IOS = "ios";
    private static final String PLATFORM_ANDROID = "android";


    @Override
    protected void setUp() throws Exception {

        super.setUp();
//
//        DesiredCapabilities capabilities = this.getCapabilitiesByPlatformEnv();
        driver = this.getDriverByPlatformEnv();
        this.rotateScreenToPortrait();
    }

    @Override
    protected void tearDown() throws Exception {
        driver.quit();
        super.tearDown();
    }

    protected void rotateScreenToPortrait() {
        driver.rotate(ScreenOrientation.PORTRAIT);
    }

    protected void rotateScreenToLandscape() {
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }

    private DesiredCapabilities getCapabilitiesByPlatformEnv() throws Exception {
        String platform = System.getenv("PLATFORM");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (platform.equals(PLATFORM_ANDROID)) {
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", "Pixel");
            capabilities.setCapability("platformVersion", "11");
            capabilities.setCapability("automationName", "Appium");
            capabilities.setCapability("appPackage", "org.wikipedia");
            capabilities.setCapability("appActivity", ".main.MainActivity");
            capabilities.setCapability("app", "/Users/apple/Desktop/JavaAppiumAutomationTests/apks/org.wikipedia.apk");
        } else if (platform.equals(PLATFORM_IOS)) {
            capabilities.setCapability("platformName", "iOS");
            capabilities.setCapability("deviceName", "iPhone 11 Pro Max");
            capabilities.setCapability("platformVersion", "13.1");
            //capabilities.setCapability("automationName", "XCUITest");
            capabilities.setCapability("app", "/Users/apple/Desktop/JavaAppiumAutomationTests/apks/Wikipedia.app");
        } else {
            throw new Exception("Cant get run platform for ENV verible Platform " + platform);
        }
        return capabilities;
    }

    private AppiumDriver getDriverByPlatformEnv() throws Exception {
        String platform = System.getenv("PLATFORM");
        if (platform.equals(PLATFORM_ANDROID)) {
            driver = new AndroidDriver(new URL(AppiumURL), this.getCapabilitiesByPlatformEnv());
        } else if (platform.equals(PLATFORM_IOS)) {
            driver = new IOSDriver(new URL(AppiumURL), this.getCapabilitiesByPlatformEnv());
        } else {
            throw new Exception("Cant get run DRIVER for ENV verible Platform " + platform);
        }
        return driver;
    }
}//end class
