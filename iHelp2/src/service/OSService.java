package service;

import java.util.ArrayList;

//import java.util.ArrayList;

import dao.OSDao;
import model.OS;
import model.Projeto;


public class OSService {

	OSDao dao = new OSDao();
	
	
	public int criar(OS os){
		return dao.criar(os);
	}
	
	public OS carregar(int id){
		return dao.carregar(id);
	}
	
	public ArrayList<Projeto> projetosVinculados(int id){
		return dao.projetosVinculados(id);
	}
	
	public ArrayList<Projeto> projetosSemVinculo(){
		return dao.projetosSemVinculo();
	}
	
	public void atualizar(OS os){
		dao.atualizar(os);
	}
	
	public void excluir(int id){
		dao.excluir(id);
	}
		
	public ArrayList<OS> vetor(){
		return dao.retornaUmVetor();
	}
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

