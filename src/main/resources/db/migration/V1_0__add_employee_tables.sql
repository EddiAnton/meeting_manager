--
-- Добавляем таблицу Сотрудник
--

DROP TABLE IF EXISTS employee;

CREATE TABLE employee
(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    date_of_birth DATE,
    email VARCHAR(64),
    login VARCHAR(255),
    password VARCHAR(255),
    role VARCHAR(255),
    status VARCHAR(255),
    department_id INT
);

COMMENT ON TABLE employee IS 'Таблица сотрудников';
COMMENT ON COLUMN employee.id IS 'Идентификатор записи';
COMMENT ON COLUMN employee.name IS 'Имя сотрудника';
COMMENT ON COLUMN employee.date_of_birth IS 'День рождения сотрудника';
COMMENT ON COLUMN employee.email IS 'Электронная почта сотрудника';
COMMENT ON COLUMN employee.department_id IS 'Идентификатор отдела, в котором работает сотрудник';

--
-- Добавляем таблицу Отдел
--

DROP TABLE IF EXISTS department;

CREATE TABLE department
(
    id BIGSERIAL PRIMARY KEY,
    department_name VARCHAR(255)
);

COMMENT ON TABLE department IS 'Таблица отделов';
COMMENT ON COLUMN department.id IS 'Идентификатор записи';
COMMENT ON COLUMN department.department_name IS 'Наименование отдела';
