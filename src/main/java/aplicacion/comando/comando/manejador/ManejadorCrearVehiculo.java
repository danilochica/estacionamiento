package aplicacion.comando.comando.manejador;

import org.springframework.stereotype.Component;

import dominio.modelo.VehiculoDTO;
import dominio.servicio.IngresarVehiculoServicio;

@Component
public class ManejadorCrearVehiculo {
	
	VehiculoDTO vehiculoDTO;
	IngresarVehiculoServicio ingresarVehiculoServicio;
	
	public ManejadorCrearVehiculo(IngresarVehiculoServicio ingresarVehiculoServicio, VehiculoDTO vehiculoDTO) {
		this.ingresarVehiculoServicio = ingresarVehiculoServicio;
		this.vehiculoDTO = vehiculoDTO;
	}
	
	public void ejecutar(VehiculoDTO vehiculoDTO) {
		this.ingresarVehiculoServicio.registrarVehiculo(vehiculoDTO);
	}

}
