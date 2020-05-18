/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Priyanka Malpekar
 */
public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private String passportNumber;
    private int accountNumber;
    private String gender;
    private String email;
    private int windowseatNumber;
    private int middleseatNumber;
    private int aisleseatNumber;
    private String seatType;

    public int getWindowseatNumber() {
        return windowseatNumber;
    }

    public void setWindowseatNumber(int windowseatNumber) {
        this.windowseatNumber = windowseatNumber;
    }

    public int getMiddleseatNumber() {
        return middleseatNumber;
    }

    public void setMiddleseatNumber(int middleseatNumber) {
        this.middleseatNumber = middleseatNumber;
    }

    public int getAisleseatNumber() {
        return aisleseatNumber;
    }

    public void setAisleseatNumber(int aisleseatNumber) {
        this.aisleseatNumber = aisleseatNumber;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }
     
    Airplane airplane = new Airplane();
    
    
    private int seatPrice = airplane.getSeatPrice();
    
    public int getSeatPrice() {
        return seatPrice;
        
    }
   public void setSearprice(int seat) {
       this.seatPrice= seat;
   } 
}
