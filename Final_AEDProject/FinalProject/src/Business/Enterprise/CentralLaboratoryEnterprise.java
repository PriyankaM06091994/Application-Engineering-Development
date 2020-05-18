/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Priyanka
 */
public abstract class CentralLaboratoryEnterprise extends Enterprise{

    public CentralLaboratoryEnterprise(String name) {
        super(name, Enterprise.EnterpriseType.Laboratory);
    }
     
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
}

