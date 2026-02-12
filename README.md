📦 SCVSupermercado

Sistema de Control de Ventas para supermercado — backend en Java Spring Boot con Docker y MySQL.

🔎 Descripción

Proyecto simple para gestionar:

✔ Productos
✔ Ventas
✔ Sucursales
✔ Detalles de venta

Puede ejecutarse con Docker Compose o desde tu IDE si tienes MySQL disponible.

🚀 Tecnologías

Java 17 · Spring Boot · Maven · Docker & Docker Compose · MySQL 8 · Hibernate/JPA · Lombok

🐳 Ejecutar con Docker (recomendado)

Levanta la base y la app juntas:

docker-compose up --build


Luego abre en navegador o Postman:

http://localhost:8080/api/productos


Ejemplo de respuesta si no hay productos:

[]

🧠 ¿Qué hace Docker Compose?

Levanta dos contenedores:

✔ MySQL con base SCVSupermercado
✔ Tu aplicación Spring Boot

La base se crea automáticamente y la app se conecta internamente con:

jdbc:mysql://scvsupermercado:3306/SCVSupermercado

📦 Endpoints principales (ejemplos)
Método	Ruta	Descripción

GET	/api/productos	Lista productos

POST	/api/productos	Crea producto

...	(Ventas, Sucursales, DetalleVentas)	Similar