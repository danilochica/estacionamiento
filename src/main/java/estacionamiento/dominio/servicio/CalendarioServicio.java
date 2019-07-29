package estacionamiento.dominio.servicio;

import java.util.Calendar;
import java.util.Date;


public class CalendarioServicio {
	
	
	public int diaDeLaSemana() {
		Calendar fechaActual =  Calendar.getInstance();
		return(fechaActual.get(Calendar.DAY_OF_WEEK));
	}
	
	
	public Date obtenerfechaAtual() {		
		Date fechaActual=new Date();
	    Calendar calendario= Calendar.getInstance();
	    calendario.setTime(fechaActual);	    
	    return calendario.getTime();
	}
	


}
