package com.lagenerica.api.DAO;

import java.util.ArrayList;

import com.lagenerica.api.DTO.ProvidersDTO;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class ProvidersDAO {

    private static DBObject createDBObject(ProvidersDTO user) {
		BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
								
		docBuilder.append("address", user.getAddress());
		docBuilder.append("name", user.getName());
		docBuilder.append("nit", user.getNit());
		docBuilder.append("phone", user.getPhone());
		return docBuilder.get();
	}

    public ProvidersDTO create(ProvidersDTO user) {
        DBObject doc = createDBObject(user);

        MyConnection connection = new MyConnection();
		DBCollection collection = connection.database().getCollection("providers");

        collection.insert(doc);

        connection.disconect();

        return get(user.getNit());
    }
    
    public ProvidersDTO update(Integer id, ProvidersDTO user) {
        DBObject doc = createDBObject(user);

        MyConnection connection = new MyConnection();
		DBCollection collection = connection.database().getCollection("providers");
        DBObject query = BasicDBObjectBuilder.start().add("nit", id).get();

		collection.update(query, doc);

        connection.disconect();

        return get(id);
    }
    
    public ArrayList<ProvidersDTO> list() {
        ArrayList<ProvidersDTO> list =  new ArrayList<ProvidersDTO>();

        MyConnection connection = new MyConnection();
		DBCollection collection = connection.database().getCollection("providers");
        
		DBObject query = BasicDBObjectBuilder.start().get();
		DBCursor cursor = collection.find(query);
		while(cursor.hasNext()){
            DBObject resultObject = cursor.next();
            ProvidersDTO user = new ProvidersDTO(Integer.parseInt(resultObject.get("nit").toString()),resultObject.get("name").toString(), resultObject.get("address").toString(), resultObject.get("phone").toString());
            list.add(user);
		}
        connection.disconect();
        return list;
    }
    

	public ProvidersDTO get(Integer id) {
        MyConnection connection = new MyConnection();
		DBCollection collection = connection.database().getCollection("providers");
        
		DBObject query = BasicDBObjectBuilder.start().add("nit", id).get();
		DBCursor cursor = collection.find(query);
		while(cursor.hasNext()){
            DBObject resultObject = cursor.next();
            connection.disconect();

            return new ProvidersDTO(Integer.parseInt(resultObject.get("nit").toString()),resultObject.get("name").toString(), resultObject.get("address").toString(), resultObject.get("phone").toString());
		}
        return null;
    }
    
    public Boolean delete(Integer id) {
        MyConnection connection = new MyConnection();
		DBCollection collection = connection.database().getCollection("providers");
        
		DBObject query = BasicDBObjectBuilder.start().add("nit",id).get();
		collection.remove(query);

        connection.disconect();
        return true;
    }

}
