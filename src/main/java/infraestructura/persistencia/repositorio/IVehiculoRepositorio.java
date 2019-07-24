package infraestructura.persistencia.repositorio;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import infraestructura.persistencia.entidad.VehiculoEntidad;

@Repository
public interface IVehiculoRepositorio extends CrudRepository<VehiculoEntidad, Long> {
	

	

}
