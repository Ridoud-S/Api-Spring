 # Students Management API 🎓

API REST para gestión de estudiantes desarrollada con Spring Boot. Proporciona operaciones CRUD y sigue buenas prácticas como el uso de DTOs para proteger la estructura de la entidad.

## Características Clave 🔑
- **CRUD Completo**: Crear, Leer, Actualizar y Eliminar estudiantes
- **Validación de Datos**: Verificación de correos electrónicos únicos
- **DTOs de Seguridad**: `StudentDTO` para transferencia segura de datos
- **Base de Datos Inicializada**: Datos de prueba al iniciar la aplicación
- **Transacciones**: Operaciones gestionadas con `@Transactional`

## 🛠️ Tecnologías

### Backend
- **Spring Boot 3.4.2** - Framework principal
- **Java 17** - Lenguaje base
- **Spring Data JPA** - Persistencia de datos
- **Hibernate** - ORM (Mapeo objeto-relacional)
- **PostgreSQL** - Base de datos relacional (Driver incluido)
- **Spring Web** - Construcción de APIs REST
- **Maven** - Gestión de dependencias y builds

### Testing
- **Spring Boot Test** - Pruebas de integración
- **JUnit 5** - Framework de testing

### Desarrollo
- **Spring Boot Maven Plugin** - Empaquetado y ejecución

- **Arquitectura**: MVC (Modelo-Vista-Controlador)
- **Persistencia**: 
  - Entity Manager integrado
  - Transacciones declarativas con `@Transactional`
  - Repositorios JPA con herencia de `JpaRepository`
- **API REST**:
  - Manejo de excepciones automático
  - Serialización/Deserialización JSON integrada
  - Validación de parámetros con annotations


## Estructura del Proyecto 📂

```bash
src/main/java
├── com/example/Students/Api
│ ├── Config/ # Configuraciones Spring
│ ├── DTO/ # Data Transfer Objects
│ ├── Entities/ # Entidades JPA
│ ├── Repositories/ # Interfaces JpaRepository
│ ├── Service/ # Lógica de negocio
│ └── Controller/ # Endpoints REST



