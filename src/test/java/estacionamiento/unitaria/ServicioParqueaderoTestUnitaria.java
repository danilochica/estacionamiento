package estacionamiento.unitaria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;
import org.mockito.Mock;

import estacionamiento.dominio.modelo.Tiquete;
import estacionamiento.dominio.modelo.Vehiculo;
import estacionamiento.dominio.modelo.VehiculoEnum;
import estacionamiento.dominio.repositorio.TiqueteRepositorio;
import estacionamiento.dominio.repositorio.VehiculoRepositorio;
import estacionamiento.dominio.servicio.CalendarioServicio;
import estacionamiento.dominio.servicio.ParqueaderoServicio;
import estacionamiento.testdatabuider.TiqueteTestDataBuilder;
import estacionamiento.testdatabuider.VehiculoTestDataBuilder;

public class ServicioParqueaderoTestUnitaria {
	
	private static final String PLACA_CON_LETRA_A = "AEQ99D";
	private static final String TIPO_VEHICULO_MOTO = "Moto";
	private static final String TIPO_VEHICULO_CARRO = "Carro";
	private static final int CILINDRAJE = 150;
	
	boolean resultado;
	@Mock
	TiqueteRepositorio tiqueteRepositorio = mock(TiqueteRepositorio.class);
	
	@Mock
	VehiculoRepositorio vehiculoRepositorio = mock(VehiculoRepositorio.class);
	
	@Mock
	CalendarioServicio calendarioServicio = mock(CalendarioServicio.class);
	
	
	@Test
	public void crearVehiculoTest() {
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conPlaca(PLACA_CON_LETRA_A).conTipoVehiculo(TIPO_VEHICULO_MOTO).conCilindraje(CILINDRAJE);
		
		Vehiculo vehiculo = vehiculoTestDataBuilder.build();
		
		assertEquals(PLACA_CON_LETRA_A, vehiculo.getPlaca());
		assertEquals(TIPO_VEHICULO_MOTO, vehiculo.getTipoVehiculo());
		assertEquals(CILINDRAJE, vehiculo.getCilindraje(),0);
		
	}
	
	@Test
	public void crearTiqueteTest() {
		
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conPlaca(PLACA_CON_LETRA_A).conTipoVehiculo(TIPO_VEHICULO_MOTO).conCilindraje(CILINDRAJE);
		Vehiculo vehiculo = vehiculoTestDataBuilder.build();	
		
		TiqueteTestDataBuilder tiqueteTestDataBuilder = new TiqueteTestDataBuilder().conEstadoRegistro(true).conVehiculo(vehiculo).conFechaDeIngreso(new Date(2019-07-23));
		Tiquete tiquete = tiqueteTestDataBuilder.build();
		
		assertEquals(PLACA_CON_LETRA_A, tiquete.getVehiculo().getPlaca());
		assertEquals(TIPO_VEHICULO_MOTO, tiquete.getVehiculo().getTipoVehiculo());
		assertEquals(CILINDRAJE,tiquete.getVehiculo().getCilindraje(),0);
		assertEquals(true,tiquete.getEstadoRegistro());
		assertEquals(new Date(2019-07-23),tiquete.getFechaIngreso());
		
	}
	
	
	@Test
	public void testVehiculoPlacaConLetraInicialIgualA() {

		String placaRegistrada = "ASQ523";
		ParqueaderoServicio servicio = new ParqueaderoServicio(tiqueteRepositorio, vehiculoRepositorio,calendarioServicio);
		
		VehiculoTestDataBuilder vehiculoBuilder = new VehiculoTestDataBuilder().conPlaca(placaRegistrada);
		Vehiculo vehiculoTest = vehiculoBuilder.build();
		
		resultado = servicio.esLetraInicialDeRestriccion(vehiculoTest.getPlaca());
		
		assertTrue(resultado);
		
	}
	
	@Test
	public void testVehiculoPlacaConLetraInicialDiferente() {
		
		String placaRegistrada = "KSQ523";
		ParqueaderoServicio servicio = new ParqueaderoServicio(tiqueteRepositorio, vehiculoRepositorio,calendarioServicio);
		VehiculoTestDataBuilder vehiculoBuilder = new VehiculoTestDataBuilder().conPlaca(placaRegistrada);
		Vehiculo vehiculoTest = vehiculoBuilder.build();
		
		
		resultado = servicio.esLetraInicialDeRestriccion(vehiculoTest.getPlaca());
		
		assertFalse(resultado);
	}

	
	@Test
	public void testHayDisponibilidadParqueoParaCarro() {

		
		ParqueaderoServicio servicio = new ParqueaderoServicio(tiqueteRepositorio, vehiculoRepositorio,calendarioServicio);
		VehiculoTestDataBuilder vehiculoBuilder = new VehiculoTestDataBuilder().conTipoVehiculo(TIPO_VEHICULO_CARRO).conPlaca("DMS125");
		Vehiculo vehiculoTest = vehiculoBuilder.build();
		when(servicio.cantidadCeldasOcupadasPorTipoVehiculo(TIPO_VEHICULO_CARRO)).thenReturn(15);

		resultado = servicio.hayDisponibilidadParqueo(vehiculoTest);

		assertTrue(resultado);
	}
	
