package infraestructura.persistencia.repositorio;

import dominio.modelo.VehiculoDTO;
import dominio.repositorio.IVehiculoRepositorio;

public class VehiculoRepositorioImp implements IVehiculoRepositorio {

	IVehiculoJPA repositorioJPA;

	public VehiculoRepositorioImp(IVehiculoJPA repositorioJPA) {
		this.repositorioJPA = repositorioJPA;
	}

	@Override
	public void registrarVehiculoEnElSistema(VehiculoDTO vehicnuloDTO) {
		//repositorioJPA.save(vehicnuloDTO);
	}



}
