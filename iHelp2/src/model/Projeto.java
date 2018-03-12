package model;

public class Projeto {

	private int id_projeto, quantidade;
	
	private int[] id_area;
	private String nome, descricao, situacao;
	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	private String[] disponibilidade;
	private OS os;

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getId_projeto() {
		return id_projeto;
	}

	public void setId_projeto(int id_projeto) {
		this.id_projeto = id_projeto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
	public OS getOs() {
		return os;
	}

	public void setOs(OS os) {
		this.os = os;
	}

	public String[] getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(String[] disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public int[] getId_area() {
		return id_area;
	}

	public void setId_area(int[] id_area) {
		this.id_area = id_area;
	}

	
	
	

}
