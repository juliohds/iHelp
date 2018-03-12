package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

import dao.VoluntarioDao;
import model.Projeto;
import model.Voluntario;


public class VoluntarioService {

	VoluntarioDao dao = new VoluntarioDao();
	
	
	public boolean verificaVinculo(int idP, int idV){
		return dao.verificaVinculo(idP, idV);
	}
	
	public int criar(Voluntario voluntario){
		
		int i = dao.criar(voluntario);
		if(i > 0){
		   dao.inserirDisponibilidade(voluntario);	
		   
		
		dao.insereArea(voluntario);
		}
		//JOptionPane.showMessageDialog(null, "id>"+voluntario.getId_voluntario());
		return i;
	}
	
	public void VincularVoluntario(int id_projeto, int id_voluntario){
		Projeto p = new Projeto();
		ProjetoService ps = new ProjetoService();
		VoluntarioService vs = new VoluntarioService();
		
		p = ps.carregar(id_projeto);
		int quantia = p.getQuantidade();
		
		ArrayList<Voluntario> lista = vs.voluntariosVinculados(id_projeto);
		
		if(lista.size()<quantia){
			
		dao.VincularVoluntario(id_projeto, id_voluntario);
		
		if(lista.size()+1==quantia){
			p.setSituacao("Ativo");
			ps.editar(p);
		}
		}
	}
	
	public ArrayList<Voluntario> vetorMatch(ArrayList<Voluntario> vLista, Projeto projeto){
		
		//Comparar disponibilidade do projeto com todos as disponibilidades dos voluntarios
	
		ArrayList<Voluntario> listaMatch = new ArrayList<Voluntario>();
		String[] TD = projeto.getDisponibilidade();
	    int qtd = projeto.getQuantidade();
	    
		int auxP[] = projeto.getId_area();
		
		boolean ehCompativel = false;
		
		for(int i=0;i<vLista.size();i++){
				
			Voluntario voluntario = vLista.get(i);
			
			if(dao.verificaVinculo(projeto.getId_projeto(), voluntario.getId_voluntario()))
		    continue;
				
			int auxV[] = voluntario.getId_area();
			boolean areaCompativel = true;
			
			//verificar as areas do projeto se elas tem no voluntario
			for (int j = 0; j < auxP.length; j++) {
				
				if(auxP[j]>0){
					
					for (int j2 = 0; j2 < auxV.length; j2++) {
					
						if(auxP[j] == auxV[j2]){
							areaCompativel = false;
						}
					
					}
					
				}
								
			}
				
			if(areaCompativel){
				continue;
			}
			
			for(int j=0; j<TD.length; j++){
		    	
		    	//converter esse disponibilidade a um vetor de 21 posicoes
		    	String a   = TD[j];
		    	//String[] b = voluntario.getDisponibilidade();
		    	voluntario.setDisponibilidade(carregarDisponibilidade(voluntario));
		    	
		    	String[] b = voluntario.getDisponibilidade();   
		    			    		    		    			    	    	
		    	if(a.equals("1")){
										
					if(b[j].equals(a)){
						
						ehCompativel = true;
						// se ele entrar aqui entao no momento o voluntario é compativel com o projeto
					}else{
						
						ehCompativel = false;
						break;
					}
						
				}
				    
			}
			
			if(ehCompativel){
			   	listaMatch.add(voluntario);
			   	qtd--;
			}
		
		}
		
		
		return listaMatch;
	}
	
	public ArrayList<Voluntario> voluntariosVinculados(int id_projeto){
		
		return dao.retornaVoluntariosVinculados(id_projeto);
	}
	
	public void DesvincularVoluntario(int id_projeto, int id_voluntario){
		Projeto p = new Projeto();
		ProjetoService ps = new ProjetoService();
		p = ps.carregar(id_projeto);
		p.setSituacao("Em Busca de Voluntarios");
		ps.editar(p);
		dao.DesvincularVoluntario(id_projeto, id_voluntario);
	}

	
	public String[] carregarDisponibilidade(Voluntario voluntario){
		
		/*return dao.carregarDisponibilidade(voluntario); */
		
		
		String Sete_Dias[] = dao.carregarDisponibilidade(voluntario);
		
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
	
	public Voluntario carregar(int id){
		Voluntario voluntario = dao.carregar(id);
		voluntario.setDisponibilidade(carregarDisponibilidade(voluntario));
		dao.carregaArea(voluntario);
		return voluntario;
	}
	
	public void excluir(int id){
		dao.excluirdisponibilidade(id);
		dao.excluirArea(id);
		dao.excluirVinculo(id);
		dao.excluir(id);
	
	}
	
	public void excluirdisponibilidade(int id){
		dao.excluirdisponibilidade(id);
	}
	
	public Voluntario atualizar(Voluntario voluntario){
		voluntario = dao.atualizar(voluntario);
		//JOptionPane.showMessageDialog(null, voluntario.getId_voluntario());
		if(verificaVinculo(0, voluntario.getId_voluntario())){
			
		}else{
		voluntario.setDisponibilidade(alterarDisponibilidade(voluntario));
		dao.excluirArea(voluntario.getId_voluntario());
		dao.insereArea(voluntario);
		}
		return voluntario;
	}
	
	public String[] alterarDisponibilidade(Voluntario voluntario){
		
		
		
		String Sete_Dias[] = dao.alterarDisponibilidade(voluntario);
		
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
	
	public ArrayList<Voluntario> vetor(){
		return dao.retornaUmArray();
	}

	
}






	

	