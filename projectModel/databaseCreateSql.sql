/**
 * @author Pedro Gregório
 * @description Tabela responsável gela gerência de todas as pessoas 
 * envolvidas, no sistema. Dentre os tipos de pessoas existentes 
 * estão médicos, pacientes, operadores e administradores.
 *
 * @primarykey id_pessoa
 * @foreignkey Não possui
 */
CREATE TABLE imed_pessoa(
  id_pessoa int(10) NOT NULL AUTO_INCREMENT,
  str_nome varchar(45) NOT NULL,
  dta_nascimento DATETIME,
  chr_sexo char(1),
  num_telefone int,
  num_fax int,
  str_email varchar(80) NOT NULL,
  num_cep int,
  str_uf varchar(45),
  str_cidade varchar(45),
  str_endereco varchar(255),
  num_endereco int,
  str_bairro varchar(45),
  num_rg int,
  str_cpf varchar(11),
  PRIMARY KEY(id_pessoa)
);

/**
 * @author Pedro Gregório
 * @description Tabela responsável pela gerência das instituições
 * que serão cadastradas ao longo do tempo no sistema.
 *
 * @primarykey id_instituicao 
 * @foreignkey Não possui
 */
CREATE TABLE imed_instituicao(
  id_instituicao int(10) NOT NULL AUTO_INCREMENT,
  str_nome varchar(45) NOT NULL,
  str_descricao varchar(255),
  num_telefone int,
  num_fax int,
  str_email varchar(45) NOT NULL,
  str_uf varchar(45),
  str_cidade varchar(45),
  str_endereco varchar(255),
  str_bairro varchar(45),
  num_endereco int,
  PRIMARY KEY(id_instituicao)
);

/**
 * @author Pedro Gregório
 * @description Tabela responsável pelo armazenamento dos médicos    
 * presentes no sistema. Lembrando que um médico é um pessoa    
 * relacionada a uma instituição.
 *
 * @primarykey id_medico
 * @foreignkey id_instituicao
 * @foreignkey id_pessoa
 */
CREATE TABLE imed_medico(
  id_medico int(10) NOT NULL,
  id_instituicao int(10) NOT NULL,
  id_pessoa int(10) NOT NULL,
  PRIMARY KEY(id_medico),
  FOREIGN KEY(id_pessoa) REFERENCES imed_pessoa(id_pessoa),
  FOREIGN KEY(id_instituicao) REFERENCES imed_instituicao(id_instituicao)
);

/**
 * @author Pedro Gregório
 * @description Tabela responsável pelo armazenamento das     
 * especialidades que um ou mais médicos podem conter.
 *
 * @primarykey id_especialidade 
 * @foreignkey Não possui
 */
CREATE TABLE imed_especialidade(
  id_especialidade int(10) NOT NULL AUTO_INCREMENT,
  str_nome varchar(45) NOT NULL,
  str_descricao varchar(255),
  PRIMARY KEY(id_especialidade)
);

/**
 * @author Pedro Gregório
 * @description Tabela responsável pelo relacionamento do médico com 
 * uma ou mais especialidades.
 *
 * @primarykey (id_medico, id_especialidade)
 * @foreignkey id_medico
 * @foreignkey id_especialidade
 */
CREATE TABLE imed_medico_especialidade(
  id_medico int(10) NOT NULL,
  id_especialidade int(10) NOT NULL,
  PRIMARY KEY(id_medico ,id_especialidade),
  FOREIGN KEY(id_medico) REFERENCES imed_medico(id_medico),
  FOREIGN KEY(id_especialidade) REFERENCES imed_especialidade(id_especialidade)
);

INSERT INTO imed_permissao(str_nome,str_descricao) VALUES('ADMINISTRADOR','Permiss?o a todas as opera??se do sistema');
INSERT INTO imed_pessoa(str_nome,str_email) VALUES('ADMIN','admin@imed.com.br');
INSERT INTO imed_usuario(str_senha,id_pessoa,id_permissao) VALUES('ebe7f15496a192cad2090b8ce90e131b8763d984',1,1); -- imagemmed-2014

