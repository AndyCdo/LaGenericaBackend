package com.lagenerica.api.DTO;

public class ProductsDTO {
	
	public ProductsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	private Integer code;
	private Double iva;
	private Integer provider;
	private String name;
	private Integer salePrice;
	private Integer purchasePrice;
	
	public ProductsDTO(Integer code, Double iva, Integer provider, String name, Integer salePrice,
			Integer purchasePrice) {
		super();
		this.code = code;
		this.iva = iva;
		this.provider = provider;
		this.name = name;
		this.salePrice = salePrice;
		this.purchasePrice = purchasePrice;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public Double getIva() {
		return iva;
	}
	public void setIva(Double iva) {
		this.iva = iva;
	}
	public Integer getProvider() {
		return provider;
	}
	public void setProvider(Integer provider) {
		this.provider = provider;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(Integer salePrice) {
		this.salePrice = salePrice;
	}
	public Integer getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(Integer purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

}
