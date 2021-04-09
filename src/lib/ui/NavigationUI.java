package lib.ui;

import io.appium.java_client.AppiumDriver;

abstract public class NavigationUI extends MainPageObject {


   protected static String
    MY_LIST;


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
