/*@homework
Feature: Homework
Scenario Outline:  dynamic url
Given user goes to the "<page_url>"
Then user waits for 5 seconds
And verifies that the page title contains the word "<title>"
And closes the page
Examples:
        |page_url|  title|
        |googleUrl | Google |
        |amazonUrl | Amazon |
        |youtubeUrl | YouTube  |*/

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Task2Week7 {
    WebDriver driver;
    @Given("user goes to the {string}")
    public void user_goes_to_the(String string) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(string);
    }
    @Then("user waits for 5 seconds")
    public void user_waits_for_seconds() throws InterruptedException {
        Thread.sleep(5000);
    }
    @Then("verifies that the page title contains the word {string}")
    public void verifies_that_the_page_title_contains_the_word(String string) {
        Assertions.assertTrue(driver.getTitle().contains(string));
//        Assertions.assertEquals(driver.getTitle(),string);
    }
    @Then("closes the page")
    public void closes_the_page() {
        driver.close();
        driver.quit();

    }}



