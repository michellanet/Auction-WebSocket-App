/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product.websocketproduct.repos;

import java.util.ArrayList;
import javax.enterprise.context.ApplicationScoped;
import javax.websocket.Session;
import product.websocketproduct.models.Product;

/**
 *
 * @author michellanet
 */
@ApplicationScoped
public class AuctionRepo {
    
    public AuctionRepo(){        
    auctions.add(new Product(auctions.size() ,"product1", "Aaron", 100));
    auctions.add(new Product(auctions.size() ,"product2", "Barry", 400));
    auctions.add(new Product(auctions.size() ,"product3", "Chris", 200));
    }
    private ArrayList<Product> auctions = new ArrayList();
    private ArrayList<Session> sessions = new ArrayList();
    
    public void addSession(Session session){
        sessions.add(session);
    }
    
    public void removeSession(Session session){
        sessions.remove(session);
    }
    
    public void addProduct(Product product){
        auctions.add(product);
    }
    
    public ArrayList<Session> getAllSessions(){
        return sessions;
    }
    
    public ArrayList<Product> getAllProducts(){
        return auctions;
    }
}
