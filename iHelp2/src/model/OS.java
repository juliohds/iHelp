package model;

import java.util.ArrayList;

public class OS {

	private int id_OS;
	private int id_projeto;
	private String nome_projeto, nome, nome_fantasia, cnpj, email, endereco, numero, cep, complemento, estado, cidade, data_inicio,
			status;

	public String getNome_projeto() {
		return nome_projeto;
	}

	public void setNome_projeto(String nome_projeto) {
		this.nome_projeto = nome_projeto;
	}

	public OS() {
	}

	public int getId_OS() {
		return id_OS;
	}

	public void setId_OS(int id_OS) {
		this.id_OS = id_OS;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome_fantasia() {
		return nome_fantasia;
	}

	public void setNome_fantasia(String nome_fantasia) {
		this.nome_fantasia = nome_fantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(String data_inicio) {
		this.data_inicio = data_inicio;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId_projeto() {
		return id_projeto;
	}

	public void setId_projeto(int id_projeto) {
		this.id_projeto = id_projeto;
	}

	@Override
	public String toString() {
		return "OS [id_OS=" + id_OS + ", nome=" + nome + ", nome_fantasia=" + nome_fantasia + ", cnpj=" + cnpj
				+ ", email=" + email + ", endereco=" + endereco + ", numero=" + numero + ", cep=" + cep
				+ ", complemento=" + complemento + ", estado=" + estado + ", cidade=" + cidade + ", data_inicio="
				+ data_inicio + ", status=" + status + "]";
	}

}
