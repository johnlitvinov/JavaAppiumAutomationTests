package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import lib.Platform;

abstract public class ArticalePageObject extends MainPageObject {

    protected static String
            TITLE,
            OPTION_BUTTON,
            ADD_TO_MY_LIST_OPTION,
            ADD_TO_MY_LIST_OVERLAY,
            INPUT,
            OK_BUTTON,
            CROSS_BUTTON,
            MORE_OPTIONS,
            ADD_TO_READING_LIST,
            PRESS_FOLDER;

    public ArticalePageObject(AppiumDriver driver) {
        super(driver);
    }

    public WebElement waitForTitleElement() {
        return this.waitForElementPresent(
                TITLE,
                "Can't find Title",
                10
        );
    }

    public String getArticaleTitle() {
        WebElement title_element = waitForTitleElement();
        if (Platform.getInstance().isAndroid()) {
            return title_element.getAttribute("text");
        } else {
            return title_element.getAttribute("name");
        }

    }

    public void addArticleToMyList(String name_of_folder) {
        this.waitForElementAndClick(
                OPTION_BUTTON,
                "Can't find text 'Add to reading list'",
                5
        );


        this.waitForElementAndClick(
                ADD_TO_MY_LIST_OPTION,
                "Can't find text 'Add to reading list'",
                5
        );

        this.waitForElementAndClick(
                ADD_TO_MY_LIST_OVERLAY,
                "Can't find 'Got it' button ",
                10
        );

        this.waitForElementAndClear(
                INPUT,
                "Can't clear text",
                10
        );

        this.waitForElementAndSendKeys(
                INPUT,
                name_of_folder,
                "Can't input text",
                10
        );

        this.waitForElementAndClick(
                OK_BUTTON,
                "Can't find button 'OK'",
                5
        );
    }

    public void closeArticle() {

        this.waitForElementAndClick(
                CROSS_BUTTON,
                "Can't find button 'X'",
                5
        );
    }

    public void addtitle_to_actual_folder() {
        this.waitForElementAndClick(
                MORE_OPTIONS,
                "Can't find text 'MoreOption",
                5
        );
        this.waitForElementAndClick(
                ADD_TO_READING_LIST,
                "Can't find text 'Add to reading list'",
                5
        );

        this.waitForElementAndClick(
                PRESS_FOLDER,
                "Can't find text 'Kotlin_folder'",
                5
        );
    }


    public void addArticalToMeSavedList() {
        this.waitForElementAndClick(
                ADD_TO_MY_LIST_OPTION,
                "Cant find option to saved Articale to MyList",
                10
        );
    }

}//end class
