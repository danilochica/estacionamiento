package estacionamiento.infraestructura.persistencia.repositorio;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import estacionamiento.infraestructura.persistencia.entidad.GestionParqueaderoEntidad;

@Repository
public interface IGestionParqueaderoJPA extends JpaRepository<GestionParqueaderoEntidad, Long>{

	//@Query("SELECT COUNT(*) FROM GestionParqueadero p JOIN p.tipoVehiculo v WHERE v.tipoVehiculo = :tipoVehiculo AND p.estado = true")
	//int contarVehiculosParqueados(String tipoVehiculo);

	List<GestionParqueaderoEntidad> findByEstado(Boolean estado);

	
}
