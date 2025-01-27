# Notas MVP - Spring Boot Project

Este proyecto es una API desarrollada en **Spring Boot** para gestionar notas.

---

## 🚀 Funcionalidades
- Gestión de usuarios (Autenticación y Autorización).
- Gestión de notas y etiquetas: creación, actualización, eliminación y obtención.
- Manejo de excepciones globales para un mejor manejo de errores.
- Configuración de CORS y seguridad.

---

## 📂 Estructura de Archivos

```plaintext
src/main/java
└── com.yacelly.notas_mvp
    ├── auth
    │   ├── controller        # Controladores relacionados con la autenticación.
    │   ├── domain            # Entidades del dominio para autenticación.
    │   ├── dto               # Data Transfer Objects para autenticación.
    │   ├── mapper            # Mapeadores para transformar entidades y DTOs.
    │   ├── repository        # Repositorios relacionados con autenticación.
    │   ├── security          # Configuración de seguridad y JWT.
    │   └── service           # Lógica de negocio para autenticación.
    │
    ├── config
    │   ├── CORSConfig        # Configuración de CORS.
    │   ├── ModelMapperConfig # Configuración de ModelMapper para transformar objetos.
    │   └── WebSecurityConfig # Configuración de seguridad web.
    │
    ├── exception
    │   ├── BadRequestException         # Excepción para solicitudes incorrectas.
    │   ├── ErrorDetails                # Detalles personalizados de errores.
    │   ├── GlobalExceptionHandler      # Manejo global de excepciones.
    │   ├── ResourceNotFoundException   # Excepción para recursos no encontrados.
    │   ├── UnauthorizedException       # Excepción para accesos no autorizados.
    │   └── UserNotAuthenticatedException # Excepción para usuarios no autenticados.
    │
    ├── notes
    │   ├── controller       # Controlador para las operaciones relacionadas con las notas.
    │   ├── domain           # Entidades del dominio para las notas.
    │   ├── dto              # Data Transfer Objects para notas.
    │   ├── mapper           # Mapeadores para las notas.
    │   ├── repository       # Repositorios relacionados con las notas.
    │   └── service          # Lógica de negocio para las notas.
    │
    └── NotasMvpApplication  # Clase principal de la aplicación.
    
    
```

## 🔧 Requisitos Previos
- Java 21 o superior.
- Maven para gestionar las dependencias.
- Spring Boot 3.x.x (o una versión compatible).


## ⚙️ Configuración
1.- Clonar el repositorio:
```bash
git clone https://github.com/dharbor2025/notas_mvp_backend.git
cd notas_mvp_backend
```

2.- Configurar el archivo application.properties: Edita el archivo src/main/resources/application.properties para establecer los valores de configuración necesarios, como la base de datos y el servidor.

```properties
# Ejemplo de configuración
spring.datasource.url=jdbc:postgresql://localhost:5432/notas_db
spring.datasource.username=usuario_bd
spring.datasource.password=contraseña_bd
spring.jpa.hibernate.ddl-auto=update
spring.security.jwt.secret=semilla_jwt

```

3.-Construir el proyecto:

## 📄 Documentación de la API
- La documentación completa de los endpoints está disponible en Postman. Puedes acceder a ella en el siguiente enlace:

👉 **Documentación en Postman** 👈: [https://documenter.getpostman.com/view/484521/2sAYQgi8k4](https://documenter.getpostman.com/view/484521/2sAYQgi8k4)



## 🛠 Endpoints Principales
### Notas
- GET /api/v1/notes/page - Obtiene todas las notas paginado.
- GET /api/v1/notes?status=true&keyword=nota - Obtiene todas las notas paginado y con filtros.
- GET /api/notes/{uuid} - Obtiene una sola nota detallada
- POST /api/notes - Crea una nueva nota.
- PUT /api/notes/{uuid} - Actualiza una nota.
- DELETE /api/notes/{uuid} - Elimina una nota.

### Etiquetas
- GET /api/v1/etiquetas/page - Obtiene todas las etiquetas paginado.
- GET /api/etiquetas/{uuid} - Obtiene una sola etiqueta detallada
- POST /api/etiquetas - Crea una nueva etiqueta.
- PUT /api/etiquetas/{uuid} - Actualiza una etiqueta.
- DELETE /api/etiquetas/{uuid} - Elimina una etiqueta.

### Autenticación
- POST /api/v1/auth/sign-in - Autenticación de usuario.
- POST /api/v1/auth/sign-up - Registro de un nuevo usuario.


## 🧑‍💻 Autor
- Desarrollado por Jose Luis Yacelly Ramos.

