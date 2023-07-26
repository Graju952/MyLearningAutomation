package com.capgemini.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DataStore {
    // Store data in an Excel sheet
    public void createExcelSheetAndStoreInExcelSheet(String data, Integer header_Row, Integer header_cell, String headerValue,Integer create_Row,Integer create_cell) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Data");

        Row headerRow = sheet.createRow(header_Row);

        Cell headerCell = headerRow.createCell(header_cell);
        headerCell.setCellValue(headerValue); // You can customize the headers here

        Row dataRow = sheet.createRow(create_Row);
        Cell dataCell = dataRow.createCell(create_cell);
        dataCell.setCellValue(data);

        // Save the Excel file
        String excelFileName = "data.xlsx";
        {
            try {
                FileOutputStream fileOut = new FileOutputStream(excelFileName);
                workbook.write(fileOut);
                workbook.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}

