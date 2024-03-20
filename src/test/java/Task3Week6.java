import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;
import org.junit.jupiter.api.Test;
/* go to "https://practicetestautomation.com/practice-test-login/"
enter username - "student"
enter password - "incorrectPassword"
and login
SOFT ASSERT the error message shown
SOFT ASSERT the error message is "Your password is invalid!" */
public class Task3Week6 extends Tests{
    @Test
    public void task3(){
        String url= "https://practicetestautomation.com/practice-test-login/";
driver.navigate().to(url);
WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("submit"));

        username.sendKeys("student");
        password.sendKeys("incorrectPassword");
        loginButton.click();

        WebElement errorMsg = driver.findElement(By.id("error"));
        SoftAssert softassertDisplay = new SoftAssert();
        softassertDisplay.assertTrue(errorMsg.isDisplayed(), "The error message is not displayed");
        softassertDisplay.assertEquals(errorMsg.getText(), "Your password is invalid!");
        softassertDisplay.assertAll();


    }

}
