import lib.*;
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

        assertEquals(
                "Not equals text titles",
                articaleTitleToClick,
                actualArticaleTitle
        );
    }
}//end class


