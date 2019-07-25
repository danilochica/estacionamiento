package estacionamiento.infraestructura.controlador;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import estacionamiento.aplicacion.manejadores.ManejadorIngresarVehiculo;
import estacionamiento.dominio.modelo.GestionParqueaderoDTO;
import estacionamiento.dominio.modelo.VehiculoDTO;
import estacionamiento.infraestructura.persistencia.repositorio.IGestionParqueaderoJPA;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/ingresarVehiculo")
public class IngresarVehiculoControlador {
	
	IGestionParqueaderoJPA gestionParqueaderoRepositorio;
	ManejadorIngresarVehiculo ingresarVehiculo;
	
	public IngresarVehiculoControlador(IGestionParqueaderoJPA gestionParqueaderoRepositorio,
			ManejadorIngresarVehiculo ingresarVehiculo) {
		this.gestionParqueaderoRepositorio = gestionParqueaderoRepositorio;
		this.ingresarVehiculo = ingresarVehiculo;
	}

	@PostMapping
	public GestionParqueaderoDTO registrarVehiculoParqueadero(@RequestBody VehiculoDTO vehiculoDTO) {
		VehiculoDTO vehiculoAlmacenado =  ingresarVehiculo.crearVehiculo(vehiculoDTO);
		GestionParqueaderoDTO parqueaderoAlmacenado = ingresarVehiculo.guardarIngresoVehiculoAlParqueadero(vehiculoAlmacenado);
		
		return parqueaderoAlmacenado;
	}
	

}
