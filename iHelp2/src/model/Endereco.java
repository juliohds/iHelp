package model;

public class Endereco {
	
	private int id_endereco;
	private String endereco, numero, complemento, cep, cidade, estado;

	@Override
	public String toString() {
		return "Endereco [id_endereco=" + id_endereco + ", endereco=" + endereco + ", numero=" + numero
				+ ", complemento=" + complemento + ", cep=" + cep + ", cidade=" + cidade + ", estado=" + estado + "]";
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
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

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public int getId_endereco() {
		return id_endereco;
	}

	public void setId_endereco(int id_endereco) {
		this.id_endereco = id_endereco;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
