
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
    Create tests that depend on each other
    Create beforeClass and set up settings.
    By creating interdependent tests;
    First go to Facebook.
    Then go to Google depending on Facebook,
    Then go to Amazon depending on Google
    Close the driver.
     */
public class Task1Week6 {
     WebDriver driver;
    @BeforeClass
    public void setUp(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
    }
@Test
    public void faceBookTest(){
        driver.navigate().to("https://www.facebook.com/");

    }

    @Test(dependsOnMethods = {"faceBookTest"})
    public void google(){
        driver.navigate().to("https://www.google.com/");

    }
    @Test(dependsOnMethods = {"google"})
    public void amazon(){
        driver.navigate().to("https://www.amazon.com/");

    }
    @AfterClass
    public void closing(){
        driver.quit();
    }


}
