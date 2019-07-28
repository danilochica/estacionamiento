package estacionamiento.dominio.servicio;

import java.util.List;

import estacionamiento.dominio.excepcion.ExcepcionPlacaIniciaConA;
import estacionamiento.dominio.excepcion.ExcepecionNoHayCeldasDisponibles;
import estacionamiento.dominio.modelo.Tiquete;
import estacionamiento.dominio.modelo.Vehiculo;
import estacionamiento.dominio.modelo.VehiculoEnum;
import estacionamiento.dominio.repositorio.TiqueteRepositorio;
import estacionamiento.dominio.repositorio.VehiculoRepositorio;

public class ParqueaderoServicio {
	
	private static final int VALOR_PARA_DIAS_DOMINGO_Y_LUNES = 2;
	public static final int CILINDRAJE_PARA_CALCULAR_RECARGO = 500;
	public static final String LETRA_INICIAL_PLACA= "A";

	public static final String PLACA_INICIA_CON_A = "No puede ingresar porque no esta en un dia habil";
	public static final String NO_HAY_CELDAS_DISPONIBLES ="No hay celdas disponibles";
	
	
	TiqueteRepositorio tiqueteRepositorio;
	VehiculoRepositorio vehiculoRepositorio;

	public ParqueaderoServicio(TiqueteRepositorio tiqueteRepositorio, VehiculoRepositorio vehiculoRepositorio) {
		this.tiqueteRepositorio = tiqueteRepositorio;
		this.vehiculoRepositorio = vehiculoRepositorio;

	}

	public boolean hayDisponibilidadParqueo(Vehiculo vehiculo) {
		boolean hayCeldas;
		int cantidadVehiculosParqueados = cantidadCeldasOcupadasPorTipoVehiculo(vehiculo.getTipoVehiculo());
		hayCeldas = vehiculo.getTipoVehiculo().equals(VehiculoEnum.CARRO.getTipoVehiculo())  ? 
				cantidadVehiculosParqueados< VehiculoEnum.CARRO.getCapacidadMaximaVehiculosParqueados()  : 
					cantidadVehiculosParqueados<VehiculoEnum.MOTO.getCapacidadMaximaVehiculosParqueados();
		return hayCeldas;
	}
	
	public int cantidadCeldasOcupadasPorTipoVehiculo(String tipoVehiculo) {
		return tipoVehiculo.equals(VehiculoEnum.MOTO.getTipoVehiculo()) ? tiqueteRepositorio.contarMotosParqueadas() : tiqueteRepositorio.contarCarrosParqueados();
	}
	
	public boolean esLetraInicialDeRestriccion(String placa) {
		char letraInicial = Character.toUpperCase(placa.charAt(0));
		return String.valueOf(letraInicial).equals(LETRA_INICIAL_PLACA);
	}
	

	public Tiquete registrarIngresoVehiculoAlParqueadero(Vehiculo vehiculo) {
		
		
		CalendarioServicio calendarioServicio = new CalendarioServicio();
		int diaDeLaSemana = calendarioServicio.diaDeLaSemana();
		if(esLetraInicialDeRestriccion(vehiculo.getPlaca()) &&  diaDeLaSemana < VALOR_PARA_DIAS_DOMINGO_Y_LUNES){
			throw new ExcepcionPlacaIniciaConA(PLACA_INICIA_CON_A);
		}
		
		if(!hayDisponibilidadParqueo(vehiculo)) {
			throw new ExcepecionNoHayCeldasDisponibles(NO_HAY_CELDAS_DISPONIBLES);
		}
		
		Vehiculo vehiculoGuardado = vehiculoRepositorio.registrarVehiculoEnElSistema(vehiculo);
		Tiquete tiqueteGenerado = generarTiqueteDeIngreso(vehiculoGuardado);
		
		
		return tiqueteGenerado;
		
	}

	public Tiquete generarTiqueteDeIngreso(Vehiculo vehiculoDTO) {
		CalendarioServicio calendarioServicio = new CalendarioServicio();
		Tiquete gestionParqueaderoDTO = new Tiquete(calendarioServicio.obtenerfechaAtual(), true, vehiculoDTO);
		Tiquete registroAlmacenado = tiqueteRepositorio.registarIngresoVehiculoAlParqueadero(gestionParqueaderoDTO);
		
		return registroAlmacenado;
		
	}
	
	public List<Tiquete> listarVehiculosParqueados(){
		 List<Tiquete> vehiculosParqueados = tiqueteRepositorio.listaVehiculosParqueados();
		 return vehiculosParqueados;
	}
	
	
	public Tiquete consultarVehiculoPorPlacaParqueado(String placa) {
		Tiquete consultaVehiculo = tiqueteRepositorio.consultarVehiculoParqueadoPorPlaca(placa);
		return consultaVehiculo;
		
	}
	
}
