package servicerest.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import servicerest.modelo.entidad.Libro;
import servicerest.modelo.persistencia.DaoLibro;

import java.util.List;

@RestController
public class ControladorLibro {

    @Autowired
    private DaoLibro daoLibro;

    @PostMapping("/libros")
    public ResponseEntity<String> altaLibro(@RequestBody Libro libro) {
        try {
            daoLibro.add(libro);
            return new ResponseEntity<>("Libro añadido con éxito", HttpStatus.CREATED);
        } catch (LibroExistenteException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(path = "libros/{id}")
    public ResponseEntity<Libro> borrarLibro(@PathVariable("id") int id){
        System.out.println("Id eliminado " + id);
        Libro l = daoLibro.delete(id);
        if(l != null){
            return new ResponseEntity<>(l, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

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
            listaLibros = daoLibro.listByTitulo(titulo);
        }
        System.out.println(listaLibros);
        return new ResponseEntity<>(listaLibros, HttpStatus.OK);
    }
}
