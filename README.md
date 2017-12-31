# spring-restapi-hibernate
A simple java REST API using spring framework and maven integrated with the Hibernate ORM. 

See `com.spring.rest.config.AppConfig.java` for all the hibernate and database related configuratons.
`com.spring.rest.config.WebInitializer.java` is the replacement for XML file with servlet mappings.

### prerequisites
1. Java 1.8
2. Maven 3.5.2
3. Tomcat 7
4. Postgresql 42.1.4
5. A proper JavaEE IDE (I'm using Eclipse Luna)
6. SOAP UI or any REST testing tools for testing the services

### setup
1. Clone this project
2. Open as maven project
3. Update maven dependencies
4. Create database using details from entity class ` com.spring.rest.model.Employee.java`
5. Run using Tomcat Application server
6. Use the below URLs to call services. (For POST and PUT, give the request JSON in the body and Content-Type as "application/json"  while testing) 

	List all employees (GET) : http://localhost:8080/SpringHibernateRestApi/getEmployeeList
	Get employee by id (GET) : http://localhost:8080/SpringHibernateRestApi/get?id=
	Add employee (POST) : http://localhost:8080/SpringHibernateRestApi/add
	Update employee (PUT) : http://localhost:8080/SpringHibernateRestApi/update
	Delete employee (GET) : http://localhost:8080/SpringHibernateRestApi/delete?id=

### code style formatter
[Spring Boot Java Conventions](https://gist.github.com/jyotsnasanthosh/e2fb456f0ff91aa42ad8203e148bff79)
Save this as xml and import into eclipse -> window -> preferences -> java -> code style -> formatter