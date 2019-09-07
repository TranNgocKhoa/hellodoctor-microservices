# Hello Doctor - Microservices architecture
 
![Architecture][architecture]

 
 ## How to import this project to IntelliJ IDEA
 
 I don't know how to do in other IDE but in IntelliJ IDEA, you could do following steps:
 
 1. Open project's folder
 2. On **Maven Toolbox**, click **(+)** button *(All Maven Projects)* and then choose `pom.xml` files.
 3. Waiting for IDE processing.
 
 ## How to deploy services on Docker
 
 1. Execute file **buildImages.bat** by `$ ./buildImages.bat`
 2. Execute `$ docker-compose up -d`
 
 ## How to run services on local
 
 Change profile of all projects to `local` except Config Server.
 
 Run in this order:
 
 
 1. Config Server
 
 2. Run command `docker-compose -f docker-compose-local.yml up -d`

 3. Discovery Server

 4. Api Gateway

 5. Remaining Services
 
 
## How to test API

Test Service is deployed on `localhost:8082`. So far, there is only one API is: http://localhost:8080/api/test/message

To access the API through **Gateway**, try http://localhost:8080/api/test/message

**Eureka** http://localhost:8761/

**Config Server** http://localhost:8888/discovery-server/default

---------------------------------------------

# Understanding the Hello Doctor Application

In this project, I will implement a system which could help users to find a good clinic near their location. I'm planning to use a Language Understanding service and a Map service to help me get a good or acceptable result.

### Common module

### Config Server

### Discovery Server

### API Gateway

### Auth

### Account Service

### Booking Service

### Location Service

### LU Service

## Wiki
Please check Wiki page: https://github.com/TranNgocKhoa/hello-doctor/wiki


---------
PRs are welcome!



[architecture]: https://github.com/TranNgocKhoa/hello-doctor/raw/master/images/mcr-arc.png "Architecture" 
