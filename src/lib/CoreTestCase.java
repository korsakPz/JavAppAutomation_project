package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.time.Duration;

public class CoreTestCase  extends TestCase {

    protected AppiumDriver driver;
    private static String AppiumURL = "http://127.0.0.1:4723/";

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","AndroidTestDevice");
        capabilities.setCapability("platformVersion","12.0");
        capabilities.setCapability("automationName","UiAutomator2");
        capabilities.setCapability("appPackage","org.wikipedia");
        capabilities.setCapability("appActivity",".main.MainActivity");
        capabilities.setCapability("app","C:\\Users\\Korsak\\Documents\\AutoTestirovanie\\JavAppAutomation\\APKs\\org.wikipedia.apk");

        driver = new AndroidDriver(new URL(AppiumURL), capabilities);
        this.rotateScreenPortrait();  //Before start test application rotate to Portrait orientation
    }


    @Override
    protected void tearDown() throws Exception
    {

        driver.quit();

        super.tearDown();
    }

    protected void rotateScreenPortrait()
    {
        driver.rotate(ScreenOrientation.PORTRAIT);
    }

    protected void rotateScreenLandscape()
    {
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }

    protected void backgroundApp(int seconds)
    {
        driver.runAppInBackground(seconds);

                //driver.runAppInBackground(Duration.ofSeconds(seconds)); 333
    }

}
