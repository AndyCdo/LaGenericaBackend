package com.lagenerica.api.DAO;

import java.util.ArrayList;

import com.lagenerica.api.DTO.CustomersDTO;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class CustomersDAO {

    private static DBObject createDBObject(CustomersDTO user) {
		BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
								
		docBuilder.append("address", user.getAddress());
		docBuilder.append("email", user.getEmail());
		docBuilder.append("identification", user.getIdentification());
		docBuilder.append("name", user.getName());
        docBuilder.append("phone", user.getPhone());
		return docBuilder.get();
	}

    public CustomersDTO create(CustomersDTO user) {
        DBObject doc = createDBObject(user);

        MyConnection connection = new MyConnection();
		DBCollection collection = connection.database().getCollection("customers");

        collection.insert(doc);

        connection.disconect();

        return get(user.getIdentification());
    }
    
    public CustomersDTO update(Integer id, CustomersDTO user) {
        DBObject doc = createDBObject(user);

        MyConnection connection = new MyConnection();
		DBCollection collection = connection.database().getCollection("customers");
        DBObject query = BasicDBObjectBuilder.start().add("identification", id).get();

		collection.update(query, doc);

        connection.disconect();

        return get(id);
    }
    
    public ArrayList<CustomersDTO> list() {
        ArrayList<CustomersDTO> list =  new ArrayList<CustomersDTO>();

        MyConnection connection = new MyConnection();
		DBCollection collection = connection.database().getCollection("customers");
        
		DBObject query = BasicDBObjectBuilder.start().get();
		DBCursor cursor = collection.find(query);
		while(cursor.hasNext()){
            DBObject resultObject = cursor.next();

            CustomersDTO user = new CustomersDTO(Integer.parseInt(resultObject.get("identification").toString()),resultObject.get("address").toString(), resultObject.get("email").toString(), resultObject.get("name").toString(), resultObject.get("phone").toString());
            list.add(user);
		}
        connection.disconect();
        return list;
    }
    

	public CustomersDTO get(Integer id) {
        MyConnection connection = new MyConnection();
		DBCollection collection = connection.database().getCollection("customers");
        
		DBObject query = BasicDBObjectBuilder.start().add("identification", id).get();
		DBCursor cursor = collection.find(query);
		while(cursor.hasNext()){
            DBObject resultObject = cursor.next();
            connection.disconect();
            return new CustomersDTO(Integer.parseInt(resultObject.get("identification").toString()),resultObject.get("address").toString(), resultObject.get("email").toString(), resultObject.get("name").toString(), resultObject.get("phone").toString());
		}
        return null;
    }
    
    public Boolean delete(Integer id) {
        MyConnection connection = new MyConnection();
		DBCollection collection = connection.database().getCollection("customers");
        
		DBObject query = BasicDBObjectBuilder.start().add("identification",id).get();
		collection.remove(query);

        connection.disconect();
        return true;
    }

}
