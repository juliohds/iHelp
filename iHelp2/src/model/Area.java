package model;

public class Area {

	private int id_area;
	private String nome;

	public int getId_area() {
		return id_area;
	}

	public void setId_area(int id_area) {
		this.id_area = id_area;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Area [id_area=" + id_area + ", nome=" + nome + "]";
	}

}
