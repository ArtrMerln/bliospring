package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import dao.ConnectionFactory;
import models.Aluno;


public class AlunoDAO {
	private Connection connection;

	public AlunoDAO() {
		connection = ConnectionFactory.getConnection();
	}

	public boolean inserir(Aluno aluno) {

		String sql = "insert into alunos (nome, matricula, cpf, endereco, dataNascimento, md3) values (?, ?, ?, ?, ?, 0);";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, aluno.getNome());
			stmt.setString(2, aluno.getMatricula());
			stmt.setString(3, aluno.getCpf());
			stmt.setString(4, aluno.getEndereco());
			stmt.setDate(5, new java.sql.Date(aluno.getDataNascimento().getTimeInMillis()));    
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	} //ADICIONA ALUNO

	public List<Aluno> getLista() {
		try {

			List<Aluno> alunos = new ArrayList<Aluno>();
			PreparedStatement stmt = connection.prepareStatement("select * from alunos");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Aluno aluno = new Aluno();
				aluno.setNome(rs.getString("nome"));
				aluno.setCpf(rs.getString("cpf"));
				aluno.setMatricula(rs.getString("matricula"));
				aluno.setEndereco(rs.getString("endereco"));
				aluno.setId(rs.getLong("id"));

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				aluno.setDataNascimento(data);

				alunos.add(aluno);
			}
			rs.close();
			stmt.close();
			return alunos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	} // LISTA OS ALUNOS. 

	
	
	

	public void remover(Aluno a) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from alunos where id=?;");
			stmt.setLong(1, a.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	} // REMOVE O ALUNO PELO ID. SIMPLES ASSIM

	public Aluno getAlunoByID(Long id) {
		try {

			Aluno aluno = null;
			PreparedStatement stmt = this.connection.prepareStatement("select * from alunos where id=?;");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				aluno = new Aluno();
				aluno.setId(rs.getLong("id"));
				aluno.setNome(rs.getString("nome"));
				aluno.setCpf(rs.getString("cpf"));
				aluno.setMatricula(rs.getString("matricula"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				aluno.setDataNascimento(data);
			}
			rs.close();
			stmt.close();
			return aluno;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public Aluno getAlunoByMatricula(String matricula) {
		try {

			Aluno aluno = null;
			PreparedStatement stmt = this.connection.prepareStatement("select * from alunos where matricula=?;");
			stmt.setString(1, matricula);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				aluno = new Aluno();
				aluno.setId(rs.getLong("id"));
				aluno.setNome(rs.getString("nome"));
				aluno.setCpf(rs.getString("cpf"));
				aluno.setMatricula(rs.getString("matricula"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				aluno.setDataNascimento(data);
			}
			rs.close();
			stmt.close();
			return aluno;
		} catch (SQLException e) {
			throw new RuntimeException(e);

		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	public List<Aluno> getLista3() {
		try {
			List<Aluno> alunos = new ArrayList<Aluno>();
			PreparedStatement stmt = connection.prepareStatement("select * from alunos");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Aluno aluno = new Aluno();
				if (rs.getInt("md3") >= 3 ) {
					continue;
				}//aqui ele checa se a variavel md3 está com 3 ou mais. se ela estiver o ALUNO NAO SERÁ LISTADO NA PARTE DE ADICIONAR EMPRESTIMO
				
				aluno.setNome(rs.getString("nome"));
				aluno.setCpf(rs.getString("cpf"));
				aluno.setMatricula(rs.getString("matricula"));
				aluno.setEndereco(rs.getString("endereco"));
				aluno.setId(rs.getLong("id"));
                aluno.setMd3(rs.getInt("md3")); // O MD3 SERÁ PASSADO DEPOIS 
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				aluno.setDataNascimento(data);

				alunos.add(aluno);
			}
			rs.close();
			stmt.close();
			return alunos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
//ESSA É A UNICA DIFERENÇA DA LISTAGEM NORMAL
	}
	
	
	
	
	
	
	
	// A VARIAVEL MD3 É A VARIAVEL QUE DIZ QUE O ALUNO TEM OU NAO TEM MAIS DE 3 LIVROS EMPRESTADOS. 
	//QUANDO O ALUNO PEGA UM LIVRO EMPRESTADO ADICIONA-SE À VARIAVEL MD3 +1 
	// QUANDO ELE TEM 3 LIVROS EMPRESTADOS ELE NAO APARECE NA ABA DE SELEÇÃO PARA EMPRESTIMO
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}