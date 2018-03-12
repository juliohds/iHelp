package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Gestor;
import model.Voluntario;
import service.GestorService;
import service.VoluntarioService;

/**
 * Servlet implementation class Test
 */
@WebServlet(name = "Test.do", urlPatterns = { "/Test.do" })
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
        GestorService gs = new GestorService();
                
        ArrayList<Gestor> lista = gs.vetor();
        request.setAttribute("gFor", lista);
        
       //instanciar o service
		VoluntarioService vs = new VoluntarioService();
               
        ArrayList<Voluntario> lista2 = vs.vetor();
        request.setAttribute("vFor", lista2);
        
        //enviar para o jsp
              
        RequestDispatcher view = 
        request.getRequestDispatcher("CrudMaster.jsp");
        view.forward(request, response);
		
    
        
	}

}
