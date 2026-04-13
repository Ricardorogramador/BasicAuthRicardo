# BasicAuthRicardo

<p align="center">
  <img src="https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=java" />
  <img src="https://img.shields.io/badge/Spring_Boot-4.0.5-brightgreen?style=for-the-badge&logo=springboot" />
  <img src="https://img.shields.io/badge/Spring_Security-JWT-blue?style=for-the-badge&logo=springsecurity" />
  <img src="https://img.shields.io/badge/PostgreSQL-Database-4169E1?style=for-the-badge&logo=postgresql" />
</p>

---

## 🇬🇧 English

### Overview

**BasicAuthRicardo** is a complete **Basic Authentication REST API** built with **Java 21** and **Spring Boot**. It provides secure user registration and login using **JSON Web Tokens (JWT)**, backed by a **PostgreSQL** database. The backend was **developed entirely by Ricardo**.

> ⚠️ **Note about the frontend:** The `index.html` file included in this repository is a **demonstration frontend created with AI assistance**. It is intended only to showcase how the API can be consumed from a browser and is **not** part of the core backend project.

---

### Technology Stack

| Layer          | Technology                                      |
|----------------|-------------------------------------------------|
| Language       | Java 21                                         |
| Framework      | Spring Boot 4.0.5                               |
| Security       | Spring Security + JWT (JJWT 0.13.0)             |
| Database       | PostgreSQL                                      |
| ORM            | Spring Data JPA / Hibernate                     |
| Validation     | Jakarta Bean Validation                         |
| Build Tool     | Maven                                           |
| Utilities      | Lombok                                          |

---

### Features

- ✅ User **registration** with name, email, and password
- ✅ User **login** returning a signed JWT
- ✅ Password validation (minimum 7 characters)
- ✅ Email format validation
- ✅ Spring Security filter chain with JWT authentication filter
- ✅ Environment-variable-based configuration (no secrets in source code)
- ✅ Demo HTML frontend for quick API testing

---

### Requirements

- Java 21 or higher
- Maven 3.9+
- PostgreSQL 14+
- (Optional) Docker

---

### Installation & Setup

#### 1. Clone the repository

```bash
git clone https://github.com/Ricardorogramador/BasicAuthRicardo.git
cd BasicAuthRicardo
```

#### 2. Create the PostgreSQL database

```sql
CREATE DATABASE authbasic;
```

#### 3. Configure environment variables

Set the following environment variables before running the application:

| Variable         | Description                        | Default                                     |
|------------------|------------------------------------|---------------------------------------------|
| `DB_URL`         | JDBC connection URL                | `jdbc:postgresql://localhost:5432/authbasic` |
| `DB_USERNAME`    | Database username                  | `postgres`                                  |
| `DB_PASSWORD`    | Database password                  | `password`                                  |
| `JWT_SECRET`     | Secret key for signing JWTs        | *(required – no default)*                   |
| `JWT_EXPIRATION` | Token expiration in milliseconds   | `86400000` (24 hours)                       |

**Linux / macOS:**
```bash
export DB_URL=jdbc:postgresql://localhost:5432/authbasic
export DB_USERNAME=postgres
export DB_PASSWORD=yourpassword
export JWT_SECRET=your_very_long_and_secure_secret_key
```

**Windows (PowerShell):**
```powershell
$env:DB_URL="jdbc:postgresql://localhost:5432/authbasic"
$env:DB_USERNAME="postgres"
$env:DB_PASSWORD="yourpassword"
$env:JWT_SECRET="your_very_long_and_secure_secret_key"
```

#### 4. Build and run

```bash
./mvnw spring-boot:run
```

The server starts on **`http://localhost:8080`** by default.

---

### API Endpoints

Base URL: `http://localhost:8080/api/auth`

#### Register

```
POST /api/auth/register
Content-Type: application/json
```

**Request body:**
```json
{
  "name": "John Doe",
  "email": "john@example.com",
  "password": "securePass1"
}
```

**Success response (`200 OK`):**
```json
{
  "token": "<JWT_TOKEN>"
}
```

**Validation errors (`400 Bad Request`):**
- `name` must not be blank
- `email` must be a valid email address
- `password` must be at least 7 characters long

---

#### Login

```
POST /api/auth/login
Content-Type: application/json
```

**Request body:**
```json
{
  "email": "john@example.com",
  "password": "securePass1"
}
```

**Success response (`200 OK`):**
```json
{
  "token": "<JWT_TOKEN>"
}
```

---

### Using the Demo Frontend

Open `index.html` directly in a browser (no web server required). Make sure the backend is running on `http://localhost:8080`.

> 🤖 **This frontend was created with AI assistance** and is purely a demonstration interface. It allows you to test the register and login endpoints visually.

---

### License

This project is open-source. See [LICENSE](LICENSE) for details.

---
---

## 🇪🇸 Español

### Descripción general

