# API REST de Gestión de Libros

Esta API REST proporciona funcionalidades para la gestión de libros, incluyendo operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre la entidad Libro. La API está implementada en Java utilizando Spring Boot.

## Archivos

La API está compuesta por los siguientes archivos:

### 1. Clase `ApiRestApplication.java`

- Esta clase es la clase principal de la aplicación Spring Boot para el servicio REST.
- Inicia la aplicación y carga el contexto de Spring.
- Implementa la configuración automática mediante la anotación `@SpringBootApplication`.

### 2. Clase `Libro.java`

- Representa la entidad `Libro`.
- Contiene atributos y métodos para describir las propiedades de un libro.

### 3. Clase `DaoLibro.java`

- Implementa un Data Access Object (DAO) para la entidad `Libro`.
- Proporciona métodos para realizar operaciones CRUD en una lista de libros.

### 4. Clase `LibroExistenteException.java`

- Define una excepción personalizada (`LibroExistenteException`) que se lanza cuando se intenta agregar un libro que ya existe.

### 5. Clase `ControladorLibro.java`

- Actúa como controlador para la gestión de libros en el servicio REST.
- Proporciona endpoints para realizar operaciones CRUD en la entidad `Libro`.

## Uso

La API proporciona las siguientes funcionalidades a través de sus endpoints:

- **Agregar un libro:** Método POST en `/libros`.
- **Eliminar un libro por su ID:** Método DELETE en `/libros/{id}`.
- **Modificar un libro por su ID:** Método PUT en `/libros/{id}`.
- **Obtener un libro por su ID:** Método GET en `/libros/{id}`.
- **Listar libros (con opción de filtrar por título):** Método GET en `/libros`.

## Tecnologías Utilizadas

- Java
- Spring Boot
- RESTful API

## Instalación y Ejecución

1. Clonar el repositorio.
2. Importar el proyecto en un IDE compatible con Spring Boot (como IntelliJ IDEA o Eclipse).
3. Ejecutar la aplicación desde la clase principal `ApiRestApplication.java`.

## Contribuciones

¡Las contribuciones son bienvenidas! Si encuentras algún problema o tienes sugerencias para mejorar la API, no dudes en crear un issue o enviar un pull request.

## Autor

- [Jorge Ruiz Martinez] - [https://github.com/n3xun3]

