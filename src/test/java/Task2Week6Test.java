import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;

/*
Go to https://testpages.eviltester.com/styled/apps/notes/simplenotes.html
Add 10 notes using data provider with excel
Run it with 3 different browsers using XML file
Run it parallel with 3 threads
//The excel file will be sent
//testng.xml file
//Test2 file
*/
public class Task2Week6Test extends Tests2{
    @Test(dataProvider ="notes")
    public void task2(String[][] notes){
        driver.get("https://testpages.eviltester.com/styled/apps/notes/simplenotes.html");
        WebElement sendNote = driver.findElement(By.id("add-note"));
        for (String[] note : notes) {
            WebElement titleField = driver.findElement(By.id("note-title-input"));
            titleField.sendKeys(note[0]);
            WebElement notesField = driver.findElement(By.id("note-details-input"));
            notesField.sendKeys(note[1]);
            sendNote.click();
        }

    }
    @DataProvider
    public Object[][] notes() throws IOException {
        FileInputStream file = new FileInputStream("/Users/reem/Desktop/dataprovidertask.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        Object[][] data = null;

        try {
            XSSFSheet sheet = workbook.getSheetAt(0);
            int numRows = 10;
            data = new Object[1][1];
            String[][] notes = new String[numRows][2];

            for (int i = 0; i < numRows; i++) {
                Row row = sheet.getRow(i);
                Cell cell1 = row.getCell(0);
                Cell cell2 = row.getCell(1);
                String cellValue1 = cell1.getStringCellValue();
                String cellValue2 = cell2.getStringCellValue();
                notes[i][0] = cellValue1;
                notes[i][1] = cellValue2;
            }
            data[0][0] = notes;
        } finally {
            file.close();
            workbook.close();
        }

        return data;
    }


}
