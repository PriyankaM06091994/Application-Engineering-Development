/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment5.entities.analytics;

import com.assignment5.entities.Customer;
import com.assignment5.entities.Item;
import com.assignment5.entities.Order;
import com.assignment5.entities.Product;
import com.assignment5.entities.SalesPerson;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 * @author Siddhi
 */
public class AnalysisHelper {
    
    
      public void orderPrint() {

        Map< Integer, Product> productsList = DataStore.getInstance().getProduct();
        Map< Integer, Customer> customerMap = DataStore.getInstance().getCustomer();
        Map< Integer, Integer> result = new HashMap<>();
        Map< Integer, Order> orderMap = DataStore.getInstance().getOrder();
       
     //   for(Customer c: customerMap.values()){
        
        for (Order order : orderMap.values()) {
               
            System.out.println("Sales ID " + order.getSupplierId() +"  Order ID "+order.getOrderId() + "Product ID "+ order.getItem().getProductId()+ " Quantity " + order.getItem().getQuantity()+ " Custimer id "+ order.getCustomerId()+" Sales Price "+ order.getItem().getSalesPrice());
    }
      }
    
    
    
    

    public void threeBestNegotiatedProducts() {

        Map< Integer, Product> productsList = DataStore.getInstance().getProduct();
        Map< Integer, Order> orderMap = DataStore.getInstance().getOrder();
        Map< Integer, Integer> result = new HashMap<>();

        for (Order order : orderMap.values()) {

            int count = 0;
            int productID = order.getItem().getProductId();
            int target = 0;
            int quant = order.getItem().getQuantity();

            for (Product p : productsList.values()) {
                if (p.getProductId() == productID) {
                    target = p.getTargetPrice();
                }
            }

            if (order.getItem().getSalesPrice() > target) {

                if (result.containsKey(productID)) {

                    count = result.get(productID); //returns the value for given key
                    quant += count;

                }

                result.put(productID, quant);
            }
        }

        Set entrySet = result.entrySet();
        List< Entry< Integer, Integer>> list = new ArrayList<>(entrySet);
        Collections.sort(list, new Comparator< Entry< Integer, Integer>>() {

            public int compare(Entry< Integer, Integer> a, Entry< Integer, Integer> b) {

                return b.getValue() - a.getValue();
            }
        });
        System.out.println("*********************************************************************");
        System.out.println("Top three negotiated products:");

        for (int i = 0; i < list.size() && i < 3; i++) {
            int productId = list.get(i).getKey();
            int quant = list.get(i).getValue();
            System.out.println("ProductID: " + productId + " Quantity: " + quant);
        }

        System.out.println("*********************************************************************");

    }

    public void topThreeCustomers() {

        Map< Integer, Product> productsList = DataStore.getInstance().getProduct();
        Map< Integer, Customer> customerMap = DataStore.getInstance().getCustomer();
        Map< Integer, Integer> result = new HashMap<>();
        Map< Integer, Order> orderMap = DataStore.getInstance().getOrder();
       
     //   for(Customer c: customerMap.values()){
        
        for (Order order : orderMap.values()) {

            int count = 0;
            int productID = order.getItem().getProductId();
            int customerID = order.getCustomerId();
            int sales = order.getItem().getSalesPrice();
            int target = 0;

            for (Product p : productsList.values()) {
                if (p.getProductId() == productID) {
                    target = p.getTargetPrice();
                }
            }
            int diff = Math.abs(sales - target);
            
            if (result.containsKey(customerID)) {

                count = result.get(customerID); //returns the value for given key
               // System.out.println("Product "+ order.getItem().getProductId()+" OLd "+ count+ " New Value "+ diff);
                diff += count;

            }
                result.put(customerID, diff);
               // System.out.println("Display"+result);
            }
        

        Set entrySet = result.entrySet();
        List< Entry< Integer, Integer>> list = new ArrayList<>(entrySet);
        Collections.sort(list, new Comparator< Entry< Integer, Integer>>() {
            public int compare(Entry< Integer, Integer> a, Entry< Integer, Integer> b) {

                return b.getValue() - a.getValue();
            }
        });
        System.out.println("Top three customers:");

        for (int i = 0; i < list.size() && i < 3; i++) {
            int custID = list.get(i).getKey();
            int quant = list.get(i).getValue();
            System.out.println("CustomerID: " + custID + " Profit: " + quant);
        }

        System.out.println("*********************************************************************");
    }
    
