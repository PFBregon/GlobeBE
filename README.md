# GlobeBE - Proyecto FullStack

Este proyecto es una aplicación completa para la gestión de una **Academia de Inglés**, donde se puede gestionar la información de estudiantes, cursos, profesores y más. El sistema consta de un **Backend** construido con **Spring Boot** y un **Frontend** desarrollado con **React**.

## Tecnologías utilizadas

- **Frontend**:
  - React.js
  - React Router
  - Axios (para realizar solicitudes HTTP)
  - Tailwind

- **Backend**:
  - Spring Boot
  - Spring Data JPA
  - MySQL / H2 (Base de datos)
  - Spring Security (para la autenticación y autorización)
  - Maven (para la gestión de dependencias)

## Funcionalidades

### Backend (Spring Boot)

- **Gestión de Estudiantes**: Registro, actualización, eliminación y consulta de estudiantes.
- **Gestión de Cursos**: Administración de cursos, asignación de cursos a estudiantes.
- **Gestión de Profesores**: Información de los profesores, asignación de cursos a profesores.
- **Autenticación y Seguridad**: Utilización de Spring Security para proteger las rutas del backend y permitir acceso solo a usuarios autenticados.

### Frontend (React)

- **Interfaz de Usuario (UI)**: Una interfaz intuitiva que permite a los usuarios gestionar estudiantes, profesores y cursos.
- **Autenticación**: Formulario de inicio de sesión que interactúa con el backend para autenticar usuarios.
- **Interacción con el Backend**: Las operaciones del CRUD (Crear, Leer, Actualizar, Eliminar) para gestionar estudiantes, cursos y profesores se realizan utilizando Axios para hacer solicitudes al backend.
  
## Instalación

### 1. Backend (Spring Boot)

1. Clona el repositorio del backend:
    ```bash
    git clone https://github.com/tu-usuario/academia-ingles-backend.git
    ```

2. Accede al directorio del proyecto backend:
    ```bash
    cd academia-ingles-backend
    ```

3. Asegúrate de tener **Java 11** o superior instalado.

4. Si utilizas **Maven** como gestor de dependencias, ejecuta:
    ```bash
    mvn clean install
    ```

5. Para ejecutar el servidor backend, usa el siguiente comando:
    ```bash
    mvn spring-boot:run
    ```

6. El backend debería estar corriendo en `http://localhost:8080`.

### 2. Frontend (React)

1. Clona el repositorio del frontend:
    ```bash
    git clone https://github.com/tu-usuario/academia-ingles-frontend.git
    ```

2. Accede al directorio del proyecto frontend:
    ```bash
    cd academia-ingles-frontend
    ```

3. Instala las dependencias de React:
    ```bash
    npm install
    ```

4. Para ejecutar el frontend en modo de desarrollo:
    ```bash
    npm start
    ```

5. El frontend debería estar corriendo en `http://localhost:3000`.

### Conexión entre el Frontend y el Backend

El **Frontend** se comunica con el **Backend** a través de las siguientes rutas:

- **Estudiantes**:
  - `GET /api/students`
  - `POST /api/students`
  - `PUT /api/students/{id}`
  - `DELETE /api/students/{id}`

- **Profesores**:
  - `GET /api/teachers`
  - `POST /api/teachers`
  - `PUT /api/teachers/{id}`
  - `DELETE /api/teachers/{id}`

- **Cursos**:
  - `GET /api/courses`
  - `POST /api/courses`
  - `PUT /api/courses/{id}`
  - `DELETE /api/courses/{id}`

