/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment5.entities;

import java.util.List;

/**
 *
 * @author kasai
 */
public class SalesPerson {
    
    private int salesId;
    private String marketSegment;
    private List<Order> orderList;

    public SalesPerson(int salesId, String marketSegment, List<Order> orderList) {
        this.salesId = salesId;
        this.marketSegment = marketSegment;
        this.orderList = orderList;
    }

    
    public int getSalesId() {
        return salesId;
    }

    public void setSalesId(int salesId) {
        this.salesId = salesId;
    }

    public String getMarketSegment() {
        return marketSegment;
    }

    public void setMarketSegment(String marketSegment) {
        this.marketSegment = marketSegment;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

   
    
    
    
    
    
}
