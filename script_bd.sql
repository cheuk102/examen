CREATE DATABASE IF NOT EXISTS arredondo_bd;

USE arredondo_bd;

CREATE TABLE IF NOT EXISTS PERSON (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    apellido VARCHAR(255),
    fechaNacimiento DATE,
    puesto VARCHAR(255),
    sueldo DECIMAL(10, 2)
);

CREATE USER 'conexion'@'localhost' IDENTIFIED BY 'pa$$word';
GRANT ALL PRIVILEGES ON arredondo_bd.* TO 'conexion'@'localhost';
FLUSH PRIVILEGES;