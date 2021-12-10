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
import com.lagenerica.api.DAO.ProductsDAO;
import com.lagenerica.api.DTO.ProductsDTO;

@RestController
@CrossOrigin
@RequestMapping("/products")
public class ProductsController {

	@PostMapping("")
	public ProductsDTO create(@RequestHeader("city") String city, @RequestBody ProductsDTO product) {
		ProductsDAO DAO = new ProductsDAO(city);
		return DAO.create(product);
	}

	@PutMapping("/{id}")
	public ProductsDTO update(@RequestHeader("city") String city, @PathVariable("id") int id, @RequestBody ProductsDTO product) {
		ProductsDAO DAO = new ProductsDAO(city);
		return DAO.update(id, product);
	}

	@GetMapping("")
	public ArrayList<ProductsDTO> list(@RequestHeader("city") String city) {
		ProductsDAO DAO = new ProductsDAO(city);
		return DAO.list();
	}

	@GetMapping("/{id}")
	public ProductsDTO get(@RequestHeader("city") String city, @PathVariable("id") int id) {
		ProductsDAO DAO = new ProductsDAO(city);
		return DAO.get(id);
	}

	@DeleteMapping("/{id}")
	public Boolean delete(@RequestHeader("city") String city, @PathVariable("id") int id) {
		ProductsDAO DAO = new ProductsDAO(city);
		return DAO.delete(id);
	}
}
