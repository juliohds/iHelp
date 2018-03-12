package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import model.Projeto;
import model.Voluntario;
import service.AreaService;
import service.ProjetoService;
import service.VoluntarioService;

	/**
	 * Servlet implementation class ManterClienteController
	 */
	@WebServlet("/ManterProjeto.do")
	public class ManterProjetoController extends HttpServlet {
	    private static final long serialVersionUID = 1L;
	    public static final String USUARIO_LOGADO = "login";
	    
	    /**
	     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	     */
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        doPost(request, response);
	    }
	    
	    /**
	     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	     */
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	         
	    	String pAcao = request.getParameter("acao");
	    	String pNome = request.getParameter("nome");
	        String pDescricao = request.getParameter("descricao");
	        String pSituacao = request.getParameter("situacao");
	        String pQuantidade = request.getParameter("quantidade");
	        
	        Projeto projeto = new Projeto();
	        
	        
	        
	        projeto.setNome(pNome);
	        projeto.setDescricao(pDescricao);
	        projeto.setSituacao(pSituacao);
	       
			//instanciar o service
			ProjetoService ps = new ProjetoService();
	        AreaService as = new AreaService();
      		
			RequestDispatcher view = null;
			
			HttpSession session = request.getSession();
			
			//JOptionPane.showMessageDialog(null,request.getParameter("a"));
			
			//ps.verificaVinculo(id, 0);
			
			
	        

			if (pAcao.equals("Criar")) {	
				
				String segunda = "";
				for(int i = 1; i<= 3;i++){
					segunda += concatenaDias(request.getParameter("chkS"+i));
				}
				
				String terca = "";
				for(int i = 1; i<= 3;i++){
					terca += concatenaDias(request.getParameter("chkT"+i));
				}
					
				String quarta = "";
				for(int i = 1; i<= 3;i++){
					quarta += concatenaDias(request.getParameter("chkQ"+i));
				}
					
				String quinta = "";
				for(int i = 1; i<= 3;i++){
					quinta += concatenaDias(request.getParameter("chkQI"+i));
				}
				
				String sexta = "";
				for(int i = 1; i<= 3;i++){
					sexta += concatenaDias(request.getParameter("chkSX"+i));
				}
				
				String sabado = "";
				for(int i = 1; i<= 3;i++){
					sabado += concatenaDias(request.getParameter("chkSB"+i));
				}
				
				String domingo = "";
				for(int i = 1; i<= 3;i++){
					domingo += concatenaDias(request.getParameter("chkD"+i));
				}
				
				List <String> dias = Arrays.asList(segunda, terca, quarta, quinta, sexta, sabado, domingo);
				String vetor[] = dias.toArray( new String[0]);
		        		
				//instanciar o javabean
		        
		       
		        projeto.setDisponibilidade(vetor);
		        
				int area1 = Integer.parseInt(concatenaDias(request.getParameter("a")));
		        int area2 = Integer.parseInt(concatenaDias(request.getParameter("b")));
		        int area3 = Integer.parseInt(concatenaDias(request.getParameter("c")));
		        int area4 = Integer.parseInt(concatenaDias(request.getParameter("d")));
		        int area5 = Integer.parseInt(concatenaDias(request.getParameter("e")));
		        int area6 = Integer.parseInt(concatenaDias(request.getParameter("f")));
		        int area7 = Integer.parseInt(concatenaDias(request.getParameter("g")));
		              
		        
		        int vetorArea[] = new int[7];
		        
		        if(area1!=0)
				vetorArea[0] = area1;
		        
		        if(area2!=0)
				vetorArea[1] = area2;
		        
		        if(area3!=0)
				vetorArea[2] = area3;
		        
		        if(area4!=0)
				vetorArea[3] = area4;
		        
		        if(area5!=0)
				vetorArea[4] = area5;
		        
		        if(area6!=0)
				vetorArea[5] = area6;
		        
		        if(area7!=0)
				vetorArea[6] = area7;
		        
		      
		        projeto.setId_area(vetorArea);
		        
				projeto.setQuantidade(Integer.parseInt(pQuantidade));

				int id = ps.criar(projeto);
			
				ArrayList<Projeto> lista = ps.vetor();
		        request.setAttribute("lista", lista);
		        
		        view = request.getRequestDispatcher("PainelProjetos.jsp");
		    	       
			} else if (pAcao.equals("Excluir")) {
				
				int id_projeto = Integer.parseInt(request.getParameter("id_projeto"));
			
				boolean exclui = ps.excluir(id_projeto);
				
				ArrayList<Projeto> lista = ps.vetor();
		        request.setAttribute("lista", lista);
		        
			    request.setAttribute("exclui", exclui);
		        view = request.getRequestDispatcher("PainelProjetos.jsp");
			
			}  else if (pAcao.equals("VincularMatch")) {
				
				int area1 = Integer.parseInt(concatenaDias(request.getParameter("a")));
		        int area2 = Integer.parseInt(concatenaDias(request.getParameter("b")));
		        int area3 = Integer.parseInt(concatenaDias(request.getParameter("c")));
		        int area4 = Integer.parseInt(concatenaDias(request.getParameter("d")));
		        int area5 = Integer.parseInt(concatenaDias(request.getParameter("e")));
		        int area6 = Integer.parseInt(concatenaDias(request.getParameter("f")));
		        int area7 = Integer.parseInt(concatenaDias(request.getParameter("g")));
		              
		        
		        int vetorArea[] = new int[7];
		        
		        if(area1!=0)
				vetorArea[0] = area1;
		        
		        if(area2!=0)
				vetorArea[1] = area2;
		        
		        if(area3!=0)
				vetorArea[2] = area3;
		        
		        if(area4!=0)
				vetorArea[3] = area4;
		        
		        if(area5!=0)
				vetorArea[4] = area5;
		        
		        if(area6!=0)
				vetorArea[5] = area6;
		        
		        if(area7!=0)
				vetorArea[6] = area7;
		        
		      
		        projeto.setId_area(vetorArea);
		        
				int id_projeto = Integer.parseInt(request.getParameter("id_projeto"));
				projeto = ps.carregar(id_projeto);
				request.setAttribute("projeto", projeto);
				
				int id_voluntario = Integer.parseInt(request.getParameter("id_voluntario"));
								
				VoluntarioService vs = new VoluntarioService();
				
				vs.VincularVoluntario(id_projeto, id_voluntario);
				
				ArrayList<Voluntario> vv = vs.voluntariosVinculados(id_projeto);
				request.setAttribute("vv", vv);
				
				ArrayList<Voluntario> lista = vs.vetor();
				ArrayList<Voluntario> mlista = null;
				mlista = vs.vetorMatch(lista, projeto);
				request.setAttribute("mlista", mlista);
				
				boolean a = ps.verificaVinculo(id_projeto, 0);
				int vinculo = 0;
				
				if(a){
					vinculo = 1;
				}
								
				request.setAttribute("vinculo", vinculo);
				
			    view = request.getRequestDispatcher("PainelProjetosVisualizar.jsp");
			
			} 
			
			else if (pAcao.equals("DesvincularMatch")) {
				
				int id_projeto = Integer.parseInt(request.getParameter("id_projeto"));
				projeto = ps.carregar(id_projeto);
				request.setAttribute("projeto", projeto);
				
				int id_voluntario = Integer.parseInt(request.getParameter("id_voluntario"));
								
				VoluntarioService vs = new VoluntarioService();
				
				vs.DesvincularVoluntario(id_projeto, id_voluntario);
				
				ArrayList<Voluntario> vv = vs.voluntariosVinculados(id_projeto);
				request.setAttribute("vv", vv);
				
				ArrayList<Voluntario> lista = vs.vetor();
				ArrayList<Voluntario> mlista = null;
				mlista = vs.vetorMatch(lista, projeto);
				request.setAttribute("mlista", mlista);
				
				boolean a = ps.verificaVinculo(id_projeto, 0);
				int vinculo = 0;
				
				if(a){
					vinculo = 1;
				}
								
				request.setAttribute("vinculo", vinculo);
				
			    view = request.getRequestDispatcher("PainelProjetosVisualizar.jsp");
			
			}
			
			
			else if (pAcao.equals("Carregar")) {
				
				
				
				ArrayList<Projeto> lista = ps.vetor();
		        request.setAttribute("lista", lista);
					        
				
		        view = request.getRequestDispatcher("PainelProjetos.jsp");
			
			} else if (pAcao.equals("Carregar3")){
				
				String busca = request.getParameter("busca");
				
				ArrayList<Projeto> lista = ps.vetorFind(busca);
		        request.setAttribute("lista", lista);
		        
		        view = request.getRequestDispatcher("PainelConsulta.jsp");
			
	    	} else if (pAcao.equals("Carregar2")) {
				
				ArrayList<Projeto> lista = ps.vetor();
		        request.setAttribute("lista", lista);
		        
					        
		        view = request.getRequestDispatcher("PainelConsulta.jsp");
			
			}
			
			else if (pAcao.equals("Editar")) {
				
				int id_projeto = Integer.parseInt(request.getParameter("id_projeto"));
				projeto = ps.carregar(id_projeto);
				request.setAttribute("projeto", projeto);
				
				ArrayList<Projeto> lista = ps.vetor();
		        request.setAttribute("lista", lista);
		        
		        boolean a = ps.verificaVinculo(id_projeto, 0);
				int vinculo = 0;
				
				if(a){
					vinculo = 1;
				}
								
				request.setAttribute("vinculo", vinculo);
				
			    view = request.getRequestDispatcher("PainelProjetosEditar.jsp");
			
			} else if (pAcao.equals("Atualizar")) {
				
				int id_projeto = Integer.parseInt(request.getParameter("id_projeto"));
				
				if(ps.verificaVinculo(id_projeto, 0)){
				
				}else{
					
					String segunda = "";
					for(int i = 1; i<= 3;i++){
						segunda += concatenaDias(request.getParameter("chkS"+i));
					}
					
					String terca = "";
					for(int i = 1; i<= 3;i++){
						terca += concatenaDias(request.getParameter("chkT"+i));
					}
						
					String quarta = "";
					for(int i = 1; i<= 3;i++){
						quarta += concatenaDias(request.getParameter("chkQ"+i));
					}
						
					String quinta = "";
					for(int i = 1; i<= 3;i++){
						quinta += concatenaDias(request.getParameter("chkQI"+i));
					}
					
					String sexta = "";
					for(int i = 1; i<= 3;i++){
						sexta += concatenaDias(request.getParameter("chkSX"+i));
					}
					
					String sabado = "";
					for(int i = 1; i<= 3;i++){
						sabado += concatenaDias(request.getParameter("chkSB"+i));
					}
					
					String domingo = "";
					for(int i = 1; i<= 3;i++){
						domingo += concatenaDias(request.getParameter("chkD"+i));
					}
					
					List <String> dias = Arrays.asList(segunda, terca, quarta, quinta, sexta, sabado, domingo);
					String vetor[] = dias.toArray( new String[0]);
			        		
					//instanciar o javabean
			        
			       
			        projeto.setDisponibilidade(vetor);
			        
				int area1 = Integer.parseInt(concatenaDias(request.getParameter("a")));
				int area2 = Integer.parseInt(concatenaDias(request.getParameter("b")));
				int area3 = Integer.parseInt(concatenaDias(request.getParameter("c")));
				int area4 = Integer.parseInt(concatenaDias(request.getParameter("d")));
				int area5 = Integer.parseInt(concatenaDias(request.getParameter("e")));
				int area6 = Integer.parseInt(concatenaDias(request.getParameter("f")));
				int area7 = Integer.parseInt(concatenaDias(request.getParameter("g")));
		              
		        
		        int vetorArea[] = new int[7];
		        
		        if(area1!=0)
				vetorArea[0] = area1;
		        
		        if(area2!=0)
				vetorArea[1] = area2;
		        
		        if(area3!=0)
				vetorArea[2] = area3;
		        
		        if(area4!=0)
				vetorArea[3] = area4;
		        
		        if(area5!=0)
				vetorArea[4] = area5;
		        
		        if(area6!=0)
				vetorArea[5] = area6;
		        
		        if(area7!=0)
				vetorArea[6] = area7;
		        
		      
		        projeto.setId_area(vetorArea);
		        
				}
				
				projeto.setId_projeto(id_projeto);
				projeto.setQuantidade(Integer.parseInt(pQuantidade));
				//System.out.println("1"+Arrays.toString(projeto.getId_area()));
				ps.editar(projeto);
				
				ArrayList<Projeto> lista = ps.vetor();
		        request.setAttribute("lista", lista);
					        
		        view = request.getRequestDispatcher("PainelProjetos.jsp");
			}
			
			 else if (pAcao.equals("Visualizar")) {
				 int id_projeto = Integer.parseInt(request.getParameter("id_projeto"));
					projeto = ps.carregar(id_projeto);
					request.setAttribute("projeto", projeto);
					
					VoluntarioService vs = new VoluntarioService();
					
					ArrayList<Voluntario> vv = vs.voluntariosVinculados(id_projeto);
					request.setAttribute("vv", vv);
					
					ArrayList<Voluntario> lista = vs.vetor();
					ArrayList<Voluntario> mlista = null;
					mlista = vs.vetorMatch(lista, projeto);
					request.setAttribute("mlista", mlista);
					
					boolean a = ps.verificaVinculo(id_projeto, 0);
					int vinculo = 0;
					
					if(a){
						vinculo = 1;
					}
									
					request.setAttribute("vinculo", vinculo);
					
				    view = request.getRequestDispatcher("PainelProjetosVisualizar.jsp");
			}
			 
			 
			view.forward(request, response);    
	       	        

	    }
	    
	    public String concatenaDias(String s){
			
			return (s!=null)?s:"0";
		}
	    
	}

	