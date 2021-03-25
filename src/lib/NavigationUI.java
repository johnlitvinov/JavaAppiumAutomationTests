package lib;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class NavigationUI extends MainPageObject {
   private static String
    MY_LIST = "//android.widget.FrameLayout[@content-desc=\"My lists\"]/android.widget.ImageView"
    ;

    public NavigationUI(AppiumDriver driver) {
        super(driver);
    }

    public void clickMyLists(){
        this.waitForElementAndClick(
                By.xpath(MY_LIST),
                "Can't find button 'MyList'",
                5
        );
    }
}//end class
