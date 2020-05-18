/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;


import java.util.Date;
import Business.Account.Account;
/**
 *
 * @author Anuja
 */
public abstract class WorkRequest {

    private String message;
    private Account sender;
    private Account receiver;
    private String status;
    private String fileDn;
    private Date requestDate;
    private Date resolveDate;
    private String NGO;

    public String getNGO() {
        return NGO;
    }

    public void setNGO(String NGO) {
        this.NGO = NGO;
    }
    
    public WorkRequest(){
        requestDate = new Date();
    }

    public String getMessage() {
        return message;
    }
    
    
    public String getFileDn() {
        return fileDn;
    }

    public void setFileDn(String fileDn) {
        this.fileDn = fileDn;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }

    public Account getSender() {
        return sender;
    }

    public void setSender(Account sender) {
        this.sender = sender;
    }

    public Account getReceiver() {
        return receiver;
    }

    public void setReceiver(Account receiver) {
        this.receiver = receiver;
    }

    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }
    @Override
    public String toString(){
        return this.message;
    }
}
