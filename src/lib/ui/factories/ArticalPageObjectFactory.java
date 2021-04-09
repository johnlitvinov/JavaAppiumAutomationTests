package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.ui.ArticalePageObject;
import lib.ui.android.AndroidArticalPageObject;
import lib.ui.ios.iOSArticalPageObject;

public class ArticalPageObjectFactory {

    public static ArticalePageObject get(AppiumDriver driver)
    {
        if(Platform.getInstance().isAndroid()){
            return new AndroidArticalPageObject(driver);
        }else{
            return new iOSArticalPageObject(driver);
        }
    }
}//end class