**BasicAuthRicardo** es una **API REST de Autenticación Básica** completa, desarrollada con **Java 21** y **Spring Boot**. Proporciona registro e inicio de sesión seguros mediante **Tokens JWT**, con una base de datos **PostgreSQL**. El backend fue **desarrollado íntegramente por Ricardo**.

> ⚠️ **Nota sobre el frontend:** El archivo `index.html` incluido en este repositorio es un **frontend de demostración creado con inteligencia artificial**. Su único propósito es mostrar cómo se puede consumir la API desde un navegador y **no** forma parte del proyecto de backend principal.

---

### Stack Tecnológico

| Capa            | Tecnología                                      |
|-----------------|-------------------------------------------------|
| Lenguaje        | Java 21                                         |
| Framework       | Spring Boot 4.0.5                               |
| Seguridad       | Spring Security + JWT (JJWT 0.13.0)             |
| Base de datos   | PostgreSQL                                      |
| ORM             | Spring Data JPA / Hibernate                     |
| Validación      | Jakarta Bean Validation                         |
| Herramienta de build | Maven                                      |
| Utilidades      | Lombok                                          |

---

### Características

- ✅ **Registro** de usuarios con nombre, correo y contraseña
- ✅ **Inicio de sesión** que devuelve un JWT firmado
- ✅ Validación de contraseña (mínimo 7 caracteres)
- ✅ Validación de formato de correo electrónico
- ✅ Cadena de filtros de Spring Security con filtro JWT
- ✅ Configuración mediante variables de entorno (sin secretos en el código fuente)
- ✅ Frontend HTML de demostración para probar la API rápidamente

---

### Requisitos

- Java 21 o superior
- Maven 3.9+
- PostgreSQL 14+
- (Opcional) Docker

---

### Instalación y configuración

#### 1. Clonar el repositorio

```bash
git clone https://github.com/Ricardorogramador/BasicAuthRicardo.git
cd BasicAuthRicardo
```

#### 2. Crear la base de datos PostgreSQL

```sql
CREATE DATABASE authbasic;
```

#### 3. Configurar variables de entorno

Establece las siguientes variables de entorno antes de ejecutar la aplicación:

| Variable         | Descripción                               | Valor por defecto                            |
|------------------|-------------------------------------------|----------------------------------------------|
| `DB_URL`         | URL de conexión JDBC                      | `jdbc:postgresql://localhost:5432/authbasic` |
| `DB_USERNAME`    | Usuario de la base de datos               | `postgres`                                   |
| `DB_PASSWORD`    | Contraseña de la base de datos            | `password`                                   |
| `JWT_SECRET`     | Clave secreta para firmar los JWT         | *(requerido – sin valor por defecto)*        |
| `JWT_EXPIRATION` | Expiración del token en milisegundos      | `86400000` (24 horas)                        |

**Linux / macOS:**
```bash
export DB_URL=jdbc:postgresql://localhost:5432/authbasic
export DB_USERNAME=postgres
export DB_PASSWORD=tucontraseña
export JWT_SECRET=tu_clave_secreta_muy_larga_y_segura
```

**Windows (PowerShell):**
```powershell
$env:DB_URL="jdbc:postgresql://localhost:5432/authbasic"
$env:DB_USERNAME="postgres"
$env:DB_PASSWORD="tucontraseña"
$env:JWT_SECRET="tu_clave_secreta_muy_larga_y_segura"
```

#### 4. Compilar y ejecutar

```bash
./mvnw spring-boot:run
```

El servidor inicia en **`http://localhost:8080`** por defecto.

---

### Endpoints de la API

URL base: `http://localhost:8080/api/auth`

#### Registro

```
POST /api/auth/register
Content-Type: application/json
```

**Cuerpo de la solicitud:**
```json
{
  "name": "Juan Pérez",
  "email": "juan@ejemplo.com",
  "password": "contraseña1"
}
```

**Respuesta exitosa (`200 OK`):**
```json
{
  "token": "<JWT_TOKEN>"
}
```

**Errores de validación (`400 Bad Request`):**
- `name` no puede estar vacío
- `email` debe tener un formato válido
- `password` debe tener al menos 7 caracteres

---

#### Inicio de sesión

```
POST /api/auth/login
Content-Type: application/json
```

**Cuerpo de la solicitud:**
```json
{
  "email": "juan@ejemplo.com",
  "password": "contraseña1"
}
```

**Respuesta exitosa (`200 OK`):**
```json
{
  "token": "<JWT_TOKEN>"
}
```

---

### Uso del frontend de demostración

Abre el archivo `index.html` directamente en un navegador (no se necesita servidor web). Asegúrate de que el backend esté ejecutándose en `http://localhost:8080`.

> 🤖 **Este frontend fue creado con inteligencia artificial** y es únicamente una interfaz de demostración. Permite probar visualmente los endpoints de registro e inicio de sesión.

---

### Licencia

Este proyecto es de código abierto. Consulta el archivo [LICENSE](LICENSE) para más detalles.
