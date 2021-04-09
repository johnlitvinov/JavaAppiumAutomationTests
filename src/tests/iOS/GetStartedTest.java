package tests.iOS;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.ios.iOSSearchPageObject;
import org.junit.Test;

public class GetStartedTest extends CoreTestCase {

@Test
    public void test()  {
    if (Platform.getInstance().isAndroid()){ return;}

    iOSSearchPageObject iOSSearchPageObject = new iOSSearchPageObject(driver);
    iOSSearchPageObject.initSearchInput();
    iOSSearchPageObject.sendKeysForIOS("Java");
    iOSSearchPageObject.clickCancelButton();
  }
}//end class