	@Test
	public void testNoHayDisponibilidadParqueoParaCarro() {

		ParqueaderoServicio servicio = new ParqueaderoServicio(tiqueteRepositorio, vehiculoRepositorio,calendarioServicio);
		VehiculoTestDataBuilder vehiculoBuilder = new VehiculoTestDataBuilder().conTipoVehiculo(TIPO_VEHICULO_CARRO).conPlaca("DMS125");
		Vehiculo vehiculoTest = vehiculoBuilder.build();
		when(servicio.cantidadCeldasOcupadasPorTipoVehiculo(TIPO_VEHICULO_CARRO)).thenReturn(22);

		resultado = servicio.hayDisponibilidadParqueo(vehiculoTest);

		assertFalse(resultado);
	}
	
	@Test
	public void testNoHayDisponibilidadParqueoParaMoto() {
		
		ParqueaderoServicio servicio = new ParqueaderoServicio(tiqueteRepositorio, vehiculoRepositorio,calendarioServicio);
		VehiculoTestDataBuilder vehiculoBuilder = new VehiculoTestDataBuilder().conTipoVehiculo(TIPO_VEHICULO_MOTO).conPlaca("ASD12D");
		Vehiculo vehiculoTest = vehiculoBuilder.build();
		when(servicio.cantidadCeldasOcupadasPorTipoVehiculo(TIPO_VEHICULO_MOTO)).thenReturn(22);

		resultado = servicio.hayDisponibilidadParqueo(vehiculoTest);

		assertFalse(resultado);
	}
	
	@Test
	public void testHayDisponibilidadParqueoParaMoto() {
		
		ParqueaderoServicio servicio = new ParqueaderoServicio(tiqueteRepositorio, vehiculoRepositorio,calendarioServicio);
		VehiculoTestDataBuilder vehiculoBuilder = new VehiculoTestDataBuilder().conTipoVehiculo(TIPO_VEHICULO_MOTO).conPlaca("FSD12D");
		Vehiculo vehiculoTest = vehiculoBuilder.build();
		when(servicio.cantidadCeldasOcupadasPorTipoVehiculo(TIPO_VEHICULO_MOTO)).thenReturn(8);

		resultado = servicio.hayDisponibilidadParqueo(vehiculoTest);

		assertTrue(resultado);
	}
	
	
	@Test
	public void testNoPuedeIngresarPorDiaHabil() {
		
		int diaDeLaSemanaDomingo = 5;
		String placaVehiculo = "ASD12D";
		CalendarioServicio calendarioServicio2 = mock(CalendarioServicio.class);
		ParqueaderoServicio servicio = new ParqueaderoServicio(tiqueteRepositorio, vehiculoRepositorio, calendarioServicio2);
		VehiculoTestDataBuilder vehiculoBuilder = new VehiculoTestDataBuilder().conTipoVehiculo(TIPO_VEHICULO_MOTO).conPlaca(placaVehiculo);
		Vehiculo vehiculoTest = vehiculoBuilder.build();
		
		when(calendarioServicio2.diaDeLaSemana()).thenReturn(diaDeLaSemanaDomingo);
		
		try {
			servicio.registrarIngresoVehiculoAlParqueadero(vehiculoTest);
			fail();
		} catch (Exception e) {
			assertEquals(ParqueaderoServicio.PLACA_INICIA_CON_A , e.getMessage());
		}
		
	}
	
	@Test
	public void testNoPuedeIngresarMotoPorNoDisponibilidadDeCeldas() {
		
		int cantidadMotosParqueadas = 10;
		String placaVehiculo = "MSD12D";
		ParqueaderoServicio servicio = new ParqueaderoServicio(tiqueteRepositorio, vehiculoRepositorio,calendarioServicio);
		VehiculoTestDataBuilder vehiculoBuilder = new VehiculoTestDataBuilder().conTipoVehiculo(TIPO_VEHICULO_MOTO).conPlaca(placaVehiculo);
		Vehiculo vehiculoTest = vehiculoBuilder.build();
		
		when(servicio.cantidadCeldasOcupadasPorTipoVehiculo(TIPO_VEHICULO_MOTO)).thenReturn(cantidadMotosParqueadas);
		
		try {
			servicio.registrarIngresoVehiculoAlParqueadero(vehiculoTest);
			fail();
		} catch (Exception e) {
			assertEquals(ParqueaderoServicio.NO_HAY_CELDAS_DISPONIBLES , e.getMessage());
		}
		
	}
	
