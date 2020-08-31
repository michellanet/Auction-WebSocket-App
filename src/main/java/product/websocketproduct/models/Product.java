/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product.websocketproduct.models;

/**
 *
 * @author michellanet
 */
public class Product {

    public Product() {
        this.currentBid = 1;
        this.currentPrice = this.initialPrice;
    }

    public Product(int id, String title, String owner, double initialPrice) {
        this.id = id;
        this.title = title;
        this.owner = owner;
        this.initialPrice = initialPrice;
        this.currentBid = 1;
        this.currentPrice = this.initialPrice;
    }

    int id;
    String title;
    double initialPrice;
    double currentBid;
    String owner;
    double currentPrice;

    public void placeBid(){
        this.currentPrice += this.currentBid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(double initialPrice) {
        this.initialPrice = initialPrice;
    }

    public double getCurrentBid() {
        return currentBid;
    }

    public void setCurrentBid(double currentBid) {
        this.currentBid = currentBid;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }
    
}
