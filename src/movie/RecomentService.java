/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movie;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author Windows10
 */
public class RecomentService {

    MovieDao moviedao;

    Recoment recoment = new Recoment();
    Movie moive = new Movie();

    public   ArrayList<String>  getMoiveAll() {
       /* List<DBObject> cursor = moviedao.getname();
         return cursor;*/
       /* LinkedList<String> name = new LinkedList<>();
        name = moviedao.getname();
        return name;*/
        ArrayList<String> nameM = moviedao.namelist();
        return nameM;
    }

}
