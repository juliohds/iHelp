package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import model.OS;
import model.Projeto;
import service.OSService;
import service.ProjetoService;

	/**
	 * Servlet implementation class ManterClienteController
	 */
	@WebServlet("/ManterOs.do")
	public class ManterOsController extends HttpServlet {
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
	          
	    	String acao = request.getParameter("acao");
	    	      	
			RequestDispatcher view = null;
			
			OSService Oservice = new OSService();
			
			

			if(acao.equals("Criar")){
			
				//int pProjeto = Integer.parseInt(request.getParameter("projeto"));
				String pNome = request.getParameter("nome");
				String pNomeFantasia = request.getParameter("nf");
		        String pCnpj = request.getParameter("cnpj");
		        String pEmail = request.getParameter("email");
		        String pEndereco = request.getParameter("endereco");
		        String pNumero = request.getParameter("numero");
		        String pCep = request.getParameter("cep");
		        String pComplemento = request.getParameter("complemento");
		        String pEstado = request.getParameter("estado");
		        String pCidade = request.getParameter("cidade");
		        String pInicio = request.getParameter("data_inicio");
		        String pStatus = request.getParameter("status");
			
		        OS os = new OS();
		       
		        //os.setId_projeto(pProjeto);
		       os.setNome(pNome);
		       os.setNome_fantasia(pNomeFantasia); 
		       os.setCep(pCep);
		       os.setCidade(pCidade);
		       os.setCnpj(pCnpj);
		       os.setComplemento(pComplemento);
		       os.setData_inicio(pInicio);
		       os.setStatus(pStatus);
		       os.setEstado(pEstado);
		       os.setEmail(pEmail);
		       os.setNumero(pNumero);
		       os.setEndereco(pEndereco);
		       
				int id = Oservice.criar(os);
				
				/*os.setId_OS(id);
	        
				os = Oservice.carregar(id);
	        	        
		        request.setAttribute("os", os);*/
				
								
		        ArrayList<OS> lista = Oservice.vetor();
			    request.setAttribute("lista", lista);
			    
		        view = request.getRequestDispatcher("PainelOs.jsp"); 
			}

			else if (acao.equals("Carregar")) {
				
				ProjetoService ps = new ProjetoService();
				ArrayList<Projeto> pLista = ps.projetosSemVinculo();
				request.setAttribute("pLista", pLista);
				
				ArrayList<OS> lista = Oservice.vetor();
			    request.setAttribute("lista", lista);
			    
		        view = request.getRequestDispatcher("PainelOs.jsp");
			
			}
			
			else if (acao.equals("Visualizar")){
				int id = Integer.parseInt(request.getParameter("id_os"));
				
				ProjetoService ps = new ProjetoService();
										
				ArrayList<Projeto> v = ps.projetosVinculados(id);
				request.setAttribute("v", v);
				
				
				ArrayList<Projeto> nv = ps.projetosSemVinculo();
				request.setAttribute("nv", nv);
				
				OS os;
				os = Oservice.carregar(id);
				request.setAttribute("os", os);
			    view = request.getRequestDispatcher("PainelOsVisualizar.jsp");
				
			}
			
			else if (acao.equals("Vincular")){
				int id = Integer.parseInt(request.getParameter("id_os"));
				int idP = Integer.parseInt(request.getParameter("id_projeto"));
				
				ProjetoService ps = new ProjetoService();
				
				ps.vincularProjeto(id, idP);
				
				ArrayList<Projeto> v = ps.projetosVinculados(id);
				request.setAttribute("v", v);
				
				
				ArrayList<Projeto> nv = ps.projetosSemVinculo();
				request.setAttribute("nv", nv);
				
				OS os;
				os = Oservice.carregar(id);
				request.setAttribute("os", os);
			    view = request.getRequestDispatcher("PainelOsVisualizar.jsp");
				
			}
			
			else if (acao.equals("Desvincular")){
				int id = Integer.parseInt(request.getParameter("id_os"));
				int idP = Integer.parseInt(request.getParameter("id_projeto"));
				
				ProjetoService ps = new ProjetoService();
				
				
				ps.DesvincularProjeto(id, idP);
				
				ArrayList<Projeto> v = ps.projetosVinculados(id);
				request.setAttribute("v", v);
				
				
				ArrayList<Projeto> nv = ps.projetosSemVinculo();
				request.setAttribute("nv", nv);
				
				OS os;
				os = Oservice.carregar(id);
				request.setAttribute("os", os);
			    view = request.getRequestDispatcher("PainelOsVisualizar.jsp");
				
			}
			
			else if (acao.equals("Excluir")) {
				
				int id_os = Integer.parseInt(request.getParameter("id_OS"));
			
				Oservice.excluir(id_os);
				
				ProjetoService ps = new ProjetoService();
				ArrayList<Projeto> pLista = ps.vetor();
				request.setAttribute("pLista", pLista);
					
				ArrayList<OS> lista = Oservice.vetor();
			    request.setAttribute("lista", lista);
			    
				view = request.getRequestDispatcher("PainelOs.jsp");
			
			} else if(acao.equals("Editar")){
				
				ProjetoService ps = new ProjetoService();
				ArrayList<Projeto> pLista = ps.vetor();
				request.setAttribute("pLista", pLista);
				
				//int id_os = Integer.parseInt(request.getParameter("id_os"));
				int id = Integer.parseInt(request.getParameter("id"));
				
				OS os;
				os = Oservice.carregar(id);
				request.setAttribute("os", os);
			    view = request.getRequestDispatcher("PainelOsEditar.jsp");
				
				
			}

			else if (acao.equals("Atualizar")) {
				
				//int pProjeto = Integer.parseInt(request.getParameter("projeto"));
				int id = Integer.parseInt(request.getParameter("id"));
				String pNome = request.getParameter("nome");
				String pNomeFantasia = request.getParameter("nf");
		        String pCnpj = request.getParameter("cnpj");
		        String pEmail = request.getParameter("email");
		        String pEndereco = request.getParameter("endereco");
		        String pNumero = request.getParameter("numero");
		        String pCep = request.getParameter("cep");
		        String pComplemento = request.getParameter("complemento");
		        String pEstado = request.getParameter("estado");
		        String pCidade = request.getParameter("cidade");
		        String pInicio = request.getParameter("data_inicio");
		        String pStatus = request.getParameter("status");
			
		        OS os = new OS();
		       
		       os.setId_OS(id);
		       os.setNome(pNome);
		       //os.setId_projeto(pProjeto);
		       os.setNome_fantasia(pNomeFantasia); 
		       os.setCep(pCep);
		       os.setCidade(pCidade);
		       os.setCnpj(pCnpj);
		       os.setComplemento(pComplemento);
		       os.setData_inicio(pInicio);
		       os.setStatus(pStatus);
		       os.setEstado(pEstado);
		       os.setEmail(pEmail);
		       os.setNumero(pNumero);
		       os.setEndereco(pEndereco);
		       
				Oservice.atualizar(os);
				
				request.setAttribute("os", os);    
				
				ArrayList<OS> lista = Oservice.vetor();
			    request.setAttribute("lista", lista);
								
				view = request.getRequestDispatcher("PainelOs.jsp");
			
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

	