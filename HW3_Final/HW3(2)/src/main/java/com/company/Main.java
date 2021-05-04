package com.company;

import java.text.ParseException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, ParseException {
        Person ignaty = new Person("Shatalovich", 78);
        Person ignaty2 = new Person("Shatalovich2", 782);
        ReflectionUtils.printFieldNames(ignaty);
        //  ExcelWorker.fillData(ignaty);
        //  int iter=1;
        // ExcelWorker.Exel(ReflectionUtils.printFieldNames(ignaty),iter);
        ArrayList<Object> list = new ArrayList<Object>();
        list.add(ignaty);
        list.add(ignaty2);
        ArrayList<String> kolomn = new ArrayList<String>();
        kolomn.add("1");
        kolomn.add("2");
        String adress = "C:\\Users\\Pavlo\\Desktop\\davvlen\\generate.xls";
        Generator.Generator(list, adress, kolomn);


    }
}
