/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

import java.util.Date;

/**
 *
 * @author Anuja
 */
public class AwarenessEvent {
    
    String networkName;
    String eventName;
    Date eventDate;
    float funds;

    public float getFunds() {
        return funds;
    }

    public void setFunds(float funds) {
        this.funds = funds;
    }

  

    public String getNetworkName() {
        return networkName;
    }

    public void setNetworkName(String networkName) {
        this.networkName = networkName;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }
    
    
}
