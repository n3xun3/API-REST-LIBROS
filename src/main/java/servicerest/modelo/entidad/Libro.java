/**
 * Clase que representa la entidad Libro.
 * Contiene atributos que describen las propiedades de un libro, así como métodos para acceder y modificar estos atributos.
 *
 * @author Jorge Ruiz Martinez
 * @version 1.0
 */
package servicerest.modelo.entidad;

/**
 * Clase que representa la entidad Libro.
 */
public class Libro {

    /** Identificador único del libro. */
    private int id;

    /** Título del libro. */
    private String titulo;

    /** Editorial del libro. */
    private String editorial;

    /** Nota asignada al libro. */
    private int nota;

    /**
     * Constructor que inicializa un libro con los valores proporcionados.
     *
     * @param id        Identificador único del libro.
     * @param titulo    Título del libro.
     * @param editorial Editorial del libro.
     * @param nota      Nota asignada al libro.
     */
    public Libro(int id, String titulo, String editorial, int nota) {
        this.id = id;
        this.titulo = titulo;
        this.editorial = editorial;
        this.nota = nota;
    }

    /**
     * Obtiene el identificador único del libro.
     *
     * @return El identificador único del libro.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador único del libro.
     *
     * @param id El nuevo identificador único del libro.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el título del libro.
     *
     * @return El título del libro.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título del libro.
     *
     * @param titulo El nuevo título del libro.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene la editorial del libro.
     *
     * @return La editorial del libro.
     */
    public String getEditorial() {
        return editorial;
    }

    /**
     * Establece la editorial del libro.
     *
     * @param editorial La nueva editorial del libro.
     */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    /**
     * Obtiene la nota asignada al libro.
     *
     * @return La nota asignada al libro.
     */
    public int getNota() {
        return nota;
    }

    /**
     * Establece la nota asignada al libro.
     *
     * @param nota La nueva nota asignada al libro.
     */
    public void setNota(int nota) {
        this.nota = nota;
    }

    /**
     * Sobrescribe el método toString para proporcionar una representación en cadena del objeto Libro.
     *
     * @return Una cadena que representa el objeto Libro.
     */
    @Override
    public String toString() {
        return "Libro [id=" + id + ", titulo=" + titulo + ", editorial=" + editorial + ", nota=" + nota + "]";
    }
}
