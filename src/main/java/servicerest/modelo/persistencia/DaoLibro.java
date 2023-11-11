package servicerest.modelo.persistencia;

import org.springframework.stereotype.Component;
import servicerest.controlador.LibroExistenteException;
import servicerest.modelo.entidad.Libro;

import java.util.ArrayList;
import java.util.List;
@Component
public class DaoLibro {

    public List<Libro> listaLibro;

    public DaoLibro(){
        System.out.println("DaoLibro -> Creando lista de libros!");
        listaLibro = new ArrayList<>();
        Libro l1 = new Libro(1,"Harry Potter y la piedra filosofa","J.K.Rowling",21);
        Libro l2 = new Libro(2,"Harry Potter y la cámara secreta","J.K.Rowling",18);
        Libro l3 = new Libro(3,"Harry Potter y el cáliz de fuego","J.K.Rowling",31);
        Libro l4 = new Libro(4,"Harry Potter y la Orden del Fénix","J.K.Rowling",25);
        Libro l5 = new Libro(5,"El Hobbit","J.R.R.Tolkien",20);
        listaLibro.add(l1);
        listaLibro.add(l2);
        listaLibro.add(l3);
        listaLibro.add(l4);
        listaLibro.add(l5);
    }

    public Libro get(int posicion){
        try{
            return listaLibro.get(posicion);
        }catch(IndexOutOfBoundsException iobe){
            System.out.println("Libro no encontrado");
            return null;
        }
    }

    public List<Libro> list() { return listaLibro; }

    public boolean existeLibroConTitulo(String titulo) {
        for (Libro l : listaLibro) {
            if (l.getTitulo().equalsIgnoreCase(titulo)) {
                return true; // Ya existe un libro con el mismo título
            }
        }
        return false; // No existe un libro con el mismo título
    }

    public boolean existeLibroConId(int id) {
        for (Libro l : listaLibro) {
            if (l.getId() == id) {
                return true; // Ya existe un libro con el mismo ID
            }
        }
        return false; // No existe un libro con el mismo ID
    }

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
