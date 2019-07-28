package estacionamiento.aplicacion.manejadores;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import estacionamiento.dominio.modelo.Tiquete;
import estacionamiento.dominio.modelo.Vehiculo;
import estacionamiento.dominio.servicio.ParqueaderoServicio;

@Service
@Transactional
public class ManejadorServicioParqueadero {
	
	ParqueaderoServicio parqueaderoServicio;
	
	public ManejadorServicioParqueadero(ParqueaderoServicio parqueaderoServicio) {
		this.parqueaderoServicio = parqueaderoServicio;
	}

	public Tiquete ingresarVehiculoAlPaqueadero(Vehiculo vehiculoDTO) {
		 return parqueaderoServicio.registrarIngresoVehiculoAlParqueadero(vehiculoDTO);
	}
	
	public List<Tiquete> listaVehiculosParqueados(){
		return this.parqueaderoServicio.listarVehiculosParqueados();
	}
	
	public Tiquete consultarVehiculoPorPlacaParqueado(String placa) {
		return this.parqueaderoServicio.consultarVehiculoPorPlacaParqueado(placa);
	}

}
