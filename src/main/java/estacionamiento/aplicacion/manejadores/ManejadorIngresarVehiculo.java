package estacionamiento.aplicacion.manejadores;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import estacionamiento.dominio.modelo.VehiculoDTO;
import estacionamiento.dominio.servicio.IngresarVehiculoServicio;

@Service
@Transactional
public class ManejadorIngresarVehiculo {
	
	IngresarVehiculoServicio ingresarVehiculoServicio;
	
	
	public ManejadorIngresarVehiculo(IngresarVehiculoServicio ingresarVehiculoServicio) {
		this.ingresarVehiculoServicio = ingresarVehiculoServicio;
	}
	
	public void guardarVehiculo(VehiculoDTO vehiculoDTO) {
		 ingresarVehiculoServicio.registrarVehiculo(vehiculoDTO);
	}
	
	public void guardarIngresoVehiculoAlParqueadero(VehiculoDTO vehiculoDTO) {
		this.ingresarVehiculoServicio.registarIngresoAlParqueadero(vehiculoDTO);
	}

}
