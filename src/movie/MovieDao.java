/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movie;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;

/**
 *
 * @author Windows10
 */
public class MovieDao {
    ArrayList<String> nameM = new ArrayList<>();
    String name;
    Connect connect;
    DB db;
    DBCollection collection;

    MovieDao() {
        connect = new Connect();

    }

    void insertDao(BasicDBObject insertUser) {
        db = connect.getDatabaseName();
        collection = db.getCollection("moive");
        collection.insert(insertUser);

    }

    public List<DBObject> getMoiveAll() {
        db = connect.getDatabaseName();
        collection = db.getCollection("moive");
        BasicDBObject sort = new BasicDBObject();
        sort.put("rating", 5);
        List<DBObject> cursor = collection.find().sort(sort).toArray();

        return cursor;
    }
    public ArrayList namelist(){
        try{
             MongoClientURI uri = new MongoClientURI("mongodb://newnewnew:new123456789@ds249503.mlab.com:49503/moiveproject");
        MongoClient client = new MongoClient(uri);
        MongoDatabase db = client.getDatabase(uri.getDatabase());
        MongoCollection<Document> songs = db.getCollection("moive");
            DBCursor cursor = collection.find();
            String[] columnname={"Moivename"};
            DefaultTableModel model = new DefaultTableModel(columnname,0);
            while(cursor.hasNext()){
                DBObject obj = cursor.next();
                String name=(String) obj.get("Moivename");
              nameM.add(name);
                model.addRow(new Object[] {name});
            }
           
        }catch(Exception e){
            e.printStackTrace();
        }
        return nameM;
    }

    public LinkedList getname() {
        MongoClientURI uri = new MongoClientURI("mongodb://newnewnew:new123456789@ds249503.mlab.com:49503/moiveproject");
        MongoClient client = new MongoClient(uri);
        MongoDatabase db = client.getDatabase(uri.getDatabase());
        MongoCollection<Document> songs = db.getCollection("moive");

        Document findU = new Document("rating", 5);

        MongoCursor<Document> cursor = songs.find().iterator();

        LinkedList<String> sosad = new LinkedList<>();

        int i = 0;
        try {
            while (cursor.hasNext()) {
                //Document doc = cursor.next();
                sosad.add(cursor.next().toString());
                System.out.print(sosad.get(i));
                String sadsad = sosad.get(i);

                i++;
            }

        } finally {

        }
        return sosad;
    }

}