    public void topThreeSales() {

        Map< Integer, Product> productsList = DataStore.getInstance().getProduct();
        Map< Integer, Order> orderMap = DataStore.getInstance().getOrder();
        Map< Integer, SalesPerson> salesMap = DataStore.getInstance().getSalesPerson();
        Map< Integer, Integer> result = new HashMap<>();

    
        
        for (Order order : orderMap.values()) {

            int count = 0;
            int productID = order.getItem().getProductId();
            int salesID = order.getSupplierId();
            int sales = order.getItem().getSalesPrice();
            int target = 0;

            for (Product p : productsList.values()) {
                if (p.getProductId() == productID) {
                    target = p.getTargetPrice();
                }
            }
            int diff = sales - target;
            int quantsales=0;
            if(diff>0)
            {
            quantsales = diff * order.getItem().getQuantity();
            if (result.containsKey(salesID)) {

                count = result.get(salesID); //returns the value for given key
                quantsales +=count;
            }

            result.put(salesID, quantsales);
            }
        }
        

        Set entrySet = result.entrySet();
        List< Entry< Integer, Integer>> list = new ArrayList<>(entrySet);
        Collections.sort(list, new Comparator< Entry< Integer, Integer>>() {
            @Override
            public int compare(Entry< Integer, Integer> a, Entry< Integer, Integer> b) {

                return b.getValue() - a.getValue();
            }
        });
        System.out.println("Top three salesperson:");

        for (int i = 0; i < list.size() && i < 3; i++) {
            int salesID = list.get(i).getKey();
            int quantsales = list.get(i).getValue();
            System.out.println("Sales ID: " + salesID + " Profit: " + quantsales);
        }

        System.out.println("*********************************************************************");
    }
     
    
    
    public void totalrevenue() {

        Map< Integer, Product> productsList = DataStore.getInstance().getProduct();
        Map< Integer, Order> orderMap = DataStore.getInstance().getOrder();
        Map< Integer, Integer> targetPrice = new HashMap<>();
         Map< Integer, Integer> result = new HashMap<>();
         int total=0;
        for (Order order : orderMap.values()) {

            int count = 0;
            int productID = order.getItem().getProductId();
            int salesID = order.getSupplierId();
            int sales = order.getItem().getSalesPrice();
            int target = 0;

            for (Product p : productsList.values()) {
                if (p.getProductId() == productID) {
                    target = p.getTargetPrice();
                }
            }
            int diff = sales - target;
            
            if(diff>0)
            {
                int quantsales = diff * order.getItem().getQuantity();
            
                total+=quantsales;

           
            }
        
        }

        System.out.println("Total revenue:"+ total);

    }

    
    
    public void finalMethod(){
         
         Map< Integer, Product> productsMap = DataStore.getInstance().getProduct();
         Map< Integer, Order> orderMap = DataStore.getInstance().getOrder();
         Map< Integer, Float> avgMap = new HashMap<>();
         Map< Integer, Integer> targetMap = new HashMap<>();
         
         //for(Order order: orderMap.values()){
           
             for (Product p : productsMap.values()) {
                 
             float sumSales = 0;
             float sumQuantity = 0;
             
             for(Order o: orderMap.values()){
                   
                if (p.getProductId() == o.getItem().getProductId()) {
                
                    sumSales += o.getItem().getSalesPrice() * o.getItem().getQuantity();
                    sumQuantity += o.getItem().getQuantity();
                    
                }
                   
                
               }
              
             avgMap.put(p.getProductId(), sumSales/sumQuantity);
                
            }  
           
           for(Product p : productsMap.values()){

               targetMap.put(p.getProductId(), p.getTargetPrice()); 
           }
             
         //}
         
         System.out.println(avgMap);
         
        Set entrySet = targetMap.entrySet();
        List< Entry< Integer, Integer>> list = new ArrayList<>(entrySet);
        Collections.sort(list, new Comparator< Entry< Integer, Integer>>() {

            public int compare(Entry< Integer, Integer> a, Entry< Integer, Integer> b) {

                return b.getValue() - a.getValue();
            }
        });
        
        System.out.println("Target Price of Each Product");

        for (int i = 0; i < list.size() ; i++) {
            int productId = list.get(i).getKey();
            int tprice = list.get(i).getValue();
            System.out.println("ProductID: " + productId + " Target Price: " + tprice);
        }

        System.out.println("*********************************************************************");

         
     }


