swagger-in-action
=================

Working example of API documentation using Wordnik Swagger. 

How To Use
----------

1. Install an Apache HTTP Server running on localhost:80

2. Symlink (or copy) the Swagger Specification directory (api-spec) to the Apache service directory (/var/www/api-spec)

3. Verify the specification is being served:
  
    http://localhost:80/api-spec/api.json
  
4. Grab the Swagger UI from here: https://github.com/wordnik/swagger-ui

    git clone git@github.com:wordnik/swagger-ui.git
    (or just download the zip directly).
    
5. Symlink the Swagger UI dist directory to /var/www/swagger-ui

   sudo ln -s /opt/swagger-ui/dist /var/www/swagger-ui

6. Verify the Swagger UI is being served

    http://localhost/swagger-ui/index.html
    
7. Change the API specification location from the default Petstore example to the following:

   http://localhost/api-spec/api.json

8. Have a JBoss 7 instance running on port 8080

9. Build swagger-customer-api and deploy to JBoss 7 standalone

10. Verify the Swagger UI Try-It-Out feature by performing CRUD operations on the Customer resource.
