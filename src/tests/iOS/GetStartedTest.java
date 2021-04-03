package tests.iOS;

import lib.CoreTestCase;
import lib.ui.WelcomePageObject;
import org.junit.Test;

public class GetStartedTest extends CoreTestCase {

@Test
    public void testPassThriughWelcomeWindows() throws InterruptedException {
    WelcomePageObject welcomePageObject = new WelcomePageObject(driver);
    welcomePageObject.goThroughWelcomePages();
  }
}
