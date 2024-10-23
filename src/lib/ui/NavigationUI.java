package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class NavigationUI extends MainPageOdject {

    private static final String
            SAVE_OPTIONS  = "//*[@class='android.widget.LinearLayout']//*[@text='Saved']",
            CLICK_BY_SAVE_MENU = "//*[@class='android.widget.LinearLayout']//*[@text='Saved']";

    public NavigationUI(AppiumDriver driver)
    {
        super(driver);
    }

    public void clickBySavedButton()
    {
        this.waitForElementAndClick(
                By.xpath(SAVE_OPTIONS),
                "Cannot find SAVE button on the down panel",
                15
        );
    }

    public void clickBySavedMenu()
    {
        this.waitForElementAndClick(
                By.xpath(CLICK_BY_SAVE_MENU),
                "Cannot find SAVE button on the down panel",
                15
        );
    }


}
