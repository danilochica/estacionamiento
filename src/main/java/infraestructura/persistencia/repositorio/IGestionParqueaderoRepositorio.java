package infraestructura.persistencia.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import infraestructura.persistencia.entidad.GestionParqueaderoEntidad;

@Repository
public interface IGestionParqueaderoRepositorio extends CrudRepository<GestionParqueaderoEntidad, Long>{

	
}
