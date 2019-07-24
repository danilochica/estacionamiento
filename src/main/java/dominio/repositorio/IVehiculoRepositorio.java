package dominio.repositorio;

import java.util.List;

import dominio.modelo.GestionParqueaderoDTO;
import dominio.modelo.VehiculoDTO;

public interface IVehiculoRepositorio {
	
	VehiculoDTO registrarVehiculoEnElSistema(VehiculoDTO vehicnuloDTO);
	
	List<GestionParqueaderoDTO> consultarEstadoVehiculosParqueados();
	


}
