package estacionamiento.dominio.servicio;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import estacionamiento.dominio.excepcion.ExcepcionPlacaIniciaConA;
import estacionamiento.dominio.excepcion.ExcepecionNoHayCeldasDisponibles;
import estacionamiento.dominio.modelo.Tiquete;
import estacionamiento.dominio.modelo.Vehiculo;
import estacionamiento.dominio.modelo.VehiculoEnum;
import estacionamiento.dominio.repositorio.TiqueteRepositorio;
import estacionamiento.dominio.repositorio.VehiculoRepositorio;

public class ParqueaderoServicio {
	
	private static final int RECARGO_POR_CILINDRAJE = 2000;
	private static final int CILINDRAJE_MAYOR_A_500 = 500;
	private static final int TOPE_PARA_COBRAR_HORAS = 9;
	private static final int SEGUNDOS_HORA = 3600;
	private static final int SEGUNDOS_DIA = 86400;
	private static final int VALOR_PARA_DIAS_DOMINGO_Y_LUNES = 2;
	public static final int CILINDRAJE_PARA_CALCULAR_RECARGO = 500;
	public static final String LETRA_INICIAL_PLACA= "A";

	public static final String PLACA_INICIA_CON_A = "No puede ingresar porque no esta en un dia habil";
	public static final String NO_HAY_CELDAS_DISPONIBLES ="No hay celdas disponibles";
	public static final String VEHICULO_NO_REGISTRADO ="No hay celdas disponibles";
	public static final String PLACA_REPETIDA ="El vehiculo ya esta registrado";
	
	
	TiqueteRepositorio tiqueteRepositorio;
	VehiculoRepositorio vehiculoRepositorio;
	CalendarioServicio calendarioServicio;

	public ParqueaderoServicio(TiqueteRepositorio tiqueteRepositorio, VehiculoRepositorio vehiculoRepositorio, CalendarioServicio calendarioServicio) {
		this.tiqueteRepositorio = tiqueteRepositorio;
		this.vehiculoRepositorio = vehiculoRepositorio;
		this.calendarioServicio = calendarioServicio;
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
		
		
		int diaDeLaSemana = calendarioServicio.diaDeLaSemana();
		
		if(esLetraInicialDeRestriccion(vehiculo.getPlaca()) &&  diaDeLaSemana > VALOR_PARA_DIAS_DOMINGO_Y_LUNES){
			throw new ExcepcionPlacaIniciaConA(PLACA_INICIA_CON_A);
		}
		
		if(!hayDisponibilidadParqueo(vehiculo)) {
			throw new ExcepecionNoHayCeldasDisponibles(NO_HAY_CELDAS_DISPONIBLES);
		}
		
		Vehiculo vehiculoGuardado = vehiculoRepositorio.registrarVehiculoEnElSistema(vehiculo);
			
		return generarTiqueteDeIngreso(vehiculoGuardado);
		
	}

	public Tiquete generarTiqueteDeIngreso(Vehiculo vehiculoDTO) {
		Tiquete gestionParqueaderoDTO = new Tiquete(calendarioServicio.obtenerfechaAtual(), true, vehiculoDTO);
				
		return tiqueteRepositorio.registarIngresoVehiculoAlParqueadero(gestionParqueaderoDTO);
		
	}
	
