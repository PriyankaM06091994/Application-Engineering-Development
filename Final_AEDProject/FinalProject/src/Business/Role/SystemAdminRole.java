/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Account.Account;
import userInterface.AdminWorkSpace.OTAWorkArea;
import javax.swing.JPanel;

/**
 *
 * @author Siddhi
 */
public class SystemAdminRole extends Role{
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, Account account, Organization organization, Enterprise enterprise, EcoSystem system) {
        return new OTAWorkArea(userProcessContainer, system);
    }
    
}
