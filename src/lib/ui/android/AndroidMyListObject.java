package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsObject;

public class AndroidMyListObject extends MyListsObject {
    static {
        FOLDER_NAME_TP = "xpath://*[contains(@text,'{FOLDERNAME}')]";
        ARTICAL_TO_DELETE_TP = "xpath://*[contains(@text,'{ARTICALENAME}')]";
    }

    public AndroidMyListObject(AppiumDriver driver) {
        super(driver);
    }
}//end class
