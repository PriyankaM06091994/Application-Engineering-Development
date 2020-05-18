/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.Date;

/**
 *
 * @author Priyanka Malpekar
 */
public class Airplane {
    
    private Airliner airliner;
    Airliner air = new Airliner();
    
    private String manufacturerName;
    private int flightNumber;
    private String modelNumber;
    private String fromLocation;
    private String toLocation;
    private String arrival;
    private String departure;
    private int seatPrice;
    private Date date;
    private int hour;
    private int minutes;

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getWindowSeat() {
        return windowSeat;
    }

    public void setWindowSeat(int windowSeat) {
        this.windowSeat = windowSeat;
    }

    public int getMiddleSeat() {
        return middleSeat;
    }

    public void setMiddleSeat(int middleSeat) {
        this.middleSeat = middleSeat;
    }

    public int getAisleSeat() {
        return aisleSeat;
    }

    public void setAisleSeat(int aisleSeat) {
        this.aisleSeat = aisleSeat;
    }
    private int seat;
    private int windowSeat;
    private int middleSeat;
    private int aisleSeat;
    private int i =0;


    public Airliner getAirliner() {
        return airliner;
    }

    public void setAirliner(Airliner airliner) {
        this.airliner = airliner;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public String getToLocation() {
        return toLocation;
    }

    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }
    

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public int getSeatPrice() {
        return seatPrice;
    }

    public void setSeatPrice(int seatPrice) {
        this.seatPrice = seatPrice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }
    
    
    public String airlinerName = air.getAirlinerName();

    public String getAirlinerName() {
        return airlinerName;
    }

    public void setAirlinerName(String airlinerName) {
        this.airlinerName = airlinerName;
    }

    public String getAirlineID() {
        return airlineID;
    }

    public void setAirlineID(String airlineID) {
        this.airlineID = airlineID;
    }
    public String airlineID = air.getAirlineID();
    
    @Override
    public String toString()
    {
    return airlinerName;
    
    }
    
    
    
}