/**
 * @author Pedro Gregório
 * @description Tabela responsável por armazenar as diferentes 
 * permissões de acesso ao sistema.
 *
 * @primarykey id_permissao 
 * @foreignkey Não possui
 */
CREATE TABLE imed_permissao(
  id_permissao int(10) NOT NULL AUTO_INCREMENT,
  str_nome varchar(45) NOT NULL,
  str_descricao varchar(255),
  PRIMARY KEY(id_permissao)
);


/**
 * @author Pedro Gregório
 * @description Tabela responsável por gerenciar todos os usuários 
 * presentes no sistema junto a suas credênciais. 
 *
 * @primarykey id_usuario
 * @foreignkey id_pessoa
 * @foreignkey id_permissao 
 */
CREATE TABLE imed_usuario(
  id_usuario int(10) NOT NULL AUTO_INCREMENT,
  str_senha varchar(255) NOT NULL,
  id_pessoa int(10) NOT NULL,
  id_permissao int(10) NOT NULL,
  PRIMARY KEY(id_usuario),
  FOREIGN KEY(id_pessoa) REFERENCES imed_pessoa(id_pessoa),
  FOREIGN KEY(id_permissao) REFERENCES imed_permissao(id_permissao)
);

/**
 * @author Pedro Gregório
 * @description Tabela responsável pelo armazenamento dos pacientes. 
 * Ele não é relacionado a uma instituição pois terá seus dados 
 * acessados por diferentes médicos(Diagnóstico remoto).
 *
 * @primarykey id_paciente 
 * @foreignkey id_pessoa
 */
CREATE TABLE imed_paciente(
  id_paciente int(10) NOT NULL AUTO_INCREMENT,
  id_pessoa int(10) NOT NULL,
  PRIMARY KEY(id_paciente),
  FOREIGN KEY(id_pessoa) REFERENCES imed_pessoa(id_pessoa)
);

/**
 * @author Pedro Gregório
 * @description Tabela responsável pelo armazenamento dos diferentes 
 * tipos de imagem que podem ser enviadas ao sistema.
 *
 * @primarykey id_tipo_imagem
 */
CREATE TABLE imed_tipo_imagem(
  id_tipo_imagem int(10) NOT NULL AUTO_INCREMENT,
  str_nome varchar(45) NOT NULL,
  str_descricao varchar(255) NOT NULL,
  PRIMARY KEY(id_tipo_imagem)
);

/**
 * @author Pedro Gregório
 * @description Tabela responsável pelo armazenamento das imagens de  
 * um paciente. Lembrando que a imagem física será gravada no sistema 
 * de arquivos. Essa tabela armazena apenas o seu path físico.
 *
 * @primarykey id_imagem 
 * @foreginkey id_paciente
 * @foreginkey id_tipo_imagem
 */
CREATE TABLE imed_paciente_imagem(
  id_imagem int(10) NOT NULL AUTO_INCREMENT,
  id_paciente int(10) NOT NULL,
  id_tipo_imagem int(10) NOT NULL,
  str_caminho_fisico varchar(255) NOT NULL,
  str_descricao varchar(255),
  PRIMARY KEY(id_imagem),
  FOREIGN KEY(id_paciente) REFERENCES imed_paciente(id_paciente),
  FOREIGN KEY(id_tipo_imagem) REFERENCES imed_tipo_imagem(id_tipo_imagem)
);

/**
 * @author Pedro Gregório
 * @description Tabela responsável pelo armazenamento dos tipos de 
 * exames.
 *
 * @primarykey id_exame 
 */
CREATE TABLE imed_exame (
  id_exame int(10) NOT NULL AUTO_INCREMENT,
  str_nome varchar(45) NOT NULL,
  str_descricao varchar(255),
  PRIMARY KEY(id_exame)
);

