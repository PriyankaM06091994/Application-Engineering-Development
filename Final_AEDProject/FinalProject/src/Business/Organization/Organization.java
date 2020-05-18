/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Employee.EmployeeDirectory;
import Business.Role.Role;
import Business.Account.AccountDirectory;
import Business.Person.DonorDirectory;
import Business.Person.RecipientDirectory;
import Business.Person.VisitorDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author Siddhi
 */
public abstract class Organization {

    private String name;
    private WorkQueue workQueue;
    private EmployeeDirectory employeeDirectory;
    private AccountDirectory accountDirectory;
    public abstract ArrayList<Role> getSupportedRole();
    private DonorDirectory donorDirectory;
    private RecipientDirectory recipientDirectory;
    private VisitorDirectory vd;
    private int organizationID;
    private static int counter = 1;

    public AccountDirectory getAccountDirectory() {
        return accountDirectory;
    }

    public void setAccountDirectory(AccountDirectory accountDirectory) {
        this.accountDirectory = accountDirectory;
    }

    public VisitorDirectory getVd() {
        return vd;
    }

    public void setVd(VisitorDirectory vd) {
        this.vd = vd;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Organization.counter = counter;
    }
    
    public enum Type{
        Doctor("Doctor Organization"), Lab("Lab Organization"), Visitor("Visitor Organization"),Screening("Screening Organization"),Radiology("Radiology Organization"),NGO("NGO Organization"),GovernmentFunding("GovernmentFunding");
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    public Organization(String name) {
        this.name = name;
        this.workQueue = new WorkQueue();
        this.employeeDirectory = new EmployeeDirectory();
        this.accountDirectory = new AccountDirectory();
        this.donorDirectory = new DonorDirectory();
        this.recipientDirectory = new RecipientDirectory();
        this.organizationID = counter;
        ++counter;
    }
    
    public AccountDirectory getUserAccountDirectory() {
        return accountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }
    
    public DonorDirectory getDonorDirectory() {
        return donorDirectory;
    }
    
    public RecipientDirectory getRecipientDirectory(){
        return recipientDirectory;
    }
    
    public String getName() {
        return name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}

