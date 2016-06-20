Description
-----------

This is a basic REST API for storing and retrieving customers. It is used as the backing API to try out via the Swagger UI.

Setup
-----

1) Build the application
    
    ./gradlew clean build

3) Run the Spring Boot application from the project root

    java -jar build/libs/swagger-customer-api-1.0.jar
    
It runs on the default port 8080.

API Usage
---------

###### To get customer(s)

GET http://localhost:8080/customers

GET http://localhost:8080/customers/1

###### To create a new customer

POST http://localhost:8080/customers

    ContentType: application/json
    {
      "id": "3",
      "firstName": "Bob",
      "lastName": "Brown",
      "address": "27 Coventry Street",
      "vulnerable": false
    }

###### To update a new customer

PUT http://localhost:8080/customers/3

    ContentType: application/json
    {
      "id": "3",
      "firstName": "Bob",
      "lastName": "Brown",
      "address": "27 Coventry Street",
      "vulnerable": true
    }

###### To delete a new customer

DELETE http://localhost:8080/customers/3
