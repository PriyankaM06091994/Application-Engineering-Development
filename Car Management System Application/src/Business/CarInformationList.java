/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author tusiyu
 */
public class CarInformationList {
    
    private static CarInformationList carLists;
    //public List<Car> carList;
    
    public static ArrayList<Car> carList = new ArrayList<>();
    
    private static Date date = new Date();

    public static Date getDate() {
        return date;
    }

    public static void setDate(Date date) {
        CarInformationList.date = date;
    }
    
    public CarInformationList(){
        
        
        
        Car car1 = new Car(true, "Ferrari", 2019, 1, 2, 1,"Red One", "Boston", true);
        Car car2 = new Car(true, "BMW", 2019, 1, 4, 2, "X1", "New York", true);
        Car car3 = new Car(true, "Toyota", 2018, 1, 4, 3, "T1", "Boston", true);
        Car car4 = new Car(true, "GM", 2018, 1, 4, 4, "G1", "New York", true);
        Car car5 = new Car(true, "Toyota", 2017, 1, 4, 5, "T2", "Chicago", true);
        Car car6 = new Car(true, "GM", 2017, 1, 4, 6, "G2", "Chicago", true);
        Car car7 = new Car(true, "Ferrari", 2016, 1, 4, 7, "T5", "Seattle", true);
        Car car8 = new Car(true, "BMW", 2016, 1, 4, 8, "X2", "Seattle", true);
        Car car9 = new Car(true, "Toyota", 2019, 1, 4, 9, "T3", "Austin", true);
        Car car10 = new Car(true, "GM", 2019, 1, 4, 10, "G3", "Austin", true);
        
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carList.add(car4);
        carList.add(car5);
        carList.add(car6);
        carList.add(car7);
        carList.add(car8);
        carList.add(car9);
        carList.add(car10);
        
    }
   public static void addCar (Car car)
   {
       carList.add(car); //return car list
   }
    public static CarInformationList  getCarList() {
        carLists = new CarInformationList();
        return carLists;
    }
public static void deleteCar(Car car)
{
  carList.remove(car);
}
public static ArrayList<Car> getArrayUniqueList() {
    return carList;
}
public static ArrayList<Car> searchByBrand(String name, ArrayList<Car> carList){
    ArrayList<Car> brandlist = new ArrayList<>();
    
    for (Car c : carList){
        if(c.getBrand().equalsIgnoreCase(name)){
            brandlist.add(c);
           // System.out.println(brandlist);
        }
    }
    return brandlist;
}
public static ArrayList<Car> searchByCity(String name, ArrayList<Car> carList){
    ArrayList<Car> citylist = new ArrayList<>();
    
    for (Car c : carList){
        if(c.getAvailble_city().equalsIgnoreCase(name)){
            citylist.add(c);
            //System.out.println(citylist);
        }
    }
    return citylist;
}

public static ArrayList<Car> searchByModel(String name, ArrayList<Car> carList){
    ArrayList<Car> modellist = new ArrayList<>();
    
    for (Car c : carList){
        if(c.getModel_num().equalsIgnoreCase(name)){
            modellist.add(c);
            //System.out.println(citylist);
        }
    }
    return modellist;
}
    public static ArrayList<Car> searchByYear(int year, ArrayList<Car> carList){
    ArrayList<Car> yearlist = new ArrayList<>();
    
    for (Car c : carList){
        if(c.getManufactured_year()== year){
            yearlist.add(c);
            //System.out.println(yearlist);
        }
    }
    return yearlist;
}
    
    public static ArrayList<Car> searchBySerial(int serial, ArrayList<Car> carList){
    ArrayList<Car> seriallist = new ArrayList<>();
    
    for (Car c : carList){
        if(c.getSerial_num()== serial){
            seriallist.add(c);
            //System.out.println(seriallist);
        }
    }
    return seriallist;
}
    public static ArrayList<Car> searchByAvail(Boolean available, ArrayList<Car> carList){
    ArrayList<Car> availlist = new ArrayList<>();
    
    for (Car c : carList){
        if(c.isAvailable()== available){
            availlist.add(c);
            //System.out.println(seriallist);
        }
    }
    return availlist;
}
    public static ArrayList<Car> searchByMainCert(Boolean MainCert, ArrayList<Car> carList){
    ArrayList<Car> maincertlist = new ArrayList<>();
    
    for (Car c : carList){
        if(c.isAvailable()== MainCert){
            maincertlist.add(c);
            //System.out.println(seriallist);
        }
    }
    return maincertlist;
}
    public static ArrayList<Car> searchSeats(int maxSeats,int minSeats, ArrayList<Car> carList){
    ArrayList<Car> searchlist = new ArrayList<>();
    
    for (Car c : carList){
        if(c.getMin_seats() >= minSeats && c.getMax_seats() <= maxSeats){
            searchlist.add(c);
            //System.out.println(searchlist);
        }
    }
    return searchlist;
}
   public static ArrayList<Car> searchByFirstAvailable(Boolean available, ArrayList<Car> carList){
    ArrayList<Car> availableList = new ArrayList<>();
    
    for (Car c : carList){
        if(c.isAvailable() == available){
            
            availableList.add(c);
            break;
             }
        }
    return availableList; 
   }
}