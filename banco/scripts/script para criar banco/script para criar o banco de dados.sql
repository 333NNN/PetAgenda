CREATE DATABASE pet_agenda;

USE pet_agenda;

-- DROP DATABASE pet_agenda;

CREATE TABLE usuario (
	id_usuario INT PRIMARY KEY AUTO_INCREMENT,
    cpf CHAR(11) NOT NULL UNIQUE,
    nome_usuario VARCHAR(45) NOT NULL,
    senha_usuario VARCHAR(25) NOT NULL,
    permissao ENUM('1', '2', '3') NOT NULL,
    codigo_recup VARCHAR(4) NOT NULL UNIQUE
);

CREATE TABLE funcionario (
	id_func INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(64) NOT NULL,
    cpf CHAR(11) NOT NULL UNIQUE,
    telefone VARCHAR(15) NOT NULL,
    rua VARCHAR(64) NOT NULL,
    cep CHAR(8) NOT NULL,
    numero VARCHAR(16) NOT NULL,
    bairro VARCHAR(64) NOT NULL,
    cidade VARCHAR(64) NOT NULL
);

CREATE TABLE servico (
	id_servico INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(64) NOT NULL,
    preco DECIMAL(8, 2) NOT NULL,
    descricao VARCHAR(200)
);

CREATE TABLE cliente (
	id_cliente INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(64) NOT NULL,
    cpf CHAR(11) NOT NULL UNIQUE,
    telefone VARCHAR(15) NOT NULL,
    rua VARCHAR(64) NOT NULL,
    numero VARCHAR(16) NOT NULL,
    bairro VARCHAR(64) NOT NULL,
    cidade VARCHAR(64) NOT NULL,
    cep CHAR(8) NOT NULL
);

CREATE TABLE cliente_contrata_servico (
	id_servico INT,
    id_cliente INT,
    FOREIGN KEY (id_servico) REFERENCES servico(id_servico),
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
);

CREATE TABLE pet (
	id_pet INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(64) NOT NULL,
    raca VARCHAR(45) NOT NULL,
    sexo ENUM("M", "F") NOT NULL,
    porte ENUM("Pequeno", "Médio", "Grande") NOT NULL,
    comportamento VARCHAR(80) NOT NULL,
    e_castrado BIT(1) NOT NULL,
    caminho_cartao_vacinacao VARCHAR(255) NOT NULL,
    estado_saude VARCHAR(80) NOT NULL,
    cor VARCHAR(16) NOT NULL,
    id_cliente INT,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
);

CREATE TABLE agendamento (
	id_agendamento INT PRIMARY KEY AUTO_INCREMENT,
    dt_hr_marcada DATETIME NOT NULL,
    endereco_pet VARCHAR(255) NOT NULL,
    qnt_passeios INT NOT NULL,
    dta_hr_iniciado DATETIME NOT NULL,
    dta_hr_finalizado DATETIME NOT NULL,
    check_entrega TINYINT NOT NULL,
    observacao VARCHAR(255),
    id_servico INT,
    id_func INT,
    FOREIGN KEY (id_servico) REFERENCES servico(id_servico),
    FOREIGN KEY (id_func) REFERENCES funcionario(id_func)
);

CREATE TABLE pet_agendamento (
	id_agendamento_pet INT,
    id_pet_agend INT,
    FOREIGN KEY (id_agendamento_pet) REFERENCES agendamento(id_agendamento),
    FOREIGN KEY (id_pet_agend) REFERENCES pet(id_pet)
);

CREATE TABLE remedio_agend (
	id_remedio_agend INT PRIMARY KEY AUTO_INCREMENT,
	nome_remedio VARCHAR(64),
    hr_administrar TIME,
    instrucoes VARCHAR(120),
    id_agendamento INT,
    FOREIGN KEY (id_agendamento) REFERENCES agendamento(id_agendamento)
);

CREATE TABLE hr_alim_agend (
	id_hr_alim_agend INT PRIMARY KEY,
    horario TIME NOT NULL,
    id_agendamento INT,
    FOREIGN KEY (id_agendamento) REFERENCES agendamento(id_agendamento)
);

CREATE TABLE incidente (
	id_incidente INT PRIMARY KEY AUTO_INCREMENT,
    data_hora DATETIME NOT NULL,
    e_emergencia BIT(1) NOT NULL,
    descricao VARCHAR(200),
    id_pet INT,
    id_servico INT,
    id_agendamento INT,
    FOREIGN KEY (id_pet) REFERENCES pet(id_pet),
    FOREIGN KEY (id_servico) REFERENCES servico(id_servico),
    FOREIGN KEY (id_agendamento) REFERENCES agendamento(id_agendamento)
);
