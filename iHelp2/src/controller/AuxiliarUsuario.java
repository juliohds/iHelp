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

import model.Usuario;
import model.Voluntario;
import service.VoluntarioService;

/**
 * Servlet implementation class Test
 */
@WebServlet(name = "AuxUsuario.do", urlPatterns = { "/AuxUsuario.do" })
public class AuxiliarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String USUARIO_LOGADO = "login";
	 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	                
       //instanciar o service
		VoluntarioService vs = new VoluntarioService();
				
		HttpSession session = request.getSession();
		
		Voluntario voluntario;
		voluntario = (Voluntario) session.getAttribute("voluntario");
		
		//request.setAttribute("user", user);
		
        ArrayList<Voluntario> lista2 = vs.vetor();
        request.setAttribute("vFor", lista2);
        
        //enviar para o jsp
              
        RequestDispatcher view = 
        request.getRequestDispatcher("usuario.jsp");
        view.forward(request, response);
		
    
        
	}

}
