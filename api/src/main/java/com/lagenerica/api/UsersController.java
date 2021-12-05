package com.lagenerica.api;
import java.util.ArrayList;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.lagenerica.api.DAO.UsersDAO;
import com.lagenerica.api.DTO.UsersDTO;

@RestController
public class UsersController {

	@RequestMapping(
	        value = "/users",
	        method = RequestMethod.POST,
	        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public UsersDTO create(@RequestBody UsersDTO user) {
		UsersDAO DAO = new UsersDAO();
		return DAO.create(user);	
	}
	
	@RequestMapping(
	        value = "/users/{id}",
	        method = RequestMethod.PUT,
	        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public UsersDTO update(@PathVariable("id") int id, @RequestBody UsersDTO user) {
		UsersDAO DAO = new UsersDAO();
		return DAO.update(id, user);	
	
	}

	@RequestMapping(
	        value = "/users",
	        method = RequestMethod.GET)
	public ArrayList<UsersDTO> list() {
		UsersDAO DAO = new UsersDAO();
		return DAO.list();	
	}

	@RequestMapping(
	        value = "/users/{id}",
	        method = RequestMethod.GET)
	public UsersDTO get(@PathVariable("id") int id) {
		UsersDAO DAO = new UsersDAO();
		return DAO.get(id);	
	}

	@RequestMapping(
	        value = "/users/{id}",
	        method = RequestMethod.DELETE)
	public Boolean delete(@PathVariable("id") int id) {
		UsersDAO DAO = new UsersDAO();
		return DAO.delete(id);	
	}


	@RequestMapping(
	        value = "/users/auth",
	        method = RequestMethod.POST,
	        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
			
	public UsersDTO auth(@RequestBody UsersDTO user) {
		UsersDAO DAO = new UsersDAO();
		return DAO.auth(user);	
	}

}