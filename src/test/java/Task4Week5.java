import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Set;

/*   Go to URL: http://facebook.com
       getCookies,
       addCookie,
       deleteCookieNamed,
       deleteAllCookies
    */
public class Task4Week5 extends Tests{

    @Test
    public void task1() {
        String url = "https://www.facebook.com/";
        driver.navigate().to(url);

        Set<Cookie> Allcookies = driver.manage().getCookies();
        System.out.println("Cookies:" + Allcookies);

        Cookie addedCookie = new Cookie("Reem", "SDA");
        driver.manage().addCookie(addedCookie);
        System.out.println("Added Cookie:" + addedCookie);


        driver.manage().deleteCookieNamed("Reem");
        System.out.println("The cookie is deleted");


        driver.manage().deleteAllCookies();
        System.out.println("All cookies deleted");

        Allcookies = driver.manage().getCookies();
        System.out.println("The Cookies after delettion:" + Allcookies);
    }
}
