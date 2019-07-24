package dominio.repositorio;

import java.util.List;

import dominio.modelo.GestionParqueaderoDTO;
import dominio.modelo.VehiculoDTO;

public interface IVigilanteRepositorio {
	
	VehiculoDTO registrarVehiculoEnElSistema(VehiculoDTO vehicnuloDTO);
	
	List<GestionParqueaderoDTO> consultarEstadoVehiculosParqueados();
	


}
