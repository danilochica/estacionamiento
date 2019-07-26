package estacionamiento.unitaria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;

import estacionamiento.dominio.modelo.GestionParqueaderoDTO;
import estacionamiento.dominio.modelo.VehiculoDTO;
import estacionamiento.dominio.repositorio.IGestionParqueaderoRepositorio;
import estacionamiento.dominio.repositorio.IVehiculoRepositorio;
import estacionamiento.dominio.servicio.ParqueaderoServicio;
import estacionamiento.testdatabuider.GestionParqueaderoTestDataBuilder;
import estacionamiento.testdatabuider.VehiculoTestDataBuilder;

public class TestUnitario {
	
	private static final String PLACA_CON_LETRA_A = "AEQ99D";
	private static final String TIPO_VEHICULO_MOTO = "Moto";
	private static final String TIPO_VEHICULO_CARRO = "Carro";
	private static final int CILINDRAJE = 150;
	
	private static final BigDecimal VALOR_SERVICIO = new BigDecimal(1000);
	private static final boolean ESTADO_REGISTRO_PARQUEADERO = true;
	private static final Date FECHA_PARA_PRUEBA_CREAR_OBJETO = new Date();

	
	boolean resultado;

	
	@Test
	public void crearVehiculoTest() {
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conPlaca(PLACA_CON_LETRA_A).conTipoVehiculo(TIPO_VEHICULO_MOTO).conCilindraje(CILINDRAJE);
		
		VehiculoDTO vehiculo = vehiculoTestDataBuilder.build();
		
		assertEquals(PLACA_CON_LETRA_A, vehiculo.getPlaca());
		assertEquals(TIPO_VEHICULO_MOTO, vehiculo.getTipoVehiculo());
		assertEquals(CILINDRAJE, vehiculo.getCilindraje(),0);
		
	}
	
	@Test
	public void testVehiculoPlacaConLetraInicialIgualA() {

		String placaRegistrada = "ASQ523";
		VehiculoTestDataBuilder vehiculoBuilder = new VehiculoTestDataBuilder().conPlaca(placaRegistrada);
		VehiculoDTO vehiculoTest = vehiculoBuilder.build();
		ParqueaderoServicio servicio = new ParqueaderoServicio();
		
		resultado = servicio.esLetraInicialDeRestriccion(vehiculoTest.getPlaca());
		
		assertTrue(resultado);
		
	}
	
	@Test
	public void testVehiculoPlacaConLetraInicialDiferente() {
		String placaRegistrada = "KSQ523";
		VehiculoTestDataBuilder vehiculoBuilder = new VehiculoTestDataBuilder().conPlaca(placaRegistrada);
		VehiculoDTO vehiculoTest = vehiculoBuilder.build();
		ParqueaderoServicio servicio = new ParqueaderoServicio();
		
		resultado = servicio.esLetraInicialDeRestriccion(vehiculoTest.getPlaca());
		
		assertFalse(resultado);
	}

	
	@Test
	public void testHayDisponibilidadParqueoParaCarro() {

		IGestionParqueaderoRepositorio gestionParqueaderoRepositorio = mock(IGestionParqueaderoRepositorio.class);
		IVehiculoRepositorio vehiculoRepositorio = mock(IVehiculoRepositorio.class);
		ParqueaderoServicio servicio = new ParqueaderoServicio(gestionParqueaderoRepositorio, vehiculoRepositorio);
		VehiculoTestDataBuilder vehiculoBuilder = new VehiculoTestDataBuilder().conTipoVehiculo(TIPO_VEHICULO_CARRO).conPlaca("DMS125");
		VehiculoDTO vehiculoTest = vehiculoBuilder.build();
		when(servicio.cantidadCeldasOcupadasPorTipoVehiculo(TIPO_VEHICULO_CARRO)).thenReturn(15);

		resultado = servicio.hayDisponibilidadParqueo(vehiculoTest);

		assertTrue(resultado);
	}
	
