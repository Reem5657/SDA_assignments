import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPageTest extends Tests {

    public RegisterPageTest(WebDriver driver) {
        this.driver = driver;
    }
    public RegisterPageTest enterFirstName(String fName) {
        WebElement firstNameField = driver.findElement(By.id("input-firstname"));
        firstNameField.sendKeys(fName);
        return this;
    }
    public RegisterPageTest enterLastName(String lName) {
        WebElement lastNameField = driver.findElement(By.id("input-lastname"));
        lastNameField.sendKeys(lName);
        return this;
    }
    public RegisterPageTest enterEmail(String email) {
        WebElement emailField = driver.findElement(By.id("input-email"));
        emailField.sendKeys(email);
        return this;
    }
    public RegisterPageTest enterTelephone(String telephone) {
        WebElement telephoneField = driver.findElement(By.id("input-telephone"));
        telephoneField.sendKeys(telephone);
        return this;
    }
    public RegisterPageTest enterPassword(String pass) {
        WebElement passwordField = driver.findElement(By.id("input-password"));
        passwordField.sendKeys(pass);
        return this;
    }
    public RegisterPageTest enterConfirmPassword(String confirmPass) {
        WebElement confirmPasswordField = driver.findElement(By.id("input-confirm"));
        confirmPasswordField.sendKeys(confirmPass);
        return this;
    }

    public RegisterPageTest subscribe(int choice){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        if(choice==1){
            WebElement subscribeYes= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='input-newsletter-yes']")));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", subscribeYes);
            subscribeYes.click();
        }
        else {
            WebElement subscribeNo= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='input-newsletter-no']")));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", subscribeNo);
            subscribeNo.click();
        }
        return this;
    }
    public void submitRegistration() {
        WebElement agreeCheckbox = driver.findElement(By.xpath("//label[@for='input-agree']"));
        agreeCheckbox.click();
        WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        continueButton.click();
    }
}
