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
import com.lagenerica.api.DAO.ProductsDAO;
import com.lagenerica.api.DTO.ProductsDTO;

@RestController
@CrossOrigin
@RequestMapping("/products")
public class ProductsController {

	@PostMapping("")
	public ProductsDTO create(@RequestBody ProductsDTO product) {
		ProductsDAO DAO = new ProductsDAO();
		return DAO.create(product);
	}

	@PutMapping("/{id}")
	public ProductsDTO update(@PathVariable("id") int id, @RequestBody ProductsDTO product) {
		ProductsDAO DAO = new ProductsDAO();
		return DAO.update(id, product);
	}

	@GetMapping("")
	public ArrayList<ProductsDTO> list() {
		ProductsDAO DAO = new ProductsDAO();
		return DAO.list();
	}

	@GetMapping("/{id}")
	public ProductsDTO get(@PathVariable("id") int id) {
		ProductsDAO DAO = new ProductsDAO();
		return DAO.get(id);
	}

	@DeleteMapping("/{id}")
	public Boolean delete(@PathVariable("id") int id) {
		ProductsDAO DAO = new ProductsDAO();
		return DAO.delete(id);
	}
}
