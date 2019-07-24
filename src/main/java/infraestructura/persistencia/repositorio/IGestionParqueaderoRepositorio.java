package infraestructura.persistencia.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import infraestructura.persistencia.entidad.GestionParqueaderoEntidad;

@Repository
public interface IGestionParqueaderoRepositorio extends CrudRepository<GestionParqueaderoEntidad, Long>{
	

	//hql
	@Query (value = "FROM gestionParqueadero v where v.estado = TRUE", nativeQuery = true)
	List<GestionParqueaderoEntidad> obtenerVehiculosParqueados();
	
	@Query (value = "FROM gestionParqueadero v where v.tipovehiculo = ? and v.estado = TRUE", nativeQuery = true)
	int obtenerVehiculosParqueadosPorTipo(String tipoVehiculo);
	

	
}
