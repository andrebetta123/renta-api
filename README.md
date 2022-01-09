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

POST /api/v1/cars/{carBoard}/prices
{
  "from": "Double",
  "to": "Double"
}
GET /api/v1/cars/{carBoard}
{
  "carBoard": "String",
  "from": "Double",
  "to": "Double",
  "createdDate": "LocalDateTime",
  "lastModifiedDate": "LocalDateTime"
}

GET /api/v1/cars/
{
  "items": [
    {
      "id": "string",
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
        "createDate": "2022-01-08T13:35:28.918Z",
        "lastModifiedDate": "2022-01-08T13:35:28.918Z"
      },
      "price": {
        "from": 0,
        "to": 0
      },
      "inventory": {
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
      "createdDate": "2022-01-08T13:35:28.918Z",
      "lastModifiedDate": "2022-01-08T13:35:28.918Z"
    }
  ],
  "page": 0,
  "size": 0,
  "totalPages": 0,
  "totalElements": 0
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
Criar um banco de dados mongo local chamado price-api, ou alterar o arquivo application.yml atualizando-o para o endereço mongo correto.
Após subir essa aplicação ficará disponível em http://localhost:8082
Swagger disponível em: http://localhost:8082/swagger-ui.html
FF4J disponível em: http://localhost:8082/ff4j-console/
