/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;
import java.util.List;
import Interface.CreateVitalJPanel;
import Interface.MainJFrame;
import Interface.ViewVitalsJPanel;
import Interface.abnormalJPanel;

/**
 *
 * @author Priyanka
 */
public class VitalSignHistory {
    
    private ArrayList<VitalSigns> vitalSignHistory;
    private ArrayList<VitalSigns> getAbnormalList;

    public ArrayList<VitalSigns> getGetAbnormalList() {
        return getAbnormalList;
    }

    public void setGetAbnormalList(ArrayList<VitalSigns> getAbnormalList) {
        this.getAbnormalList = getAbnormalList;
    }
    private double maxbp; 

    public double getMaxbp() {
        return maxbp;
    }

    public void setMaxbp(double maxbp) {
        this.maxbp = maxbp;
    }

    public double getMinbp() {
        return minbp;
    }

    public void setMinbp(double minbp) {
        this.minbp = minbp;
    }
    private double minbp;
    
    public VitalSignHistory()
    {
        
        vitalSignHistory = new ArrayList<VitalSigns>();
        getAbnormalList = new ArrayList<VitalSigns>();
    
    }

    public ArrayList<VitalSigns> getVitalSignHistory() {
        return vitalSignHistory;
    }

    public void setVitalSignHistory(ArrayList<VitalSigns> vitalSignHistory) {
        this.vitalSignHistory = vitalSignHistory;
    }
    
    public ArrayList<VitalSigns> getAbnormalList() {
        return getAbnormalList;
    }

    public void setAbnormalList(ArrayList<VitalSigns> getAbnormalList) {
        this.getAbnormalList = getAbnormalList;
    }
    
    public VitalSigns addVitals()
    {
        VitalSigns vs = new VitalSigns();
        vitalSignHistory.add(vs);
        return vs;
    
    }
    
    public void deleteVitals(VitalSigns v)
    {
        vitalSignHistory.remove(v);
    
    
    }
    
    public List<VitalSigns> getAbnormalList(double maxbp, double minbp)
    {
        List<VitalSigns> abnList = new ArrayList<>();
        
        for(VitalSigns vs: vitalSignHistory)
        {
            if(vs.getBloodPressure()>maxbp || vs.getBloodPressure()<minbp)
            {
                abnList.add(vs);
            }
            
        
        }
    
            return abnList;
   
    }
    
    
}
