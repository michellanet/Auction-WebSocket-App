/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product.websocketproduct.servers;

import com.google.gson.Gson;
import java.io.IOException;
import javax.inject.Inject;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import product.websocketproduct.models.Product;
import product.websocketproduct.repos.AuctionRepo;

/**
 *
 * @author michellanet
 */
@ServerEndpoint("/products")
public class SocketServer {

    @Inject
    private AuctionRepo repo;

    Gson gson;

    @OnMessage
    public void getAuction(Session session, String product) throws IOException {
        Product productObject = gson.fromJson(product, Product.class);

        if (productObject.getId() == -1) {

            productObject.setId(repo.getAllProducts().size());
            repo.addProduct(productObject);

            for (Session connectedClient : repo.getAllSessions()) {
                if (session.isOpen()) {
                    String json = gson.toJson(repo.getAllProducts());
                    connectedClient.getBasicRemote().sendText(json);
                }
            }
        } else {

            repo.getAllProducts().get(productObject.getId()).placeBid();

            for (Session connectedClient : repo.getAllSessions()) {
                if (session.isOpen()) {
                    String json = gson.toJson(repo.getAllProducts());
                    connectedClient.getBasicRemote().sendText(json);
                }
            }
        }
    }

    @OnOpen
    public void open(Session session) throws IOException, EncodeException {
        repo.addSession(session);
        gson = new Gson();
        String json = gson.toJson(repo.getAllProducts());
        session.getBasicRemote().sendText(json);
    }

    @OnClose
    public void close(Session session) {
        repo.removeSession(session);
    }
}
