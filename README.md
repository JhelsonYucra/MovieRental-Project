# Movie Rental API – Spring Boot

API creada para gestionar un catálogo de películas.  
Incluye autenticación con JWT, roles (ADMIN/USER), ratings y filtros avanzados.

---

## Funcionalidades Principales
- CRUD de películas (solo ADMIN).
- Búsqueda por nombre.
- Filtros por categoría y año.
- Paginación y ordenamiento.
- Registro y login de usuarios con JWT.
- Calificación de películas (1–5) por usuario autenticado.
- Un usuario solo puede calificar una vez y puede eliminar su rating.
- Swagger UI habilitado.

---

## Tecnologías
- Java + Spring Boot  
- Spring Security + JWT  
- Spring Data JPA (MySQL/PostgreSQL)  
- Swagger / OpenAPI  

---

## Endpoints (resumen)
**Auth**
- `POST /auth/login` – Obtener token  
- `POST /auth/register` – Registrar usuario (ADMIN)

**Movies**
- `GET /movies` – Listar (buscar, filtrar, paginar, ordenar)  
- `POST /movies` – Crear (ADMIN)  
- `PUT /movies/{id}` – Actualizar  
- `DELETE /movies/{id}` – Eliminar

**Ratings**
- `POST /movies/{id}/rate` – Calificar  
- `DELETE /movies/{id}/rate` – Quitar calificación  
- `GET /ratings/me` – Mis calificaciones

---


