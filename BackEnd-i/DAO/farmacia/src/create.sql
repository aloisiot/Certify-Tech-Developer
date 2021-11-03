CREATE TABLE IF NOT EXISTS medicamentos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    laboratorio VARCHAR(100) NOT NULL,
    quantidade INT,
    preco DOUBLE NOT NULL
);