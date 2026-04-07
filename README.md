# EscenaDelCrimen Videoclub - Backend

API REST desarrollada con Java y Spring Boot para la gestión del catálogo de películas del videoclub **EscenaDelCrimen**, especializado en cine negro, thriller y crimen.

---

## Tecnologías

- Java 21
- Spring Boot 3.3.5
- Spring Data JPA
- MySQL
- Maven

---

## Requisitos previos

- Java 21+
- Maven
- MySQL corriendo en `localhost:3306`

---

## Configuración

Crea la base de datos en MySQL antes de arrancar:

```sql
CREATE DATABASE EscenaDelCrimen;
```

Las credenciales por defecto en `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/EscenaDelCrimen
spring.datasource.username=root
spring.datasource.password=root
```

Modifícalas si tu configuración de MySQL es diferente.

---

## Instalación y arranque

```bash
# Clonar el repositorio
git clone <url-del-repo>

# Entrar al directorio
cd Back-del-Videoclub-Java-SpringBoot

# Compilar y arrancar
mvn spring-boot:run
```

El servidor arranca en `http://localhost:8080`.

---

## Endpoints

### Películas

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/movies` | Obtener todas las películas |
| GET | `/movies/{id}` | Obtener película por ID |
| GET | `/movies/ASC` | Obtener todas ordenadas alfabéticamente |
| GET | `/movies/category/{category}` | Obtener películas por categoría |
| POST | `/movies` | Crear nueva película |
| PUT | `/movies/{id}` | Actualizar película existente |
| DELETE | `/movies/{id}` | Eliminar película |

### Categorías disponibles

| Valor | Descripción |
|-------|-------------|
| `mafiasYGangsters` | Mafias y Gángsters |
| `cineNegroClasico` | Cine Negro Clásico |
| `thrillerPolicial` | Thriller Policial |
| `thrillerPsicologico` | Thriller Psicológico |
| `thrillerModerno` | Thriller Moderno |
| `misterioDetectives` | Misterio y Detectives |
| `terrorCriminal` | Terror Criminal |

---

## Ejemplo de uso

### Crear película (POST /movies)

```json
{
  "title": "Pulp Fiction",
  "year": 1994,
  "director": "Quentin Tarantino",
  "main_cast": "John Travolta, Uma Thurman, Samuel L. Jackson",
  "filmaffinity_score": 8.9,
  "description": "Historias entrelazadas del crimen en Los Ángeles.",
  "img": "src/images/films/pulpFiction.jpg",
  "url": "https://www.youtube.com/watch?v=s7EdQ4FqbhY",
  "trailer": null,
  "ranking": 3,
  "category": "mafiasYGangsters"
}
```

### Respuesta

```json
{
  "id": 1,
  "title": "Pulp Fiction",
  "year": 1994,
  "director": "Quentin Tarantino",
  "main_cast": "John Travolta, Uma Thurman, Samuel L. Jackson",
  "filmaffinity_score": 8.9,
  "description": "Historias entrelazadas del crimen en Los Ángeles.",
  "img": "src/images/films/pulpFiction.jpg",
  "url": "https://www.youtube.com/watch?v=s7EdQ4FqbhY",
  "trailer": null,
  "ranking": 3.0,
  "category": "mafiasYGangsters"
}
```

---

## CORS

El backend permite peticiones desde `http://localhost:5173` (frontend React + Vite) para todos los métodos y rutas.

---

## Estructura del proyecto

```
src/
└── main/
    └── java/
        └── Inditex/
            └── EscenaDelCrimenVideoclub/
                ├── config/
                │   └── WebConfig.java         # Configuración CORS global
                ├── controller/
                │   └── MovieController.java   # Endpoints REST
                ├── model/
                │   └── Movie.java             # Entidad JPA
                ├── repository/
                │   └── MovieRepository.java   # Acceso a datos
                ├── service/
                │   └── MovieService.java      # Lógica de negocio
                └── EscenaDelCrimenVideoclubApplication.java
```

---

## Licencia

MIT License

Copyright (c) 2024 EscenaDelCrimen Videoclub

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.