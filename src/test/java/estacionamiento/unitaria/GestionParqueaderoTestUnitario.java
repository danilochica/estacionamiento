package estacionamiento.unitaria;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;

import estacionamiento.dominio.modelo.GestionParqueaderoDTO;
import estacionamiento.dominio.modelo.VehiculoDTO;
import estacionamiento.testdatabuider.GestionParqueaderoTestDataBuilder;
import estacionamiento.testdatabuider.VehiculoTestDataBuilder;

public class GestionParqueaderoTestUnitario {
	
	private static final BigDecimal VALOR_SERVICIO = new BigDecimal(1000);
	private static final boolean ESTADO_REGISTRO_PARQUEADERO = true;
	private static final Date FECHA_PARA_PRUEBA_CREAR_OBJETO = new Date();
	private static final String PLACA_CON_LETRA_A = "AEQ99D";
	private static final String TIPO_VEHICULO_MOTO = "moto";
	private static final int CILINDRAJE = 150;
	
	boolean resultado;
	
	
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
