package com.lagenerica.api.DAO;

import java.util.ArrayList;

import com.lagenerica.api.DTO.UsersDTO;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class UsersDAO {

    private static DBObject createDBObject(UsersDTO user) {
		BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
								
		docBuilder.append("identification", user.getIdentification());
		docBuilder.append("email", user.getEmail());
		docBuilder.append("username", user.getUsername());
		docBuilder.append("password", user.getPassword());
        docBuilder.append("user", user.getUser());
		return docBuilder.get();
	}

    public UsersDTO create(UsersDTO user) {
        DBObject doc = createDBObject(user);

        MyConnection connection = new MyConnection();
		DBCollection collection = connection.database().getCollection("users");

        collection.insert(doc);

        connection.disconect();

        return get(user.getIdentification());
    }
    
    public UsersDTO update(Integer id, UsersDTO user) {
        DBObject doc = createDBObject(user);

        MyConnection connection = new MyConnection();
		DBCollection collection = connection.database().getCollection("users");
        DBObject query = BasicDBObjectBuilder.start().add("identification", id).get();

		collection.update(query, doc);

        connection.disconect();

        return get(id);
    }
    
    public ArrayList<UsersDTO> list() {
        ArrayList<UsersDTO> list =  new ArrayList<UsersDTO>();

        MyConnection connection = new MyConnection();
		DBCollection collection = connection.database().getCollection("users");
        
		DBObject query = BasicDBObjectBuilder.start().get();
		DBCursor cursor = collection.find(query);
		while(cursor.hasNext()){
            DBObject resultObject = cursor.next();
            UsersDTO user = new UsersDTO(Integer.parseInt(resultObject.get("identification").toString()),resultObject.get("email").toString(), resultObject.get("username").toString(), resultObject.get("password").toString(), resultObject.get("user").toString());
            list.add(user);
		}
        connection.disconect();
        return list;
    }
    

	public UsersDTO get(Integer id) {
        MyConnection connection = new MyConnection();
		DBCollection collection = connection.database().getCollection("users");
        
		DBObject query = BasicDBObjectBuilder.start().add("identification", id).get();
		DBCursor cursor = collection.find(query);
		while(cursor.hasNext()){
            DBObject resultObject = cursor.next();
            connection.disconect();
            return new UsersDTO(Integer.parseInt(resultObject.get("identification").toString()),resultObject.get("email").toString(), resultObject.get("username").toString(), resultObject.get("password").toString(), resultObject.get("user").toString());
		}
        return null;
    }
    
    public Boolean delete(Integer id) {
        MyConnection connection = new MyConnection();
		DBCollection collection = connection.database().getCollection("users");
        
		DBObject query = BasicDBObjectBuilder.start().add("identification",id).get();
		collection.remove(query);

        connection.disconect();
        return true;
    }
    
    public UsersDTO auth(UsersDTO user) {
        MyConnection connection = new MyConnection();
		DBCollection collection = connection.database().getCollection("users");
        
		DBObject query = BasicDBObjectBuilder.start().add("username",user.getUsername()).add("password", user.getPassword()).get();
		DBCursor cursor = collection.find(query);
		while(cursor.hasNext()){
            DBObject resultObject = cursor.next();
            connection.disconect();
            return new UsersDTO(Integer.parseInt(resultObject.get("identification").toString()),resultObject.get("email").toString(), resultObject.get("username").toString(), resultObject.get("password").toString(), resultObject.get("user").toString());
		}
        return null;
    }

}