	public List<Tiquete> listarVehiculosParqueados(){
		
		 return tiqueteRepositorio.listaVehiculosParqueados();
	}
	
	
	public Tiquete consultarVehiculoPorPlacaParqueado(String placa) {
		return tiqueteRepositorio.consultarVehiculoParqueadoPorPlaca(placa);
		
	}
	
	
	public BigDecimal calcularValorServicio(String tipoVehiculo, int cilindraje, int dias, int  horas) {
		
		BigDecimal valorServicioPorHora;
		BigDecimal valorServicioPorDia = new BigDecimal(0);
		BigDecimal valorTotalServicio;
		
		if(tipoVehiculo.equals(VehiculoEnum.MOTO.getTipoVehiculo())) {
			
			if(horas < TOPE_PARA_COBRAR_HORAS) {
				valorServicioPorHora = new BigDecimal(horas).multiply(new BigDecimal(VehiculoEnum.MOTO.getValorHora()));
			}else {
				valorServicioPorHora = new BigDecimal(VehiculoEnum.MOTO.getValorDia());
			}
			if(dias > 0) {
				valorServicioPorDia = new BigDecimal(dias).multiply(new BigDecimal(VehiculoEnum.MOTO.getValorDia()));
			}
			
			if(cilindraje > CILINDRAJE_MAYOR_A_500) {
				valorTotalServicio = valorServicioPorDia.add(valorServicioPorHora.add(new BigDecimal(RECARGO_POR_CILINDRAJE)));
			}else {
				valorTotalServicio = valorServicioPorDia.add(valorServicioPorHora);
			}
		} else {
			
			if(horas < TOPE_PARA_COBRAR_HORAS) {
				valorServicioPorHora = new BigDecimal(horas).multiply(new BigDecimal(VehiculoEnum.CARRO.getValorHora()));
			}else {
				valorServicioPorHora = new BigDecimal(VehiculoEnum.CARRO.getValorDia());
			}
			if(dias > 0) {
				valorServicioPorDia = new BigDecimal(dias).multiply(new BigDecimal(VehiculoEnum.CARRO.getValorDia()));
			}

			valorTotalServicio = valorServicioPorDia.add(valorServicioPorHora);
			
		}
		return valorTotalServicio;
	}
	
	public Tiquete consultarVehiculoPorPlaca(String placa) {
		return consultarVehiculoPorPlacaParqueado(placa);
				
	}
	
	public Tiquete registrarSalidaVehiculo(String placa) {
		
		int dias = 0;
		int horas = 0;
		
		Tiquete registroVehiculoParqueadoPorPlaca = consultarVehiculoPorPlaca(placa);
		
		Date registroSalidaVehiculo = calendarioServicio.obtenerfechaAtual();
		registroVehiculoParqueadoPorPlaca.setFechaSalida(registroSalidaVehiculo);

		int diferencia = diferenciaEntreFechas(registroVehiculoParqueadoPorPlaca.getFechaSalida(), registroVehiculoParqueadoPorPlaca.getFechaIngreso());
        
        if(diferencia>SEGUNDOS_DIA) {
        	dias = calcularDiferenciaEnDia(diferencia);
        	diferencia = diferencia-(dias*SEGUNDOS_DIA);
        }
        
        if(diferencia>SEGUNDOS_HORA) {
        	horas = calcularDiferenciaEnHoras(diferencia);
            
        }
        
        BigDecimal valorServicio = calcularValorServicio(registroVehiculoParqueadoPorPlaca.getVehiculo().getTipoVehiculo(), registroVehiculoParqueadoPorPlaca.getVehiculo().getCilindraje(), dias, horas);
        Tiquete vehiculoListoParaSalir = new Tiquete(registroVehiculoParqueadoPorPlaca.getIdTiquete(), registroVehiculoParqueadoPorPlaca.getFechaIngreso(), registroVehiculoParqueadoPorPlaca.getFechaSalida(), valorServicio, false, registroVehiculoParqueadoPorPlaca.getVehiculo());

        return tiqueteRepositorio.regitrarSalidaVehiculoDelParqueadero(vehiculoListoParaSalir);

	}
	
	public int diferenciaEntreFechas(Date registroSalidaVehiculo, Date registroIngresoVehiculo) {
		return (int) ((registroSalidaVehiculo.getTime()- registroIngresoVehiculo.getTime())/1000);
	}
	
	public int calcularDiferenciaEnDia(int diferencia) {
		 return (diferencia/SEGUNDOS_DIA);
        
	}
	
	public int calcularDiferenciaEnHoras(int diferencia) {  
        return (diferencia/SEGUNDOS_HORA);
	}
}
