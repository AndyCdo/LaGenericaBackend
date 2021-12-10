package com.lagenerica.api;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lagenerica.api.DAO.UsersDAO;
import com.lagenerica.api.DTO.UsersDTO;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UsersController {

	@PostMapping("")
	public UsersDTO create(@RequestHeader("city") String city, @RequestBody UsersDTO user) {
		UsersDAO DAO = new UsersDAO(city);
		return DAO.create(user);
	}

	@PutMapping("/{id}")
	public UsersDTO update(@RequestHeader("city") String city, @PathVariable("id") int id, @RequestBody UsersDTO user) {
		UsersDAO DAO = new UsersDAO(city);
		return DAO.update(id, user);

	}

	@GetMapping("")
	public ArrayList<UsersDTO> list(@RequestHeader("city") String city) {
		UsersDAO DAO = new UsersDAO(city);
		return DAO.list();
	}

	@GetMapping("/{id}")
	public UsersDTO get(@RequestHeader("city") String city, @PathVariable("id") int id) {
		UsersDAO DAO = new UsersDAO(city);
		return DAO.get(id);
	}

	@DeleteMapping("/{id}")
	public Boolean delete(@RequestHeader("city") String city, @PathVariable("id") int id) {
		UsersDAO DAO = new UsersDAO(city);
		return DAO.delete(id);
	}

	@PostMapping("/auth")
	public UsersDTO auth(@RequestHeader("city") String city, @RequestBody UsersDTO user) {
		UsersDAO DAO = new UsersDAO(city);
		return DAO.auth(user);
	}

}