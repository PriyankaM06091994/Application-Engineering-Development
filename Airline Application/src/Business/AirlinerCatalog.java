package Business;


import Business.Airliner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Priyanka Malpekar
 */
public class AirlinerCatalog {
    
    private ArrayList<Airliner> airliner;

    public ArrayList<Airliner> getAirliner() {
        return airliner;
    }

    public void setAirliner(ArrayList<Airliner> airliner) {
        this.airliner = airliner;
    }
    
    public AirlinerCatalog()
    {
    this.airliner = new ArrayList<Airliner>();
    addCsv();
    }
    
    
    public Airliner addAirliner()
    {
        Airliner air = new Airliner();
        airliner.add(air);
        return air;
    
    }
    
    public Airliner  searchAirliner(String air)
    {
        for(Airliner a: airliner)
        {
        if(a.getAirlineID().equalsIgnoreCase(air))
        {
            return a;
        
        }
        
        
        }
    
    return null;
    }
    public void cancelAirliner(Airliner air)
    {
        airliner.remove(air);
    
    
    }

    private void addCsv() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    String fileCSV= "C:/Users/Priyanka Malpekar/Desktop/Airliner.csv";
        BufferedReader br=null;
        String line=",";
        String cvsSB=",";
        
        try{
            br = new BufferedReader(new FileReader(fileCSV));
            
            while((line=br.readLine())!= null){
                String[] airlinerData= line.split(cvsSB);
                
                Airliner b=new Airliner();
               
                
                b.setAirlinerName(airlinerData[0]);
                b.setAirlineID(airlinerData[1]);
                b.setAirlineCompany(airlinerData[2]);
                b.setFleetSize(Integer.parseInt(airlinerData[4]));
                b.setHeadquarters(airlinerData[3]);
                
                
                airliner.add(b);
                
            
        }
            
        }catch(FileNotFoundException e)
        {
                e.printStackTrace();
        
        }catch(IOException e){
            e.printStackTrace();
   
        }
    }
    
    
    }
    
      
        
    
     
   
            
            
    
    
    
    