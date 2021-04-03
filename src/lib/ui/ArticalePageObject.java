package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class ArticalePageObject extends MainPageObject {

    private static final String
            TITLE = "xpath://*[contains(@text,'Kotline')]",
            OPTION_BUTTON = "xpath://android.widget.ImageView[@content-desc=\"More options\"]",
            ADD_TO_MY_LIST_OPTION = "xpath://*[contains(@text,'Add to reading list')]",
            ADD_TO_MY_LIST_OVERLAY = "id:org.wikipedia:id/onboarding_button",
            INPUT = "id:org.wikipedia:id/text_input",
            OK_BUTTON = "xpath://*[contains(@text,'OK')]",
            CROSS_BUTTON = "xpath://android.widget.ImageButton[@content-desc='Navigate up']",
            MORE_OPTIONS = "xpath://android.widget.ImageView[@content-desc=\"More options\"]",
            ADD_TO_READING_LIST = "xpath://*[contains(@text,'Add to reading list')]",
            PRESS_FOLDER = "xpath://*[contains(@text,'Kotlin_folder')]";

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
        return title_element.getAttribute("text");
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
}//end class