     public void averageSalePrice()        
    {
        Map< Integer, Product> products = DataStore.getInstance().getProduct();
        Map< Integer, Order> orders = DataStore.getInstance().getOrder();
        Map< Integer, Item> item = DataStore.getInstance().getItem();
        Map< Integer, Integer> targetPrice = new HashMap<>();
        Map< Integer, Integer> result = new HashMap<>();
        Map< Integer, Integer> quantList = new HashMap<>();
        Map< Integer, Integer> avgSale = new HashMap<>();
        Map< Integer, Float> positiveDiff = new HashMap<>();
        Map< Integer, Float> negativeDiff = new HashMap<>();
        
        
        int sum =0;
        int quant = 0;
        int totalSP = 0;
        int countProductID = 0;
            int totalQuant = 0;
            int avgSalePrice = 0;
            int qu =0;
            int sum1=0;
        for (Order order : orders.values()) {
        
            int count = 0;
            int productID = order.getItem().getProductId();
            int salesID = order.getSupplierId();
            int sales = order.getItem().getSalesPrice();
            int target = 0;
            
            
        
        for(Product p :products.values() )
        {
         sum=0;
         quant = 0;
         totalSP = 0;
         countProductID = 0;
         totalQuant = 0;
         avgSalePrice = 0;
         qu =0;
  
          
          
        if (p.getProductId() == productID) {
                    
            
            totalSP = order.getItem().getSalesPrice();
            totalQuant = order.getItem().getQuantity();
            sum = (order.getItem().getSalesPrice() * order.getItem().getQuantity());
            targetPrice.put(productID, p.getTargetPrice());
            //System.out.println( "sum:" + sum + "SP:" + totalSP + "total Quant:" + totalQuant);
                }
          //totalQuant = order.getItem().getQuantity();
                
        if (result.containsKey(productID)) {

                count = result.get(productID); //returns the value for given key
                sum +=count;
                quant = quantList.get(productID);
                totalQuant += quant;
                //System.out.println(totalQuant);
            }

            result.put(productID, sum);
            quantList.put(productID, totalQuant);
        }

        qu = quantList.get(productID);
        sum1 = result.get(productID);
        avgSalePrice = sum1 / qu;
        avgSale.put(productID, avgSalePrice);
        
        }
        
        Set entrySet = avgSale.entrySet();
        List< Entry< Integer, Integer>> list = new ArrayList<>(entrySet);
        
        System.out.println("*********************************************************************");
        
        System.out.println("ORIGINAL DATA");
        System.out.println("Average Sale Price of Each Product :");
         System.out.println("\n");
         System.out.println("Average Sale Price is greater than the target price   ");
          System.out.println("_________________________________________________________");

        for (int i = 0; i < list.size(); i++) {
          
           float  diff =(list.get(i).getValue()-targetPrice.get(i));
           
         
          
           if(diff>0)
           {
               
               System.out.println(" ProductID   " + list.get(i).getKey() + " | Average sale price    " +list.get(i).getValue()+" | Target price   "+targetPrice.get(i)+" | The difference between the average sale price and target price of each product  " + diff);
               
               positiveDiff.put(list.get(i).getKey(), diff); 
               //System.out.println(positiveDiff);
           
           }
               
        }
        System.out.println("\n");
        System.out.println("Average Sale Price is less than the target price   ");
        System.out.println("_________________________________________________________");
        for (int i = 0; i < list.size(); i++) {
            
            float diff =(list.get(i).getValue()-targetPrice.get(i));
            
         
           if(diff<0 || diff == 0)
           {
               negativeDiff.put(list.get(i).getKey(), diff);
               System.out.println(" ProductID   " + list.get(i).getKey() + " | Average sale price    " +list.get(i).getValue()+" | Target price   "+targetPrice.get(i)+" | The difference between the average sale price and target price of each product  " + diff);
           
           
           }
       
        }
         System.out.println("\n");
        System.out.println("Average Sale Price is greater than the target price    ");
       System.out.println("Sorted high to low based on the difference:    ");
        System.out.println("_________________________________________________________");
        
        
        List<Map.Entry< Integer, Float>> list1 = new ArrayList<>(positiveDiff.entrySet());
        Collections.sort(list1, new Comparator< Entry< Integer, Float>>() {
            @Override
            public int compare(Entry< Integer, Float> a, Entry< Integer, Float> b) {

                return (int)(b.getValue() - a.getValue());
            }
        });
         
         //System.out.println(list1);
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(" ProductID   " + list.get(i).getKey() + " | Average sale price    " +list.get(i).getValue()+" | Target price   "+targetPrice.get(i)+" | The difference between the average sale price and target price of each product    " +  list1.get(i).getValue());
           
        }

