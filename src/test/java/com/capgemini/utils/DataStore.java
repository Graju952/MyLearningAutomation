package com.capgemini.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.capgemini.utils.Helper.driver;

public class DataStore {
    List<List<String>> tableData;

    public void storeTable(){
  
    // Find the table element
    WebElement table = driver.findElement(By.xpath("//table[@id='idTrainingGapTable']")); 

    // Get all the rows of the table
    List<WebElement> rows = table.findElements(By.tagName("tr"));

    // Create a list to store the table data
     tableData = new ArrayList<>();

    // Loop through each row
    for (WebElement row : rows) {
        // Get the columns of the current row
        List<WebElement> columns = row.findElements(By.tagName("td"));

        // Create a list to store the data of the current row
        List<String> rowData = new ArrayList<>();

        // Loop through each column in the row
        for (WebElement column : columns) {
            // Get the text of the cell and add it to the rowData list
            rowData.add(column.getText());
        }

        // Add the rowData list to the tableData list
        tableData.add(rowData);
    }
}


    // Store data in an Excel sheet
    public void createExcelSheetAndStoreInExcelSheet() {
        storeTable();
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Table Data");

            // Create a Font for styling header cells
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFont(headerFont);

            // Create header row
            Row headerRow = sheet.createRow(0);

            // Get the headers from the first row of tableData
            List<String> headers = tableData.get(0);

            // Write the headers to the header row
            for (int i = 0; i < headers.size(); i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers.get(i));
                cell.setCellStyle(headerCellStyle);
            }

            // Write the table data to the sheet
            for (int i = 1; i <= tableData.size(); i++) {
                Row row = sheet.createRow(i);

                List<String> rowData = tableData.get(i - 1);

                for (int j = 0; j < rowData.size(); j++) {
                    row.createCell(j).setCellValue(rowData.get(j));
                }
            }

            // Write the workbook to an Excel file
            try (FileOutputStream fileOut = new FileOutputStream("src/test/java/com/capgemini/utils/dateStore.xlsx")) {
                workbook.write(fileOut);
                System.out.println("Table data has been successfully stored in the Excel file.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

