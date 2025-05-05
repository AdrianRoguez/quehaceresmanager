-- Crear tabla de usuarios
CREATE TABLE users (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    username TEXT NOT NULL UNIQUE,
    email TEXT NOT NULL UNIQUE,
    password TEXT NOT NULL,
    created_at DATE NOT NULL DEFAULT (DATE('now'))
);

-- Crear tabla de tareas
CREATE TABLE tasks (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    user_id INTEGER NOT NULL,
    title TEXT NOT NULL,
    subtitle TEXT,
    urgency TEXT NOT NULL CHECK (urgency IN ('BAJA', 'MEDIA', 'ALTA')),
    description TEXT,
    creation_date DATE NOT NULL,
    due_date DATE NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);