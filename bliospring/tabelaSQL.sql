create table alunos (
id BIGINT NOT NULL AUTO_INCREMENT,
nome VARCHAR(255),
matricula VARCHAR(255),
cpf VARCHAR(255),
endereco VARCHAR(255),
dataNascimento DATE,
md3 int,
primary key (id)
);


create table livros (
id BIGINT NOT NULL AUTO_INCREMENT,
titulo VARCHAR(255),
autor VARCHAR(255),
editora VARCHAR(255),
anoEdicao VARCHAR(255),
anoPublicacao int,
emprestavel bool,
primary key (id)
);



create table emprestimos (
id BIGINT NOT NULL AUTO_INCREMENT,
aluno bigint,
livro bigint,
dataEmprestimo DATE,
dataDevolucao DATE,
primary key (id),
foreign key (aluno) references alunos(id),
foreign key (livro) references livros(id)
);