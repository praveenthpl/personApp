# personApp
1.This spring boot application has an entry point Java class called PersonApplication.java with the public static void main(String[] args) method, which you can run to start the application.
2. I have l build a CRUD REST APIs using Spring Boot 2, JPA and H2 as a database. Following are five REST APIs (Controller handler methods) are created for Person resource and we will write Integration tests for all these REST APIs.
3. I have created five REST API and Testing could be done via  Postman Client

a) HTTP Method: POST 
Request URL: http://localhost:8080/api/v1/persons 

b. Get Person by ID REST API
HTTP Method: GET 
Request URL: http://localhost:8080/api/v1/persons/1

c). Get all persons REST API
HTTP Method: GET 
Request URL: http://localhost:8080/api/v1/persons

d). Update Person REST API
HTTP Method: GET 
Request URL: http://localhost:8080/api/v1/persons/7

e). Delete Person REST API
HTTP Method: DELETE 

Request URL: http://localhost:8080/api/v1/persons/11


4. Tools and Technologies Used
Spring Boot - 2.0.4.RELEASE
JDK - 1.8 or later
Spring Framework - 5.0.8 RELEASE
Hibernate - 5.2.17.Final
JPA
Maven - 3.2+
IDE - Eclipse or Spring Tool Suite (STS)

5.Junit Test
The spring-boot-starter-test “Starter” (in the test scope) contains the following provided libraries:
JUnit: The de-facto standard for unit testing Java applications.
Spring Test & Spring Boot Test: Utilities and integration test support for Spring Boot applications.
AssertJ: A fluent assertion library.
Hamcrest: A library of matcher objects (also known as constraints or predicates).
Mockito: A Java mocking framework.
JSONassert: An assertion library for JSON.
JsonPath: XPath for JSON.

6.Integration Testing REST APIs
I have written integration test for a rest service, we would want to launch the entire spring context.
While running the integration tests that start the embedded servlet containers, it is better to use WebEnvironment.RANDOM_PORT so that it won’t conflict with other running applications, especially in Continuous Integration (CI) environments where multiple builds run in parallel.
You can specify which configuration classes to use to build ApplicationContext by using the classes attribute of the @SpringBootTest annotation
