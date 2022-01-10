# rental-api
Aplicação para cadastro de locações a ser utilizada na disciplina de Apis Rest com Java e Spring da UNIFACEF.

# A solução

![PosFacef_API_Locadora-microsserviços drawio (2)-microsserviços drawio](https://user-images.githubusercontent.com/64381101/148108906-9786a8c2-7470-447d-8b67-c461020b0d75.png)


# Car-API:

Microsserviço responsável pelo CRUD de carros via HTTP, por persistir no mongo e enviar para a Location-API.

# Price-API:

Microsserviço responsável pelo CRUD de preços via HTTP, por persistir no mongo e enviar para a Location-API.

# Customers-API:

Microsserviço responsável pelo CRUD de clientes via HTTP, por persistir no mongo e enviar para a Location-API.

# Rental-API:

Microsserviço responsável por agregar os dados oriundos dos microsserviços de entrada.

# Arquitetura utilizada na solução:

Hexagonal

![image](https://user-images.githubusercontent.com/64381101/145391252-c6f74a82-2a81-4ef0-9aa2-8ba86a38cd75.png)

# Contratos da API de rental:

POST /api/v1/cars/{carBoard}
{
  "brand": "string",
  "model": "string",
  "color": "string",
  "year": "string",
  "typeCar": "COMPACT",
  "tankStatus": "EMPTY",
  "availability": true
}

POST /api/v1/cars/{carBoard}/prices
{
  "from": "Double",
  "to": "Double"
}

GET /api/v1/cars/{carBoard}
{
  "carBoard": "string",
  "car": {
    "board": "string",
    "brand": "string",
    "model": "string",
    "color": "string",
    "year": "string",
    "typeCar": "COMPACT",
    "tankStatus": "EMPTY",
    "availability": true,
    "createDate": "2022-01-09T23:51:41.686Z",
    "lastModifiedDate": "2022-01-09T23:51:41.686Z"
  },
  "price": {
    "from": 0,
    "to": 0
  },
  "createdDate": "2022-01-09T23:51:41.686Z",
  "lastModifiedDate": "2022-01-09T23:51:41.686Z"
}

GET /api/v1/cars/
{
  "items": [
    {
      "carBoard": "string",
      "car": {
        "board": "string",
        "brand": "string",
        "model": "string",
        "color": "string",
        "year": "string",
        "typeCar": "COMPACT",
        "tankStatus": "EMPTY",
        "availability": true,
        "createDate": "2022-01-09T23:50:50.675Z",
        "lastModifiedDate": "2022-01-09T23:50:50.675Z"
      },
      "price": {
        "from": 0,
        "to": 0
      },
      "createdDate": "2022-01-09T23:50:50.675Z",
      "lastModifiedDate": "2022-01-09T23:50:50.675Z"
    }
  ],
  "page": 0,
  "size": 0,
  "totalPages": 0,
  "totalElements": 0
}

GET/api/v1/rentals/
{
  "items": [
    {
      "id": "string",
      "carBoard": "string",
      "deliveryDate": "2022-01-09T23:54:36.879Z",
      "leaseDate": "2022-01-09T23:54:36.879Z",
      "costumerId": "string",
      "leaseValue": 0,
      "kilometers": {
        "initialKm": 0,
        "returnKm": 0
      },
      "tankStatus": "EMPTY",
      "createdDate": "2022-01-09T23:54:36.879Z",
      "lastModifiedDate": "2022-01-09T23:54:36.879Z"
    }
  ],
  "page": 0,
  "size": 0,
  "totalPages": 0,
  "totalElements": 0
}

GET/api/v1/rentals/{rentalId}
{
  "id": "string",
  "carBoard": "string",
  "deliveryDate": "2022-01-09T23:54:56.090Z",
  "leaseDate": "2022-01-09T23:54:56.090Z",
  "costumerId": "string",
  "leaseValue": 0,
  "kilometers": {
    "initialKm": 0,
    "returnKm": 0
  },
  "tankStatus": "EMPTY",
  "createdDate": "2022-01-09T23:54:56.090Z",
  "lastModifiedDate": "2022-01-09T23:54:56.090Z"
}

POST/api/v1/rentals/
{
  "id": "string",
  "carBoard": "string",
  "deliveryDate": "2022-01-09T23:55:42.795Z",
  "leaseDate": "2022-01-09T23:55:42.795Z",
  "costumerId": "string",
  "leaseValue": 0,
  "kilometers": {
    "initialKm": 0,
    "returnKm": 0
  },
  "tankStatus": "EMPTY"
}

PUT/api/v1/rentals/
{
  "id": "string",
  "carBoard": "string",
  "deliveryDate": "2022-01-09T23:56:13.929Z",
  "leaseDate": "2022-01-09T23:56:13.929Z",
  "costumerId": "string",
  "leaseValue": 0,
  "kilometers": {
    "initialKm": 0,
    "returnKm": 0
  },
  "tankStatus": "EMPTY"
}

GET/api/v1/costumer/
{
  "items": [
    {
      "costumerId": "string",
      "costumer": {
        "id": "string",
        "name": "string",
        "phone": "string",
        "driverLicense": "string",
        "active": true,
        "address": {
          "city": "string",
          "district": "string",
          "id": 0,
          "streetName": "string",
          "zipCode": "string"
        }
      },
      "createdDate": "2022-01-09T23:57:32.584Z",
      "lastModifiedDate": "2022-01-09T23:57:32.584Z"
    }
  ],
  "page": 0,
  "size": 0,
  "totalPages": 0,
  "totalElements": 0
}

GET/api/v1/costumer/{id}
{
  "costumerId": "string",
  "costumer": {
    "id": "string",
    "name": "string",
    "phone": "string",
    "driverLicense": "string",
    "active": true,
    "address": {
      "city": "string",
      "district": "string",
      "id": 0,
      "streetName": "string",
      "zipCode": "string"
    }
  },
  "createdDate": "2022-01-09T23:58:08.870Z",
  "lastModifiedDate": "2022-01-09T23:58:08.870Z"
}

POST/api/v1/costumer/{id}
{
  "name": "string",
  "phone": "string",
  "driverLicense": "string",
  "active": true,
  "address": {
    "city": "string",
    "district": "string",
    "id": 0,
    "streetName": "string",
    "zipCode": "string"
  }
}

# Tecnologias utilizadas
Java 8
MongoDB
Lombok
Spring Boot
Spring Data
Open Feign
FF4J


# Para subir essa APP
Criar um banco de dados mongo local chamado rental-car-api, ou alterar o arquivo application.yml atualizando-o para o endereço mongo correto.
Após subir essa aplicação ficará disponível em http://localhost:8084
Swagger disponível em: http://localhost:8084/swagger-ui.html
FF4J disponível em: http://localhost:8084/ff4j-console/
