import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

/** ( This task should be managed with keyboard actions ) */
// go to https://www.google.com/
// search for "Scroll Methods" by using an Actions object
public class Task2Week5 {
    WebDriver driver;
    @Test
    public void task1() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        String url = "https://www.google.com/";
        driver.navigate().to(url);
        Actions actions = new Actions(driver);
        actions.sendKeys("Scroll Methods").build().perform();
        actions.sendKeys(Keys.ENTER).build().perform();
        driver.quit();
    }
}
