package model;

public class Gestor  {
	
	private int id_gestor;
	private String nome, cpf, login, senha, imagem;
	
	public Gestor(){
		
	}
	
	
	public int getId_gestor() {
		return id_gestor;
	}
	public void setId_gestor(int id_gestor) {
		this.id_gestor = id_gestor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	@Override
	public String toString() {
		return "Gestor [id_gestor=" + id_gestor + ", nome=" + nome + ", cpf=" + cpf + ", login=" + login + ", senha="
				+ senha + ", imagem=" + imagem + "]";
	}
	
	
	
	
	
	

}
