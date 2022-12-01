-- -----------------------------------------------------
-- Schema deemodb
-- -----------------------------------------------------
CREATE DATABASE deemodb;

USE deemodb;

-- -----------------------------------------------------
-- Table  clientes
-- -----------------------------------------------------
CREATE TABLE clientes (
  id_cadastro INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255) NOT NULL,
  cpf VARCHAR(14) NOT NULL,
  email VARCHAR(255) NOT NULL,
  rua VARCHAR(255) NOT NULL,
  bairro VARCHAR(255) NOT NULL,
  telefone VARCHAR(255) NOT NULL,
  cep VARCHAR(255) NOT NULL,
  cidade VARCHAR(255) NOT NULL,
  PRIMARY KEY (id_cadastro)
);

-- -----------------------------------------------------
-- Table  fornecedores
-- -----------------------------------------------------
CREATE TABLE fornecedores (
  id_fornecedor INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255) NOT NULL,
  cnpj VARCHAR(255) NOT NULL,
  telefone VARCHAR (255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  PRIMARY KEY (id_fornecedor, cnpj)
);

-- -----------------------------------------------------
-- Table  produtos
-- -----------------------------------------------------
CREATE TABLE produtos (
  id_produto INT NOT NULL AUTO_INCREMENT,
  modelo VARCHAR(255) NOT NULL,
  tamanho INT NOT NULL,
  cor VARCHAR(255) NOT NULL,
  marca VARCHAR(255) NOT NULL,
  preco DOUBLE NOT NULL,
  quantidade INT NOT NULL,
  fornecedores_id_fornecedor INT NOT NULL,
  PRIMARY KEY (id_produto, fornecedores_id_fornecedor),
  FOREIGN KEY (fornecedores_id_fornecedor) REFERENCES fornecedores (id_fornecedor)
);

-- -----------------------------------------------------
-- Table  usuario
-- -----------------------------------------------------
CREATE TABLE usuario (
  id_usuario INT NOT NULL AUTO_INCREMENT,
  login VARCHAR(255) NOT NULL,
  senha VARCHAR(255) NOT NULL,
  nome VARCHAR(255) NOT NULL,
  PRIMARY KEY (id_usuario)
);

-- -----------------------------------------------------
-- Table  venda
-- -----------------------------------------------------
CREATE TABLE venda (
  id_venda INT NOT NULL AUTO_INCREMENT,
  preco DOUBLE NOT NULL,
  data VARCHAR(50) NOT NULL,
  usuario_id_usuario INT NOT NULL,
  clientes_id_cadastro INT NOT NULL,
  PRIMARY KEY (
    id_venda,
    usuario_id_usuario,
    clientes_id_cadastro
  ),
  FOREIGN KEY (usuario_id_usuario) REFERENCES usuario (id_usuario),
  FOREIGN KEY (clientes_id_cadastro) REFERENCES clientes (id_cadastro)
);

-- -----------------------------------------------------
-- Table  venda_has_produtos
-- -----------------------------------------------------
CREATE TABLE venda_has_produtos (
  venda_id_venda INT NOT NULL,
  produtos_id_produto INT NOT NULL,
  PRIMARY KEY (venda_id_venda, produtos_id_produto),
  FOREIGN KEY (venda_id_venda) REFERENCES venda (id_venda),
  FOREIGN KEY (produtos_id_produto) REFERENCES produtos (id_produto)
);

create table estoque(
  id_estoque int not null auto_increment primary key,
  id_fornecedor int not null,
  id_produto int not null,
  quantidade int not null,
  valor varchar(50) not null,
  data varchar(50)
);