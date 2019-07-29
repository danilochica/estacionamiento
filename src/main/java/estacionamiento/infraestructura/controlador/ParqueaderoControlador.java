package estacionamiento.infraestructura.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import estacionamiento.aplicacion.manejadores.ManejadorServicioParqueadero;
import estacionamiento.dominio.modelo.Tiquete;
import estacionamiento.dominio.modelo.Vehiculo;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/parqueadero")
public class ParqueaderoControlador {
	
	ManejadorServicioParqueadero servicioParqueadero;
	
	public ParqueaderoControlador(ManejadorServicioParqueadero servicioParqueadero) {
		this.servicioParqueadero = servicioParqueadero;
	}

	@PostMapping
	public Tiquete registrarIngresoDelVehiculoAlParqueadero(@RequestBody Vehiculo vehiculoDTO) {
		Tiquete tiqueteVehiculoIngresado =  servicioParqueadero.ingresarVehiculoAlPaqueadero(vehiculoDTO);
		return tiqueteVehiculoIngresado;
	}
	
	@GetMapping(value = "/vehiculosParqueados")
	public List<Tiquete>  obtenerVehiculosParqueados(){
		List<Tiquete> vehiculosParqueados = servicioParqueadero.listaVehiculosParqueados();
		return vehiculosParqueados;
	}
	
	
	@PutMapping(value = "/registrarSalida/{placa}")
	public Tiquete registrarSalidaVehiculo(@PathVariable String placa) {
		
		Tiquete registroSalidaVehiculo = servicioParqueadero.registraSalidaVehiculo(placa);
		return registroSalidaVehiculo;
	}
	

}
