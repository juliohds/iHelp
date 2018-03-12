package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.OS;
import model.Projeto;
import model.Voluntario;
import service.OSService;
import service.ProjetoService;
import service.VoluntarioService;

/*dss
 * Servlet implementation class Test
 */
@WebServlet(name = "Aux.do", urlPatterns = { "/Aux.do" })
public class Auxiliar extends HttpServlet {
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
	        
		OSService Oservice = new OSService();
              
		ArrayList<OS> lista = Oservice.vetor();
	    request.setAttribute("oFor", lista);
	
        ProjetoService ps = new ProjetoService();
        
        ArrayList<Projeto> lista3 = ps.vetor();
        request.setAttribute("pFor", lista3);
        
       //instanciar o service
		VoluntarioService vs = new VoluntarioService();
               
        ArrayList<Voluntario> lista2 = vs.vetor();
        request.setAttribute("vFor", lista2);
        
        //enviar para o jsp
              
        RequestDispatcher view = 
        request.getRequestDispatcher("PainelProjetos.jsp");
        view.forward(request, response);
		
    
        
	}

}
