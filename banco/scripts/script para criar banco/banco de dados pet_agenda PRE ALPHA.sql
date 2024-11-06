CREATE DATABASE pet_agenda;

USE pet_agenda;

DROP DATABASE pet_agenda;

CREATE TABLE usuario (
	id_usuario INT PRIMARY KEY AUTO_INCREMENT,
    cpf CHAR(11) NOT NULL,
    nome_usuario VARCHAR(45) NOT NULL,
    senha_usuario VARCHAR(25) NOT NULL,
    permissao INT(11) NOT NULL
);

CREATE TABLE funcionario (
	id_func INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(64) NOT NULL,
    cpf CHAR(11) NOT NULL,
    rua VARCHAR(45) NOT NULL,
    cep CHAR(8) NOT NULL,
    numero VARCHAR(16) NOT NULL,
    cidade VARCHAR(32) NOT NULL,
    telefone VARCHAR(12) NOT NULL,
    local_de_atuacao VARCHAR(45) NOT NULL
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
    rua VARCHAR(45) NOT NULL,
    numero VARCHAR(16) NOT NULL,
    bairro VARCHAR(32) NOT NULL,
    cidade VARCHAR(32) NOT NULL,
    cep CHAR(8) NOT NULL,
    telefone VARCHAR(12) NOT NULL,
    cpf CHAR(11) NOT NULL,
    check_entrega TINYINT NOT NULL,
    buscar_com VARCHAR(64),
    devolver_para VARCHAR(64),
    id_servico INT,
    FOREIGN KEY (id_servico) REFERENCES servico(id_servico)
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
    estado_saude VARCHAR(80)NOT NULL,
    cor VARCHAR(16) NOT NULL,
    id_cliente INT,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
);

CREATE TABLE agendamento (
	id_agendamento INT PRIMARY KEY AUTO_INCREMENT,
    dt_hr_marcada DATETIME NOT NULL,
    endereco_pet VARCHAR(255) NOT NULL,
    qnt_passeios INT NOT NULL,
    observacao VARCHAR(255),
    pet_buscar_com VARCHAR(64),
    pet_devolver_para VARCHAR(64),
    local_cuidado VARCHAR(255),
    id_servico INT,
    id_pet INT,
    id_func INT,
    FOREIGN KEY (id_servico) REFERENCES servico(id_servico),
    FOREIGN KEY (id_pet) REFERENCES pet(id_pet),
    FOREIGN KEY (id_func) REFERENCES funcionario(id_func)
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
	id_hr_alim_agend TIME PRIMARY KEY,
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
    FOREIGN KEY (id_pet) REFERENCES pet(id_pet),
    FOREIGN KEY (id_servico) REFERENCES servico(id_servico)
);

CREATE TABLE historico_servico (
	id_historico_servico INT PRIMARY KEY AUTO_INCREMENT,
    dt_hora_iniciado DATETIME NOT NULL,
    dt_hr_finalizado DATETIME NOT NULL,
    caminho_anexo VARCHAR(200) NOT NULL,
    id_incidente INT,
    id_agendamento INT,
	FOREIGN KEY (id_incidente) REFERENCES incidente(id_incidente),
    FOREIGN KEY (id_agendamento) REFERENCES agendamento(id_agendamento)
);

CREATE TABLE financeiro (
	id_financeiro INT PRIMARY KEY AUTO_INCREMENT,
    relatorio_dia DECIMAL(8, 2) NOT NULL,
    relatorio_semanal DECIMAL(8, 2) NOT NULL,
    relatorio_mes DECIMAL(8, 2) NOT NULL,
    relatorio_anual DECIMAL(8, 2) NOT NULL,
    id_historico_servico INT,
    FOREIGN KEY (id_historico_servico) REFERENCES historico_servico(id_historico_servico)
);
