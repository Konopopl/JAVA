package com.company;

import java.lang.reflect.Field;


public class ReflectionUtils1 { // по классу выводим его поля
    public static void printFieldNames(Class<?> clazz) {
        System.out.println("Class name:" + clazz.getName());
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName() + " " + field.getType().getName());
            System.out.println("parent " + clazz.getSuperclass()); // вывод родительского класса
        }
    }

    public static void main(String[] args) {


        printFieldNames(Person.class);
        printFieldNames(Number.class);
    }


    //public static void main(String[] args) {

    // printFieldNames(ArrayList.class);
    //  }


}
