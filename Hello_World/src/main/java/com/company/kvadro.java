package com.company;

import java.io.FileInputStream;
import java.io.IOException;

public class kvadro {
    public String[] reading(String s) {
        String datafail = "";
        try (FileInputStream fin = new FileInputStream(s)) {
            System.out.printf("File size: %d bytes \n", fin.available());
            String type;
            String j;
            j = "";
            int i = -1;
            int iter = 0;
            while ((i = fin.read()) != -1) {
                if (((char) i == ' ') | ((char) i == '\n')) {
                    type = j;
                    datafail += j;
                    iter += 1;
                    // if(iter==2){ objectlegal.name = type;}
                    //if(iter==3){ objectlegal.surname = type;}
                    //if(iter==2){ }


                    j = " ";
                    //legal a = new legal();
                    //System.out.printf(" " + iter + type);

                } else {

                    j = j + (char) i;
                }


                // System.out.print((char)i);

            }
            type = j;
            datafail += j;
            iter += 1;

            // if(iter==4){ objectlegal.inn = Integer.parseInt(type);}
            //legal a = new legal();
            //System.out.printf(" "+iter+type);


        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        //objectlegal.displayInfo();
        //System.out.printf(datafail);
        String[] data = datafail.split(" ");

        return(data);

    }
}