package estacionamiento.infraestructura.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import estacionamiento.aplicacion.manejadores.ManejadorServicioParqueadero;
import estacionamiento.dominio.modelo.GestionParqueaderoDTO;
import estacionamiento.dominio.modelo.VehiculoDTO;
import estacionamiento.infraestructura.persistencia.repositorio.IGestionParqueaderoJPA;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/parqueadero")
public class ParqueaderoControlador {
	
	IGestionParqueaderoJPA gestionParqueaderoRepositorio;
	ManejadorServicioParqueadero servicioParqueadero;
	
	public ParqueaderoControlador(IGestionParqueaderoJPA gestionParqueaderoRepositorio,
			ManejadorServicioParqueadero ingresarVehiculo) {
		this.gestionParqueaderoRepositorio = gestionParqueaderoRepositorio;
		this.servicioParqueadero = ingresarVehiculo;
	}

	@PostMapping
	public GestionParqueaderoDTO registrarVehiculoParqueadero(@RequestBody VehiculoDTO vehiculoDTO) {
		VehiculoDTO vehiculoAlmacenado =  servicioParqueadero.crearVehiculo(vehiculoDTO);
		GestionParqueaderoDTO parqueaderoAlmacenado = servicioParqueadero.guardarIngresoVehiculoAlParqueadero(vehiculoAlmacenado);
		
		return parqueaderoAlmacenado;
	}
	
	@GetMapping(value = "/vehiculosParqueados")
	public List<GestionParqueaderoDTO>  obtenerVehiculosParqueados(){
		List<GestionParqueaderoDTO> vehiculosParqueados = servicioParqueadero.listaVehiculosParqueados();
		return vehiculosParqueados;
	}
	

}
