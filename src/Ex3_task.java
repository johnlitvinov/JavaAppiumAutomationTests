import lib.*;
import org.junit.Test;

public class Ex3_task extends CoreTestCase {

    @Test
    public void testEx3()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        String search_line = "Kotlin";
        SearchPageObject.typeSearchLine(search_line);
        String firstArticleTitleToClick = "Kotlin Island";
        SearchPageObject.clickByArticaleWithSubstring(firstArticleTitleToClick);
        ArticalePageObject articalePageObject = new ArticalePageObject(driver);
        articalePageObject.closeArticle();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(firstArticleTitleToClick);
        SearchPageObject.clickCancelButton();
        SearchPageObject.waitForSearchResultToDisappear(firstArticleTitleToClick);
    }
} //end class

