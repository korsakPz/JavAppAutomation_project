import lib.CoreTestCase;
import lib.ui.MainPageOdject;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import java.time.Duration;





public class FirstTest extends CoreTestCase {

    private MainPageOdject MainPageOdject;

    protected void setUp() throws Exception
    {
        super.setUp();

        MainPageOdject = new MainPageOdject(driver);
    }



   @Test
    public void testSearch()
    {
        MainPageOdject.waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Skip')]"),
                "Cannot SKIP element",
                5
        );


        MainPageOdject.waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find search next ELEMENT",
                5
        );


        MainPageOdject.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Java",
                "Cannot find topic by JAVA",
                        15
        );

        MainPageOdject.waitForElementPresent(
                By.xpath("//*[@class='android.view.ViewGroup']//*[@text='Object-oriented programming language']"),
                "Cannot find element of JAVA",
                15

        );


    }

    @Test
    public void testCancelSearch()
    {
        MainPageOdject.waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Skip')]"),
                "Cannot SKIP element",
                5
        );

        MainPageOdject.waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find search next ELEMENT",
                5
        );

        MainPageOdject.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Java",
                "Cannot find topic by JAVA",
                15
        );

        MainPageOdject.waitForElementAndClear(
                By.id("org.wikipedia:id/search_src_text"),
                "Cannot find search FIELD",
                5
        );

        MainPageOdject.waitForElementAndClick(
                By.id("Navigate up"),
                "Cannot find button BACK",
                5
        );

        MainPageOdject.waitForElementNotPresent(
                By.id("Navigate up"),
                "It not present in our window",
                5
        );

    }

    @Test
    public void testCompareArticleTitle()
    {
        MainPageOdject.waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Skip')]"),
                "Cannot SKIP element",
                5
        );


        MainPageOdject.waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find search next ELEMENT",
                5
        );


        MainPageOdject.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Java",
                "Cannot find topic by JAVA",
                15
        );

        MainPageOdject.waitForElementAndClick(
                By.xpath("//*[@class='android.view.ViewGroup']//*[@text='Object-oriented programming language']"),
                "Cannot find search next ELEMENT",
                5
        );

        WebElement title_element = MainPageOdject.waitForElementPresent(
                By.xpath("//*[@class='android.view.View']//*[@text='Java (programming language)']"),
                "Cannot find article TITLE",
                15
        );

        String article_title = title_element.getAttribute("text");

        Assert.assertEquals(
                "We see unexpected title",
                "Java (programming language)",
                article_title
        );

    }

    @Test
    public void testSwipeArticle()
    {
        MainPageOdject.waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Skip')]"),
                "Cannot SKIP element",
                5
        );


        MainPageOdject.waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find search next ELEMENT",
                5
        );


        MainPageOdject.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Appium",
                "Cannot find topic by JAVA",
                15
        );

        MainPageOdject.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/search_results_list']//*[@text='Automation for Apps']"),
                "Cannot find search next ELEMENT",
                15
        );

        MainPageOdject.swipeUpToFindElement(
                By.xpath("//*[@resource-id='pcs-footer-container-readmore-heading2']"),
                "We cannot find the end of the article",
                20
        );

