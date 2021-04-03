package lib.ui;

import io.appium.java_client.AppiumDriver;

public class WelcomePageObject extends MainPageObject {

    private static String
            FIRST_PAGE_LABLE = "id:The free encyclopedia",
            SEARCH_LINE = "id:Search Wikipedia";

    public WelcomePageObject(AppiumDriver driver) {
        super(driver);
    }

    public void goThroughWelcomePages() throws InterruptedException {
        this.waitForElementPresent(
                FIRST_PAGE_LABLE,
                "Can't find 'The free encyclopedia' label",
                10
        );

        this.clickByCordinate(90, 834);

        this.waitForElementPresent(
                SEARCH_LINE,
                "Can't find 'Search Wikipedia'",
                10
        );
    }
}//end class
