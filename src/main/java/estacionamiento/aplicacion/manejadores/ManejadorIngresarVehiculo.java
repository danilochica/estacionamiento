package estacionamiento.aplicacion.manejadores;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import estacionamiento.dominio.modelo.GestionParqueaderoDTO;
import estacionamiento.dominio.modelo.VehiculoDTO;
import estacionamiento.dominio.servicio.IngresarVehiculoServicio;

@Service
@Transactional
public class ManejadorIngresarVehiculo {
	
	IngresarVehiculoServicio ingresarVehiculoServicio;
	
	
	public ManejadorIngresarVehiculo(IngresarVehiculoServicio ingresarVehiculoServicio) {
		this.ingresarVehiculoServicio = ingresarVehiculoServicio;
	}
	
	public VehiculoDTO  crearVehiculo(VehiculoDTO vehiculoDTO) {
		 return ingresarVehiculoServicio.registrarVehiculo(vehiculoDTO);
	}
	
	public GestionParqueaderoDTO guardarIngresoVehiculoAlParqueadero(VehiculoDTO vehiculoDTO) {
		return this.ingresarVehiculoServicio.registarIngresoAlParqueadero(vehiculoDTO);
	}

}
