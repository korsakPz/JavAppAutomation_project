package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageOdject
{

    private static final String
        TITLE = "//*[@class='android.view.View']//*[@text='Java (programming language)']",
        FOOTER_ELEMENT = "//*[@resource-id='pcs-footer-container-readmore-heading2']",
        SAVE_BUTTON = "//*[@resource-id='org.wikipedia:id/page_save']",
        CONTEXT_MENU_OPTIONS = "//*[@class='org.wikipedia:id/page_actions_tab_layout']//*[@text='Move from Saved to another reading list']",
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "//*[@resource-id='org.wikipedia:id/create_button']//*[@class='android.widget.ImageView']",
        ADD_TEXT_OPTIONS = "//*[contains(@text, 'Name of this list')]",
        BUTTON_OK_OPTIONS = "//*[@class='android.widget.LinearLayout']//*[@text='OK']",
        CLOSE_ARTICLE_BUTTON = "//*[@class='android.widget.ImageButton']",
        BACK_BUTTON_OF_ARTICLE = "//*[@class='android.view.ViewGroup']//*[@class='android.widget.ImageButton']";



    public ArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public WebElement waitForTitleElement()
    {
        return this.waitForElementPresent(By.xpath(TITLE),"Cannot find article", 15);
    }

    public String getArticleTitle()
    {
        WebElement title_element = waitForTitleElement();
        return title_element.getAttribute("text");
    }

    public void swipeToFooter()
    {
        this.swipeUpToFindElement(
                By.xpath(FOOTER_ELEMENT),
                "Cannot find the element of article",
                20);

    }


    public void addArticleToMyList(String name_of_folder)
    {
        this.waitForElementAndClick(
                By.xpath(SAVE_BUTTON),
                "Cannot find SafeLy moment",
                15
        );

        this.waitForElementAndClick(
                By.xpath(SAVE_BUTTON),
                "Cannot find SECOND SafeLy moment",
                40
        );

        this.waitForElementAndClick(
                By.xpath("SAVE_BUTTON"),
                "Remove first context MENU",
                15
        );

        this.waitForElementAndClick(
                By.xpath(CONTEXT_MENU_OPTIONS),
                "Cannot find context menu",
                15
        );

        this.waitForElementAndClick(
                By.xpath(OPTIONS_ADD_TO_MY_LIST_BUTTON),
                "Cannot find button for add list",
                20
        );

        this.waitForElementAndSendKeys(
                By.xpath(ADD_TEXT_OPTIONS),
                name_of_folder,
                "Cannot find text line for input",
                30
        );


        this.waitForElementAndClick(
                By.xpath(BUTTON_OK_OPTIONS),
                "Cannot find button for add list",
                40
        );
    }

    public void closeArticle()
    {
        this.waitForElementAndClick(
                By.xpath(CLOSE_ARTICLE_BUTTON),
                "Cannot find button BACK on the article",
                15
        );

    }

    public void backArticleButton()
    {
        this.waitForElementAndClick(
                By.xpath(BACK_BUTTON_OF_ARTICLE),
                "Cannot find button BACK on the find list articles",
                15
        );
    }



}
