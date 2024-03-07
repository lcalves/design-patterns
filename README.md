
# Project

Design Patterns is a project suggested from [Digital Innovation One](https://dio.me) for to practice some Design Patterns as a Singleton, Factory and Strategy using Java and the Spring Boot framework.

# Implementation
This project just has one API to do a CRUD and implement Onion Architecture working with DTO in externals layers and the model with restricted access. Another care is that the ID isn't exposted and the access to the data is with registration that is generated when the new client is created.

# How to use?
For using this project is necessery Java 17, Maven and some IDE to run this app or if you want to run without IDE in a terminal execute ```mvn clean install -U && mvn exec:java -Dexec.mainClass="br.com.lcalves.designpatterns.DesignPatternsApplication"```

Access ```http://localhost:8080/swagger-ui/index.html#/``` and use this page to

- POST - to create a new client
- GET - to list all clients
- DELETE - with {registration} to delete the client
- GET - with {registration} to find a specific client