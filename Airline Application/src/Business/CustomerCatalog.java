/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author Priyanka Malpekar
 */
public class CustomerCatalog {
    
    private ArrayList<Person> person;
    
    public CustomerCatalog(){
        this.person=new ArrayList<Person>();
    }
    public ArrayList<Person> getPerson(){
        return person;
    }
    
    public void setPerson(ArrayList<Person> person){
        this.person = person;
    }
    
    public Person addPerson(){
        Person per = new Person();
        person.add(per);
        return per;
    }
}
