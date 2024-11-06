CREATE DATABASE pet_agenda;

USE pet_agenda;

CREATE TABLE usuario (
	id_usuario INT PRIMARY KEY AUTO_INCREMENT,
    cpf CHAR(11),
    nome_usuario VARCHAR(45),
    senha_usuario VARCHAR(25),
    permissao VARCHAR(45)
);

CREATE TABLE funcionario (
	id_func INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(64),
    cpf CHAR(11),
    rua VARCHAR(45),
    cep CHAR(8),
    numero VARCHAR(16),
    cidade VARCHAR(32),
    telefone VARCHAR(12),
    local_de_atuacao VARCHAR(45)
);

CREATE TABLE servico (
	id_servico INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(64),
    preco DECIMAL(8, 2),
    descricao VARCHAR(200)
);

CREATE TABLE cliente (
	id_cliente INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(64),
    rua VARCHAR(45),
    numero VARCHAR(16),
    bairro VARCHAR(32),
    cidade VARCHAR(32),
    cep CHAR(8),
    telefone VARCHAR(12),
    cpf CHAR(11),
    check_entrega TINYINT,
    buscar_com VARCHAR(64),
    devolver_para VARCHAR(64),
    id_servico INT,
    FOREIGN KEY (id_servico) REFERENCES servico(id_servico)
);

CREATE TABLE pet (
	id_pet INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(64),
    raca VARCHAR(45),
    sexo ENUM("M", "F"),
    porte ENUM("Pequeno", "Medio", "Grande"),
    comportamento VARCHAR(80),
    e_castrado BIT(1),
    caminho_cartao_vacinacao VARCHAR(255),
    estado_saude VARCHAR(80),
    cor VARCHAR(16),
    id_cliente INT,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
);

CREATE TABLE agendamento (
	id_agendamento INT PRIMARY KEY AUTO_INCREMENT,
    dt_hr_marcada DATETIME,
    endereco_pet VARCHAR(255),
    qnt_passeios INT,
    observacao VARCHAR(255),
    pet_buscar_com VARCHAR(64),
    pet_devolver_para VARCHAR(64),
    local_cuidado VARCHAR(255),
    id_servico INT,
    id_pet INT,
    id_funcionario INT,
    FOREIGN KEY (id_servico) REFERENCES servico(id_servico),
    FOREIGN KEY (id_pet) REFERENCES pet(id_pet),
    FOREIGN KEY (id_funcionario) REFERENCES funcionario(id_funcionario)
);

CREATE TABLE remedio_agend (
	id_remedio_agend VARCHAR(64),
    hr_administrar TIME,
    instrucoes VARCHAR(120),
    id_agendamento INT,
    FOREIGN KEY (id_agendamento) REFERENCES agendamento(id_agendamento)
);

CREATE TABLE hr_alim_agend (
	hr_alimentacao TIME PRIMARY KEY,
    id_agendamento INT,
    FOREIGN KEY (id_agendamento) REFERENCES agendamento(id_agendamento)
);

CREATE TABLE incidente (
	id_incidente INT PRIMARY KEY AUTO_INCREMENT,
    data_hora DATETIME,
    e_emergencia BIT(1),
    descricao TEXT,
    descricao VARCHAR(45),
    id_pet INT,
    id_servico INT,
    FOREIGN KEY (id_pet) REFERENCES pet(id_pet),
    FOREIGN KEY (id_servico) REFERENCES servico(id_servico)

);

CREATE TABLE historico_servico (
	id_historico_servico INT PRIMARY KEY AUTO_INCREMENT,
    dt_hora_iniciado DATETIME,
    dt_hr_finalizado DATETIME,
    id_incidente INT,
    id_agendamento INT,
	FOREIGN KEY (id_incidente) REFERENCES incidente(id_incidente),
    FOREIGN KEY (id_agendamento) REFERENCES agendamento(id_agendamento)
);

CREATE TABLE financeiro (
	id_financeiro INT PRIMARY KEY AUTO_INCREMENT,
    relatorio_dia DECIMAL(8, 2),
    relatorio_semanal DECIMAL(8, 2),
    relatorio_mes DECIMAL(8, 2),
    relatorio_anual DECIMAL(8, 2),
    id_historico_servico INT,
    FOREIGN KEY (id_historico_servico) REFERENCES historico_servico(id_historico_servico)
);

CREATE TABLE anexo_historico (
	caminho_anexo VARCHAR(255) PRIMARY KEY,
	nome VARCHAR(64),
    id_historico_servico INT,
    FOREIGN KEY (id_historico_servico) REFERENCES historico_servico(id_historico_servico)
);