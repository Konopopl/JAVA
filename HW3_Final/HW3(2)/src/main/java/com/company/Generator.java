package com.company;

import java.text.ParseException;
import java.util.ArrayList;

public class Generator {
    public static void Generator(ArrayList<Object> objectsClass, String adress, ArrayList<String> kolomn) throws IllegalAccessException, ParseException {
    createFile.createFile(adress, kolomn);
    int iter=1;
    for(Object object:objectsClass){iter=(ExcelWorker.Exel( (ReflectionUtils.printFieldNames(object)) , iter, adress)); } ;                                                                  }






    }






