package citis;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Class for creating a new city
 */

public class DataNewCity {

    public static City newCity(){
        Scanner sc = new Scanner(System.in);
        City city = new City();
         String name = enterName() ;
         Coordinates coordinates = enterCoordinates();
         Long area = enterArea();
         Long population = enterPopulation();
         Long metersAboveSeaLevel = enterMetersAboveSeaLevel();
         Integer telephoneCode = enterTelephoneCode();
         int agglomeration = enterAgglomeration();
         Governmet government = enterGovernment();
         Human governor = enterGovernor();

         city.setName(name);
         city.setCoordinates(coordinates);
         city.setArea(area);
         city.setPopulation(population);
         city.setMetersAboveSeaLevel(metersAboveSeaLevel);
         city.setTelephoneCode(telephoneCode);
         city.setAgglomeration(agglomeration);
         city.setGovernment(government);
         city.setGovernor(governor);

         return city;
    }

    public static Long longMaker(String nameValue){
        Long values = null;
        while (values == null) {
            try {
                System.out.println("Введите " + nameValue);
                values = Long.parseLong(Enter.writeString());
                if (values == null){
                    System.out.println("Поле не может быть null");
                }
            } catch (NumberFormatException e) {
                System.out.println("Неправельный формат данных. Должно быть поле типа Long ");
            }

        }
        return values;
    }

    public static  String enterName(){
        String name = " ";
        while (name.equals(" ")){
            System.out.println("Введите name города");
            name = Enter.writeString().trim();
            if (name.equals(" ")){
                System.out.println("Поле не может быть пустым");
            }
        }
        return name;
    }

    public static Coordinates enterCoordinates(){
        System.out.println("Введите координаты ");
        Float coordX = null;
        Long coordY = null ;
        while (coordX == null){
            try {
                System.out.println("Введите X: ");
                coordX = Float.parseFloat(Enter.writeString());
                if (coordX == null){
                    System.out.println("Поле не может быть null");
                }
            }catch (NumberFormatException e){
                System.out.println("Неправельный формат данных. Поле типа long");
            }

        }

            coordY = longMaker("Y");


        Coordinates coordinates = new Coordinates();
        coordinates.setX(coordX);
        coordinates.setY(coordY);

        return coordinates;
    }

    public static Long enterArea() {
        Long area = 0l;
        while (area<=0 ){
            area = longMaker("area") ;
            if (area < 0){
                System.out.println("Поле не может быть отрицательным");
            }
            if (area == 0){
                System.out.println("Поле не может быть нулём");
            }
        }

        return area;
    }

    public static Long enterPopulation() {
        Long population = 0l;
        while (population<=0 ){
            population = longMaker("population") ;
            if (population < 0){
                System.out.println("Поле не может быть отрицательным");
            }
            if (population == 0){
                System.out.println("Поле не может быть нулём");
            }
        }
        return population;
    }

    public static Long enterMetersAboveSeaLevel() {
        Long metersAboveSeaLevel = longMaker("meters above seaLevel") ;
        return metersAboveSeaLevel;
    }

    public static Integer enterAgglomeration() {
        int agglomeration = 0 ;

        while (agglomeration <= 0) {
            try {
                System.out.println(" Введите agglomeration города");
                agglomeration = Integer.parseInt(Enter.writeString());
                if (agglomeration == 0) {
                    System.out.println("Поле не может быть нулём");
                }

                if (agglomeration < 0) {
                    System.out.println("Поле не может быть отрецательным");
                }

            } catch (NumberFormatException e) {
                System.out.println("Неправельный формат данных. Поле типа integer");
            }
        }
        return agglomeration;
    }

    public static Integer enterTelephoneCode() {
        Integer telephoneCode = 0 ;

            while ((telephoneCode <= 0) ||(telephoneCode > 100000)) {
                    try {
                        System.out.println("Введите telephone code в диапозоне от 0 до 100000");
                        telephoneCode = Integer.parseInt(Enter.writeString());
                        if (telephoneCode > 100000) {
                            System.out.println("Неправельный формат, количество символов превышает допустимое значение");
                        }
                        if (telephoneCode == 0) {
                            System.out.println("Поле не может быть нулём");
                        }
                        if (telephoneCode < 0) {
                            System.out.println("Значение поля должно быть положительным и не превышать 100000");
                        }
                    } catch(NumberFormatException e){
                        System.out.println("Неправельный вормат данных. Поле типа integer");
                    }
                }
        return telephoneCode;
    }

    public  static  Governmet enterGovernment(){
        Governmet governmet = null;
        Governmet[] possibleGovernmets = Governmet.values();
        String[] possibleGovernmetsString = new String[possibleGovernmets.length];

        for(int i = 0; i <possibleGovernmets.length; i++){
            Governmet possibleGovernmet = possibleGovernmets[i];
            possibleGovernmetsString[i] = possibleGovernmet.name();
        }
        System.out.println("Введите значение поля goverrment. (Допустимые значения: "+ String.join(", ", possibleGovernmetsString) + ")");
       boolean correctInput = false;
       while ( !correctInput){
           List<String> governmetLict = Arrays.asList(possibleGovernmetsString);

           String governmetS = Enter.writeString();
           if(!governmetLict.contains(governmetS)){
               System.out.println("Неверное значение");
               System.out.println("Введите значение поля goverrment. (Допустимые значения: "+ String.join(", ", possibleGovernmetsString) + ")");
           } else {
               if(governmetLict.contains(governmetS)){
                   governmet = Governmet.valueOf(governmetS);
               }
               correctInput = true;
           }
       }
       return governmet;
    }

    public static Human enterGovernor(){
        Human governor = null;
        Long age = (long) 0;

            while ((age <= 0 ) || (age>100)) {
                age = longMaker("age governor");
                if(age<0){
                    System.out.println("Это поле не может быть отрицательным");
                }
                if(age==0){
                    System.out.println("Это поле не может быть нулём");
                }
                if(age> 100){
                    System.out.println("Значение поля слишком большое, думаю Ваш губернатор уже на пенсии. Пожалуйста введите адекватнай возраст. ");
                }
            }
            governor = new Human();
            governor.setAge(age);

        return governor;
    }
}
