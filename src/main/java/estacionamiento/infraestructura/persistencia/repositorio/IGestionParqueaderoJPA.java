package estacionamiento.infraestructura.persistencia.repositorio;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import estacionamiento.infraestructura.persistencia.entidad.GestionParqueaderoEntidad;

@Repository
public interface IGestionParqueaderoJPA extends JpaRepository<GestionParqueaderoEntidad, Long>{

	//@Query("SELECT COUNT(1) FROM GestionParqueadero p, Vehiculo v  WHERE p.idvehiculo = :v.idvehiculo AND v.tipovehiculo = :tipoVehiculo AND p.estado = true")
	//Long contarVehiculosParqueados(String tipoVehiculo);

	List<GestionParqueaderoEntidad> findByEstado(Boolean estado);

	
}