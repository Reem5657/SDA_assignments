
//Store the path of the file as string and open the file.
//Open the workbook.
//Open the first worksheet.
//Go to the first row.
//Create a cell on the 3rd column (2nd index) on the first row.
//Write “POPULATION” on that cell.
//Create a cell on the 2nd row 3rd cell(index2), and write data.
//Create a cell on the 3rd row 3rd cell(index2), and write data.
//Create a cell on the 4th row 3rd cell(index2), and write data.
//Write and save the workbook.
//Close the file.
//Close the workbook.

//The 3rd column on excel file must be empty before running.
// Otherwise, new data will be written on the old data

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class Task5Week5 {
    @Test
    public void Task5() throws IOException {
        FileInputStream file = new FileInputStream("/Users/reem/Desktop/BookNew.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);

           try{ XSSFSheet sheet = workbook.getSheetAt(0);
            Row firstRow = sheet.getRow(0);


            Row row1 = sheet.createRow(0);
            Cell cell = row1.createCell(2);
            cell.setCellValue("POPULATION");
//Create a cell on the 2nd row 3rd cell(index2), and write data.

               Row row2 = sheet.createRow(1);
               Cell cell2 = row2.createCell(2);
               cell2.setCellValue("2nd row, 3rd cell");
//Create a cell on the 3rd row 3rd cell(index2), and write data.

               Row row3 = sheet.createRow(2);
               Cell cell3 = row3.createCell(2);
               cell3.setCellValue("3rd row, 3rd cell");
//Create a cell on the 4th row 3rd cell(index2), and write data.
               Row row4 = sheet.createRow(3);
               Cell cell4 = row4.createCell(2);
               cell4.setCellValue("4th row, 3rd cell");

               FileOutputStream output = new FileOutputStream("/Users/reem/Desktop/BookNew.xlsx");
               workbook.write(output);

    }finally {
               file.close();
               workbook.close();
           }
           }
}
