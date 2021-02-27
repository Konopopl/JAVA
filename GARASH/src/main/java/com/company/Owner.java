package main.java.com.company;

import java.util.HashMap;
import java.util.Map;

public class Owner {
    public final String name;
    public final String lastName;
    public final int age;

    public Owner() {
        name = null;
        lastName = null;
        age = 0;
    }
    public Owner(String Name,String LastName , int Age ) {
        name = Name;
        lastName = LastName;
        age = Age;
    }

    public  void displayInfo() { System.out.printf("\n name: %s \t lastName: %s \t  age: %d \n "  ,
            name, lastName,age);}







}
