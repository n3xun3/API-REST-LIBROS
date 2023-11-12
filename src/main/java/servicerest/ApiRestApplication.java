/**
 * Clase principal que inicia la aplicación Spring Boot para el servicio REST.
 * Utiliza la anotación @SpringBootApplication para la configuración automática de la aplicación.
 *
 * @author Jorge Ruiz Martinez
 * @version 1.0
 */
package servicerest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal que inicia la aplicación Spring Boot para el servicio REST.
 */
@SpringBootApplication
public class ApiRestApplication {

    /**
     * Método principal que inicia la aplicación Spring Boot y carga el contexto.
     *
     * @param args Argumentos de la línea de comandos (no se utilizan en este ejemplo).
     */
    public static void main(String[] args) {
        System.out.println("Servicio Rest -> Cargando el contexto de Spring...");
        SpringApplication.run(ApiRestApplication.class, args);
        System.out.println("Servicio Rest -> Contexto de Spring cargado!");
    }

}
