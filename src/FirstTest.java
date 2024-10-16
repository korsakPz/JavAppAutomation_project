import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import java.net.URL;
import java.util.List;
import java.util.Locale;


public class FirstTest {

    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","AndroidTestDevice");
        capabilities.setCapability("platformVersion","12.0");
        capabilities.setCapability("automationName","UiAutomator2");
        capabilities.setCapability("appPackage","org.wikipedia");
        capabilities.setCapability("appActivity",".main.MainActivity");
        capabilities.setCapability("app","C:\\Users\\Korsak\\Documents\\AutoTestirovanie\\JavAppAutomation\\APKs\\org.wikipedia.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), capabilities);
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }

   /* @Test
    public void firstTest()
    {
        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Skip')]"),
                "Cannot SKIP element",
                5
        );


        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find search next ELEMENT",
                5
        );


        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Java",
                "Cannot find topic by JAVA",
                        15
        );

        waitForElementPresent(
                By.xpath("//*[@class='android.view.ViewGroup']//*[@text='Object-oriented programming language']"),
                "Cannot find element of JAVA",
                15

        );


    }*/

    @Test
    public void testCancelSearch()
    {
        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Skip')]"),
                "Cannot SKIP element",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find search next ELEMENT",
                5
        );

        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Java",
                "Cannot find topic by JAVA",
                15
        );

        waitForElementAndClear(
                By.id("org.wikipedia:id/search_src_text"),
                "Cannot find search FIELD",
                5
        );

        waitForElementAndClick(
                By.id("Navigate up"),
                "Cannot find button BACK",
                5
        );

        waitForElementNotPresent(
                By.id("Navigate up"),
                "It not present in our window",
                5
        );

    }

    @Test
    public void testCompareArticleTitle()
    {
        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Skip')]"),
                "Cannot SKIP element",
                5
        );


        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find search next ELEMENT",
                5
        );


        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Java",
                "Cannot find topic by JAVA",
                15
        );

        waitForElementAndClick(
                By.xpath("//*[@class='android.view.ViewGroup']//*[@text='Object-oriented programming language']"),
                "Cannot find search next ELEMENT",
                5
        );

        WebElement title_element = waitForElementPresent(
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
        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Skip')]"),
                "Cannot SKIP element",
                5
        );


        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find search next ELEMENT",
                5
        );


        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Appium",
                "Cannot find topic by JAVA",
                15
        );

        waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/search_results_list']//*[@text='Automation for Apps']"),
                "Cannot find search next ELEMENT",
                15
        );

        swipeUpToFindElement(
                By.xpath("//*[@resource-id='pcs-footer-container-readmore-heading2']"),
                "We cannot find the end of the article",
                20
        );

//        swipeUpToFindElement(
//                By.xpath()
//        );

    }

    @Test
    public void saveFirstToMyArticleList()   //************************************ 4 Movie
    {
        String name_of_folder = "Test list1";
        String search_line = "java";



        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Skip')]"),
                "Cannot SKIP element",
                5
        );



        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find search pole",
                5
        );

        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                search_line,
                "Cannot find articles by JAVA word",
                15
        );

        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Java (programming language)')]"),
                "Cannot find search article by JAVA",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_save']"),
                "Cannot find SafeLy moment",
                15
        );

        waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_save']"),
                "Cannot find SECOND SafeLy moment",
                40
        );

        waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_save']"),
                "Remove first context MENU",
                15
        );

        waitForElementAndClick(
                By.xpath("//*[@class='org.wikipedia:id/page_actions_tab_layout']//*[@text='Move from Saved to another reading list']"),
                "Cannot find context menu",
                15
        );

        waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/create_button']//*[@class='android.widget.ImageView']"),
                "Cannot find button for add list",
                20
        );

        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Name of this list')]"),
                name_of_folder,
                "Cannot find text line for input",
                30
        );


        waitForElementAndClick(
                By.xpath("//*[@class='android.widget.LinearLayout']//*[@text='OK']"),
                "Cannot find button for add list",
                40
        );

        waitForElementAndClick(
                By.xpath("//*[@class='android.widget.ImageButton']"),
                "Cannot find button BACK on the article",
                15
        );

        waitForElementAndClick(
                By.xpath("//*[@class='android.view.ViewGroup']//*[@class='android.widget.ImageButton']"),
                "Cannot find button BACK on the find list articles",
                15
        );

        waitForElementAndClick(
                By.xpath("//*[@class='android.widget.LinearLayout']//*[@text='Saved']"),
                "Cannot find SAVE button on the down panel",
                15
        );

        waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/item_title_container']//*[@text='" + name_of_folder + "']"),
                "Cannot find SAVEd think",
                15
        );


        swipeElementToLeft(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Java (programming language)']"),
                "Cannot fined save article"

        );

        waitForElementNotPresent(
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


        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Skip')]"),
                "Cannot SKIP element",
                5
        );



        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find search field",
                5
        );

        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                search_line,
                "Cannot find articles by JAVA word",
                15
        );

        waitForElementPresent(
          By.xpath(search_result_locator),
                "Cannot find search result" + search_line,
                15
        );

        int amount_of_search_results = getAmountOfElements(
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


        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Skip')]"),
                "Cannot SKIP element",
                5
        );


        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find search field",
                5
        );

        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                search_line,
                "Cannot find articles by JAVA word",
                15
        );

        waitForElementPresent(
                By.xpath(empty_result_label),
                "Cannot find element " + empty_result_label,
                15
        );

        assertElementNotPresent(
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


        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Skip')]"),
                "Cannot SKIP element",
                5
        );


        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find search field",
                5
        );

        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                search_line,
                "Cannot find articles by JAVA word",
                15
        );

        waitForElementAndClick(
                By.xpath(search_result_locator),
                "Cannot find " + search_line + " topic",
                15
        );

        String title_before_rotation = waitForElementAndGetAttribute(
          By.id("pcs"),
                  "text",
                "Cannot find title of article",
                15
        );

        driver.rotate(ScreenOrientation.LANDSCAPE);

        String title_after_rotation = waitForElementAndGetAttribute(
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

        String title_after_second_rotation = waitForElementAndGetAttribute(
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


        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Skip')]"),
                "Cannot SKIP element",
                5
        );


        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find search next ELEMENT",
                5
        );


        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Java",
                "Cannot find topic by JAVA",
                15
        );

        waitForElementPresent(
                By.xpath("//*[@class='android.view.ViewGroup']//*[@text='Object-oriented programming language']"),
                "Cannot find article",
                5
        );

