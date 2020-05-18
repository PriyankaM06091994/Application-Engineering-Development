/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment5.xerox;

import com.assignment5.entities.Customer;
import com.assignment5.entities.Item;
import com.assignment5.entities.Order;
import com.assignment5.entities.Product;
import com.assignment5.entities.SalesPerson;
import com.assignment5.entities.analytics.AnalysisHelper;
import com.assignment5.entities.analytics.DataStore;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author anuja
 */
public class GateWay {
    
    
    DataReader productReader;
    DataReader orderReader;
    AnalysisHelper helper;
    
    public GateWay() throws IOException {
        
        DataGenerator generator = DataGenerator.getInstance();
        productReader = new DataReader(generator.getProductCataloguePath());
        orderReader = new DataReader(generator.getOrderFilePath());
        helper = new AnalysisHelper();
    }
   
    public static void main(String args[]) throws IOException{
        
        GateWay inst = new GateWay();
        inst.readData();
        
    }   
    
    private void readData() throws IOException{
        
        String[] row;
        while((row = productReader.getNextRow()) != null ){
            generateProduct(row);
        }
        while((row = orderReader.getNextRow()) != null ){
         //   Order order = generateOrder(row);
            generateOrder(row);
        }
        runAnalysis();
    }
    
    
        
      //  DataGenerator generator = DataGenerator.getInstance();
        
      //  AnalysisHelper helper = new AnalysisHelper();
        
        
        //Below is the sample for how you can use reader. you might wanna 
        //delete it once you understood.
        
     /*   DataReader orderReader = new DataReader(generator.getOrderFilePath()); // Insert path of CSV
        String[] orderRow;
        printRow(orderReader.getFileHeader());
        while((orderRow = orderReader.getNextRow()) != null){
            printRow(orderRow);
        }
        System.out.println("_____________________________________________________________");
        DataReader productReader = new DataReader(generator.getProductCataloguePath());
        String[] prodRow;
        printRow(productReader.getFileHeader());
        while((prodRow = productReader.getNextRow()) != null){
            printRow(prodRow);
        }
        
        
        
        helper.productSellAboveAverage();
    }
    
    public static void printRow(String[] row){
        for (String row1 : row) {
            System.out.print(row1 + ", ");
        }
        System.out.println("");
    }*/
    
     private void generateProduct(String[] row) {
         
        int productID = Integer.parseInt(row[0]);
        int minPrice = Integer.parseInt(row[1]);
        int maxPrice = Integer.parseInt(row[2]);
        int targetPrice = Integer.parseInt(row[3]);
        int modifiedTargetPrice =Integer.parseInt(row[4]);
      
        Product product = new Product(productID, minPrice, maxPrice,targetPrice,modifiedTargetPrice);
        DataStore.getInstance().getProduct().put(productID, product);
       
    }

    private void generateOrder(String[] row) {
        
        int orderId = Integer.parseInt(row[0]);
        int supplierId = Integer.parseInt(row[4]);
        int customerId = Integer.parseInt(row[5]);
        int productId = Integer.parseInt(row[2]);
        int salesPrice = Integer.parseInt(row[6]);
        int quantity = Integer.parseInt(row[3]);
        String marketPrice = row[7];
        
        Item item = new Item( productId,  salesPrice,  quantity);
        item.setProductId(productId);
        item.setQuantity(quantity);
        item.setSalesPrice(salesPrice);
    
        DataStore.getInstance().getItem().put(orderId, item);
        
        Order order = new Order( orderId,  supplierId,  customerId, item);
        DataStore.getInstance().getOrder().put(orderId, order);
        
        Map<Integer,Order> orders = DataStore.getInstance().getOrder();
        
        ArrayList<Order> o1 =new ArrayList<>();
        o1.add(order);
        Customer cs = new Customer(customerId,o1);
        DataStore.getInstance().getCustomer().put(customerId,cs);
        
        SalesPerson sp =new SalesPerson(supplierId,marketPrice,o1);
        DataStore.getInstance().getSalesPerson().put(supplierId, sp);
        
     /*   if(orders.containsKey(item.getProductId())){
            orders.get(orderId).getItem().add(item);
        }
      */  
        /* int commentId = Integer.parseInt(row[0]);
        int commentingUserId = Integer.parseInt(row[4]);
        int likes = Integer.parseInt(row[3]);
        int postId = Integer.parseInt(row[1]);
        String comment = row[5];
        
        Comment c = new Comment(commentId, commentingUserId, postId, comment, likes);
        DataStore.getInstance().getComments().put(commentId, c);
        
        Map<Integer,User> users = DataStore.getInstance().getUsers();
        
        if(users.containsKey(commentingUserId)){
            users.get(commentingUserId).getComments().add(c);
        }*/
       // return null;
        
    }

  /*  private void generateItem(String[] row, Order order) {
       
        int productId;
        int salesPrice;
        int quantity;
        
    }*/
    
    private void runAnalysis(){
        
        helper.threeBestNegotiatedProducts();
        helper.topThreeCustomers();
        helper.topThreeSales();
        helper.totalrevenue();
        helper.averageSalePrice();
        helper.modifiedTargetPrice();
        
        
    }

   
    
}
