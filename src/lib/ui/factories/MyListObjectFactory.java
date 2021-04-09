package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.ui.MyListsObject;
import lib.ui.android.AndroidMyListObject;
import lib.ui.ios.iOSMyListObject;

public class MyListObjectFactory {

    public static MyListsObject get(AppiumDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidMyListObject(driver);
        } else {
            return new iOSMyListObject(driver);
        }
    }
}//end class

