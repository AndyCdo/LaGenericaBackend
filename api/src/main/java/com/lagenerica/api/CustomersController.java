package com.lagenerica.api;
import java.util.ArrayList;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.lagenerica.api.DAO.CustomersDAO;
import com.lagenerica.api.DTO.CustomersDTO;

@RestController
public class CustomersController {
	
	@RequestMapping(
	        value = "/customers",
	        method = RequestMethod.POST,
	        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public CustomersDTO create(@RequestBody CustomersDTO customer) {
		CustomersDAO DAO = new CustomersDAO();
		return DAO.create(customer);	
	}
	
	@RequestMapping(
	        value = "/customers/{id}",
	        method = RequestMethod.PUT,
	        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public CustomersDTO update(@PathVariable("id") int id, @RequestBody CustomersDTO customer) {
		CustomersDAO DAO = new CustomersDAO();
		return DAO.update(id, customer);	
	
	}

	@RequestMapping(
	        value = "/customers",
	        method = RequestMethod.GET)
	public ArrayList<CustomersDTO> list() {
		CustomersDAO DAO = new CustomersDAO();
		return DAO.list();	
	}

	@RequestMapping(
	        value = "/customers/{id}",
	        method = RequestMethod.GET)
	public CustomersDTO get(@PathVariable("id") int id) {
		CustomersDAO DAO = new CustomersDAO();
		return DAO.get(id);	
	}

	@RequestMapping(
	        value = "/customers/{id}",
	        method = RequestMethod.DELETE)
	public Boolean delete(@PathVariable("id") int id) {
		CustomersDAO DAO = new CustomersDAO();
		return DAO.delete(id);	
	}
}
