Table of Contents

1. [Servlet-3 based simple web-application](#Servlet-3-based-simple-web-application)
   1. [Features available](#Features-available)
      1. [Servlet-3 compliant](Servlet-3-compliant)
      1. [No web.xml](#No-web.xml)
      1. [In memory tomcat for integration tests for war file](#In-memory-tomcat-for-integration-tests-for-war-file)
   1. [Angular JS Integration](#Angular-JS-Integration)
      1. [Sample angular JS integration](#Sample-angular-JS-integration) 
      
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