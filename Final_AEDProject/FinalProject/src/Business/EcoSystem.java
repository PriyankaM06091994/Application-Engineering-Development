/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Network.Network;
import Business.Organization.Organization;
import Business.Person.AwarenessEvent;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import java.util.ArrayList;

/**
 *
 * @author Anuja
 */
public class EcoSystem extends Organization{
    
    private static EcoSystem business;
    private ArrayList<Network> networkList;
    private ArrayList<AwarenessEvent> eventList;
 
    
    public static EcoSystem getInstance(){
        if(business==null){
            business=new EcoSystem();
        }
        return business;
    }

    public ArrayList<AwarenessEvent> getEventList() {
        return eventList;
    }

    
    public Network createAndAddNetwork(){
        Network network=new Network();
        networkList.add(network);
        return network;
    }
    
    public AwarenessEvent createEvent(){
    
        AwarenessEvent event = new AwarenessEvent();
        eventList.add(event);
        return event;
    } 
    
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList=new ArrayList<Role>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }
    private EcoSystem(){
        super(null);
        networkList=new ArrayList<Network>();
        eventList = new ArrayList<AwarenessEvent>();
        
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkList = networkList;
    }
    
    public boolean checkIfUserIsUnique(String userName){
        return true;
    }
}
