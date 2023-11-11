package servicerest.controlador;

public class LibroExistenteException extends RuntimeException {
    public LibroExistenteException(String mensaje) {
        super(mensaje);
    }
}
