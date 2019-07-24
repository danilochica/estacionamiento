package dominio.servicio;

import java.util.Calendar;

public class CalendarioServicio {

	public boolean esDiaHabilParaPlacaConLetraInicialA() {
		Calendar fechaActual =  Calendar.getInstance();
		return(fechaActual.get(Calendar.DAY_OF_WEEK) <= 2);
	}
}
