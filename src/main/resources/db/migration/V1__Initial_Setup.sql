-- V1__Initial_Setup.sql
CREATE TABLE livros (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    isbn VARCHAR(13) NOT NULL,
    ano_publicacao INT NOT NULL
);