	@Test
	public void testNoHayDisponibilidadParqueoParaCarro() {
		
		IGestionParqueaderoRepositorio gestionParqueaderoRepositorio = mock(IGestionParqueaderoRepositorio.class);
		IVehiculoRepositorio vehiculoRepositorio = mock(IVehiculoRepositorio.class);
		ParqueaderoServicio servicio = new ParqueaderoServicio(gestionParqueaderoRepositorio, vehiculoRepositorio);
		VehiculoTestDataBuilder vehiculoBuilder = new VehiculoTestDataBuilder().conTipoVehiculo(TIPO_VEHICULO_CARRO).conPlaca("DMS125");
		VehiculoDTO vehiculoTest = vehiculoBuilder.build();
		when(servicio.cantidadCeldasOcupadasPorTipoVehiculo(TIPO_VEHICULO_CARRO)).thenReturn(22);

		resultado = servicio.hayDisponibilidadParqueo(vehiculoTest);

		assertFalse(resultado);
	}
	
	@Test
	public void testNoHayDisponibilidadParqueoParaMoto() {
		
		IGestionParqueaderoRepositorio gestionParqueaderoRepositorio = mock(IGestionParqueaderoRepositorio.class);
		IVehiculoRepositorio vehiculoRepositorio = mock(IVehiculoRepositorio.class);
		ParqueaderoServicio servicio = new ParqueaderoServicio(gestionParqueaderoRepositorio, vehiculoRepositorio);
		VehiculoTestDataBuilder vehiculoBuilder = new VehiculoTestDataBuilder().conTipoVehiculo(TIPO_VEHICULO_MOTO).conPlaca("ASD12D");
		VehiculoDTO vehiculoTest = vehiculoBuilder.build();
		when(servicio.cantidadCeldasOcupadasPorTipoVehiculo(TIPO_VEHICULO_MOTO)).thenReturn(22);

		resultado = servicio.hayDisponibilidadParqueo(vehiculoTest);

		assertFalse(resultado);
	}
	
	
	@Test()
	public void testCuandoElRegistroDelVehiculoEsExitoso() {
		
		IGestionParqueaderoRepositorio gestionParqueaderoRepositorio = mock(IGestionParqueaderoRepositorio.class);
		IVehiculoRepositorio vehiculoRepositorio = mock(IVehiculoRepositorio.class);
		
		ParqueaderoServicio servicio = new ParqueaderoServicio(gestionParqueaderoRepositorio, vehiculoRepositorio);
		
		VehiculoTestDataBuilder vehiculoBuilder = new VehiculoTestDataBuilder().conTipoVehiculo(TIPO_VEHICULO_MOTO).conPlaca("KEQ99D");
		VehiculoDTO vehiculoTest = vehiculoBuilder.build();
		
		servicio.registrarVehiculo(vehiculoTest);
		
	}
	
	@Test
	public void testCrearRegistroGestionParqueadero() {
		
		//Arrange
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conPlaca(PLACA_CON_LETRA_A).conTipoVehiculo(TIPO_VEHICULO_MOTO).conCilindraje(CILINDRAJE);
		VehiculoDTO vehiculo = vehiculoTestDataBuilder.build();
		
		GestionParqueaderoTestDataBuilder parqueaderoTestDataBuilder = new GestionParqueaderoTestDataBuilder().conFechaDeIngreso(FECHA_PARA_PRUEBA_CREAR_OBJETO).conFechaDeSalida(FECHA_PARA_PRUEBA_CREAR_OBJETO).conEstadoRegistro(ESTADO_REGISTRO_PARQUEADERO).conValorDeServicio(VALOR_SERVICIO).conVehiculo(vehiculo);
		//Act
		GestionParqueaderoDTO parqueadero = parqueaderoTestDataBuilder.build();
		
		//Assert
		assertEquals(FECHA_PARA_PRUEBA_CREAR_OBJETO, parqueadero.getFechaIngreso());
		assertEquals(FECHA_PARA_PRUEBA_CREAR_OBJETO, parqueadero.getFechaSalida());
		assertEquals(ESTADO_REGISTRO_PARQUEADERO, parqueadero.getEstadoRegistro());
		assertEquals(VALOR_SERVICIO, parqueadero.getValorServicio());
		
		assertEquals(CILINDRAJE, vehiculo.getCilindraje(),0);
		
	}
}
