# 💾 Proyecto: bd_java_tarea

## 👩‍💻 Integrantes
- **Camila Bastidas**
- **Evelin Pulsara**
- **Jesus Villota**

---

## 📚 Descripción del proyecto
Este proyecto en **Java** tiene como objetivo practicar el uso de **MySQL** mediante la implementación de operaciones CRUD (Crear, Leer, Actualizar y Eliminar) sobre la tabla `actor` de la base de datos `sakila`.

Se desarrolló utilizando el **patrón de repositorio**, conectando la aplicación con MySQL para realizar transacciones desde Java y ejecutando pruebas de inserción, consulta, actualización y eliminación de registros.

---

## ⚙️ Tecnologías utilizadas
- **Java 17**
- **Maven**
- **MySQL**
- **JDBC (Java Database Connectivity)**
- **IDE:** Visual Studio Code

---

## 🧩 Estructura del proyecto
bd_java_tarea/
│
├── src/
│ ├── main/java/com/ucc/
│ │ ├── Main.java
│ │ ├── model/
│ │ │ └── Actor.java
│ │ └── repository/
│ │ └── ActorRepository.java
│ └── resources/
│
├── pom.xml
└── README.md

---

## 🧠 Funcionalidades principales

### 1️⃣ Crear un actor
Inserta un nuevo registro en la tabla `actor`:
```java
actorRepository.save(new Actor(9999, "PepitoCode2", "PepitoCode2"));

Salida esperada:
=== CREATE ===
Inserted: Actor [actor_id=9999, first_name=PepitoCode2, last_name=PepitoCode2]

2️⃣ Consultar actor por ID

Obtiene un solo elemento de la tabla usando su actor_id:
Actor actor = actorRepository.findById(9999);

Salida esperada:
=== GET BY ID ===
Found: Actor [actor_id=9999, first_name=PepitoCode2, last_name=PepitoCode2]

3️⃣ Actualizar un actor

Modifica los datos de un actor existente:
actorRepository.update(9999, "PepitoUpdated", "PepitoUpdated");

Salida esperada:
=== UPDATE ===
Rows updated: 1
After update: Actor [actor_id=9999, first_name=PepitoUpdated, last_name=PepitoUpdated]

4️⃣ Eliminar un actor

Elimina un registro de la tabla:
actorRepository.delete(9999);

Salida esperada:
=== DELETE ===
Rows deleted: 1

🧪 Ejecución del proyecto

Abre la terminal en la carpeta del proyecto.

Ejecuta el siguiente comando Maven:
mvn exec:java

🗃️ Base de datos usada

Base: sakila

Tabla: actor

Ejemplo de estructura de la tabla:
CREATE TABLE actor (
  actor_id INT PRIMARY KEY,
  first_name VARCHAR(45),
  last_name VARCHAR(45),
  last_update TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

🚀 Resultado final esperado en consola

=== CREATE ===
Inserted: Actor [actor_id=9999, first_name=PepitoCode2, last_name=PepitoCode2]

=== GET BY ID ===
Found: Actor [actor_id=9999, first_name=PepitoCode2, last_name=PepitoCode2]

=== UPDATE ===
Rows updated: 1
After update: Actor [actor_id=9999, first_name=PepitoUpdated, last_name=PepitoUpdated]

=== DELETE ===
Rows deleted: 1

=== LIST (first 10) ===
Actor [actor_id=1, first_name=PENELOPE, last_name=GUINESS]
Actor [actor_id=2, first_name=NICK, last_name=WAHLBERG]
