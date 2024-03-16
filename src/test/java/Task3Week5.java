import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.time.Duration;

/*
   Go to ebay
   Scroll to the bottom of the page using a robot
   Click on the "Back to top" web element
   Click on the announcement at the bottom of the page (in the footer) using JavascriptExecutor
   Use Actions to type "ClarusWay" in the search box and perform the search
*/
public class Task3Week5 extends Tests{
    @Test
    public void task1() throws AWTException{
        String url = "https://www.ebay.com/";
        driver.navigate().to(url);


        Robot robot = new Robot();
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        robot.delay(3000);
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        robot.delay(3000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement backToTopButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='Scroll to top']")));
        if(backToTopButton.isDisplayed()) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", backToTopButton);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", backToTopButton);
        }

        WebElement ebayBlog = driver.findElement(By.xpath("//a[@href='https://community.ebay.com/t5/Announcements/bg-p/Announcements' and @class='thrd']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", ebayBlog);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        WebElement searchInputBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='lia-form-type-text lia-autocomplete-input search-input lia-search-input-message']")));
        Actions actions = new Actions(driver);
        actions.moveToElement(searchInputBox).click().sendKeys("ClarusWay").sendKeys(Keys.RETURN).perform();


    }
}
