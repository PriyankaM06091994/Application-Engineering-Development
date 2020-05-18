/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author Priyanka Malpekar
 */
public class AirplaneCatalog {
    
    private ArrayList<Airplane> airlinerCatalog;
    
    public AirplaneCatalog(){
        this.airlinerCatalog = new ArrayList<Airplane>();
        addCsv();
        
    }

    public ArrayList<Airplane> getAirlinerCatalog() {
        return airlinerCatalog;
    }

    public void setAirlinerCatalog(ArrayList<Airplane> airlinerCatalog) {
        this.airlinerCatalog = airlinerCatalog;
    }
  
   public Airplane addAirplane(){
       Airplane airplane = new Airplane();
       airlinerCatalog.add(airplane);
       return airplane;
   }
   
   
   public void cancelFlight(AirplaneCatalog airliner){
       airlinerCatalog.remove(airliner);
   } 
    
   public Airplane searchAirplane(String ap){
       for(Airplane airplane:airlinerCatalog){
      if(airplane.getFlightNumber()==Integer.parseInt(ap))
      {
          return airplane;
      }
  }
   return null;
  
   }   
   
  public void reserveWindowSeat()
   {
       Airplane airplane = new Airplane();
       //airCatalog.add("1");
       //System.out.println(airCatalog.listIterator(1));
       //return airCatalog;
       //airplane.setSeatNumber();
        int i =0;
       i=i+1;
       airplane.setWindowSeat(i);
       int number = i;
       
       //return number;
  
   }
    

    private void addCsv() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    String fileCSV= "C:/Users/Priyanka Malpekar/Desktop/Airplanes.csv";
        BufferedReader br=null;
        String line=",";
        String cvsSB=",";
        
        try{
            br = new BufferedReader(new FileReader(fileCSV));
            while((line=br.readLine())!= null){
                String[] airplaneData= line.split(cvsSB);
                Airplane ap=new Airplane();
               
                ap.setAirlinerName(airplaneData[0]);
                ap.setAirlineID(airplaneData[1]);
                ap.setFlightNumber(Integer.parseInt(airplaneData[2]));
                ap.setModelNumber(airplaneData[3]);
                ap.setManufacturerName(airplaneData[4]);
                ap.setFromLocation(airplaneData[5]);
                ap.setToLocation(airplaneData[6]);
                ap.setArrival(airplaneData[7]);
                ap.setDeparture(airplaneData[8]);
                ap.setSeatPrice(Integer.parseInt(airplaneData[9]));
                
                
                airlinerCatalog.add(ap);
                
            
        }
            
        }catch(FileNotFoundException e)
        {
                e.printStackTrace();
        
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    
    }
    

