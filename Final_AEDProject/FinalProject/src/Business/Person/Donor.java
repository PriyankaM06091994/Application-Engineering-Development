/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

import java.util.List;

/**
 *
 * @author Siddhi
 */
public class Donor extends Person{
    
    private String pocName;
    private String pocContact;
    private boolean isOrganAvaiNow;
    List<String> organs;

     public boolean getIsOrganAvaiNow() {
        return isOrganAvaiNow;
    }

    public void setIsOrganAvaiNow(boolean isOrganAvaiNow) {
        this.isOrganAvaiNow = isOrganAvaiNow;
    }
    
    public List<String> getOrgans() {
        return organs;
    }

    public void setOrgans(List<String> organs) {
        this.organs = organs;
    }
    
    /**
     * @return the pocName
     */
    public String getPocName() {
        return pocName;
    }

    /**
     * @param pocName the pocName to set
     */
    public void setPocName(String pocName) {
        this.pocName = pocName;
    }

    /**
     * @return the pocContact
     */
    public String getPocContact() {
        return pocContact;
    }

    /**
     * @param pocContact the pocContact to set
     */
    public void setPocContact(String pocContact) {
        this.pocContact = pocContact;
    }
    
    @Override
    public String toString() {
        return this.getName();
    }
}
