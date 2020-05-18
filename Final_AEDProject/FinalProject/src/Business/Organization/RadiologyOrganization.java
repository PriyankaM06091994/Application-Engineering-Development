/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Enterprise.CentralLaboratoryEnterprise;
import Business.Role.LabAssistantRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Priyanka
 */
public class RadiologyOrganization extends CentralLaboratoryEnterprise {
     public RadiologyOrganization() {
       super(Organization.Type.Radiology.getValue());
    }  
     
     @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new LabAssistantRole());
        return roles;
    }
    
    
}
