Meeting-Manager-1-0.
Для развертывания приложения на локальной машине должны быть установлены:
--JavaSE(JRE)1.8.x--
--Apache Tomcat 8.5.x--
--СУБД Postgresql 42.2.x--

Сервер БД используется для процедур хранения, обработки и извлечения данных.
В качестве базы данных используется Postgresql. После развертывания приложения
необходимо создать базу данных и подключить ее к приложению внеся изменения в файл aplication.properties.

spring.datasource.url=${SPRING_DATASOURCE_URL:jdbc:postgresql://localhost:PORT/DB_NAME}
spring.datasource.username=${SPRING_DATASOURCE_USERNAME:USERNAME}
spring.datasource.password=${SPRING_DATASOURCE_PASSWORD:PASSWORD}

PORT, DB_NAME, USERNAME и PASSWORD необходимо заменить на действительные значения.

Для запуска приложения введите адрес (http://localhost:8080/index) в строке поиска браузера.

Первую версию приложения можно посмотреть по адресу:
https://meeting-manager-1-0.herokuapp.com/search_page


