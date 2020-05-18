/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Siddhi
 */
public class RecipientDirectory {
    
    private List<Recipient> recipientList;
    
    public RecipientDirectory(){
       this.recipientList = new ArrayList<Recipient>();
    }

    public List<Recipient> getRecipientList() {
        return recipientList;
    }

      public Recipient addRecipient(String name, int age, String sex, String bloodGroup, String contactNum, String address, String sign,
                String emailAdd, String organ){
        Recipient newRecipient = new Recipient();
        newRecipient.setName(name);
        newRecipient.setAge(age);
        newRecipient.setGender(sex);
        newRecipient.setBloodGroup(bloodGroup);
        newRecipient.setContactNum(contactNum);
        newRecipient.setAddress(address);
        newRecipient.setSign(sign);
        newRecipient.setEmailAdd(emailAdd);
        newRecipient.setOrgan(organ);
        recipientList.add(newRecipient);
        return newRecipient;
    }
    

}
