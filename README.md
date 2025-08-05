# Foro Challenge - Spring Boot API REST 💬

**ForoHub** es una API REST desarrollada con **Java y Spring Boot** que simula un foro educativo donde los usuarios pueden registrar, listar, consultar, actualizar y eliminar tópicos.

Este proyecto forma parte del **Desafío Alura**, y tiene como objetivo aplicar conceptos fundamentales como:

- Desarrollo de API REST con Spring Boot
- Persistencia de datos con JPA y MySQL
- Migraciones automáticas con Flyway
- Seguridad con JWT
- Pruebas con Insomnia.

---
## 🚀 Funcionalidades principales

- 🧑‍💻 Registro de usuarios (`POST /registro`)
- 🔐 Autenticación con JWT (`POST /login`)
- ✅ Registro de un tópico
- 📄 Listado de tópicos
- 🔍 Consulta de tópico por ID
- ✏️ Actualización de tópico
- 🗑️ Eliminación lógica de tópico

---
## 🛠️ Tecnologías utilizadas

- ☕ Java 21
- ⚙️ Spring Boot 3.4.7
- 🗄️ MySQL
- 🧩 Spring Security + JWT
- 📦 JPA / Hibernate
- 🧬 Spring Data
- 🦋 Flyway
- ✍️ Lombok
- 🔍 Insomnia / Postman (para pruebas)

---
## 🧩 Estructura del proyecto (simplificada)

```src/
├── main/
│ ├── java/com/foro/
│ │ ├── controller/ # Controladores REST
│ │ ├── entities/ # Entidades JPA
│ │ ├── infra/
│ │ │ ├── security/ # JWT, filtros, autenticación
│ │ │ └── exceptions/ # Manejo de errores
│ └── resources/
│ ├── application.properties
│ └── db/migration/ # Archivos de migración Flyway
└── test/

---
## ⚙️ Configuración del entorno

### 1. Clonar el repositorio
git clone https://github.com/Willifranc/Foro-Challenge.git
cd Foro-Challenge

2. Crear la base de datos MySQL
CREATE DATABASE forohub;

3. Configurar application.properties
spring.datasource.url=jdbc:mysql://localhost/forohub
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
# Clave secreta para firmar el JWT
jwt.secret=unaClaveMuySeguraYPrivada123

4. Ejecutar el proyecto
Desde tu IDE favorito (IntelliJ, Eclipse, etc.) con la clase ForoHubApplication.java.
Las migraciones Flyway se aplicarán automáticamente para crear las tablas.

🔐 Seguridad con JWT
Para acceder a los endpoints protegidos, primero debes autenticarte.

🧑 Registro de usuario
POST /registro
Content-Type: application/json

{
  "nombre": "Ana",
  "correoElectronico": "ana@example.com",
  "contrasena": "123456"
}

🔐 Obtener Token JWT
POST /login
Content-Type: application/json

{
  "correoElectronico": "ana@example.com",
  "contrasena": "123456"
}

📥 Respuesta:
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}

📌 Usar el token en tus solicitudes
Agrega el siguiente encabezado en cada solicitud protegida:

Authorization: Bearer eyJhbGciOiJIUzI1NiJ9...

🧪 Ejemplos de pruebas en Insomnia
▶️ Registrar tópico

POST /topicos
Authorization: Bearer {token}

{
  "titulo": "Error al compilar",
  "mensaje": "Mi clase no encuentra la dependencia de JPA",
  "cursoId": 1
}

📋 Listar todos los tópicos
GET /topicos
Authorization: Bearer {token}

🔍 Consultar un tópico
GET /topicos/{id}
Authorization: Bearer {token}

✏️ Actualizar un tópico
PUT /topicos/{id}
Authorization: Bearer {token}

{
  "titulo": "Solución encontrada",
  "mensaje": "Era una versión incorrecta de JPA",
  "cursoId": 2
}

🗑️ Eliminar un tópico
DELETE /topicos/{id}
Authorization: Bearer {token}

👩‍💻 Autor
**William Franco Gonzalez**, Desarrollador Backend en formación.

**Desafio Alura para desarrollar un foro con Spring Boot y MySQL**

🌐 Repositorio
🔗 https://github.com/Willifranc/Foro-Challenge
---

