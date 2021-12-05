package laGeneria_Api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import LaGenerica_DAO.ProductoDAO;
import laGenerica.Productos;

@RestController //esta es una clase REST
@RequestMapping("productos")
public class ProductosAPI {
	@Autowired//inyecta la dependencia de todos los métodos del JPA para clienteDAO
	private ProductoDAO productoDAO;
	
	@PostMapping("/guardar")
	public void guardar(@RequestBody Productos producto) {//Request convierte en un objeto Java desde un JSon
		productoDAO.save(producto);
	}
	
	@GetMapping("/listar")
	public List<Productos> listar(){
		return productoDAO.findAll();
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		productoDAO.deleteById(id);
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Productos producto) {
		productoDAO.save(producto);
	}	
}
