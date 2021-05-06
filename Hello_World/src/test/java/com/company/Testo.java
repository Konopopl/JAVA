package com.company;
/*
import org.testng.annotations.Test;

import static org.junit.Assert.*; */
import org.junit.jupiter.api.*;

public class Testo {
    @Test
    public void Testo(){

 Object o= Main.program("C:\\Users\\Pavlo\\IdeaProjects\\Hello_World\\names1.txt");
 if(o instanceof legal  ) { legal l=(legal)o;
     Assertions.assertEquals(l.name,"ignat");
     Assertions.assertEquals(l.surname,"ignatovich");
     Assertions.assertEquals(l.inn,1488);

     l.displayInfo();

        }
    }

    @Test
    public void Testo1(){

        Object o= Main.program("C:\\Users\\Pavlo\\IdeaProjects\\Hello_World\\names2.txt");
        if(o instanceof individual  ) { individual  l=(individual)o;
            Assertions.assertEquals(l.name,"hghg");
            Assertions.assertEquals(l.surname,"hghghghghghg");
            Assertions.assertEquals(l.age,88);
            Assertions.assertEquals(l.inn,777);
            l.displayInfo();

        }
    }

    @Test
    public void Testo2(){

        Object o= Main.program("C:\\Users\\Pavlo\\IdeaProjects\\Hello_World\\names3.txt");
        if(o instanceof holding ) { holding  l=(holding)o;
            Assertions.assertEquals(l.name,"Felix ");
            Assertions.assertEquals(l.surname,"Svarch");
            Assertions.assertEquals(l.inn,234 );
            Assertions.assertEquals(l.gender,"men");

            l.displayInfo();

        }
    }
}


























