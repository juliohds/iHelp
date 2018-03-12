package model;


public class Voluntario {
	
	private int id_voluntario;
	private String nome, email, data_nascimento, genero, telefone, celular, rg, cpf, estado_civil, senha, descricao, imagem;
	private Endereco endereco;
	private String[] disponibilidade;
	private int[] id_area;
	

	public int[] getId_area() {
		return id_area;
	}

	public void setId_area(int[] id_area) {
		this.id_area = id_area;
	}

	public Voluntario(){
		
	}
		
	public int getId_voluntario() {
		return id_voluntario;
	}
	public void setId_voluntario(int id_voluntario) {
		this.id_voluntario = id_voluntario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getData_nascimento() {
		return data_nascimento;
	}
	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String[] getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(String[] disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
	
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getEstado_civil() {
		return estado_civil;
	}
	public void setEstado_civil(String estado_civil) {
		this.estado_civil = estado_civil;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}



	

	
	
}
