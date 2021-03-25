import lib.*;
import org.junit.Test;

public class Ex5_task extends CoreTestCase {

    @Test
    public void testEx5()
    {
        // SEARCH FIRST ITEM AND ADD IT TO THE FOLDER
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        String search_line = "Kotlin";
        SearchPageObject.typeSearchLine(search_line);
        String firstArticleTitleToClick = "Kotlin Island";
        SearchPageObject.clickByArticaleWithSubstring(firstArticleTitleToClick);
        String folder = "Kotlin_folder";
        ArticalePageObject articalePageObject = new ArticalePageObject(driver);
        articalePageObject.addArticleToMyList(folder);
        articalePageObject.closeArticle();
        // SEARCH FIRST ITEM AND ADD IT TO THE FOLDER
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line);
        String secondArticleTitleToClick = "Kotline";
        SearchPageObject.clickByArticaleWithSubstring(secondArticleTitleToClick);
        articalePageObject.addtitle_to_actual_folder();
        articalePageObject.closeArticle();
        NavigationUI navigationUI = new NavigationUI(driver);
        navigationUI.clickMyLists();
        MyListsObject myListsObject = new MyListsObject(driver);
        myListsObject.openFolderByName(folder);
        // DELETE ARTICLE TITLE
        myListsObject.swipeToDeleteArticle(firstArticleTitleToClick);
        // CHECK ITEMS IN THE FOLDER
        SearchPageObject.waitForSearchResultToDisappear(firstArticleTitleToClick);
        SearchPageObject.waitForSearchResult(secondArticleTitleToClick);
        ArticalePageObject ArticalePageObject = new ArticalePageObject(driver);
        String actualArticaleTitle = ArticalePageObject.getArticaleTitle();

        assertEquals(
                "Not equals text titles",
                secondArticleTitleToClick,
                actualArticaleTitle
        );
    }
} //end class


