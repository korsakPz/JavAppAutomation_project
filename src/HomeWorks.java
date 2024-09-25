import com.gargoylesoftware.htmlunit.javascript.host.Console;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
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

import java.net.URL;
import java.util.List;

public class HomeWorks {



    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","AndroidTestDevice");
        capabilities.setCapability("platformVersion","8.0");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("appPackage","org.wikipedia");
        capabilities.setCapability("appActivity",".main.MainActivity");
        capabilities.setCapability("app","C:\\Users\\Korsak\\Documents\\AutoTestirovanie\\JavAppAutomation\\APKs\\org.wikipedia.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }


@Test
public void testHomeWorkEx5()
{
    String name_of_folder = "Test list1";
    String search_line = "Java";



    waitForElementAndClick(
            By.xpath("//*[contains(@text, 'Skip')]"),
            "Cannot SKIP button",
            5
    );


    waitForElementAndClick(
            By.xpath("//*[@resource-id='org.wikipedia:id/search_container']//*[@text='Search Wikipedia']"),
            "Cannot find search line __Search Wikipedia__",
            5
    );

    waitForElementAndSendKeys(
            By.xpath("//*[@resource-id='org.wikipedia:id/search_plate']//*[@text='Search Wikipedia']"),
            search_line,
            "Cannot find articles by JAVA articles",
            15
    );

    waitForElementAndClick(
            By.xpath("//*[contains(@text, 'Java (programming language)')]"),
            "Cannot find search article by JAVA",
            5
    );

    //First click to context menu button
    waitForElementAndClick(
            By.xpath("//*[@resource-id='org.wikipedia:id/page_save']"),
            "Cannot find context button for SAVE article. First action",
            15
    );

    //Second click to context menu button
    waitForElementAndClick(
            By.xpath("//*[contains(@text, 'Java (programming language)')]"),
            "Hide context menu",
            30
    );

    waitForElementAndClick(
            By.xpath("//*[@resource-id='org.wikipedia:id/page_save']"),
            "Cannot find save context menu",
            15
    );

    waitForElementAndSendKeys(
            By.xpath("//*[@resource-id='org.wikipedia:id/content']//[@text='Add to another reading list']"),
            name_of_folder,
            "Cannot find text line for input in the context menu",
            15
    );


//    waitForElementAndClick(
//            By.xpath("//*[@resource-id='android:id/button1']//*[@text='OK']"),
//            "Cannot find button OK, in the context menu, for add list",
//            40
//    );

//    waitForElementAndClick(
//            By.xpath("//*[@class='android.widget.ImageButton']"),
//            "Cannot find button BACK on the article",
//            15
//    );



//    waitForElementAndClick(
//            By.xpath("//*[@class='android.view.ViewGroup']//*[@class='android.widget.ImageButton']"),
//            "Cannot find button BACK on the find list articles",
//            15
//    );
//
//    waitForElementAndClick(
//            By.xpath("//*[@class='android.widget.LinearLayout']//*[@text='Saved']"),
//            "Cannot find SAVE button on the down panel",
//            15
//    );
//
//    waitForElementAndClick(
//            By.xpath("//*[@resource-id='org.wikipedia:id/item_title_container']//*[@text='" + name_of_folder + "']"),
//            "Cannot find SAVEd think",
//            15
//    );
//
//
//    swipeElementToLeft(
//            By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Java (programming language)']"),
//            "Cannot fined save article"
//
//    );
//
//    waitForElementNotPresent(
//            By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Java (programming language)']"),
//            "Cannot delet saved article",
//            15
//
//    );

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
                .press(x, start_y)
                .waitAction(timeOfSwipe)
                .moveTo(x, end_y)
                .release()
                .perform();
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
                .press(right_x, middle_y)
                .waitAction(300)
                .moveTo(left_x, middle_y)
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
