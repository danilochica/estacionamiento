package estacionamiento.infraestructura.persistencia.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import estacionamiento.infraestructura.persistencia.entidad.TiqueteEntidad;

@Repository
public interface ITiqueteJPA extends JpaRepository<TiqueteEntidad, Long>{

	@Query(value = "SELECT count(v.*) FROM vehiculo v, tiquete t WHERE v.id_Vehiculo =  t.id_vehiculo and t.estado = true and v.tipo_vehiculo = 'Moto'",
		    nativeQuery = true)
	int contarMotosParqueadas();
	
	@Query(value = "SELECT count(v.*) FROM vehiculo v, tiquete t WHERE v.id_Vehiculo =  t.id_vehiculo and t.estado = true and v.tipo_vehiculo = 'Carro'",
		    nativeQuery = true)
	int contarCarrosParqueados();
	
	@Query(value = "SELECT vehiculo.tipo_vehiculo, tiquete.Registro_ingreso, vehiculo.placa  FROM vehiculo v, tiquete t WHERE v.id_Vehiculo =  t.id_vehiculo and t.estado = true",
		    nativeQuery = true)
	List<TiqueteEntidad> vehiculosParqueados();
	
	@Query(value = "SELECT v.tipo_vehiculo, t.Registro_ingreso, v.placa FROM vehiculo v,Tiquete t WHERE t.id_vehiculo =  v.id_vehiculo and t.estado = true and v.placa= :placa",
		    nativeQuery = true)
	TiqueteEntidad consultarVehiculoParqueadoPorPlaca(@Param("placa") String placa);
	

	
}