//
        driver.runAppInBackground((Duration.ofSeconds(1)));
//
        waitForElementPresent(
                By.xpath("//*[@class='android.view.ViewGroup']//*[@text='Object-oriented programming language']"),
                "Cannot find article after returning from background",
                5
        );


    }




    private WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)

        );

    }

    private WebElement waitForElementPresent(By by, String error_message)
    {
        return waitForElementPresent(by, error_message, 5);
    }

    private WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds)
    {
        WebElement element =  waitForElementPresent(by, error_message, 5);
        element.click();
        return element;
    }

    private WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeoutInSeconds)
    {
        WebElement element =  waitForElementPresent(by, error_message, 5);
        element.sendKeys(value);
        return element;
    }



    private boolean waitForElementNotPresent(By by, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );

    }

    private WebElement waitForElementAndClear(By by, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.clear();
        return element;
    }

    protected void swipeUp(int timeOfSwipe)
    {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int x = size.width / 2;
        int start_y = (int) (size.height * 0.4);
        int end_y = (int)(size.height * 0.2);

        action

                .press(PointOption.point(x, start_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(timeOfSwipe)))
                .moveTo((PointOption.point(x, end_y)))
                .release()
                .perform();

//                .press(x, start_y)
//                .waitAction(timeOfSwipe)
//                .moveTo(x, end_y)
//                .release()
//                .perform();
    }

    protected void swipeUpQuick()
    {
        swipeUp(200);

    }


    protected void swipeUpToFindElement(By by, String error_message, int max_swipes)
    {
        int alredy_swiped = 0;
          
        while (driver.findElements(by).size() == 0) {
            if (alredy_swiped > max_swipes){
                waitForElementPresent(by, "Cannot find element by swiped up. \n" + error_message, 0);
                return;
            }

            swipeUpQuick();
            ++alredy_swiped;
        }
    }

    protected void swipeElementToLeft(By by, String error_message)
    {
        WebElement element = waitForElementPresent(
                by,
                error_message,
                10
        );

        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_y) / 2;

        TouchAction  action = new TouchAction(driver);
        action
                .press(PointOption.point(right_x, middle_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
                .moveTo(PointOption.point(left_x, middle_y))
                .release()
                .perform();

    }

    private int getAmountOfElements(By by)
    {
        List elements = driver.findElements(by);
        return elements.size();
    }

    private void assertElementNotPresent(By by, String error_message)
    {
        int amount_of_element = getAmountOfElements(by);

        if (amount_of_element > 0) {
            String default_message = "An element '" + by.toString() + "' supposed to be present";
            throw new AssertionError(default_message + " " + error_message);
        }

    }

    private String waitForElementAndGetAttribute(By by, String attribute, String error_message, long timeOutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeOutInSeconds);
        return element.getAttribute(attribute);
    }










}
