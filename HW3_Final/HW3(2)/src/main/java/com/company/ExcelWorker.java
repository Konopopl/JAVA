package com.company;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;

public class ExcelWorker {
    public static int Exel(HashMap<String, String> tablo, int iter, String adress) throws ParseException {

        // создание самого excel файла в памяти
        HSSFWorkbook workbook = new HSSFWorkbook();
        // создание листа с названием "Просто лист"
        HSSFSheet sheet = workbook.createSheet("Sheet");

        // заполняем список какими-то данными
      //  List<DataModel> dataList = fillData();

        // счетчик для строк
        int rowNum = iter+1;

        // создаем подписи к столбцам (это будет первая строчка в листе Excel файла)
        Row row = sheet.createRow(rowNum);
        int i=0;
        for(String elem:tablo.keySet()){row.createCell(i).setCellValue(elem);i+=1;}

        rowNum += 1;
         row = sheet.createRow(rowNum);
         i=0;
        for(String elem:tablo.keySet()){row.createCell(i).setCellValue(tablo.get(elem) ); i +=1;}

      //  row.createCell(0).setCellValue("0");
      //  row.createCell(1).setCellValue("1");
      //  row.createCell(2).setCellValue("2");
       /// row.createCell(3).setCellValue("3");

        // заполняем лист данными
      //  for (DataModel dataModel : dataList) {
       //     createSheetHeader(sheet, ++rowNum, dataModel);
       // }

        // записываем созданный в памяти Excel документ в файл
        try (FileOutputStream out = new FileOutputStream(adress)) {
            workbook.write(out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Excel ");
        return(rowNum);
    }

    // заполнение строки (rowNum) определенного листа (sheet)
    // данными  из dataModel созданного в памяти Excel файла
   // private static void createSheetHeader(HSSFSheet sheet, int rowNum, DataModel dataModel) {
    //    Row row = sheet.createRow(rowNum);

  //      row.createCell(0).setCellValue(dataModel.getName());
  //      row.createCell(1).setCellValue(dataModel.getSurname());
   //     row.createCell(2).setCellValue(dataModel.getCity());
    //    row.createCell(3).setCellValue(dataModel.getSalary());
  //  }

    // заполняем список рандомными данными
    // в реальных приложениях данные будут из БД или интернета
  //  private static List<DataModel> fillData() {
  //      List<DataModel> dataModels = new ArrayList<>();
  //      dataModels.add(new DataModel("Howard", "Wolowitz", "Massachusetts", 90000.0));
  //      dataModels.add(new DataModel("Leonard", "Hofstadter", "Massachusetts", 95000.0));
  //      dataModels.add(new DataModel("Sheldon", "Cooper", "Massachusetts", 120000.0));

  //      return dataModels;
  //  }
}