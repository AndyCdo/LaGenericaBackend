package com.lagenerica.api.DTO;
import java.io.*;

public class SalesDetailsDTO implements Serializable {
	
	private Integer amount;
	private Integer code;
	private double total;
	private double value;
	private double iva;

	public SalesDetailsDTO() {
		super();
	}

	public SalesDetailsDTO(Integer amount, Integer code, double total, double value, double iva) {
		super();
		this.amount = amount;
		this.code = code;
		this.total = total;
		this.value = value;
		this.iva = iva;
	}
	public Integer getamount() {
		return amount;
	}
	public void setamount(Integer amount) {
		this.amount = amount;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public double getIva() {
		return iva;
	}
	public void setIva(double iva) {
		this.iva = iva;
	}

}
