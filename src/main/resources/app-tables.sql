-- Crear la tabla de usuarios
CREATE TABLE IF NOT EXISTS usuarios (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    usuario TEXT NOT NULL UNIQUE,
    email TEXT NOT NULL UNIQUE CHECK(email LIKE '%@%'),
    contrasenia TEXT NOT NULL
);

-- Insertar un usuario de ejemplo
INSERT INTO usuarios (usuario, email, contrasenia) 
VALUES 
('ejemploUser', 'ejemplo@example.com', 'password123');

-- Consultar usuarios
SELECT * FROM usuarios;
