/*
           go to url : https://ecommerce-playground.lambdatest.io/index.php?route=account/register
           register account test with fluent page object approach
*/


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task1Week7Test extends Tests {
@Test
        public  void testMethod() {
    driver.navigate().to("https://ecommerce-playground.lambdatest.io/index.php?route=account/register");

    RegisterPageTest registrationPage = new RegisterPageTest(driver);

    registrationPage.enterFirstName("Reem")
            .enterLastName("Almusharraf")
            .enterEmail("reem@sda12.com")
            .enterTelephone("05555555555")
            .enterPassword("123@@")
            .enterConfirmPassword("123@@")
            .subscribe(1)
            .submitRegistration();

    var currentUrl = driver.getCurrentUrl();
    Assertions.assertEquals("https://ecommerce-playground.lambdatest.io/index.php?route=account/success", currentUrl);
}
    }


