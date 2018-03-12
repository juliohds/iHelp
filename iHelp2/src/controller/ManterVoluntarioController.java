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

import model.Area;
import model.Endereco;
import model.Usuario;
import model.Voluntario;
import service.AreaService;
import service.UsuarioService;
import service.VoluntarioService;

	/**
	 * Servlet implementation class ManterClienteController
	 */
	@WebServlet("/ManterVoluntario.do")
	public class ManterVoluntarioController extends HttpServlet {
	    private static final long serialVersionUID = 1L;
	    
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
	      
	    	request.setCharacterEncoding("UTF-8");
	        response.setCharacterEncoding("UTF-8");
	    	
	        String acao = request.getParameter("acao");
	    	      	
			RequestDispatcher view = null;
			
			AreaService as = new AreaService();
			VoluntarioService vs = new VoluntarioService();
			
			if(acao.equals("Cadastro")){
				
				ArrayList<Area> lista = as.array();
				request.setAttribute("lista", lista);
			   			
		        view = request.getRequestDispatcher("cadastro.jsp");
			}
			
			if(acao.equals("Criar")){
			
				String pNome = request.getParameter("nome");
		        String pEmail = request.getParameter("email");
		        String pData_nascimento = request.getParameter("data_nascimento");
		        String pGenero = request.getParameter("genero");
		        String pTelefone = request.getParameter("telefone");
		        String pCelular = request.getParameter("celular");
		        String pRg = request.getParameter("rg");
		        String pCpf = request.getParameter("cpf");
		        String pEndereco = request.getParameter("endereco");
		        String pNumero = request.getParameter("numero");
		        String pComplemento = request.getParameter("complemento");
		        String pCep = request.getParameter("cep");
		        String pEstado_civil = request.getParameter("estado_civil");
		        String pSenha = request.getParameter("senha");
		        String pDescricao = request.getParameter("descricao");
		        String pEstado = request.getParameter("estado");
		        String pCidade = request.getParameter("cidade");
		        
		        
		        int area1 = Integer.parseInt(concatenaDias(request.getParameter("Esporte")));
		        int area2 = Integer.parseInt(concatenaDias(request.getParameter("Saude")));
		        int area3 = Integer.parseInt(concatenaDias(request.getParameter("Cultura")));
		        int area4 = Integer.parseInt(concatenaDias(request.getParameter("Pessoas com deficiencia")));
		        int area5 = Integer.parseInt(concatenaDias(request.getParameter("Criancas e Adolescentes")));
		        int area6 = Integer.parseInt(concatenaDias(request.getParameter("Meio ambiente")));
		        int area7 = Integer.parseInt(concatenaDias(request.getParameter("Competitividade e Desenvolvimento")));
		              
		        
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
		        Voluntario voluntario = new Voluntario();
		        voluntario.setDisponibilidade(vetor);
		        voluntario.setNome(pNome);
				voluntario.setEmail(pEmail);
				voluntario.setData_nascimento(pData_nascimento);
				voluntario.setGenero(pGenero);
				voluntario.setTelefone(pTelefone);
				voluntario.setCelular(pCelular);
				voluntario.setRg(pRg);
				voluntario.setCpf(pCpf);
				voluntario.setEstado_civil(pEstado_civil);
				voluntario.setSenha(pSenha);
				voluntario.setDescricao(pDescricao);
				
				voluntario.setId_area(vetorArea);
				
				Endereco endereco = new Endereco(); 
				
				endereco.setEndereco(pEndereco);
				endereco.setNumero(pNumero);
				endereco.setComplemento(pComplemento);
				endereco.setCep(pCep);
				endereco.setEstado(pEstado);
				endereco.setCidade(pCidade);
				
				voluntario.setEndereco(endereco);	
						
				int id = vs.criar(voluntario);
				voluntario.setId_voluntario(id);
	        
				voluntario = vs.carregar(id);
	        
		       /* ArrayList<Voluntario> lista = vs.vetor();
		        request.setAttribute("vFor", lista);*/
		        
		        request.setAttribute("voluntario", voluntario);

		        HttpSession session = request.getSession();       
				session.setAttribute("voluntario", voluntario);
				
				boolean a = vs.verificaVinculo(0, voluntario.getId_voluntario());
				int vinculo = 0;
				
				if(a){
					vinculo = 1;
				}
								
				request.setAttribute("vinculo", vinculo);
				
		        view = request.getRequestDispatcher("usuario.jsp");
			}

			else if (acao.equals("Carregar")) {
				
				HttpSession session = request.getSession();
				
				Voluntario voluntario;
				voluntario = (Voluntario) session.getAttribute("voluntario");
				
				boolean a = vs.verificaVinculo(0, voluntario.getId_voluntario());
				int vinculo = 0;
				
				if(a){
					vinculo = 1;
				}
								
				request.setAttribute("vinculo", vinculo);
				
				request.setAttribute("voluntario", voluntario);
				
		        view = request.getRequestDispatcher("usuario.jsp");
			
			}
			
			else if (acao.equals("Carregar2")) {
				
				String login = request.getParameter("login");
		        String senha = request.getParameter("senha");
				
		        Usuario user = new Usuario();
		        user.setLogin(login);
		        user.setSenha(senha);

		        UsuarioService us = new UsuarioService();
		        int id = us.logar(user);
		        
		        Voluntario voluntario = vs.carregar(id);
				
				request.setAttribute("voluntario", voluntario);
				
				boolean a = vs.verificaVinculo(0, voluntario.getId_voluntario());
				int vinculo = 0;
				
				if(a){
					vinculo = 1;
				}
								
				request.setAttribute("vinculo", vinculo);
				
		        view = request.getRequestDispatcher("usuario.jsp");
			
			}
			
			else if (acao.equals("Excluir")) {
				
				HttpSession session = request.getSession();
				
				Voluntario voluntario;
				voluntario = (Voluntario) session.getAttribute("voluntario");
				
				vs.excluir(voluntario.getId_voluntario());
					
				session.invalidate();			
								
		        view = request.getRequestDispatcher("index.jsp");
			
			} 
			
			else if (acao.equals("Editar")) {
				
				HttpSession session = request.getSession();
				
				Voluntario voluntario;
				voluntario = (Voluntario) session.getAttribute("voluntario");		
				
				String pNome = request.getParameter("nome");
		        String pEmail = request.getParameter("email");
		        String pTelefone = request.getParameter("telefone");
		        String pCelular = request.getParameter("celular");
		        String pRg = request.getParameter("rg");
		        String pCpf = request.getParameter("cpf");
		        String pEndereco = request.getParameter("endereco");
		        String pSenha = request.getParameter("senha");
		        String pEstado = request.getParameter("estado");
		        String pCidade = request.getParameter("cidade");
		        
		       
		        voluntario.setNome(pNome);
				voluntario.setEmail(pEmail);
				voluntario.setTelefone(pTelefone);
				voluntario.setCelular(pCelular);
				voluntario.setRg(pRg);
				voluntario.setCpf(pCpf);
				voluntario.setSenha(pSenha);
			
				
				Endereco endereco = voluntario.getEndereco(); 
				
				endereco.setEndereco(pEndereco);
				endereco.setEstado(pEstado);
				endereco.setCidade(pCidade);
				
				voluntario.setEndereco(endereco);	
				
				if(vs.verificaVinculo(0, voluntario.getId_voluntario())){
					
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
				        
				        voluntario.setDisponibilidade(vetor);
				
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
				
				voluntario.setId_area(vetorArea);
				
				}
				
			    vs.atualizar(voluntario);
			    
				/*voluntario.setDisponibilidade(vs.carregarDisponibilidade(voluntario));*/
				
				
				request.setAttribute("voluntario", voluntario);    
				session.setAttribute("voluntario", voluntario);
				
		        view = request.getRequestDispatcher("ManterVoluntario.do?acao=Carregar");
			
			} 
			
			
	        view.forward(request, response);
	        
	       	        

	    }
	    
	    @Override
		public String toString() {
			return "ManterVoluntarioController []";
		}

		public String concatenaDias(String s){
			
			return (s!=null)?s:"0";
		}
	    
	}

	