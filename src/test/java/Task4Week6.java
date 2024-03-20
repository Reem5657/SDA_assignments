import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.time.Duration;

//Open the site: http://opencart.abstracta.us/index.php?route=account/login
//Login with that credentials
//Email: clarusway@gmail.com
//Password: 123456789
//Using the Search function do it with Data Provider for Mac, iPad and Samsung.
public class Task4Week6 {

    protected WebDriver driver;

    protected Wait<WebDriver> wait;
    @Test
    public void login(){
        driver.navigate().to("http://opencart.abstracta.us/index.php?route=account/login");

        WebElement email = driver.findElement(By.id("input-email"));
        WebElement password = driver.findElement(By.id("input-password"));
        WebElement loginButton = driver.findElement(By.cssSelector("input.btn.btn-primary"));

        email.sendKeys("clarusway@gmail.com");
        password.sendKeys("123456789");
        loginButton.click();
    }
@Test(dataProvider = "source", dependsOnMethods = "login")
    public void task4(String search){
        WebElement searchField = driver.findElement(By.xpath("//input[@class=\"form-control input-lg\"]"));
    WebElement searchButton = driver.findElement(By.xpath("//button[@class=\"btn btn-default btn-lg\"]"));
    searchField.clear();
        searchField.sendKeys(search);
        searchButton.click();

    }
@DataProvider
    public Object[][] source(){
    return new Object[][] { {"Mac"}, {"Ipad"}, {"Samsung"}};
    }


@BeforeClass
public void beforeEach(){
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("start-maximized");
    driver = new ChromeDriver(chromeOptions);
    wait = new WebDriverWait(driver, Duration.ofSeconds(5));
}

@AfterClass
public void afterEach(){
    driver.quit();
}

    }
