package com.lagenerica.api.DTO;

public class ConsolidatedDTO {
    private String city;
    private Integer total;
    
    public ConsolidatedDTO() {
    }
    public ConsolidatedDTO(String city, Integer total) {
        this.city = city;
        this.total = total;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    
    public Integer getTotal() {
        return total;
    }
    
    public void setTotal(Integer total) {
        this.total = total;
    }
}
