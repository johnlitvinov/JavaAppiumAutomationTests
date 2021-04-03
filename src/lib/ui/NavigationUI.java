package lib.ui;

import io.appium.java_client.AppiumDriver;

public class NavigationUI extends MainPageObject {
   private static String
    MY_LIST = "xpath://android.widget.FrameLayout[@content-desc=\"My lists\"]/android.widget.ImageView"
    ;

    public NavigationUI(AppiumDriver driver) {
        super(driver);
    }

    public void clickMyLists(){
        this.waitForElementAndClick(
                MY_LIST,
                "Can't find button 'MyList'",
                5
        );
    }
}//end class
