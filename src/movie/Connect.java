/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movie;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

/**
 *
 * @author Windows10
 */
public class Connect {
    MongoClientURI uri;
    MongoClient client;
    DB db;
    DBCollection collecttion;
    public Connect() {
        try {
            uri = new MongoClientURI("mongodb://newnewnew:new123456789@ds249503.mlab.com:49503/moiveproject");
            client = new MongoClient(uri);
            System.out.println("Connect Sucessful!! ");

        } catch (Exception e) {

        }

    }
    public DB getDatabaseName() {
        return db = client.getDB(uri.getDatabase());

    }
    public DBCollection getCollection() {
        collecttion = db.getCollection("moive");
        return collecttion;
    }
    
}