/**
 * @author Pedro Gregório
 * @description Tabela responsável pelo armazenamento dos tipos de 
 * doenças.
 *
 * @primarykey id_doenca 
 */
CREATE TABLE imed_doenca (
  id_doenca int(10) NOT NULL AUTO_INCREMENT,
  str_nome varchar(45) NOT NULL,
  str_descricao varchar(255),
  PRIMARY KEY(id_doenca)
);

/**
 * @author Pedro Gregório
 * @description Tabela responsável pela relação de um paciente com 
 * uma ou mais doenças.
 *
 * @primarykey (id_paciente,id_doenca)
 * @foreginkey id_paciente
 * @foreginkey id_doenca
 */
CREATE TABLE imed_paciente_doenca(
  id_paciente int(10) NOT NULL,
  id_doenca int(10) NOT NULL,
  PRIMARY KEY(id_paciente,id_doenca),
  FOREIGN KEY(id_paciente) REFERENCES imed_paciente(id_paciente),
  FOREIGN KEY(id_doenca) REFERENCES imed_doenca(id_doenca));

/**
 * @author Pedro Gregório
 * @description Tabela responsável pela relação de um paciente com 
 * uma ou mais exames.
 *
 * @primarykey (id_paciente,id_exame)
 * @foreginkey id_paciente
 * @foreginkey id_exame
 */
CREATE TABLE imed_paciente_exame(
  id_paciente int(10) NOT NULL,
  id_exame int(10) NOT NULL,
  str_observacao varchar(255),
  PRIMARY KEY(id_paciente,id_exame),
  FOREIGN KEY(id_paciente) REFERENCES imed_paciente(id_paciente),
  FOREIGN KEY(id_exame) REFERENCES imed_exame(id_exame)
);

/**
 * @author Pedro Gregório
 * @description Tabela responsável pelo armazenamento de parentes do 
 * paciente.
 *
 * @primarykey (id_paciente,id_pessoa)
 * @foreginkey id_paciente
 * @foreginkey id_pessoa
 */
CREATE TABLE imed_paciente_parente(
  id_paciente int(10) NOT NULL,
  id_pessoa int(10) NOT NULL,
  str_historico varchar(255),
  PRIMARY KEY(id_paciente,id_pessoa),
  FOREIGN KEY(id_paciente) REFERENCES imed_paciente(id_paciente),
  FOREIGN KEY(id_pessoa) REFERENCES imed_pessoa(id_pessoa)
);

/**
 * @author Pedro Gregório
 * @description Tabela responsável pelo armazenamento de diagnósticos 
 * fornecidos a um paciente por um médico do sistema.
 *
 * @primarykey (id_paciente,id_medico)
 * @foreginkey id_paciente
 * @foreginkey id_medico
 */
CREATE TABLE imed_paciente_diagnostico(
  id_paciente int(10) NOT NULL,
  id_medico int(10) NOT NULL,
  str_descricao varchar(255),
  PRIMARY KEY(id_paciente,id_medico),
  FOREIGN KEY(id_paciente) REFERENCES imed_paciente(id_paciente),
  FOREIGN KEY(id_medico) REFERENCES imed_medico(id_medico)
);

/**
 * @author Pedro Gregório
 * @description Tabela responsável pelo armazenamento de notas do 
 * caso de um paciente.
 *
 * @primarykey (id_paciente,id_medico)
 * @foreginkey id_paciente
 * @foreginkey id_medico
 */
CREATE TABLE imed_paciente_nota(
  id_nota int(10) NOT NULL AUTO_INCREMENT,
  id_paciente int(10) NOT NULL,
  str_descricao varchar(255),
  PRIMARY KEY(id_nota),
  FOREIGN KEY(id_paciente) REFERENCES imed_paciente(id_paciente)
);
