package LaGenerica_DAO;

import org.springframework.data.mongodb.repository.MongoRepository;

import laGenerica.Productos;

// Parámetros de MongoRepository --> <DTO, tipo de dato de la PK>
public interface ProductoDAO extends MongoRepository<Productos, Integer>{
	public Productos findByCodigo(Integer codigo);
}