	@Test
	public void testNoPuedeIngresarCarroPorNoDisponibilidadDeCeldas() {
		
		int cantidadCarrosParqueados = 25;
		String placaVehiculo = "MSD12D";
		ParqueaderoServicio parqueaderoServicio = new ParqueaderoServicio(tiqueteRepositorio, vehiculoRepositorio,calendarioServicio);
		VehiculoTestDataBuilder vehiculoBuilder = new VehiculoTestDataBuilder().conTipoVehiculo(TIPO_VEHICULO_CARRO).conPlaca(placaVehiculo);
		Vehiculo vehiculoTest = vehiculoBuilder.build();
		
		when(parqueaderoServicio.cantidadCeldasOcupadasPorTipoVehiculo(TIPO_VEHICULO_CARRO)).thenReturn(cantidadCarrosParqueados);
		
		try {
			parqueaderoServicio.registrarIngresoVehiculoAlParqueadero(vehiculoTest);
			fail();
		} catch (Exception e) {
			assertEquals(ParqueaderoServicio.NO_HAY_CELDAS_DISPONIBLES , e.getMessage());
		}
		
	}
	
	@Test
	public void testValidarTarifaMotoSeisHoras() {
		
		int horas = 6;
		int dias = 0;
		int cilindraje = 0;
		BigDecimal valorTotal = new BigDecimal(3000);
		ParqueaderoServicio parqueaderoServicio = new ParqueaderoServicio(tiqueteRepositorio, vehiculoRepositorio,calendarioServicio);
		
		BigDecimal valorACancelar = parqueaderoServicio.calcularValorServicio(VehiculoEnum.MOTO.getTipoVehiculo(), cilindraje, dias, horas);
		
		assertEquals(valorTotal, valorACancelar);
		
	}
	
	@Test
	public void testValidarTarifaMotoConCilindrajeMayorAQuinientos() {
		
		int horas = 6;
		int dias = 0;
		int cilindraje = 600;
		BigDecimal valorTotal = new BigDecimal(5000);
		ParqueaderoServicio parqueaderoServicio = new ParqueaderoServicio(tiqueteRepositorio, vehiculoRepositorio,calendarioServicio);
		
		BigDecimal valorACancelar = parqueaderoServicio.calcularValorServicio(VehiculoEnum.MOTO.getTipoVehiculo(), cilindraje, dias, horas);
		
		assertEquals(valorTotal, valorACancelar);
		
	}
	
	@Test
	public void testValidarTarifaSuperiorANueveHoras() {
		
		int horas = 10;
		int dias = 0;
		int cilindraje = 0;
		BigDecimal valorTotal = new BigDecimal(4000);
		ParqueaderoServicio parqueaderoServicio = new ParqueaderoServicio(tiqueteRepositorio, vehiculoRepositorio,calendarioServicio);
		
		BigDecimal valorACancelar = parqueaderoServicio.calcularValorServicio(VehiculoEnum.MOTO.getTipoVehiculo(), cilindraje, dias, horas);
		
		assertEquals(valorTotal, valorACancelar);
		
	}
	
	@Test
	public void testValidarTarifaConHorasYDiaCarro() {
		int horas = 3;
		int dias = 1;
		int cilindraje = 0;
		BigDecimal valorTotal = new BigDecimal(11000);
		ParqueaderoServicio parqueaderoServicio = new ParqueaderoServicio(tiqueteRepositorio, vehiculoRepositorio,calendarioServicio);
		
		BigDecimal valorACancelar = parqueaderoServicio.calcularValorServicio(VehiculoEnum.CARRO.getTipoVehiculo(), cilindraje, dias, horas);
		
		assertEquals(valorTotal, valorACancelar);
	}
	
	@Test
	public void testValidarTarifaConHorasCarro() {
		int horas = 3;
		int dias = 0;
		int cilindraje = 0;
		BigDecimal valorTotal = new BigDecimal(3000);
		ParqueaderoServicio parqueaderoServicio = new ParqueaderoServicio(tiqueteRepositorio, vehiculoRepositorio,calendarioServicio);
		
		BigDecimal valorACancelar = parqueaderoServicio.calcularValorServicio(VehiculoEnum.CARRO.getTipoVehiculo(), cilindraje, dias, horas);
		
		assertEquals(valorTotal, valorACancelar);
	}
	
	@Test
	public void testCalcularDiferenciaFechas() {
		Date fechaActual = new Date();
		ParqueaderoServicio parqueaderoServicio = new ParqueaderoServicio(tiqueteRepositorio, vehiculoRepositorio,calendarioServicio);
		
		int diferenciaEntreFechas = parqueaderoServicio.diferenciaEntreFechas(fechaActual, fechaActual);
		
		assertEquals(0, diferenciaEntreFechas);
		
	}
	
	
	
}
