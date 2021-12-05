package LaGenerica_DAO;

import org.springframework.data.mongodb.repository.MongoRepository;

import laGenerica.Usuarios;

// Parámetros de MongoRepository --> <DTO, tipo de dato de la PK>
public interface UsuarioDAO extends MongoRepository<Usuarios, Integer>{
	public Usuarios findByUsername(String username);
}
