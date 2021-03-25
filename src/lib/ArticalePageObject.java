package lib;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticalePageObject extends MainPageObject {

    private static final String
            TITLE = "//*[contains(@text,'Kotline')]",
            OPTION_BUTTON = "//android.widget.ImageView[@content-desc=\"More options\"]",
            ADD_TO_MY_LIST_OPTION = "//*[contains(@text,'Add to reading list')]",
            ADD_TO_MY_LIST_OVERLAY = "org.wikipedia:id/onboarding_button",
            INPUT = "org.wikipedia:id/text_input",
            OK_BUTTON = "//*[contains(@text,'OK')]",
            CROSS_BUTTON = "//android.widget.ImageButton[@content-desc='Navigate up']";

    public ArticalePageObject(AppiumDriver driver) {
        super(driver);
    }

    public WebElement waitForTitleElement() {
        return this.waitForElementPresent(
                By.xpath(TITLE),
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
                By.xpath(OPTION_BUTTON),
                "Can't find text 'Add to reading list'",
                5
        );


        this.waitForElementAndClick(
                By.xpath(ADD_TO_MY_LIST_OPTION),
                "Can't find text 'Add to reading list'",
                5
        );

        this.waitForElementAndClick(
                By.id(ADD_TO_MY_LIST_OVERLAY),
                "Can't find 'Got it' button ",
                10
        );

        this.waitForElementAndClear(
                By.id(INPUT),
                "Can't clear text",
                10
        );

        this.waitForElementAndSendKeys(
                By.id(INPUT),
                name_of_folder,
                "Can't input text",
                10
        );

        this.waitForElementAndClick(
                By.xpath(OK_BUTTON),
                "Can't find button 'OK'",
                5
        );
    }

    public void closeArticle() {

        this.waitForElementAndClick(
                By.xpath(CROSS_BUTTON),
                "Can't find button 'X'",
                5
        );
    }

    public void addtitle_to_actual_folder() {
        this.waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc=\"More options\"]"),
                "Can't find text 'Add to reading list'",
                5
        );
        this.waitForElementAndClick(
                By.xpath("//*[contains(@text,'Add to reading list')]"),
                "Can't find text 'Add to reading list'",
                5
        );

        this.waitForElementAndClick(
                By.xpath("//*[contains(@text,'Kotlin_folder')]"),
                "Can't find text 'Kotlin_folder'",
                5
        );
    }
}//end class
