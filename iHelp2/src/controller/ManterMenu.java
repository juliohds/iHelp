package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.OS;
import model.Projeto;
import service.OSService;
import service.ProjetoService;

	/**
	 * Servlet implementation class ManterClienteController
	 */
	@WebServlet("/ManterMenu.do")
	public class ManterMenu extends HttpServlet {
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
	    		    	
	    	request.setCharacterEncoding("UTF-8");
	        response.setCharacterEncoding("UTF-8");
	        
	        RequestDispatcher view = null;
			
			HttpSession session = request.getSession();
	    				
	        OSService Oservice = new OSService();
            ProjetoService ps = new ProjetoService();
            
			ArrayList<OS> lista = Oservice.vetor();
		    request.setAttribute("lista", lista);
		    
		    if(acao.equals("Projeto")){
		    ArrayList<Projeto> lista2 = ps.vetor();
		    request.setAttribute("lista2", lista2);
		    
		    view = request.getRequestDispatcher("projetos.jsp");
	    
		    }
		    
		    else if(acao.equals("Os")){
	        //enviar para o jsp	
	        view = request.getRequestDispatcher("parceiros.jsp");
	        
		    }
		    
		    
		    view.forward(request, response);
	    }
	    
	   
	}

	