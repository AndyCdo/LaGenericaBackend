package LaGenerica_DAO;

import org.springframework.data.mongodb.repository.MongoRepository;

import laGenerica.Clientes;

// Parámetros de MongoRepository --> <DTO, tipo de dato de la PK>
public interface ClienteDAO extends MongoRepository<Clientes, Integer>{
	public Clientes findByCedula(Integer cedula);
}
