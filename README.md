# Foro Challenge - Spring Boot API REST 
Desafio Alura para desarrollar un foro.

Este es un proyecto de backend desarrollado en **Java con Spring Boot**, que simula un foro donde los usuarios pueden registrar, listar, consultar, actualizar y eliminar tópicos.

Forma parte de un desafío educativo para aplicar conceptos clave como API REST, JPA, migraciones con Flyway y pruebas con Insomnia.

---

## 🚀 Funcionalidades principales

- ✅ Registrar un tópico
- 📄 Listar todos los tópicos
- 🔍 Consultar un tópico por ID
- ✏️ Actualizar un tópico
- 🗑️ Eliminar un tópico

---

## 🛠️ Tecnologías utilizadas

- Java 21
- Spring Boot 3.4.7
- MySQL
- JPA / Hibernate
- Spring Data
- Flyway (para migraciones de base de datos)
- Lombok
- Insomnia (para pruebas de API)

---

## 📁 Estructura del proyecto

src/
├── main/
│ ├── java/com/foro/
│ │ ├── entities/
│ │ ├── topico/
│ │ ├── curso/
│ │ ├── usuario/
│ │ └── infra/
│ └── resources/
│ ├── application.properties
│ └── db/migration/
└── test/

---

## ⚙️ Configuración del entorno

1. Clona este repositorio:
   ```bash
   git clone https://github.com/Willifranc/Foro-Challenge.git
Crea la base de datos en MySQL:

CREATE DATABASE foro_challenge;

Configura las credenciales en src/main/resources/application.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/foro_challenge
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
Ejecuta el proyecto desde IntelliJ o tu IDE favorito usando la clase ForoHubApplication.

📝 Flyway aplicará automáticamente las migraciones SQL para crear las tablas necesarias.

🧪 Ejemplos de pruebas en Insomnia
▶️ Registrar tópico

POST /topicos

{
"titulo": "Error al compilar",
"mensaje": "Mi clase no encuentra la dependencia de JPA",
"autorId": 1,
"cursoId": 1
}
📋 Listar todos los tópicos
GET /topicos

🔍 Ver detalle de un tópico
GET /topicos/{id}

✏️ Actualizar un tópico
PUT /topicos/{id}

{
"titulo": "Solución encontrada",
"mensaje": "Era una versión incorrecta de JPA",
"cursoId": 2
}
🗑️ Eliminar un tópico
DELETE /topicos/{id}

👩‍💻 Autor
**William Franco Gonzalez**, Desarrollador Backend en formación.

**Desafio Alura para desarrollar un foro con Spring Boot y MySQL**

🌐 Repositorio
🔗 https://github.com/Willifranc/Foro-Challenge

---

