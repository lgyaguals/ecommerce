-- crear la base de datos antes de ejecutar el proyecto
CREATE SCHEMA ad_ecommerce CHARACTER SET utf8 COLLATE utf8_general_ci;

-- crear los roles despues de ejecutar el projecto;
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN'), ('ROLE_PROVIDER'), ('ROLE_USER');
