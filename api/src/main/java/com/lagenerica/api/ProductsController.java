package com.lagenerica.api;
import java.util.ArrayList;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.lagenerica.api.DAO.ProductsDAO;
import com.lagenerica.api.DTO.ProductsDTO;

@RestController
public class ProductsController {
	
	@RequestMapping(
	        value = "/products",
	        method = RequestMethod.POST,
	        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ProductsDTO create(@RequestBody ProductsDTO product) {
		ProductsDAO DAO = new ProductsDAO();
		return DAO.create(product);	
	}
	
	@RequestMapping(
	        value = "/products/{id}",
	        method = RequestMethod.PUT,
	        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ProductsDTO update(@PathVariable("id") int id, @RequestBody ProductsDTO product) {
		ProductsDAO DAO = new ProductsDAO();
		return DAO.update(id, product);	
	
	}

	@RequestMapping(
	        value = "/products",
	        method = RequestMethod.GET)
	public ArrayList<ProductsDTO> list() {
		ProductsDAO DAO = new ProductsDAO();
		return DAO.list();	
	}

	@RequestMapping(
	        value = "/products/{id}",
	        method = RequestMethod.GET)
	public ProductsDTO get(@PathVariable("id") int id) {
		ProductsDAO DAO = new ProductsDAO();
		return DAO.get(id);	
	}

	@RequestMapping(
	        value = "/products/{id}",
	        method = RequestMethod.DELETE)
	public Boolean delete(@PathVariable("id") int id) {
		ProductsDAO DAO = new ProductsDAO();
		return DAO.delete(id);	
	}
}
