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


B. Run
1. open Mysql workbench and run this query: create database tikiFlash

2. run mvn flyway:migrate

3. on the root project, run this command: mvn spring-boot:run


