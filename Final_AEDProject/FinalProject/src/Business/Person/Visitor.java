/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

/**
 *
 * @author Anuja
 */
public class Visitor {
    private String name;
    private String email;

    public boolean isOption() {
        return option;
    }

    public void setOption(boolean option) {
        this.option = option;
    }
    private boolean option;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
