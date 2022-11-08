Meeting-Manager-2-0.
To deploy the application, the machine must have the following installed:
--JavaSE (JRE) 1.8.x--
--Apache Tomcat 8.5.x -
- Postgresql 42.2.x DBMS--

The database server is used for data storage, processing and retrieval procedures.
Postgresql is used as a database. After deploying the application
you need to create a database and connect it to the application by making changes
in the aplication.properties file.

spring.datasource.url = $ {SPRING_DATASOURCE_URL: jdbc: postgresql: // localhost: PORT / DB_NAME}
spring.datasource.username = $ {SPRING_DATASOURCE_USERNAME: USERNAME}
spring.datasource.password = $ {SPRING_DATASOURCE_PASSWORD: PASSWORD}

PORT, DB_NAME, USERNAME and PASSWORD must be replaced with valid values.

To configure the distribution of notifications, set the valid values ​​in the following
aplication.properties file fields:

spring.mail.username=username@gmail.com
spring.mail.password = password

username@gmail.com - your username
password - your password

The application is designed to work with the gmail.com mail server.

To run the application on your local machine, enter the address
(http: // localhost: 8080 / index) in the search bar.

The first version of the application can be viewed at:
https://meeting-manager-2-0.herokuapp.com/index



