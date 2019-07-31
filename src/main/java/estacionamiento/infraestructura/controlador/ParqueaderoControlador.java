package estacionamiento.infraestructura.controlador;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/parqueadero")
public class ParqueaderoControlador {
	
	ManejadorServicioParqueadero servicioParqueadero;
	
	public ParqueaderoControlador(ManejadorServicioParqueadero servicioParqueadero) {
		this.servicioParqueadero = servicioParqueadero;
	}

	@PostMapping
	public ResponseEntity<Tiquete> registrarIngresoDelVehiculoAlParqueadero(@RequestBody Vehiculo vehiculoDTO) {
		return new ResponseEntity<> (servicioParqueadero.ingresarVehiculoAlPaqueadero(vehiculoDTO), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Tiquete>>  obtenerVehiculosParqueados(){
		return new ResponseEntity<>(servicioParqueadero.listaVehiculosParqueados(), HttpStatus.OK);
	}
	
		
	@PutMapping(value = "/registrarSalida/{placa}")
	public ResponseEntity<Tiquete>  registrarSalidaVehiculo(@PathVariable String placa) {
		Tiquete tiquete = servicioParqueadero.registraSalidaVehiculo(placa);
		return new ResponseEntity<>(tiquete , HttpStatus.OK);
	}
	

}
