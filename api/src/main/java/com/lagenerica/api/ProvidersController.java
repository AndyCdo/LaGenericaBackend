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
import com.lagenerica.api.DAO.ProvidersDAO;
import com.lagenerica.api.DTO.ProvidersDTO;

@RestController
@CrossOrigin
@RequestMapping("/providers")
public class ProvidersController {

	@PostMapping("")
	public ProvidersDTO create(@RequestHeader("city") String city, @RequestBody ProvidersDTO provider) {
		ProvidersDAO DAO = new ProvidersDAO(city);
		return DAO.create(provider);
	}

	@PutMapping("/{id}")
	public ProvidersDTO update(@RequestHeader("city") String city, @PathVariable("id") int id, @RequestBody ProvidersDTO provider) {
		ProvidersDAO DAO = new ProvidersDAO(city);
		return DAO.update(id, provider);
	}

	@GetMapping("")
	public ArrayList<ProvidersDTO> list(@RequestHeader("city") String city) {
		ProvidersDAO DAO = new ProvidersDAO(city);
		return DAO.list();
	}

	@GetMapping("/{id}")
	public ProvidersDTO get(@RequestHeader("city") String city, @PathVariable("id") int id) {
		ProvidersDAO DAO = new ProvidersDAO(city);
		return DAO.get(id);
	}

	@DeleteMapping("/{id}")
	public Boolean delete(@RequestHeader("city") String city, @PathVariable("id") int id) {
		ProvidersDAO DAO = new ProvidersDAO(city);
		return DAO.delete(id);
	}
}
