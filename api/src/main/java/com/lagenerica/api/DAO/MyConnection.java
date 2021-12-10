package com.lagenerica.api.DAO;

import java.net.UnknownHostException;
import java.util.Optional;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class MyConnection {

	
	static String url = "mongodb://127.0.0.1:27017/?directConnection=true&serverSelectionTimeoutMS=2000";

    MongoClient connection = null;

	public MyConnection() {
		try {
			connection = new MongoClient(new MongoClientURI(url));
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        }
	}

    public DB database(Optional<String> city ) {
		if(city.isPresent()){
			return connection.getDB(city.get());
		}
        return connection.getDB("bogota");
    } 

	public DB database( ) {
		
        return connection.getDB("bogota");
    } 

	public MongoClient getConnection() {
		return connection;
	}

	public void disconect() {
        connection.close();
		connection = null;
	}
}
