package estacionamiento.aplicacion.manejadores;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import estacionamiento.dominio.modelo.GestionParqueaderoDTO;
import estacionamiento.dominio.modelo.VehiculoDTO;
import estacionamiento.dominio.servicio.ParqueaderoServicio;

@Service
@Transactional
public class ManejadorServicioParqueadero {
	
	ParqueaderoServicio ingresarVehiculoServicio;
	
	public ManejadorServicioParqueadero(ParqueaderoServicio ingresarVehiculoServicio) {
		this.ingresarVehiculoServicio = ingresarVehiculoServicio;
	}
	
	public VehiculoDTO  crearVehiculo(VehiculoDTO vehiculoDTO) {
		 return ingresarVehiculoServicio.registrarVehiculo(vehiculoDTO);
	}
	
	public GestionParqueaderoDTO guardarIngresoVehiculoAlParqueadero(VehiculoDTO vehiculoDTO) {
		return this.ingresarVehiculoServicio.registarIngresoAlParqueadero(vehiculoDTO);
	}
	
	public List<GestionParqueaderoDTO> listaVehiculosParqueados(){
		return this.ingresarVehiculoServicio.listarVehiculosParqueados();
		
	}

}
