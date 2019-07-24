package infraestructura.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import aplicacion.comando.comando.manejador.ManejadorCrearVehiculo;
import dominio.modelo.VehiculoDTO;
import infraestructura.persistencia.entidad.GestionParqueaderoEntidad;
import infraestructura.persistencia.repositorio.IGestionParqueaderoJPA;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/ingresarVehiculo")
public class IngresarVehiculoControlador {
	
	@Autowired
	IGestionParqueaderoJPA gestionParqueaderoRepositorio;
	
	ManejadorCrearVehiculo crearVehiculo;
	/*
	@Produces (MediaType.APPLICATION_JSON)
	@GetMapping(value = "/vehiculosParqueados")
	public ResponseEntity<Object> vehiculosParqueados(){
		List<GestionParqueaderoEntidad> vehiculosParqueados = gestionParqueaderoRepositorio.obtenerVehiculosParqueados();
		return new ResponseEntity<>(vehiculosParqueados, HttpStatus.OK);
	}
	
	@PostMapping
	public void crear(@RequestBody VehiculoDTO vehiculo) {
		this.crearVehiculo.ejecutar(vehiculo);
	}*/

}