        System.out.println("\n");
        
        System.out.println("Average Sale Price is less than the target price    ");
        System.out.println("Sorted high to low based on the difference:    ");
        System.out.println("_________________________________________________________");
        
         List<Map.Entry< Integer, Float>> list2 = new ArrayList<>(negativeDiff.entrySet());
        Collections.sort(list2, new Comparator< Entry< Integer, Float>>() {
            @Override
            public int compare(Entry< Integer, Float> a, Entry< Integer, Float> b) {

                return (int)(b.getValue() - a.getValue());
            }
        });
         
         //System.out.println(list1);
        for (int i = 0; i < list2.size(); i++) {
            System.out.println(" ProductID   " + list.get(i).getKey() + " | Average sale price    " +list.get(i).getValue()+" | Target price   "+targetPrice.get(i)+" | The difference between the average sale price and target price of each product    " +  list2.get(i).getValue());
           
        }

       System.out.println("\n");
        
        
        
        
        }
        
    
    public void modifiedTargetPrice()
    {
    
        Map< Integer, Product> products = DataStore.getInstance().getProduct();
        Map< Integer, Order> orders = DataStore.getInstance().getOrder();
        Map< Integer, Item> item = DataStore.getInstance().getItem();
        Map< Integer, Float> targetPrice = new HashMap<>();
        Map< Integer, Integer> result = new HashMap<>();
        Map< Integer, Integer> quantList = new HashMap<>();
        Map< Integer, Integer> avgSale = new HashMap<>();
        Map< Integer, Float> positiveModifiedDiff = new HashMap<>();
        Map< Integer, Float> negativeModifiedDiff = new HashMap<>(); 
                
        
        
        int sum =0;
        int quant = 0;
        int totalSP = 0;
        int countProductID = 0;
            int totalQuant = 0;
            int avgSalePrice = 0;
            int qu =0;
            int sum1=0;
        for (Order order : orders.values()) {
        
            int count = 0;
            int productID = order.getItem().getProductId();
            int salesID = order.getSupplierId();
            int sales = order.getItem().getSalesPrice();
            int target = 0;
            
            
        
        for(Product p :products.values() )
        {
         sum=0;
         quant = 0;
         totalSP = 0;
         countProductID = 0;
         totalQuant = 0;
         avgSalePrice = 0;
         qu =0;
  
          
          
        if (p.getProductId() == productID) {
                    
            
           
            sum = (order.getItem().getSalesPrice() * order.getItem().getQuantity());
            targetPrice.put(productID, p.getModifiedTargetPrice());
             totalQuant = order.getItem().getQuantity();
            //System.out.println( "sum:" + sum + "SP:" + totalSP + "total Quant:" + totalQuant);
                }
        
      
        
        if (result.containsKey(productID)) {

                count = result.get(productID); //returns the value for given key
                sum +=count;
                quant = quantList.get(productID);
                totalQuant += quant;
                //System.out.println(totalQuant);
            }

            result.put(productID, sum);
            quantList.put(productID, totalQuant);
        }

        qu = quantList.get(productID);
        sum1 = result.get(productID);
        avgSalePrice = sum1 / qu;
        avgSale.put(productID, avgSalePrice);
        
        }
        
        Set entrySet = avgSale.entrySet();
        List< Entry< Integer, Integer>> list = new ArrayList<>(entrySet);
        
        System.out.println("*********************************************************************");
        System.out.println("\n");
         System.out.println("MODIFIED TARGET PRICE DATA:");
         System.out.println("\n");
        System.out.println("Average Sale Price of Each Product :");
         System.out.println("\n");
         System.out.println("Average Sale Price is greater than the modified target price   ");
          System.out.println("_________________________________________________________");

        for (int i = 0; i < list.size(); i++) {
          
           float diff =(list.get(i).getValue()-targetPrice.get(i));
           
          
           if(diff>0)
           {
                positiveModifiedDiff.put(list.get(i).getKey(), diff);
               System.out.println(" ProductID   " + list.get(i).getKey() + " | Average sale price    " +list.get(i).getValue()+" | Modified Target price   "+targetPrice.get(i)+" | The difference between the average sale price and Modified target price of each product  " + diff);
           }
               
        }
        System.out.println("\n");
        System.out.println("Average Sale Price is less than the modified target price   ");
        System.out.println("_________________________________________________________");
        for (int i = 0; i < list.size(); i++) {
            
            float diff =(list.get(i).getValue()-targetPrice.get(i));
         
           if(diff<0 || diff == 0)
           {
                negativeModifiedDiff.put(list.get(i).getKey(), diff);
               System.out.println(" ProductID   " + list.get(i).getKey() + " | Average sale price    " +list.get(i).getValue()+" | Target price   "+targetPrice.get(i)+" | The difference between the average sale price and modified target price of each product  " + diff);
           
           
           }
       
        }
        
         System.out.println("\n");
    
        //System.out.println("________________Modified Target Price:_____________________________________________________________");
        
        System.out.println("\n");
        System.out.println("Average Sale Price is greater than the modified target price   ");
        System.out.println("Sorted high to low based on the difference:    ");
        System.out.println("_________________________________________________________");
        
        
        List<Map.Entry< Integer, Float>> list1 = new ArrayList<>(positiveModifiedDiff.entrySet());
        Collections.sort(list1, new Comparator< Entry< Integer, Float>>() {
            @Override
            public int compare(Entry< Integer, Float> a, Entry< Integer, Float> b) {

                return (int)(b.getValue() - a.getValue());
            }
        });
        
         //System.out.println(list1);
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(" ProductID   " + list.get(i).getKey() + " | Average sale price    " +list.get(i).getValue()+" | Modified Target price   "+targetPrice.get(i)+" | The difference between the average sale price and modified target price of each product    " +  list1.get(i).getValue());
           
        }

        System.out.println("\n");
        
        System.out.println("Average Sale Price is less than the modified target price    ");
        System.out.println("Sorted high to low based on the difference:    ");
       
        System.out.println("_________________________________________________________");
        
         List<Map.Entry< Integer, Float>> list2 = new ArrayList<>(negativeModifiedDiff.entrySet());
        Collections.sort(list2, new Comparator< Entry< Integer, Float>>() {
            @Override
            public int compare(Entry< Integer, Float> a, Entry< Integer, Float> b) {

                return (int)(b.getValue() - a.getValue());
            }
        });
        
         //System.out.println(list1);
        for (int i = 0; i < list2.size(); i++) {
            System.out.println(" ProductID   " + list.get(i).getKey() + " | Average sale price    " +list.get(i).getValue()+" | Modified Target price   "+targetPrice.get(i)+" | The difference between the average sale price and modified target price of each product    " +  list2.get(i).getValue());
           
        }

        System.out.println("\n");
        
        
         System.out.println("The error of the modified target price positive error:    ");
          System.out.println("_________________________________________________________");

        for (int i = 0; i < list.size(); i++) {
          
           float error =(targetPrice.get(i)-avgSale.get(i))/avgSale.get(i);
           
          
           if(error>0)
           {
               
               System.out.println(" ProductID   " + list.get(i).getKey() + " | Average sale price    " +list.get(i).getValue()+" | Modified Target price   "+targetPrice.get(i)+" | The error of the modified target price   " + error);
              
           
           }
               
        }
    
        System.out.println("\n");
        System.out.println("The error of the modified target price negative error:  ");
        System.out.println("_________________________________________________________");
        
         for (int i = 0; i < list.size(); i++) {
            
            float error =(targetPrice.get(i)-avgSale.get(i))/avgSale.get(i);
         
           if(error<0 || error == 0)
           {
               System.out.println(" ProductID   " + list.get(i).getKey() + " | Average sale price    " +list.get(i).getValue()+" | Target price   "+targetPrice.get(i)+" | The error of the modified target price   " + error);
               
           
           }
       
        }
    
    
        
    
    
    
    }
}
