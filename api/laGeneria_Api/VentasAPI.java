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

import LaGenerica_DAO.VentaDAO;
import laGenerica.Ventas;

@RestController //esta es una clase REST
@RequestMapping("ventas")
public class VentasAPI {
	@Autowired//inyecta la dependencia de todos los métodos del JPA para clienteDAO
	private VentaDAO ventaDAO;
	
	@PostMapping("/guardar")
	public void guardar(@RequestBody Ventas venta) {//Request convierte en un objeto Java desde un JSon
		ventaDAO.save(venta);
	}
	
	@GetMapping("/listar")
	public List<Ventas> listar(){
		return ventaDAO.findAll();
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		ventaDAO.deleteById(id);
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Ventas venta) {
		ventaDAO.save(venta);
	}	
}
