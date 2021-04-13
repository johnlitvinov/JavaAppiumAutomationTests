package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticalePageObject;

public class AndroidArticalPageObject extends ArticalePageObject
{
    static {
        TITLE = "xpath://*[contains(@text,'Kotline')]";
        OPTION_BUTTON = "xpath://android.widget.ImageView[@content-desc=\"More options\"]";
        ADD_TO_MY_LIST_OPTION = "xpath://*[contains(@text,'Add to reading list')]";
        ADD_TO_MY_LIST_OVERLAY = "id:org.wikipedia:id/onboarding_button";
        INPUT = "id:org.wikipedia:id/text_input";
        OK_BUTTON = "xpath://*[contains(@text,'OK')]";
        CROSS_BUTTON = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";
        MORE_OPTIONS = "xpath://android.widget.ImageView[@content-desc=\"More options\"]";
        ADD_TO_READING_LIST = "xpath://*[contains(@text,'Add to reading list')]";
        PRESS_FOLDER = "xpath://*[contains(@text,'Kotlin_folder')]";
        CELL = "";
    }

    public AndroidArticalPageObject(AppiumDriver driver) {
        super(driver);
    }
}//end class

