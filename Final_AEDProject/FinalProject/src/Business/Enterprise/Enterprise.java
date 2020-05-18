/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;

/**
 *
 * @author Siddhi
 */
public abstract class Enterprise extends Organization{
    
    private EnterpriseType enterpriseType;
    private OrganizationDirectory organizationDirectory;
    
    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

    public enum EnterpriseType{
        Hospital("Hospital"),
        Awareness("Awareness Camp"),
        Laboratory("Central Laboratory"),
        Government("Government");
        
        
        private String value;
        
        private EnterpriseType(String value){
            this.value=value;
        }
        public String getValue() {
            return value;
        }
        @Override
        public String toString(){
        return value;
    }
    }
   //added 
    public enum Type{
        Laboratory("Central Laboratory"),Screening("Screening Organization"),Radiology("Radiology Organization");
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    
    //added
    public enum EnumType{
        Hospital("Hospital"), Doctor("Doctor Organization"), Lab("Lab Organization"), Visitor("Visitor Organization");
        private String value;
        private EnumType(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    
    public enum EnumType1{
        Awareness("Awareness Camp"), NGO("NGO");
        private String value;
        private EnumType1(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    public enum EnumType2{
        Government("Government"), GovernmentFunding("GovernmentFunding");
        private String value;
        private EnumType2(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    
    
    
    
    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(EnterpriseType enterpriseType) {
        this.enterpriseType = enterpriseType;
    }

    
    public Enterprise(String name,EnterpriseType type){
        super(name);
        this.enterpriseType=type;
        organizationDirectory=new OrganizationDirectory();
    }
}
