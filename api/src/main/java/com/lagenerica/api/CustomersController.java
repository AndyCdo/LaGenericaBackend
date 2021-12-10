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
import com.lagenerica.api.DAO.CustomersDAO;
import com.lagenerica.api.DTO.CustomersDTO;

@RestController
@CrossOrigin
@RequestMapping("/customers")
public class CustomersController {

	@PostMapping("")
	public CustomersDTO create(@RequestHeader("city") String city, @RequestBody CustomersDTO customer) {
		CustomersDAO DAO = new CustomersDAO(city);
		return DAO.create(customer);
	}

	@PutMapping("/{id}")
	public CustomersDTO update(@RequestHeader("city") String city, @PathVariable("id") int id, @RequestBody CustomersDTO customer) {
		CustomersDAO DAO = new CustomersDAO(city);
		return DAO.update(id, customer);
	}

	@GetMapping("")
	public ArrayList<CustomersDTO> list(@RequestHeader("city") String city) {
		CustomersDAO DAO = new CustomersDAO(city);
		return DAO.list();
	}

	@GetMapping("/{id}")
	public CustomersDTO get(@RequestHeader("city") String city, @PathVariable("id") int id) {
		CustomersDAO DAO = new CustomersDAO(city);
		return DAO.get(id);
	}

	@DeleteMapping("/{id}")
	public Boolean delete(@RequestHeader("city") String city, @PathVariable("id") int id) {
		CustomersDAO DAO = new CustomersDAO(city);
		return DAO.delete(id);
	}
}
