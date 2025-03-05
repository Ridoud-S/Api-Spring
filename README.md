 # Students Management API 🎓

API REST para gestión de estudiantes desarrollada con Spring Boot. Proporciona operaciones CRUD y sigue buenas prácticas como el uso de DTOs para proteger la estructura de la entidad.

## Características Clave 🔑
- **CRUD Completo**: Crear, Leer, Actualizar y Eliminar estudiantes
- **Validación de Datos**: Verificación de correos electrónicos únicos
- **DTOs de Seguridad**: `StudentDTO` para transferencia segura de datos
- **Base de Datos Inicializada**: Datos de prueba al iniciar la aplicación
- **Transacciones**: Operaciones gestionadas con `@Transactional`

## Tecnologías 🛠️
- **Spring Boot 3**
- Spring Data JPA
- Hibernate (ORM)
- Base de datos H2 (embebida, para desarrollo)
- Maven (gestión de dependencias)

## Estructura del Proyecto 📂

src/main/java
├── com/example/Students/Api
│ ├── Config/ # Configuraciones Spring
│ ├── DTO/ # Data Transfer Objects
│ ├── Entities/ # Entidades JPA
│ ├── Repositories/ # Interfaces JpaRepository
│ ├── Service/ # Lógica de negocio
│ └── Controller/ # Endpoints REST



