CREATE SCHEMA IF NOT EXISTS tutorial_spring_database_1;

CREATE TABLE IF NOT EXISTS produtos (
  id SERIAL PRIMARY KEY,
  nome VARCHAR(255) NOT NULL,
  quantidade INTEGER NOT NULL,
  valor NUMERIC(15,2) NOT NULL,
  observacao TEXT
);







