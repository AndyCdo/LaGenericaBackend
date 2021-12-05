package com.lagenerica.api.DAO;

import java.util.ArrayList;

import com.lagenerica.api.DTO.ProductsDTO;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class ProductsDAO {

    private static DBObject createDBObject(ProductsDTO user) {
		BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
								
		docBuilder.append("code", user.getCode());
		docBuilder.append("iva", user.getIva());
		docBuilder.append("name", user.getName());
		docBuilder.append("provider", user.getProvider());
        docBuilder.append("purchasePrice", user.getPurchasePrice());
        docBuilder.append("salePrice", user.getSalePrice());

		return docBuilder.get();
	}

    public ProductsDTO create(ProductsDTO user) {
        DBObject doc = createDBObject(user);

        MyConnection connection = new MyConnection();
		DBCollection collection = connection.database().getCollection("products");

        collection.insert(doc);

        connection.disconect();

        return get(user.getCode());
    }
    
    public ProductsDTO update(Integer id, ProductsDTO user) {
        DBObject doc = createDBObject(user);

        MyConnection connection = new MyConnection();
		DBCollection collection = connection.database().getCollection("products");
        DBObject query = BasicDBObjectBuilder.start().add("code", id).get();

		collection.update(query, doc);

        connection.disconect();

        return get(id);
    }
    
    public ArrayList<ProductsDTO> list() {
        ArrayList<ProductsDTO> list =  new ArrayList<ProductsDTO>();

        MyConnection connection = new MyConnection();
		DBCollection collection = connection.database().getCollection("products");
        
		DBObject query = BasicDBObjectBuilder.start().get();
		DBCursor cursor = collection.find(query);
		while(cursor.hasNext()){
            DBObject resultObject = cursor.next();
            ProductsDTO user = new ProductsDTO(Integer.parseInt(resultObject.get("code").toString()),Integer.parseInt(resultObject.get("iva").toString()), Integer.parseInt(resultObject.get("provider").toString()), resultObject.get("name").toString(), Integer.parseInt(resultObject.get("salePrice").toString()), Integer.parseInt(resultObject.get("purchasePrice").toString()));
            list.add(user);
		}
        connection.disconect();
        return list;
    }
    

	public ProductsDTO get(Integer id) {
        MyConnection connection = new MyConnection();
		DBCollection collection = connection.database().getCollection("products");
        
		DBObject query = BasicDBObjectBuilder.start().add("code", id).get();
		DBCursor cursor = collection.find(query);
		while(cursor.hasNext()){
            DBObject resultObject = cursor.next();
            connection.disconect();
            return new ProductsDTO(Integer.parseInt(resultObject.get("code").toString()),Integer.parseInt(resultObject.get("iva").toString()), Integer.parseInt(resultObject.get("provider").toString()), resultObject.get("name").toString(), Integer.parseInt(resultObject.get("salePrice").toString()), Integer.parseInt(resultObject.get("purchasePrice").toString()));
		}
        return null;
    }
    
    public Boolean delete(Integer id) {
        MyConnection connection = new MyConnection();
		DBCollection collection = connection.database().getCollection("products");
        
		DBObject query = BasicDBObjectBuilder.start().add("code",id).get();
		collection.remove(query);

        connection.disconect();
        return true;
    }
    
}
