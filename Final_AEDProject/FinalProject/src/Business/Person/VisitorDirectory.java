/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

import java.util.ArrayList;

/**
 *
 * @author Anuja
 */
public class VisitorDirectory {
    private ArrayList<Visitor> visitorList;

    public VisitorDirectory() {
        visitorList = new ArrayList();
    }

    public ArrayList<Visitor> getVisitorList() {
        return visitorList;
    }

    public void setVisitorList(ArrayList<Visitor> visitorList) {
        this.visitorList = visitorList;
    }
    
    public Visitor createVisitor(String email, boolean option){
        Visitor visitor = new Visitor();
        visitor.setEmail(email);
        visitor.setOption(option);
        visitorList.add(visitor);
        return visitor;
    }
}
