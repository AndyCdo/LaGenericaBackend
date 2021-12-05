package com.lagenerica.api;
import java.util.ArrayList;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.lagenerica.api.DAO.ProvidersDAO;
import com.lagenerica.api.DTO.ProvidersDTO;

@RestController
public class ProvidersController {
	
	@RequestMapping(
	        value = "/providers",
	        method = RequestMethod.POST,
	        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ProvidersDTO create(@RequestBody ProvidersDTO provider) {
		ProvidersDAO DAO = new ProvidersDAO();
		return DAO.create(provider);	
	}
	
	@RequestMapping(
	        value = "/providers/{id}",
	        method = RequestMethod.PUT,
	        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ProvidersDTO update(@PathVariable("id") int id, @RequestBody ProvidersDTO provider) {
		ProvidersDAO DAO = new ProvidersDAO();
		return DAO.update(id, provider);	
	
	}

	@RequestMapping(
	        value = "/providers",
	        method = RequestMethod.GET)
	public ArrayList<ProvidersDTO> list() {
		ProvidersDAO DAO = new ProvidersDAO();
		return DAO.list();	
	}

	@RequestMapping(
	        value = "/providers/{id}",
	        method = RequestMethod.GET)
	public ProvidersDTO get(@PathVariable("id") int id) {
		ProvidersDAO DAO = new ProvidersDAO();
		return DAO.get(id);	
	}

	@RequestMapping(
	        value = "/providers/{id}",
	        method = RequestMethod.DELETE)
	public Boolean delete(@PathVariable("id") int id) {
		ProvidersDAO DAO = new ProvidersDAO();
		return DAO.delete(id);	
	}
}
