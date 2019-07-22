package infraestructura.persistencia.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import infraestructura.persistencia.entidad.VehiculoEntidad;

@Repository
public interface IVehiculoRepositorio extends CrudRepository<VehiculoEntidad, Long> {
	
	//hql
	@Query (value = "FROM vehiculo v where v.estado = TRUE", nativeQuery = true)
	List<VehiculoEntidad> obtenerVehiculosParqueados();
	
	

}
