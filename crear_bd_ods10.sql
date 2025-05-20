-- Crear base de datos
CREATE DATABASE IF NOT EXISTS ods10_db;

-- Usar la base de datos
USE ods10_db;

-- Crear tabla necesidades
CREATE TABLE IF NOT EXISTS necesidades (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre_persona VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    grupo_vulnerable VARCHAR(50) NOT NULL,
    descripcion TEXT NOT NULL,
    fecha_registro DATETIME DEFAULT CURRENT_TIMESTAMP
);