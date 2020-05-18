/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Account;
import Business.Employee.Employee;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class AccountDirectory {
        private ArrayList<Account> accountList;

    public AccountDirectory() {
        accountList = new ArrayList();
    }

    public ArrayList<Account> getUserAccountList() {
        return accountList;
    }
    
    public Account authenticateUser(String username, String password){
        for (Account ua : accountList)
            if (ua.getUsername().equals(username) && ua.getPassword().equals(password)){
                return ua;
            }
        return null;
    }
    
    public Account createUserAccount(String username, String password, Employee employee, Role role){
        if(checkIfUsernameIsUnique(username)){
            Account account = new Account();
            account.setUsername(username);
            account.setPassword(password);
            account.setEmployee(employee);
            account.setRole(role);
            accountList.add(account);
            return account;
        }else 
            return null;   
    }
    
    public boolean checkIfUsernameIsUnique(String username){
        for (Account ua : accountList){
            if (ua.getUsername().equals(username))
                return false;
        }
        return true;
    }
}
