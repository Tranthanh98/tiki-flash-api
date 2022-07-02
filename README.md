# tikiFlash
The restfull api with java spring.

How to run on dev environment

A. Setup development env

1. Install openjdk 11

2. Install Apache Maven 3.8.1

3. Install docker (optional) if you want to run with docker.

4. Install vs studio code and https://marketplace.visualstudio.com/items?itemName=Pivotal.vscode-boot-dev-pack and https://marketplace.visualstudio.com/items?itemName=pverest.java-ide-pack

5. (optional) Install https://www.jetbrains.com/idea/ or eclipse + spring boot plugin or choose you best tool here  https://spring.io/tools

6. Install mysql and create database tikiFlash

7. Create new setting file application-dev.properties

   7.1. Copy the setting from application.properties and uncomment migration and mssql setting

   7.2. Set server.port = 9000

   7.3. Update your database username and password

   7.4  Add jwt setting

   ####### resource server configuration properties
   spring.security.oauth2.resourceserver.jwt.issuer-uri: http://localhost:8080/auth/realms/docsoupdev

   7.5 Add the credentials access key and secret key of the aws cloud
   ###### the configuration properties
   cloud.aws.credentials.access-key=
   cloud.aws.credentials.secret-key=

B. Run
1. Run with debug

mvn spring-boot:run --debug

2. Swagger
   http://localhost:9000/api/swagger-ui.html

2. Run with docker

docker-compose up --build

Test Environment


1. Url = http://ec2-18-139-221-206.ap-southeast-1.compute.amazonaws.com/health

