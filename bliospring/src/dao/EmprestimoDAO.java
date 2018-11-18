package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import models.Aluno;
import models.Emprestimo;
import models.Livro;

public class EmprestimoDAO {
	private Connection connection;

	public EmprestimoDAO() {
		connection = ConnectionFactory.getConnection();
	}

	public boolean inserir(Emprestimo emprestimo) {

		String query = "insert into emprestimos (aluno, livro, dataEmprestimo) values (?, ?, ?);";

		try {
			PreparedStatement p = connection.prepareStatement(query);

			Calendar calendario = Calendar.getInstance();
			Long calendarioEF = calendario.getTimeInMillis();

			p.setLong(1, emprestimo.getAluno().getId());
			p.setLong(2, emprestimo.getLivro().getId());
			p.setDate(3, new java.sql.Date(calendarioEF));
			// p.setDate(4, new java.sql.Date(calendarioEF));

			p.execute();
			p.close();
			System.out.println("emprestimo coisado");

		} catch (SQLException e) {
			e.printStackTrace();
			return true;
		}
		return false;
	} //adiciona emprestimo


public void alterarmd3mais(Emprestimo emprestimo) {
	String sql = "update alunos set md3= md3 + 1 where id=?;";
	try {
		PreparedStatement stmt = connection.prepareStatement(sql);

		stmt.setLong(1, emprestimo.getAluno().getId() );
		 //ALTERA O NUMERO DE LIVROS EMPRESTADOS DO NUMERO ATUAL PARA O NUMERO ATUAL +1
		stmt.execute();
		stmt.close();
	} catch (Exception e) {
		throw new RuntimeException(e);
	}
}
public void alterarmd3menos(Emprestimo emprestimo) {
	String sql = "update alunos set md3= md3 - 1 where id=?;";
	try {
		PreparedStatement stmt = connection.prepareStatement(sql);
	EmprestimoDAO dao = new EmprestimoDAO();
				
		stmt.setLong(1, emprestimo.getAluno().getId());
		
		// ALTERA O NUMERO DE LIVROS EMPRESTADOS DO NUMERO ATUAL PARA O NUMERO ATUAL -1
		
		stmt.execute();
		stmt.close();
	} catch (Exception e) {
		throw new RuntimeException(e);
	}
} 
//test	
	
	/*public boolean qtdEmprestimos(Aluno aluno) throws SQLException {

		try {
			PreparedStatement stmt = connection
					.prepareStatement("select * from emprestimos where aluno = ? and dataDevolucao IS NULL;");
			stmt.setLong(1, aluno.getId());
			ResultSet rs = stmt.executeQuery();
			int cont = 0;
			while (rs.next()) {
				cont++;
			}
			stmt.close();
			if (cont > 2) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}*/

