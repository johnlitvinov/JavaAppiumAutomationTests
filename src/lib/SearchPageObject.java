package lib;


import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SearchPageObject extends MainPageObject {


    private static final String
            SEARCH_INIT_ELEMENT = "//*[contains(@text,'Search Wikipedia')]",
            SEARCH_INPUT = "org.wikipedia:id/search_src_text",
            SEARCH_CANCEL_BUTTON = "org.wikipedia:id/search_close_btn",
            SEARCH_RESULT_BY_SUBSTRING_TMP = "//*[contains(@text,'{SUBSTRING}')]";


    public SearchPageObject(AppiumDriver driver) {
        super(driver);
    }

    private static String getResultSearchElement(String subsstring) {
        return SEARCH_RESULT_BY_SUBSTRING_TMP.replace("{SUBSTRING}", subsstring);
    }

    public void initSearchInput() {
        this.waitForElementAndClick(By.xpath(SEARCH_INIT_ELEMENT), "Can't find and click search init element", 10);
        this.waitForElementAndClick(By.xpath(SEARCH_INIT_ELEMENT), "Can't find element", 10);
    }

    public void typeSearchLine(String search_line) {
        this.waitForElementAndSendKeys(By.id(SEARCH_INPUT), search_line, "Can't input data", 10);
    }

    public void waitForSearchResult(String subsstring) {
        String search_result_xpath = getResultSearchElement(subsstring);
        this.waitForElementPresent(By.xpath(search_result_xpath), "Can't find Search_Result " + subsstring, 30);
    }

    public void waitForSearchResultToDisappear(String subsstring) {
        String search_result_xpath = getResultSearchElement(subsstring);
        this.waitForElementNotPresent(By.xpath(search_result_xpath), "Find Search_Result " + subsstring, 30);
    }

    public void clickByArticaleWithSubstring(String subsstring) {
        String search_result_xpath = getResultSearchElement(subsstring);
        this.waitForElementAndClick(By.xpath(search_result_xpath), "Can't find and click Search_Result " + subsstring, 30);
    }

    public void waitForCancelButtonToDisappear() {
        this.waitForElementNotPresent(By.xpath(SEARCH_CANCEL_BUTTON), "Find X button", 10);
    }

    public void waitForCancelButtonToAppear() {
        this.waitForElementPresent(By.xpath(SEARCH_CANCEL_BUTTON), "Can't find X button", 10);
    }

    public void clickCancelButton() {
        waitForElementAndClick(By.id(SEARCH_CANCEL_BUTTON), "Can't tap X button", 10);
    }
}//end class
