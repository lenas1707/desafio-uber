# Food Trucks API

API para consulta de food trucks de São Francisco, desenvolvida com Spring Boot.

## Tecnologias Utilizadas

- Java 21
- Spring Boot 3.5.0
- Spring WebFlux
- Maven


## Endpoints

### Listar Todos os Food Trucks
```
GET /foodtrucks
```

### Filtrar por Tipo de Instalação
```
GET /foodtrucks?facilitytype={tipo}
```

```
## Estrutura do Projeto

```
src/main/java/spring/boot/desafio/uber/
├── controllers/
│   └── FoodTruckLocationController.java
├── entities/
│   ├── FoodTruckLocation.java
│   └── FoodItemsDeserializer.java
├── services/
│   └── FoodTruckLocationService.java
└── UberApplication.java
```

## Dados

A API consome dados da API pública de Food Trucks de São Francisco:
https://data.sfgov.org/resource/rqzj-sfat.json 