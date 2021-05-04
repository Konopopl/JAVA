package com.company;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class createFile {
    public static void createFile(String adress, ArrayList<String> kolomn) {
        // создание самого excel файла в памяти
        HSSFWorkbook workbook = new HSSFWorkbook();
        // создание листа с названием "Просто лист"
        HSSFSheet sheet = workbook.createSheet("Sheet");


        int rowNum = 0;

        // создаем подписи к столбцам (это будет первая строчка в листе Excel файла)
        Row row = sheet.createRow(rowNum);
        int i = 0;
        for (String elem : kolomn) {
            row.createCell(i).setCellValue(elem);
            i += 1;
        }


        try (FileOutputStream out = new FileOutputStream(new File(adress))) {
            workbook.write(out);
            out.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
        System.out.println("Excel ");

    }


}



