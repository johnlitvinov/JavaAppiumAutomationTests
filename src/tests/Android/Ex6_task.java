package tests.Android;
import lib.*;

import junit.framework.TestCase;
import lib.ui.ArticalePageObject;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class Ex6_task extends CoreTestCase {

    @Test
    public void testEx6() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        String search_line = "Kotlin";
        SearchPageObject.typeSearchLine(search_line);
        String articaleTitleToClick = "Kotline";
        SearchPageObject.clickByArticaleWithSubstring(articaleTitleToClick);
        ArticalePageObject ArticalePageObject = new ArticalePageObject(driver);
        String actualArticaleTitle = ArticalePageObject.getArticaleTitle();

        TestCase.assertEquals(
                "Not equals text titles",
                articaleTitleToClick,
                actualArticaleTitle
        );
    }
}//end class


