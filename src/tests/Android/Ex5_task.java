package tests.Android;

import lib.*;
import lib.ui.ArticalePageObject;
import lib.ui.MyListsObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticalPageObjectFactory;
import lib.ui.factories.MyListObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class Ex5_task extends CoreTestCase {

    @Test
    public void testEx5() {

        // SEARCH FIRST ITEM AND ADD IT TO THE FOLDER
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        String search_line = "Kotlin";
        SearchPageObject.typeSearchLine(search_line);
        String firstArticleTitleToClick = "Kotlin Island";
        SearchPageObject.clickByArticaleWithSubstring(firstArticleTitleToClick);
        String folder = "Kotlin_folder";

        ArticalePageObject articalePageObject = ArticalPageObjectFactory.get(driver);

        if (Platform.getInstance().isAndroid()) {
            articalePageObject.addArticleToMyList(folder);
        } else {
            articalePageObject.addArticalToMeSavedList();
        }
        articalePageObject.closeArticle();

        // SEARCH Second ITEM AND ADD IT TO THE FOLDER
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line);
        String secondArticleTitleToClick = "Kotline";
        SearchPageObject.clickByArticaleWithSubstring(secondArticleTitleToClick);
        articalePageObject.addtitle_to_actual_folder();
        articalePageObject.closeArticle();


        NavigationUI navigationUI = NavigationUIFactory.get(driver);
        navigationUI.clickMyLists();


        MyListsObject myListsObject = MyListObjectFactory.get(driver);

        if (Platform.getInstance().isAndroid()) {
            myListsObject.openFolderByName(folder);
        }

        // DELETE ARTICLE TITLE
        myListsObject.swipeToDeleteArticle(firstArticleTitleToClick);

        // CHECK ITEMS IN THE FOLDER
        SearchPageObject.waitForSearchResultToDisappear(firstArticleTitleToClick);
        SearchPageObject.waitForSearchResult(secondArticleTitleToClick);
        ArticalePageObject ArticalePageObject = ArticalPageObjectFactory.get(driver);
        String actualArticaleTitle = ArticalePageObject.getArticaleTitle();

        assertEquals("Not equals text titles", secondArticleTitleToClick, actualArticaleTitle);
    }
}//end class