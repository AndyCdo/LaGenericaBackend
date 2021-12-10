package com.lagenerica.api.DAO;

import java.util.ArrayList;

import com.lagenerica.api.DTO.ConsolidatedDTO;
import com.lagenerica.api.DTO.SalesDTO;

public class ConsolidatedDAO {
    
    private String city;

    public ConsolidatedDAO(String city) {
        this.city = city;
    }




    public ArrayList<ConsolidatedDTO> list() {
        ArrayList<ConsolidatedDTO> list =  new ArrayList<ConsolidatedDTO>();
        SalesDAO salesDAO = new SalesDAO("bogota");
        ArrayList<SalesDTO> salesBogota = salesDAO.list("bogota");
        ArrayList<SalesDTO> salesMedellin = salesDAO.list("medellin");
        ArrayList<SalesDTO> salesCali = salesDAO.list("cali");
 
        Integer totalBogota = 0;
        Integer totalMedellin = 0;
        Integer totalCali = 0;

        for (SalesDTO sale : salesBogota){
            totalBogota += sale.getTotal();

        } 
        for (SalesDTO sale : salesMedellin){
            totalMedellin += sale.getTotal();
        }
        for (SalesDTO sale : salesCali){
            totalCali += sale.getTotal();
        }

        list.add(new ConsolidatedDTO("Bogotá", totalBogota));
        list.add(new ConsolidatedDTO("Medellín", totalMedellin));
        list.add(new ConsolidatedDTO("Cali", totalCali));

        return list;
    }
    
}
