swagger-in-action
=================

Working example of try-it-out style API documentation using Wordnik Swagger. 

How To Use
----------

1. Install an Apache HTTP Server running on localhost:80

2. Symlink (or copy) the Swagger API specification directory (api-spec) to the Apache service directory (/var/www/api-spec)

3. Verify the API specification is being served:
  
    http://localhost:80/api-spec/api.json
  
4. Grab the Swagger UI from here: https://github.com/wordnik/swagger-ui

    git clone git@github.com:wordnik/swagger-ui.git
    
    (or just download the zip directly and extract)
    
5. Symlink/shortcut to the Swagger UI dist directory to /var/www/swagger-ui

   sudo ln -s /opt/swagger-ui/dist /var/www/swagger-ui

6. Verify the Swagger UI is being served

    http://localhost/swagger-ui/index.html
    
7. Change the API specification location on the Swagger UI top bar to the following:

   http://localhost/api-spec/api.json
   
   This should show the documentation for the Customer API, replacing the default Petstore API.

8. Have a JBoss 7 instance running on port 8080

   ${JBOSS_HOME}/bin/standalone.sh -b 0.0.0.0

9. Build swagger-customer-api and deploy the WAR to JBoss 7 standalone deployments

   mvn clean package

10. Check that the Swagger UI works by performing CRUD operations on the Customer resource.
