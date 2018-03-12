package service;

import java.util.ArrayList;

import dao.AreaDao;
import model.Area;


public class AreaService {

	AreaDao dao = new AreaDao();
	
	/*
	public Gestor carregar(int id){
		return dao.carregar(id);
	}
	*/
		
	public ArrayList<Area> array(){
		return dao.array();
	}
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

