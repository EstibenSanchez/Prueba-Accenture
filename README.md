# Prueba Técnica Accenture

## Pasos para ejecutar

1. Clona el repositorio:
   ```bash
   git clone https://github.com/EstibenSanchez/Prueba-Accenture.git
2. Abre el proyecto en el editor de tu preferencia (puede ser IntelliJ, VS Code, Eclipse, etc.).
3. Configura las siguientes variables de entorno para utilizar la base de datos que está alojada en AWS:

DB_HOST: Endpoint de la base de datos. database-1.cnc6a8o44ebx.us-east-2.rds.amazonaws.com

DB_PORT: Puerto de la base de datos (por defecto 3306 para MySQL). 3306

DB_NAME: Nombre de la base de datos. pruebaAccenture

DB_USERNAME: Usuario de la base de datos. admin

DB_PASSWORD: Contraseña de la base de datos. Brayan.Barragan2

Estas variables se deben configurar en tu entorno de desarrollo o en el sistema operativo.

4. Ejecuta el proyecto con el siguiente comando:

mvn spring-boot:run

## Documentación de Endpoints

Franchise (Franquicia)
Crear una nueva franquicia

Endpoint: POST /api/franchises/create
Body:
{
  "name": "string"
}

Crear una nueva sucursal asociada a una franquicia

Endpoint: POST /api/subsidiaries/create
Body:
{
  "name": "string",
  "franchise_id": int
}

Crear un producto asociado a una sucursal

Endpoint: POST /api/products/create
Body:
{
  "name": "string",
  "stock": int,
  "franchise_id": int
}


Elimunar un producto asociado a una sucursal

Endpoint: DELETE /api/products/delete/{id}

Modificar el stock y nombre de un producto

Endpoint: PUT /api/products/update
Body:
{
  "id": int,
  "name": "string",
  "stock": int,
}

Listar los prductos con mas stock en una sucursal con una franquicia especifica
Endpoint: GET /api/franchises/get/{id_franquicia}



Editar una franquicia

Endpoint: PUT /api/franchises/update
Body:
{
    "id": "1",
    "name": "Hola"
}

Editar el nombre de una sucursal

Endpoint: PUT /api/subsidiaries/update
Body:
{
    "id": "1",
    "name": "Hola"
}

Obtener una franquicia por ID
Endpoint: GET /api/franchises/get/{id}

Obtener todas las franquicias
Endpoint: GET /api/franchises/get/all




