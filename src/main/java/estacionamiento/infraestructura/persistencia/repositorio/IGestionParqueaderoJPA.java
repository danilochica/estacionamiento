package estacionamiento.infraestructura.persistencia.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import estacionamiento.infraestructura.persistencia.entidad.GestionParqueaderoEntidad;

@Repository
public interface IGestionParqueaderoJPA extends JpaRepository<GestionParqueaderoEntidad, Long>{

	@Query(
			value = "SELECT count(v.*) FROM vehiculo v,Gestion_Parqueadero p WHERE p.id_Vehiculo =  v.id_vehiculo and p.estado = true and v.tipo_vehiculo = 'Moto'",
		    nativeQuery = true)
	int contarMotosParqueadas();
	
	@Query(
			value = "SELECT count(v.*) FROM vehiculo v,Gestion_Parqueadero p WHERE p.id_Vehiculo =  v.id_vehiculo and p.estado = true and v.tipo_vehiculo = 'Moto'",
		    nativeQuery = true)
	int contarCarrosParqueados();

	List<GestionParqueaderoEntidad> findByEstado(Boolean estado);

	
}
