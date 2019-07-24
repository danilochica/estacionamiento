package estacionamiento.dominio.excepcion;

public class ExcepecionNoHayCeldasDisponibles  extends RuntimeException {
	
    private static final long serialVersionUID = 1L;

    public ExcepecionNoHayCeldasDisponibles(String mensaje) {
        super(mensaje);
    }
	
}
