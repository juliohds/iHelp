package service;

import java.util.ArrayList;

import dao.GestorDao;
import model.Gestor;


public class GestorService {

	GestorDao dao = new GestorDao();
	
	
	public int criar(Gestor gestor){
		return dao.criar(gestor);
	}
	
	public Gestor carregar(int id){
		return dao.carregar(id);
	}
	
	public void atualizar(Gestor gestor){
		dao.atualizar(gestor);
	}
	
	public void excluir(int id){
		dao.excluir(id);
	}
		
	public ArrayList<Gestor> vetor(){
		return dao.retornaUmVetor();
	}
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

