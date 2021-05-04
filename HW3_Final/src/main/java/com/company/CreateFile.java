package com.company;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class CreateFile {
    public static void createFile(String adress,  ArrayList<Object> objects , HashMap<String, String> customFieldNamesOfOurClass) throws IllegalAccessException {

        HSSFWorkbook workbook = new HSSFWorkbook();

        HSSFSheet sheet = workbook.createSheet("Sheet");


        int rowNum = 0;


        Row row = sheet.createRow(rowNum);
        int i = 0;
        ArrayList<String> arrayOffieldNamesOfOurClass = new ArrayList<String>();

      //   for (String elemkolomn : ReflectionUtils.ArrayOfFieldNames(objects.get(0))) { // если не требуется менять названия полей класса на пользовательские
     //       arrayOffieldNamesOfOurClass.add(elemkolomn);
     //   }




        for (String elemkolomn : ReflectionUtils.arrayOfWordsByClassFieldNames(objects.get(0),customFieldNamesOfOurClass)) {
            arrayOffieldNamesOfOurClass.add(elemkolomn);
        }


        for (String elem : arrayOffieldNamesOfOurClass) {
            row.createCell(i).setCellValue(elem);
            i += 1;
        }

        rowNum = 1;
        row = sheet.createRow(rowNum);
        i = 0;
        for (Object o : objects) {
            HashMap<String, String> tablo = new HashMap<String, String>();
            tablo = ReflectionUtils.hashTableOfObjectClassFieldNamesInTheirValues(o);
            row = sheet.createRow(rowNum);
            for (String obTablo : tablo.values()) {

                //System.out.println(obTablo);

                row.createCell(i).setCellValue(obTablo);
                i += 1;


            }
            i = 0;
            rowNum += 1;

        }


        try (FileOutputStream out = new FileOutputStream(new File(adress))) {
            workbook.write(out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Excel ");

    }


}



