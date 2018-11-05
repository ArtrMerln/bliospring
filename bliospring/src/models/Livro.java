package models;

public class Livro {
	private Long id;
	private String titulo;
	private String autor;
	private String editora;
	private String anoEdicao;
	private int anoPublicacao;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getAnoEdicao() {
		return anoEdicao;
	}

	public void setAnoEdicao(String anoEdicao) {
		this.anoEdicao = anoEdicao;
	}

	public int getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(int anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