	public List<Emprestimo> getListaAtivos() {
		try {

			List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
			PreparedStatement stmt = connection
					.prepareStatement("select * from emprestimos where dataDevolucao is null;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Emprestimo emprestimo = new Emprestimo();
		
				emprestimo.setId(rs.getLong("id"));
				Livro livro = new LivroDAO().getLivroByID(rs.getLong("livro"));
				Aluno aluno = new AlunoDAO().getAlunoByID(rs.getLong("aluno"));

				emprestimo.setLivro(livro);
				emprestimo.setAluno(aluno);
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataEmprestimo"));
				emprestimo.setDataEmprestimo(data);

				
				
				if (rs.getDate("dataDevolucao") != null) {
					Calendar dataDevolucao = Calendar.getInstance();
					dataDevolucao.setTime(rs.getDate("dataDevolucao"));
					emprestimo.setDataDevolucao(dataDevolucao);
				}

				emprestimos.add(emprestimo);
			}

			stmt.close();
			return emprestimos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		// lista apenas os emprestimos que não tiveram a sua data de devolução preenchida
	}

	public List<Emprestimo> getListaAtraso() {
		try {

			List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
			PreparedStatement stmt = connection
					.prepareStatement("select * from emprestimos where dataDevolucao is null and dataEmprestimo < ?;");
			Calendar date = Calendar.getInstance();
			stmt.setDate(1, new Date(date.getTimeInMillis() - 14 * 24 * 60 * 60 * 1000));
			ResultSet rs = stmt.executeQuery();
			Emprestimo emprestimo = new Emprestimo();
			
			emprestimo.setId(rs.getLong("id"));
			Livro livro = new LivroDAO().getLivroByID(rs.getLong("livro"));
			Aluno aluno = new AlunoDAO().getAlunoByID(rs.getLong("aluno"));

			emprestimo.setLivro(livro);
			emprestimo.setAluno(aluno);
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("dataEmprestimo"));
			emprestimo.setDataEmprestimo(data);
			while (rs.next()) {
								
				if (rs.getDate("dataDevolucao") != null) {
					Calendar datafinal = Calendar.getInstance();
					datafinal.setTime(rs.getDate("dataDevolucao"));
					emprestimo.setDataDevolucao(datafinal);
				
				
				}
			
			
			
			}
			stmt.close();
			return emprestimos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public List<Emprestimo> getLista() {
		try {
			//LISTA TODOS OS EMPRESTIMOS INDEPENDENTE SE DEVOLVEU OU NAO
			List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
			PreparedStatement stmt = connection.prepareStatement("select * from emprestimos ");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Emprestimo emprestimo = new Emprestimo();
                emprestimo.setId(rs.getLong("id"));
				Aluno aluno = new AlunoDAO().getAlunoByID(rs.getLong("aluno"));
				emprestimo.setAluno(aluno);
				Livro livro = new LivroDAO().getLivroByID(rs.getLong("livro"));
				emprestimo.setLivro(livro);

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataEmprestimo"));
				emprestimo.setDataEmprestimo(data);

				
				
				if (rs.getDate("dataDevolucao") != null) {
					Calendar data2 = Calendar.getInstance();
					data2.setTime(rs.getDate("dataDevolucao"));
					emprestimo.setDataDevolucao(data2);
				}
				emprestimos.add(emprestimo);
			}
			rs.close();
			stmt.close();
			return emprestimos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public boolean devolucao(Emprestimo emprestimo) {
		//FAZ UM UPDATE DOS EMPRESTIMOS DEVOLVENDO IMPRESTIMO APARTIR DO ID. PEGA O ID E PEGA A DATA ATUAL. AI O EMPRSTIMO É DEVOLVIDO COM BASE NA DATA ATUAL 
		String sql = "update emprestimos set dataDevolucao=? where id=?;";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setDate(1, new java.sql.Date(Calendar.getInstance().getTimeInMillis())); // AQI PEGA A DATA ATUAL E  MANDA
			stmt.setLong(2, emprestimo.getId()); //AQUI ELE MANDA O ID 
			EmprestimoDAO dao = new EmprestimoDAO();
		 AlunoDAO adao = new AlunoDAO();
            
		
			stmt.execute();
			stmt.close();
		//dao.alterarmd3menos(emprestimo); test
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
	/*public void remover (Emprestimo emprestavel) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from emprestimos where id=?;");
			stmt.setLong(1, emprestavel.getId());  //MANDA O ID
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}*/

	
//DELETA O EMPRESTIMO PELO ID. SIMPLES ASSIM





	
	public List<Emprestimo> getListaid(Long long1) {
		try {
			//LISTA TODOS OS EMPRESTIMOS INDEPENDENTE SE DEVOLVEU OU NAO
			List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
			PreparedStatement stmt = connection.prepareStatement("select alunos from emprestimos where emprestimos.id=?; ");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Emprestimo emprestimo = new Emprestimo();
                emprestimo.setId(rs.getLong("id"));
		
EmprestimoDAO dao = new EmprestimoDAO();
dao.alterarmd3menos(emprestimo);
				emprestimos.add(emprestimo);
				
			}
			rs.close();
			stmt.close();
			return emprestimos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}


public List<Emprestimo> getEmprestimosAtrasados() {
	List<Emprestimo> result = new ArrayList<>();

	try {
		PreparedStatement stmt = this.connection
				.prepareStatement("select * from emprestimos where dataDevolucao IS NULL and dataEmprestimo < ?;");
		Calendar data = Calendar.getInstance();
		stmt.setDate(1, new Date(data.getTimeInMillis() - 14 * 24 * 60 * 60 * 1000));
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {

			Emprestimo e = new Emprestimo();
			Calendar dataEmprestimo = Calendar.getInstance();
			dataEmprestimo.setTime(rs.getDate("dataEmprestimo"));
			e.setDataEmprestimo(dataEmprestimo);
			Aluno a = new AlunoDAO().getAlunoByID(rs.getLong("idAluno"));
			Livro l = new LivroDAO().getLivroByID(rs.getLong("idLivro"));
			e.setAluno(a);
			e.setLivro(l);

			result.add(e);


		}
		rs.close();
		stmt.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}

	return result;
}}
