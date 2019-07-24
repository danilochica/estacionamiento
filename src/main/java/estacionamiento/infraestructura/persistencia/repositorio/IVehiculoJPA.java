package estacionamiento.infraestructura.persistencia.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import estacionamiento.dominio.modelo.VehiculoDTO;
import estacionamiento.infraestructura.persistencia.entidad.VehiculoEntidad;

@Repository
public interface IVehiculoJPA extends JpaRepository<VehiculoEntidad, Long> {
	
	//@Query("FROM Vehiculo V WHERE V.placa = :placa")
	//VehiculoEntidad buscarVehiculoPorPlaca(String placa);

	//void guardarVehiculo (VehiculoDTO vehicnuloDTO);
	

}