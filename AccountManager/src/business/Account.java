/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.Date;

/**
 *
 * @author Priyanka
 */
public class Account {
    private String rountingNumber;
    private String accountNumber;
    private String bankName;
    private int balance;
    private Date createdOn;

    public Account() {
        this.createdOn = new Date();
    }
    
    public String getRountingNumber() {
        return rountingNumber;
    }

    public void setRountingNumber(String rountingNumber) {
        this.rountingNumber = rountingNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    @Override
   public String toString()
   {
       return bankName;
   
   
   }
    
    
}
