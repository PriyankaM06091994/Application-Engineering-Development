/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author Siddhi
 */
public class FundWorkRequest extends WorkRequest{
    private String eventName;
    private String network;
    private String date;
    private String approval;
    private String NGO;
    private String Fundstatus;
    private float funds;
    
    public float getFunds() {
        return funds;
    }

    public void setFunds(float funds) {
        this.funds = funds;
    }

    public String getFundstatus() {
        return Fundstatus;
    }

    public void setFundstatus(String Fundstatus) {
        this.Fundstatus = Fundstatus;
    }

    public String getApproval() {
        return approval;
    }

    public void setApproval(String approval) {
        this.approval = approval;
    }

    public String getNGO() {
        return NGO;
    }

    public void setNGO(String NGO) {
        this.NGO = NGO;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    
    
    
    
    
    
}
