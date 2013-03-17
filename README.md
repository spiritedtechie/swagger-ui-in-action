swagger-examples
================

My experiments with Wordnik Swagger. 

How To Use:

1. Install an Apache HTTP Server running on localhost:80
2. Symlink our Swagger Specification directory (api-spec) to the Apache service directory (/var/www/api-spec)
3. Verify the specification is being served:
  
    http://localhost:80/api-spec/api.json
    http://localhost:80/api-spec/customer
  
4. Get yourself the Swagger UI from here: https://github.com/wordnik/swagger-ui
5. Change the properties in the Swagger UI src index.html, then rebuild Swagger UI:
  
    discoveryUrl:"http://localhost:80/api-spec/api.json",
    apiKey:"",
    supportHeaderParams: true,
    supportedSubmitMethods: ['get', 'post', 'put', 'delete']

6. Symlink the rebuilt Swagger UI dist directory to /var/www/swagger-ui
7. Verify the Swagger UI is being served

    http://localhost:80/swagger-ui

8. Have a JBoss 7 instance running on port 8080
9. Build swagger-customer-api and deploy to JBoss 7 standalone
10. Very the Swagger UI Try-It-Out feature works by performing CRUD operations on the Customer resource.
