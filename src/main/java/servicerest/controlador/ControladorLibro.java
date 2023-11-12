/**
 * Clase que actúa como controlador para la gestión de libros en un servicio REST.
 * Proporciona endpoints para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en la entidad Libro.
 *
 * @author Jorge Ruiz Martinez
 * @version 1.0
 */

package servicerest.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import servicerest.modelo.entidad.Libro;
import servicerest.modelo.persistencia.DaoLibro;

import java.util.List;

/**
 * Controlador para la gestión de libros en un servicio REST.
 */
@RestController
public class ControladorLibro {

    /** DAO para la entidad Libro. */
    @Autowired
    private DaoLibro daoLibro;

    /**
     * Endpoint para agregar un nuevo libro.
     *
     * @param libro El libro a agregar, proporcionado en el cuerpo de la solicitud.
     * @return ResponseEntity con un mensaje de éxito o un mensaje de error si el libro ya existe.
     */
    @PostMapping("/libros")
    public ResponseEntity<String> altaLibro(@RequestBody Libro libro) {
        try {
            daoLibro.add(libro);
            return new ResponseEntity<>("Libro añadido con éxito", HttpStatus.CREATED);
        } catch (LibroExistenteException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Endpoint para eliminar un libro por su ID.
     *
     * @param id El ID del libro a eliminar, proporcionado como parte de la URL.
     * @return ResponseEntity con el libro eliminado o un código de estado NOT_FOUND si no se encuentra.
     */
    @DeleteMapping(path = "libros/{id}")
    public ResponseEntity<Void> borrarLibro(@PathVariable("id") int id) {
        try {
            System.out.println("Eliminando libro con ID: " + id);
            Libro libroEliminado = daoLibro.delete(id);

            if (libroEliminado != null) {
                System.out.println("Libro eliminado con éxito. ID: " + libroEliminado.getId());
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                System.out.println("No se encontró el libro con ID: " + id);
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            System.err.println("Error al eliminar el libro con ID: " + id);
            e.printStackTrace(); // Imprime la traza de la excepción en la consola
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Endpoint para modificar un libro existente por su ID.
     *
     * @param id El ID del libro a modificar, proporcionado como parte de la URL.
     * @param l  El nuevo libro con la información actualizada, proporcionado en el cuerpo de la solicitud.
     * @return ResponseEntity con un código de estado OK si la modificación es exitosa, o NOT_FOUND si no se encuentra el libro.
     */
    @PutMapping(path = "libros/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<Libro>modificarLibro(
            @PathVariable("id") int id,
            @RequestBody Libro l){
        System.out.println("Id a modificar: " + id);
        System.out.println("Datos a modificar: " + l);
        l.setId(id);
        Libro lUpdate = daoLibro.update(l);
        if(lUpdate != null){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Endpoint para obtener un libro por su ID.
     *
     * @param id El ID del libro a obtener, proporcionado como parte de la URL.
     * @return ResponseEntity con el libro encontrado o un código de estado NOT_FOUND si no se encuentra.
     */
    @GetMapping(path = "libros/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Libro> getLibro(@PathVariable("id") int id){
        System.out.println("Buscando persona con id: " + id);
        Libro l = daoLibro.get(id);
        if(l != null){
            return new ResponseEntity<>(l, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Endpoint para listar libros, con la opción de filtrar por título.
     *
     * @param titulo El título del libro para filtrar la lista (opcional).
     * @return ResponseEntity con la lista de libros, o un código de estado NOT_FOUND si no se encuentran libros.
     */
    @GetMapping(path="libros",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Libro>> listarLibros(
            @RequestParam(name="titulo",required=false) String titulo) {
        List<Libro> listaLibros;
        //Si no me viene el nombre, devolvemos toda la lista
        if(titulo == null) {
            System.out.println("Listando las personas");
            listaLibros = daoLibro.list();
        }else {
            System.out.println("Listando las personas por nombre: " + titulo);
            listaLibros = daoLibro.listByEditorial(titulo);
        }
        System.out.println(listaLibros);
        return new ResponseEntity<>(listaLibros, HttpStatus.OK);
    }
}
