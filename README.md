Description
-----------

Working example of Try-It-Out style API documentation using Swagger UI.

The API specification is Swagger 2.0 (Open API) specification, served out of the Customer service as a separate resource. In this example, it has been manually drafted in JSON format - there is another Github project for defining the API specification via Swagger annotations (https://github.com/spiritedtechie/swagger-annotations-in-action)

How To Use
----------

1) Run the customer service (follow instructions in subfolder README)

2) Check manually the service is serving the API specification:

GET http://localhost:8090/api-doc

3) Go to:

http://petstore.swagger.io/

4) Change URL in top bar to:

http://localhost:8090/api-doc

5) Hit 'Explore' and expand 'default'. You should see the operations on Customer.

6) Have a play with each operation. These work against the deployed service.


Details
-------

The Swagger spec is defined in swagger-customer-api/src/main/resources/api.json
