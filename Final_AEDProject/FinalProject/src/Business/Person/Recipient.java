/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

/**
 *
 * @author Siddhi
 */
public class Recipient extends Person implements Comparable<Recipient> {
    
    private String organ;
    private int priority;

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
    
    public String getOrgan() {
        return organ;
    }

    public void setOrgan(String organ) {
        this.organ = organ;
    }
    
    @Override
    public String toString() {
        return this.getName();
    }
    
     public int compareTo(Recipient o) {
		return Integer.compare(o.getPriority(), this.getPriority());
	}
}
