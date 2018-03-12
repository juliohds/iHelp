package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import model.Voluntario;
import service.UsuarioService;
import service.VoluntarioService;

	/**
	 * Servlet implementation class ManterClienteController
	 */
	@WebServlet("/LoginUsuario.do")
	public class LoginUsuarioController extends HttpServlet {
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
	        
	    	String login = request.getParameter("login");
	        String senha = request.getParameter("senha");
	     
	        //instanciar o javabean
	        Usuario user = new Usuario();
	        user.setLogin(login);
	        user.setSenha(senha);
	      	        
	        //instanciar o service
	        UsuarioService us = new UsuarioService();
	        VoluntarioService vs = new VoluntarioService();
	        
	       int ehValido = us.logar(user);
	        
	        if(ehValido>0){       
	        
	        HttpSession sessao = request.getSession();
	        sessao.setAttribute(USUARIO_LOGADO, user);
	        
	        //chamar o carregar do voluntario os dados a partid desse login
	        Voluntario voluntario = vs.carregar(ehValido);
	        voluntario.setDisponibilidade(vs.carregarDisponibilidade(voluntario));
	        
	        sessao.setAttribute("voluntario", voluntario);
	        request.setAttribute("voluntario", voluntario);	
	        
	        boolean a = vs.verificaVinculo(0, voluntario.getId_voluntario());
			int vinculo = 0;
			
			if(a){
				vinculo = 1;
			}
							
			request.setAttribute("vinculo", vinculo);
			
	        RequestDispatcher view = 
	        request.getRequestDispatcher("usuario.jsp");
	        view.forward(request, response);
	        
	        }else{
	        	
	        	 RequestDispatcher view = 
	                request.getRequestDispatcher("index.jsp");
	                view.forward(request, response);
	        	
	        }
	    }
	    
	}

	


