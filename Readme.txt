CREATE TABLE meeting (id bigserial primary key, date_spending date, topic varchar(255), organized_department_id int, organized_employee_id int, foreign key (organized_department_id) references department(id), foreign key (organized_employee_id) references employee(id))

CREATE TABLE participants (meeting_id int, employee_id int, foreign key (meeting_id) references meeting(id), foreign key (employee_id) references employee(id))

CREATE TABLE department (id bigserial primary key, department_name varchar(255))

CREATE TABLE employee (id bigserial primary key, name varchar(255), date_of_birth date, department_id int, foreign key (department_id) references department(id))


