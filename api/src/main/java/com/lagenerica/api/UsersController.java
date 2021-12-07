package com.lagenerica.api;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lagenerica.api.DAO.UsersDAO;
import com.lagenerica.api.DTO.UsersDTO;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UsersController {

	@PostMapping("")
	public UsersDTO create(@RequestBody UsersDTO user) {
		UsersDAO DAO = new UsersDAO();
		return DAO.create(user);
	}

	@PutMapping("/{id}")
	public UsersDTO update(@PathVariable("id") int id, @RequestBody UsersDTO user) {
		UsersDAO DAO = new UsersDAO();
		return DAO.update(id, user);

	}

	@GetMapping("")
	public ArrayList<UsersDTO> list() {
		UsersDAO DAO = new UsersDAO();
		return DAO.list();
	}

	@GetMapping("/{id}")
	public UsersDTO get(@PathVariable("id") int id) {
		UsersDAO DAO = new UsersDAO();
		return DAO.get(id);
	}

	@DeleteMapping("/{id}")
	public Boolean delete(@PathVariable("id") int id) {
		UsersDAO DAO = new UsersDAO();
		return DAO.delete(id);
	}

	@PostMapping("/auth")
	public UsersDTO auth(@RequestBody UsersDTO user) {
		UsersDAO DAO = new UsersDAO();
		return DAO.auth(user);
	}

}