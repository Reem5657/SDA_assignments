import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertTrue;

/*
Go to URL: http://demo.guru99.com/test/drag_drop.html
Drag and drop the BANK button to the Account section in DEBIT SIDE
Drag and drop the SALES button to the Account section in CREDIT SIDE
Drag and drop the 5000 button to the Amount section in DEBIT SIDE
Drag and drop the second 5000 button to the Amount section in CREDIT SIDE
Verify the visibility of Perfect text.
*/
public class Task1Week5 {
    WebDriver driver;
    @Test
    public void task1(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        String url= "http://demo.guru99.com/test/drag_drop.html";
        driver.navigate().to(url);
        WebElement BankButton = driver.findElement(By.xpath("//a[@class='button button-orange' and text()=' BANK ']"));
        WebElement draglocation =driver.findElement(By.id("bank"));
        DragAndDrop(BankButton, draglocation);
        WebElement salesButton = driver.findElement(By.xpath("//a[@class='button button-orange' and text()=' SALES ']"));
        WebElement draglocation2 =driver.findElement(By.id("loan"));
        DragAndDrop(salesButton, draglocation2);
        WebElement fiveHundredButton = driver.findElement(By.xpath("//a[@class='button button-orange' and text()=' 5000 ']"));
        WebElement draglocation3 =driver.findElement(By.id("amt7"));
        DragAndDrop(fiveHundredButton, draglocation3);
        WebElement fiveHundredButton2 = driver.findElement(By.xpath("//a[@class='button button-orange' and text()=' 5000']"));
        WebElement draglocation4 =driver.findElement(By.id("amt8"));
        DragAndDrop(fiveHundredButton2, draglocation4);
        WebElement perfectText = driver.findElement(By.xpath("//a[@class='button button-green' and text()='Perfect!']"));
        assertTrue("Perfect text is not visible.", perfectText.isDisplayed());
    }
    public void DragAndDrop(WebElement source, WebElement target){
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source,target).build().perform();
    }
}
