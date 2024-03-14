import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

// Go to amazon.com
// Take Full Page Screenshot.
// Take any spesific WebElement ScreenShot
public class Task6Week5 extends Tests {
    @Test
    public void test6() {
        String url = "https://www.amazon.com/";
        driver.navigate().to(url);
        try {
            File fullPageScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(fullPageScreenshot, new File("full_page_screenshot.png"));
            System.out.println("The screenshot has been taken.");

            WebElement Logo = driver.findElement(By.xpath("//i[@class='a-icon a-logo']"));

            File elementScreenshot = Logo.getScreenshotAs(OutputType.FILE);
            FileHandler.copy(elementScreenshot, new File("logo_screenshot.png"));
            System.out.println("Logo screenshot has been taken.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}

