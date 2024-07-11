CREATE DATABASE pacientes_db;

USE pacientes_db;

CREATE TABLE formulario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    dni VARCHAR(20),
    nombres VARCHAR(50),
    apellidos VARCHAR(50),
    fecha_nacimiento DATE,
    sexo VARCHAR(300) COMMENT 'RadioButton/ComboBox',
    celular VARCHAR(20),
    email VARCHAR(50),
    direccion VARCHAR(100),
    colesterol VARCHAR(400) COMMENT 'Spinner',
    glucosa VARCHAR(400) COMMENT 'Spinner',
    hemoglobina VARCHAR(400)COMMENT 'Spinner',
    tipoSeguro VARCHAR(300) COMMENT 'ComboBox'

);
SELECT * FROM formulario;

INSERT INTO formulario (dni, nombres, apellidos, fecha_nacimiento, sexo, celular, email, direccion, colesterol, glucosa, hemoglobina, tipoSeguro) VALUES
('12345678', 'Juan', 'Pérez', '1985-05-10', 'Masculino', '987654321', 'juan.perez@mail.com', 'Av. Siempre Viva 123', '70', '25', '12', 'EsSalud'),
('23456789', 'María', 'González', '1990-08-15', 'Femenino', '987654322', 'maria.gonzalez@mail.com', 'Calle Falsa 456', '72', '26', '13', 'Privado'),
('34567890', 'Luis', 'Ramírez', '1975-11-20', 'Masculino', '987654323', 'luis.ramirez@mail.com', 'Jr. Puno 789', '68', '24', '11', 'EsSalud'),
('45678901', 'Ana', 'Lopez', '1980-02-28', 'Femenino', '987654324', 'ana.lopez@mail.com', 'Av. Arequipa 321', 75, '27', '14', 'Privado'),
('56789012', 'Carlos', 'Sanchez', '1995-12-05', 'Masculino', '987654325', 'carlos.sanchez@mail.com', 'Calle Luna 654', '69', '25', '12', 'EsSalud');