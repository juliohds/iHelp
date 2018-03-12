package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

import dao.ProjetoDao;
import model.Projeto;
import model.Voluntario;


public class ProjetoService {

	ProjetoDao dao = new ProjetoDao();
	
	public boolean verificaVinculo(int idP, int idV){
		return dao.verificaVinculo(idP, idV);
	}
	
	public int criar(Projeto projeto){
		
		int i = dao.criar(projeto);
		if(i > 0){
		   dao.inserirDisponibilidade(projeto);	
		   dao.insereArea(projeto);
		}
		return i;
	}
		
	public ArrayList<Projeto> projetosVinculados(int id){
		return dao.projetosVinculados(id);
	}
	
	
	public void vincularProjeto(int id_os, int id_projeto){
		dao.vincularProjeto(id_os, id_projeto);
	}
	
	public void DesvincularProjeto(int id_os, int id_projeto){
		dao.DesvincularProjeto(id_os, id_projeto);
	}
	
	
	public ArrayList<Projeto> projetosSemVinculo(){
		return dao.projetosSemVinculo();
	}
	
	public ArrayList<Projeto> vetor(){
		return dao.retornaUmArray();
	}
	
	public ArrayList<Projeto> vetorFind(String s){
		return dao.vetorFind(s);
	}
	
	public boolean excluir(int id){
		
		boolean a = dao.excluirdisponibilidade(id);
		dao.excluirArea(id);
		dao.excluirVinculos(id);
		boolean b = dao.excluir(id);
	
		return b;
	}
		
	public Projeto carregar(int id){
		 Projeto projeto;
		 projeto = dao.carregar(id);
		 projeto.setDisponibilidade(carregarDisponibilidade(projeto));
		 projeto.setId_area(dao.carregaArea(projeto));
		 return projeto;
	}
	
	public void editar(Projeto projeto){
		dao.atualizar(projeto);
		
		if(verificaVinculo(projeto.getId_projeto(), 0)){
			
		}else{
		dao.alterarDisponibilidade(projeto);
		int areaNova[] = projeto.getId_area();
		System.out.println(Arrays.toString(areaNova));
		dao.excluirArea(projeto.getId_projeto());
		projeto.setId_area(areaNova);
		dao.insereArea(projeto);
		}
	}
	
	public String[] carregarDisponibilidade(Projeto projeto){
		
		/*return dao.carregarDisponibilidade(voluntario); */
		
		
		String Sete_Dias[] = dao.carregarDisponibilidade(projeto);
		
		//								
		String a1 = Sete_Dias[0].substring(0, 1);
		String a2 = Sete_Dias[0].substring(1, 2);
		String a3 = Sete_Dias[0].substring(2, 3);
		
		String b1 = Sete_Dias[1].substring(0, 1);
		String b2 = Sete_Dias[1].substring(1, 2);
		String b3 = Sete_Dias[1].substring(2, 3);
		
		String c1 = Sete_Dias[2].substring(0, 1);
		String c2 = Sete_Dias[2].substring(1, 2);
		String c3 = Sete_Dias[2].substring(2, 3);
		
		String d1 = Sete_Dias[3].substring(0, 1);
		String d2 = Sete_Dias[3].substring(1, 2);
		String d3 = Sete_Dias[3].substring(2, 3);
		
		String e1 = Sete_Dias[4].substring(0, 1);
		String e2 = Sete_Dias[4].substring(1, 2);
		String e3 = Sete_Dias[4].substring(2, 3);
		
		String f1 = Sete_Dias[5].substring(0, 1);
		String f2 = Sete_Dias[5].substring(1, 2);
		String f3 = Sete_Dias[5].substring(2, 3);
		
		String g1 = Sete_Dias[6].substring(0, 1);
		String g2 = Sete_Dias[6].substring(1, 2);
		String g3 = Sete_Dias[6].substring(2, 3);
				
		List <String> dias = Arrays.asList(a1, a2, a3, b1, b2, b3, c1, c2, c3, d1, d2, d3, e1, e2, e3, f1, f2, f3, g1, g2, g3);
		String vinte_um[] = dias.toArray(new String[0]);
		
	
		return vinte_um;
		
		
	}
	
	
	
}






	

	