package com.company;

public enum ENUM {
     legal{



         void newobject(String[] data){

         var legal = "legal";
         var individual = "individual";
         var holding = "holding";
         var x=0;

         legal objectlegal = new legal();
         objectlegal.name = "";
         objectlegal.surname = "";
         objectlegal.inn = 0;
         String namelegal = "";
         String surnamelegal = "";
         int innlegal = 0;


         x = 0;
            while (!(data[x].equalsIgnoreCase("name")) & (x < 100)) {
             x += 1;
         }
         namelegal = data[x + 1];

         x = 0;
            while (!(data[x].equalsIgnoreCase("surname")) & (x < 100)) {
             x += 1;
         }
         surnamelegal = data[x + 1];
         x = 0;
            while (!(data[x].equalsIgnoreCase("inn")) & (x < 100)) {
             x += 1;
         }
         innlegal = Integer.parseInt(data[x + 1]);

         namelegal = namelegal.trim();
         surnamelegal = surnamelegal.trim();


         objectlegal.name = namelegal;
         objectlegal.surname = surnamelegal;
         objectlegal.inn = innlegal;
            objectlegal.displayInfo();              }
            },
    holding{
        void newobject(String[] data) {
            var legal = "legal";
            var individual = "individual";
            var holding = "holding";
            var x = 0;
            holding objectholding = new holding();
            objectholding.name = "";
            objectholding.surname = "";

            objectholding.inn = 0;
            String nameholding = "";
            String surnameholding = "";
            String genderholding = "";
            int innholding = 0;


            x = 0;
            while (!(data[x].equalsIgnoreCase("name")) & (x < 100)) {
                x += 1;
            }
            nameholding = data[x + 1];

            x = 0;
            while (!(data[x].equalsIgnoreCase("surname")) & (x < 100)) {
                x += 1;
            }
            surnameholding = data[x + 1];
            x = 0;
            while (!(data[x].equalsIgnoreCase("inn")) & (x < 100)) {
                x += 1;
            }
            innholding = Integer.parseInt(data[x + 1]);

            x = 0;
            while (!(data[x].equalsIgnoreCase("gender")) & (x < 100)) {
                x += 1;
            }
            genderholding = data[x + 1];

            nameholding = nameholding.trim();
            surnameholding = surnameholding.trim();
            genderholding = genderholding.trim();


            objectholding.name = nameholding;
            objectholding.surname = surnameholding;
            objectholding.inn = innholding;
            objectholding.gender = genderholding;
            //System.out.println(ageindividual);
            objectholding.displayInfo();


        }

    },
    individual{

        void newobject(String[] data) {

            var legal = "legal";
            var individual = "individual";
            var holding = "holding";
            var x = 0;


            individual objectindividual = new individual();
            objectindividual.name = "";
            objectindividual.surname = "";
            objectindividual.age = 0;
            objectindividual.inn = 0;
            String nameindividual = "";
            String surnameindividual = "";
            int innindividual = 0;
            int ageindividual = 0;


            x = 0;
            while (!(data[x].equalsIgnoreCase("name")) & (x < 100)) {
                x += 1;
            }
            nameindividual = data[x + 1];

            x = 0;
            while (!(data[x].equalsIgnoreCase("surname")) & (x < 100)) {
                x += 1;
            }
            surnameindividual = data[x + 1];
            x = 0;
            while (!(data[x].equalsIgnoreCase("inn")) & (x < 100)) {
                x += 1;
            }
            innindividual = Integer.parseInt(data[x + 1]);
            x = 0;
            while (!(data[x].equalsIgnoreCase("age")) & (x < 100)) {
                x += 1;
            }
            ageindividual = Integer.parseInt(data[x + 1]);


            nameindividual = nameindividual.trim();
            surnameindividual = surnameindividual.trim();


            objectindividual.name = nameindividual;
            objectindividual.surname = surnameindividual;
            objectindividual.inn = innindividual;
            objectindividual.age = ageindividual;
            //System.out.println(ageindividual);
            objectindividual.displayInfo();


        }




    };
     abstract void newobject(String[] data );
}
