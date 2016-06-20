Description
-----------

Working example of Try-It-Out style API documentation using Swagger UI.

The API specification is Swagger 2.0 (Open API) specification, served out of the Customer service as a separate resource.

How To Use
----------

1. Run the customer service (follow instructions in subfolder README)

2. Check manually the service is serving the API specification:

GET http://localhost:8090/api-doc

2. Go to:

http://petstore.swagger.io/

3. Change URL in top bar to:

http://localhost:8090/api-doc

4. Hit 'Explore' and expand 'default'. You should see the operations on Customer.

5. Have a play with each operation. These work against the deployed service.


Details
-------

The Swagger spec is defined in swagger-customer-api/src/main/resources/api.json