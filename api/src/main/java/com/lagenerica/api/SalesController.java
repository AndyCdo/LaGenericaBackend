package com.lagenerica.api;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lagenerica.api.DAO.SalesDAO;
import com.lagenerica.api.DTO.SalesDTO;

@RestController
@CrossOrigin
@RequestMapping("/sales")
public class SalesController {

	@PostMapping("")
	public SalesDTO create(@RequestHeader("city") String city, @RequestBody SalesDTO sale) {
		SalesDAO DAO = new SalesDAO(city);
		return DAO.create(sale);
	}

	@GetMapping("")
	public ArrayList<SalesDTO> list(@RequestHeader("city") String city) {
		SalesDAO DAO = new SalesDAO(city);
		return DAO.list();
	}

	@GetMapping("last")
	public SalesDTO getLast(@RequestHeader("city") String city) {
		SalesDAO DAO = new SalesDAO(city);
		return DAO.getLast();
	}

	@GetMapping("/customer")
	public ArrayList<SalesDTO> listByCustomer(@RequestHeader("city") String city) {
		SalesDAO DAO = new SalesDAO(city);
		return DAO.listByCustomer();
	}



}