# football-api-ed-it-jwt - Educación IT 2026 (Curso dictado por mi autoría)

Este proyecto implementa un servicio REST que gestiona equipos de fútbol (**CRUD completo**), utilizando Spring Boot, Spring Security (JWT), JPA/Hibernate, base de datos en memoria H2 y Caché.

Utiliza arquitectura en capas (entity -> repository -> service -> controller), manejo de excepciones y validaciones de duplicidad en la creación de entidades.
Además la app cuenta con seguridad con JWT (login, registro y logout), uso de roles y un endpoint de administración de usuarios, disponible solo para el rol Administrador.

<p align="center">
  <img src="https://github.com/user-attachments/assets/fcd9331b-a0d4-4952-acca-ab38de75d347"/>
</p>

---

## Tecnologías Utilizadas
- **Spring Boot Versión 4.1.0** 
- **Spring Boot Starter Data JPA**
- **Spring Boot Starter Test / Junit**
- **H2 Database:**
- **Spring Boot Starter Validation**
- **Lombok**
- **Spring Boot Starter Security**
- **Spring Boot Starter Cache y Caffeine**
- **DataFaker:** Utilizado para generar datos para los test unitarios.
- **Swagger**

## Construcción y Ejecución

Utiliza el siguiente comando Maven:

```bash
mvn clean install
```

## Endpoint swagger

El endpoint de swagger se encuentra en:

`/swagger-ui/index.html`

<img width="2167" height="973" alt="image" src="https://github.com/user-attachments/assets/b8842aac-779e-43e6-851f-2e6e6d49d03b" />


## Live Demo

### [Click Here! 🖱️](https://football-api-ed-it-jwt.onrender.com/swagger-ui/index.html)

#### Usuarios de prueba (pass: *password*):
- admin
- user1

<hr>

## Información Adicional
Para cualquier información adicional o consultas: <maxisandoval98@gmail.com>

<p align="center"><b>¡Muchas gracias! 🦔</b></p>
