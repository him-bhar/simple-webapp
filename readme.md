Table of Contents

1. [Servlet-3 based simple web-application](#Servlet-3-based-simple-web-application)
   1. [Features available](#Features-available)
      1. [Servlet-3 compliant](Servlet-3-compliant)
      1. [No web.xml](#No-web.xml)
      1. [In memory tomcat for integration tests for war file](#In-memory-tomcat-for-integration-tests-for-war-file)
   1. [Angular JS Integration](#Angular-JS-Integration)
      1. [Sample angular JS integration](#Sample-angular-JS-integration)
   1. [Swagger API Documentation](#Swagger API Documentation)
      1. [Where is the swagger json?](#Where is the swagger json?)
      1. [CORS Issue?](#CORS Issue?)
      
# Servlet-3 based simple web-application
## Features available
1. ### Servlet-3 compliant:
   Supports web application running on tomcat-7 and tomcat-8.
1. ### No web.xml
   This is a complete **no XML solution**, everything is managed via servlet-3 annotations.
1. ### In memory tomcat for integration tests for war file
   There is a clear demarcation available for unit and integration tests (look how maven-surefire-plugin is configured) and also maven-tomcat-plugin added to run integration tests.
## Angular JS Integration
_Currently integrates with ver. 1.6.9_
1. ### Sample angular JS integration
   `index.html` provides a sample integration with Angular JS.
## Swagger API Documentation
_Currently integrates with ver. 1.5.22_
1. ### Where is the swagger json?
   Deploy the application onto the tomcat server, and swagger.json can be located at the following uri:
   `http://<tomcat host>:<tomcat port>/<context>/api/swagger.json`
1. ### CORS Issue?
   Swagger provided its own CORSFilter in the sample code, which didn't work on tomcat (tried on ver. 8.0.33). To get it working rather used tomcat's provided CORS Filter. `org.apache.catalina.filters.CorsFilter`
   