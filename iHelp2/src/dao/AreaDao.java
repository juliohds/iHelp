package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Area;

public class AreaDao {

	
	public ArrayList<Area> array() {
		
		ArrayList<Area> lista = new ArrayList <Area> ();
		
		String sqlSelect = "SELECT id_area, nome FROM area";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					Area a = new Area();
					a.setId_area(rs.getInt("id_area"));
					a.setNome(rs.getString("nome"));
					lista.add(a);
					
				} 
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		
		return lista;
	}
	
	
	
}
