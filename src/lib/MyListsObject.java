package lib;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MyListsObject extends MainPageObject {

    private static String
            FOLDER_NAME_TP = "//*[contains(@text,'{FOLDERNAME}')]",
            ARTICAL_TO_DELETE_TP = "//*[contains(@text,'{ARTICALENAME}')]";

    private static String getArticalToDeleteTp(String articale_name) {
        return ARTICAL_TO_DELETE_TP.replace("{ARTICALENAME}", articale_name);
    }


    private static String getFolderByXpath(String name_folder) {
        return FOLDER_NAME_TP.replace("{FOLDERNAME}", name_folder);
    }

    public MyListsObject(AppiumDriver driver) {
        super(driver);
    }


    public void openFolderByName(String name_folder) {
        String folder_xpath = getFolderByXpath(name_folder);
        this.waitForElementAndClick(
                By.xpath(folder_xpath),
                "Can't find folder ",
                5
        );
    }

    public void waitForArticaletitleDisappeare(String articale_title) {
        String art_name = getArticalToDeleteTp(articale_title);
        this.waitForElementNotPresent(By.xpath(art_name), "Can't delete articale", 20);
    }

    public void waitForArticaletitleToAppeare(String articale_title) {
        String art_name = getArticalToDeleteTp(articale_title);
        this.waitForElementPresent(By.xpath(art_name), "Can't find saved title", 20);
    }

    public void swipeToDeleteArticle(String articale_name) {
        this.waitForArticaletitleToAppeare(articale_name);

        String art_name = getArticalToDeleteTp(articale_name);
        this.swipeElementToLeft(
                By.xpath(art_name),
                "Can't delete  articale"
        );

        this.waitForArticaletitleDisappeare(articale_name);
    }
}//end class