//        swipeUpToFindElement(
//                By.xpath()
//        );

    }

    @Test
    public void testSaveFirstToMyArticleList()   //************************************ 4 Movie
    {
        String name_of_folder = "Test list1";
        String search_line = "java";



        MainPageOdject.waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Skip')]"),
                "Cannot SKIP element",
                5
        );



        MainPageOdject.waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find search pole",
                5
        );

        MainPageOdject.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                search_line,
                "Cannot find articles by JAVA word",
                15
        );

        MainPageOdject.waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Java (programming language)')]"),
                "Cannot find search article by JAVA",
                5
        );

        MainPageOdject.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_save']"),
                "Cannot find SafeLy moment",
                15
        );

        MainPageOdject.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_save']"),
                "Cannot find SECOND SafeLy moment",
                40
        );

        MainPageOdject.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_save']"),
                "Remove first context MENU",
                15
        );

        MainPageOdject.waitForElementAndClick(
                By.xpath("//*[@class='org.wikipedia:id/page_actions_tab_layout']//*[@text='Move from Saved to another reading list']"),
                "Cannot find context menu",
                15
        );

        MainPageOdject.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/create_button']//*[@class='android.widget.ImageView']"),
                "Cannot find button for add list",
                20
        );

        MainPageOdject.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Name of this list')]"),
                name_of_folder,
                "Cannot find text line for input",
                30
        );


        MainPageOdject.waitForElementAndClick(
                By.xpath("//*[@class='android.widget.LinearLayout']//*[@text='OK']"),
                "Cannot find button for add list",
                40
        );

        MainPageOdject.waitForElementAndClick(
                By.xpath("//*[@class='android.widget.ImageButton']"),
                "Cannot find button BACK on the article",
                15
        );

        MainPageOdject.waitForElementAndClick(
                By.xpath("//*[@class='android.view.ViewGroup']//*[@class='android.widget.ImageButton']"),
                "Cannot find button BACK on the find list articles",
                15
        );

        MainPageOdject.waitForElementAndClick(
                By.xpath("//*[@class='android.widget.LinearLayout']//*[@text='Saved']"),
                "Cannot find SAVE button on the down panel",
                15
        );

        MainPageOdject.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/item_title_container']//*[@text='" + name_of_folder + "']"),
                "Cannot find SAVEd think",
                15
        );


        MainPageOdject.swipeElementToLeft(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Java (programming language)']"),
                "Cannot fined save article"

        );

        MainPageOdject.waitForElementNotPresent(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Java (programming language)']"),
                "Cannot delet saved article",
                15

        );

    }





    @Test
    public void testAmountNotEmptySearch()  // **********Video 5 **********
    {

        String search_line = "Madonna";
        String search_result_locator = "//*[@resource-id='org.wikipedia:id/search_results_list']/*[@class='android.view.ViewGroup']/*[@resource-id='org.wikipedia:id/page_list_item_title']";


        MainPageOdject.waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Skip')]"),
                "Cannot SKIP element",
                5
        );



        MainPageOdject.waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find search field",
                5
        );

        MainPageOdject.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                search_line,
                "Cannot find articles by JAVA word",
                15
        );

        MainPageOdject.waitForElementPresent(
          By.xpath(search_result_locator),
                "Cannot find search result" + search_line,
                15
        );

        int amount_of_search_results = MainPageOdject.getAmountOfElements(
                By.xpath(search_result_locator)
        );

        Assert.assertTrue(
                "We found too wew results",
                amount_of_search_results > 0
        );


    }
    @Test
    public void testAmountOfEmptySearch()  // **********Video 6 **********
    {
        String search_line = "asdfsdafsdfsdf";
        String search_result_locator = "//*[@resource-id='org.wikipedia:id/search_results_list']/*[@class='android.view.ViewGroup']/*[@resource-id='org.wikipedia:id/page_list_item_title']";
        String empty_result_label = "//*[@text,'No results']";


        MainPageOdject.waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Skip')]"),
                "Cannot SKIP element",
                5
        );


        MainPageOdject.waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find search field",
                5
        );

        MainPageOdject.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                search_line,
                "Cannot find articles by JAVA word",
                15
        );

        MainPageOdject.waitForElementPresent(
                By.xpath(empty_result_label),
                "Cannot find element " + empty_result_label,
                15
        );

        MainPageOdject.assertElementNotPresent(
                By.xpath(search_result_locator),
                "We've found some results by request " + search_line
        );



    }

    @Test
    public void testChangeScreenOrientationOnSearchResults() //********** _Video 7_ ******************
    {
        String search_line = "Java";
        String search_result_locator = "//*[@resource-id='org.wikipedia:id/search_results_list']/*[@class='android.view.ViewGroup']/*[@resource-id='org.wikipedia:id/page_list_item_title']";
        String empty_result_label = "//*[@text,'No results']";


        MainPageOdject.waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Skip')]"),
                "Cannot SKIP element",
                5
        );


        MainPageOdject.waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find search field",
                5
        );

        MainPageOdject.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                search_line,
                "Cannot find articles by JAVA word",
                15
        );

        MainPageOdject.waitForElementAndClick(
                By.xpath(search_result_locator),
                "Cannot find " + search_line + " topic",
                15
        );

        String title_before_rotation = MainPageOdject.waitForElementAndGetAttribute(
          By.id("pcs"),
                  "text",
                "Cannot find title of article",
                15
        );

        driver.rotate(ScreenOrientation.LANDSCAPE);

        String title_after_rotation = MainPageOdject.waitForElementAndGetAttribute(
                By.id("pcs"),
                "text",
                "Cannot find title of article",
                15
        );

        Assert.assertEquals(
                "Article title have been changed after screen rotation",
                title_before_rotation,
                title_after_rotation
        );

        driver.rotate(ScreenOrientation.PORTRAIT);

        String title_after_second_rotation = MainPageOdject.waitForElementAndGetAttribute(
                By.id("pcs"),
                "text",
                "Cannot find title of article",
                15
        );

        Assert.assertEquals(
                "Article title have been changed after screen rotation",
                title_before_rotation,
                title_after_second_rotation
        );


    }

    @Test
    public void testCheckArticleInBackground()
    {
        String search_line = "java";
        String search_result_locator = "//*[@resource-id='org.wikipedia:id/search_results_list']/*[@class='android.view.ViewGroup']/*[@resource-id='org.wikipedia:id/page_list_item_title']";


        MainPageOdject.waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Skip')]"),
                "Cannot SKIP element",
                5
        );


        MainPageOdject.waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find search next ELEMENT",
                5
        );


        MainPageOdject.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Java",
                "Cannot find topic by JAVA",
                15
        );

        MainPageOdject.waitForElementPresent(
                By.xpath("//*[@class='android.view.ViewGroup']//*[@text='Object-oriented programming language']"),
                "Cannot find article",
                5
        );

//
        driver.runAppInBackground((Duration.ofSeconds(1)));
//
        MainPageOdject.waitForElementPresent(
                By.xpath("//*[@class='android.view.ViewGroup']//*[@text='Object-oriented programming language']"),
                "Cannot find article after returning from background",
                5
        );


    }















}
