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
public class Product {
    
    private int productId;
    private int minPrice;
    private int maxPrice;
    private int targetPrice;
     private float modifiedTargetPrice;
    //private List<Item> itemList;

    public Product(int productId, int minPrice, int maxPrice, int targetPrice, float modifiedTargetPrice ) {
        this.productId = productId;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.targetPrice = targetPrice;
        this.modifiedTargetPrice = modifiedTargetPrice;
       
    }

    public float getModifiedTargetPrice() {
        return modifiedTargetPrice;
    }

    public void setModifiedTargetPrice(float modifiedTargetPrice) {
        this.modifiedTargetPrice = modifiedTargetPrice;
    }

       public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public int getTargetPrice() {
        return targetPrice;
    }

    public void setTargetPrice(int targetPrice) {
        this.targetPrice = targetPrice;
    }

}
