package com.lagenerica.api.DAO;

import java.util.ArrayList;

import com.lagenerica.api.DTO.SalesDTO;
import com.lagenerica.api.DTO.SalesDetailsDTO;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class SalesDAO {

    private static DBObject createDBObject(SalesDTO sale) {
        BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
        docBuilder.append("code", sale.getCode());
        docBuilder.append("identification", sale.getIdentification());
        BasicDBList saleDetailsList = new BasicDBList();
        for (SalesDetailsDTO saleDatail : sale.getDetails()) {
            BasicDBObjectBuilder saleDocBuilder = new BasicDBObjectBuilder();
            saleDocBuilder.append("amount", saleDatail.getamount());
            saleDocBuilder.append("code", saleDatail.getCode());
            saleDocBuilder.append("total", saleDatail.getTotal());
            saleDocBuilder.append("value", saleDatail.getValue());
            saleDocBuilder.append("iva", saleDatail.getIva());
            saleDetailsList.add(saleDocBuilder.get());
        }

        docBuilder.append("details", saleDetailsList);
        docBuilder.append("total", sale.getTotal());
        docBuilder.append("value", sale.getValue());
        return docBuilder.get();
    }

    public SalesDTO create(SalesDTO sale) {
        DBObject doc = createDBObject(sale);

        MyConnection connection = new MyConnection();
        DBCollection collection = connection.database().getCollection("sales");

        collection.insert(doc);

        connection.disconect();
        return get(2);
    }

    public SalesDTO getLast() {
        MyConnection connection = new MyConnection();
        DBCollection collection = connection.database().getCollection("sales");
        DBObject sort = BasicDBObjectBuilder.start().add("_id", -1).get();
        DBCursor cursor = collection.find().sort(sort);
        while (cursor.hasNext()) {
            DBObject resultObject = cursor.next();
            connection.disconect();

            ArrayList<SalesDetailsDTO> list = new ArrayList<SalesDetailsDTO>();
            BasicDBList saleDetailsList = (BasicDBList) resultObject.get("details");
            for (Object detail : saleDetailsList.toArray()) {
                BasicDBObject saleDatail = (BasicDBObject) detail;

                SalesDetailsDTO obj = new SalesDetailsDTO(saleDatail.getInt("amount"), saleDatail.getInt("code"),
                        saleDatail.getDouble("total"), saleDatail.getDouble("value"), saleDatail.getDouble("iva"));
                list.add(obj);
            }

            return new SalesDTO(Integer.parseInt(resultObject.get("code").toString()),
                    Integer.parseInt(resultObject.get("identification").toString()), list,
                    Integer.parseInt(resultObject.get("total").toString()),
                    Integer.parseInt(resultObject.get("value").toString()));
        }
        return null;

    }

    public ArrayList<SalesDTO> list() {
        ArrayList<SalesDTO> list = new ArrayList<SalesDTO>();

        MyConnection connection = new MyConnection();
        DBCollection collection = connection.database().getCollection("sales");

        DBObject query = BasicDBObjectBuilder.start().get();
        DBCursor cursor = collection.find(query);
        while (cursor.hasNext()) {
            DBObject resultObject = cursor.next();
            connection.disconect();

            ArrayList<SalesDetailsDTO> listDetails = new ArrayList<SalesDetailsDTO>();
            BasicDBList saleDetailsList = (BasicDBList) resultObject.get("details");
            for (Object detail : saleDetailsList.toArray()) {
                BasicDBObject saleDatail = (BasicDBObject) detail;

                SalesDetailsDTO obj = new SalesDetailsDTO(saleDatail.getInt("amount"), saleDatail.getInt("code"),
                        saleDatail.getDouble("total"), saleDatail.getDouble("value"), saleDatail.getDouble("iva"));
                listDetails.add(obj);
            }
            SalesDTO sale = new SalesDTO(Integer.parseInt(resultObject.get("code").toString()),
                    Integer.parseInt(resultObject.get("identification").toString()), listDetails,
                    Integer.parseInt(resultObject.get("total").toString()),
                    Integer.parseInt(resultObject.get("value").toString()));
            list.add(sale);
        }
        connection.disconect();
        return list;
    }

    public SalesDTO get(Integer id) {
        MyConnection connection = new MyConnection();
        DBCollection collection = connection.database().getCollection("sales");

        DBObject query = BasicDBObjectBuilder.start().add("code", id).get();
        DBCursor cursor = collection.find(query);
        while (cursor.hasNext()) {
            DBObject resultObject = cursor.next();
            connection.disconect();

            ArrayList<SalesDetailsDTO> list = new ArrayList<SalesDetailsDTO>();
            BasicDBList saleDetailsList = (BasicDBList) resultObject.get("details");
            for (Object detail : saleDetailsList.toArray()) {
                BasicDBObject saleDatail = (BasicDBObject) detail;

                SalesDetailsDTO obj = new SalesDetailsDTO(saleDatail.getInt("amount"), saleDatail.getInt("code"),
                        saleDatail.getDouble("total"), saleDatail.getDouble("value"), saleDatail.getDouble("iva"));
                list.add(obj);
            }

            return new SalesDTO(Integer.parseInt(resultObject.get("code").toString()),
                    Integer.parseInt(resultObject.get("identification").toString()), list,
                    Integer.parseInt(resultObject.get("total").toString()),
                    Integer.parseInt(resultObject.get("value").toString()));
        }
        return null;
    }

}
