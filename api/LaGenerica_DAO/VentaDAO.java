package LaGenerica_DAO;

import org.springframework.data.mongodb.repository.MongoRepository;

import laGenerica.Ventas;

// Parámetros de MongoRepository --> <DTO, tipo de dato de la PK>
public interface VentaDAO extends MongoRepository<Ventas, Integer>{
	public Ventas findByCodigo(Integer codigo);
}
