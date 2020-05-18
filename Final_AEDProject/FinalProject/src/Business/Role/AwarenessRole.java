/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Account.Account;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import javax.swing.JPanel;
import userInterface.AwarenessCamps.AwarenessCamps;

/**
 *
 * @author Anuja
 */
public class AwarenessRole extends Role{
    @Override
    public JPanel createWorkArea(JPanel rightPanel, Account account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new AwarenessCamps(rightPanel, business, account, enterprise);
    }
}
