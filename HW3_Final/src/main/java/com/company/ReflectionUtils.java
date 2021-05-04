package com.company;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;


public class ReflectionUtils { // по объекту получаем класс и выводим его поля а также значение полей у объекта object.getClass() -класс объекта
    public static HashMap<String, String> hashTableOfObjectClassFieldNamesInTheirValues(Object object) throws IllegalAccessException {
        HashMap<String, String> tablo = new HashMap<>();

        System.out.println("Class name:" + object.getClass());
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true); // вскрытие
           // System.out.println(field.getName());
           // System.out.println(field.get(object).toString());

            tablo.put(field.getName().toString(), field.get(object).toString());


        }
        // System.out.println("tablo");
        return tablo;
    }

    public static ArrayList<String> ArrayOfFieldNames(Object object) {
        ArrayList<String> tablo= new ArrayList<String>();
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true); // вскрытие
            //System.out.println(field.getName());
           tablo.add(field.getName().toString());


        }
        return tablo;
    }





    public static ArrayList<String> arrayOfWordsByClassFieldNames(Object object, HashMap<String, String> customFieldNamesOfOurClass) {
        ArrayList<String> arrayOfCustomFieldNames= new ArrayList<String>();
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true); // вскрытие
            //System.out.println(field.getName());

            arrayOfCustomFieldNames.add(customFieldNamesOfOurClass.get(field.getName().toString()));


        }
        return arrayOfCustomFieldNames;
    }













}




