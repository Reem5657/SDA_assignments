import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

//Go to URL: http://crossbrowsertesting.github.io/
//Click to To-Do App
//Checking Box to do-4 and Checking Box to do-5
//If both clicks worked, then the following List should be have length 3.
//Assert that this is correct
//Assert that the to do we added is present in the list
//Archiving old todos
//If our archive link worked, then the following list should have length 4.
//Assert that this is true as well
//Doing Cross Browser Testing.
public class Task5Week6 extends Tests2{
    @Test
    public void task5(){
        driver.navigate().to("http://crossbrowsertesting.github.io/");
        WebElement toDoApp = driver.findElement(By.xpath("//a[@href=\"todo-app.html\"]"));
        toDoApp.click();
        WebElement toDo4 = driver.findElement(By.name("todo-4"));
        WebElement toDo5 = driver.findElement(By.name("todo-5"));
        toDo4.click();
        toDo5.click();
        WebElement actual = driver.findElement(By.className("ng-binding"));
   assertEquals("The list is not 3",actual.getText(),"3 of 5 remaining" );
        WebElement toDoText= driver.findElement(By.id("todotext"));
        toDoText.sendKeys("The new To do Task");
        WebElement addButton= driver.findElement(By.id("addbutton"));
        addButton.click();
        WebElement addedTask= driver.findElement(By.xpath("//span[@class='done-false' and contains(text(), 'The new To do Task')] "));
        assertTrue("The new Task is not added", addedTask.isDisplayed());

 WebElement archive = driver.findElement(By.xpath("//a[text() ='archive']"));
 archive.click();
        assertEquals("The list is not 3",actual.getText(),"4 of 4 remaining" );
    }
}
