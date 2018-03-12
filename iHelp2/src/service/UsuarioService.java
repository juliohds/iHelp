package service;

import dao.UsuarioDao;
import model.Usuario;
import model.Voluntario;


public class UsuarioService {

	UsuarioDao dao = new UsuarioDao();
	
	public int logar(Usuario usuario){
		return dao.logar(usuario);
	}
	
	public Voluntario carregarUsuario(Usuario user){
	
		Voluntario voluntario = dao.carregarUsuario(user);
		VoluntarioService vs = new VoluntarioService();
		
		voluntario.setDisponibilidade(vs.carregarDisponibilidade(voluntario));
		
		return voluntario;
		
	}
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


