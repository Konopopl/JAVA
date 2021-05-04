package com.company;
/*
import org.testng.annotations.Test;

import static org.junit.Assert.*; */
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Testo {
    @Test
    public void Testo() throws IllegalAccessException {
        Person ignaty  = new Person("Shatalovich", 78);
        Person ignaty2  = new Person("Shatalovich2", 782);

        ArrayList<Object> objects = new ArrayList<>();
        objects.add(ignaty);
        objects.add(ignaty2);

        HashMap<String, String> tabl = new HashMap<String, String>();

        tabl.put("name","name");
        tabl.put("age","age");

        CreateFile.createFile("C:\\Users\\Pavlo\\Desktop\\davvlen\\raport.xls", objects,tabl);



        }
    }



























