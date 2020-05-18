/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.AwarenessRole;
import Business.Role.GovernmentRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Siddhi
 */
public class GovernmentFunding extends Organization{

    public GovernmentFunding() {
        super(Organization.Type.GovernmentFunding.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
       roles.add(new GovernmentRole());
        return roles;
    }
}
