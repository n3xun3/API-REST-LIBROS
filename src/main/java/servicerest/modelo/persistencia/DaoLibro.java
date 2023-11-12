/**
 * Esta clase representa un Data Access Object (DAO) para la entidad Libro.
 * Proporciona métodos para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en una lista de libros.
 *
 * @author Jorge Ruiz Martinez
 * @version 1.0
 */
package servicerest.modelo.persistencia;

import org.springframework.stereotype.Component;
import servicerest.controlador.LibroExistenteException;
import servicerest.modelo.entidad.Libro;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que implementa un DAO para la entidad Libro.
 */
@Component
public class DaoLibro {

    /** Lista que almacena los libros. */
    public List<Libro> listaLibro;

    /**
     * Constructor que inicializa la lista de libros y agrega algunos libros de ejemplo.
     */
    public DaoLibro(){
        System.out.println("DaoLibro -> Creando lista de libros!");
        listaLibro = new ArrayList<>();
        Libro l1 = new Libro(1,"Harry Potter y la piedra filosofa","Publicaciones y Ediciones Salamandra S.A.",10);
        Libro l2 = new Libro(2,"Harry Potter y la cámara secreta","Publicaciones y Ediciones Salamandra S.A.",10);
        Libro l3 = new Libro(3,"Harry Potter y el cáliz de fuego","Publicaciones y Ediciones Salamandra S.A.",9);
        Libro l4 = new Libro(4,"Harry Potter y la Orden del Fénix","Publicaciones y Ediciones Salamandra S.A.",9);
        Libro l5 = new Libro(5,"El Hobbit","Minotaurio",8);
        listaLibro.add(l1);
        listaLibro.add(l2);
        listaLibro.add(l3);
        listaLibro.add(l4);
        listaLibro.add(l5);
    }

    /**
     * Obtiene un libro en la posición especificada de la lista.
     *
     * @param posicion La posición del libro en la lista.
     * @return El libro en la posición especificada, o null si no se encuentra.
     */
    public Libro get(int posicion){
        try{
            return listaLibro.get(posicion);
        }catch(IndexOutOfBoundsException iobe){
            System.out.println("Libro no encontrado");
            return null;
        }
    }

    /**
     * Obtiene la lista completa de libros.
     *
     * @return La lista de libros.
     */
    public List<Libro> list() { return listaLibro; }

    /**
     * Verifica si existe un libro con el título especificado.
     *
     * @param titulo El título del libro a buscar.
     * @return true si existe un libro con el mismo título, false en caso contrario.
     */
    public boolean existeLibroConTitulo(String titulo) {
        for (Libro l : listaLibro) {
            if (l.getTitulo().equalsIgnoreCase(titulo)) {
                return true; // Ya existe un libro con el mismo título
            }
        }
        return false; // No existe un libro con el mismo título
    }

    /**
     * Verifica si existe un libro con el ID especificado.
     *
     * @param id El ID del libro a buscar.
     * @return true si existe un libro con el mismo ID, false en caso contrario.
     */
    public boolean existeLibroConId(int id) {
        for (Libro l : listaLibro) {
            if (l.getId() == id) {
                return true; // Ya existe un libro con el mismo ID
            }
        }
        return false; // No existe un libro con el mismo ID
    }

    /**
     * Agrega un nuevo libro a la lista si no existe otro libro con el mismo título o ID.
     * Lanza una excepción si ya existe un libro con el mismo título o ID.
     *
     * @param l El libro a agregar.
     * @throws LibroExistenteException Si ya existe un libro con el mismo título o ID.
     */
    public void add(Libro l) {
        if (!existeLibroConTitulo(l.getTitulo()) && !existeLibroConId(l.getId())) {
            l.setId(l.getId());
            listaLibro.add(l);
        } else {
            if (existeLibroConTitulo(l.getTitulo())) {
                throw new LibroExistenteException("Ya existe un libro con el mismo título. No se puede agregar.");
            } else {
                throw new LibroExistenteException("Ya existe un libro con el mismo id. No se puede agregar.");
            }
        }
    }

    /**
     * Elimina un libro con el ID especificado de la lista.
     *
     * @param id El ID del libro a eliminar.
     * @return El libro eliminado, o null si no se encuentra.
     */
    public Libro delete(int id) {
        for (Libro libro : listaLibro) {
            if (libro.getId() == id) {
                listaLibro.remove(libro);
                System.out.println("delete -> Libro eliminado");
                return libro;
            }
        }
        System.out.println("delete -> Libro no encontrado");
        return null;
    }

    /**
     * Actualiza la información de un libro existente.
     *
     * @param l El libro con la nueva información.
     * @return El libro actualizado, o null si el libro no existe.
     */
    public Libro update(Libro l) {
        try {
            Libro pAux = listaLibro.get(l.getId());
            pAux.setTitulo(l.getTitulo());
            pAux.setEditorial(l.getEditorial());
            pAux.setNota(l.getNota());

            return pAux;
        } catch (IndexOutOfBoundsException iobe) {
            System.out.println("update -> Libro actualizado");
            return null;
        }
    }

    /**
     * Obtiene una lista de libros que tienen el título especificado.
     *
     * @param titulo El título de los libros a buscar.
     * @return La lista de libros con el título especificado.
     */
    public List<Libro> listByTitulo(String titulo){
        List<Libro> listaPersonasAux = new ArrayList<>();
        for(Libro l : listaLibro) {
            if(l.getTitulo().equalsIgnoreCase(titulo)) {//contains()
                listaPersonasAux.add(l);
            }
        }
        return listaPersonasAux;
    }
}
