/**
 * Excepción personalizada que se lanza cuando se intenta agregar un libro que ya existe.
 * Extiende la clase RuntimeException para indicar que es una excepción no verificada.
 *
 * @author Jorge Ruiz Martinez
 * @version 1.0
 */
package servicerest.controlador;

/**
 * Excepción lanzada cuando se intenta agregar un libro que ya existe en el sistema.
 */
public class LibroExistenteException extends RuntimeException {

    /**
     * Constructor que acepta un mensaje para describir la excepción.
     *
     * @param mensaje Mensaje descriptivo de la excepción.
     */
    public LibroExistenteException(String mensaje) {
        super(mensaje);
    }
}
