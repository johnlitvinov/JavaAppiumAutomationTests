package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class iOSSearchPageObject extends SearchPageObject {
    static
    {
        SEARCH_INIT_ELEMENT = "xpath://XCUIElementTypeSearchField[@name='Search Wikipedia']";
        //TODO
        SEARCH_INPUT = "id:Search Wikipedia";

        SEARCH_CANCEL_BUTTON = "xpath://XCUIElementTypeStaticText[@name='Cancel']";
        SEARCH_RESULT_BY_SUBSTRING_TMP = "xpath://XCUIElementTypeLink[@name='{SUBSTRING}']";
        SEARCH_EMPTY_RESULT = "id:No results found";
    }
    public iOSSearchPageObject(AppiumDriver driver) {
        super(driver);
    }
}//end class
