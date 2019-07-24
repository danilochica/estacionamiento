package dominio.excepcion;

public class ExcepcionPlacaIniciaConA extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

    public ExcepcionPlacaIniciaConA(String mensaje) {
        super(mensaje);
    }

}
