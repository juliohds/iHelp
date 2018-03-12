package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Gestor;

public class GestorDao {

	public int criar(Gestor gestor) {
		String sqlInsert = "INSERT INTO gestor(nome, cpf, login, senha) VALUES (?, ?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, gestor.getNome());
			stm.setString(2, gestor.getCpf());
			stm.setString(3, gestor.getLogin());
			stm.setString(4, gestor.getSenha());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					gestor.setId_gestor(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gestor.getId_gestor();
	}	
	
	public void atualizar(Gestor gestor) {
		String sqlUpdate = "UPDATE gestor SET nome=?, cpf=?, Login=?, senha=? WHERE id=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, gestor.getNome());
			stm.setString(2, gestor.getCpf());
			stm.setString(3, gestor.getLogin());
			stm.setString(4, gestor.getSenha());
			stm.setInt(4, gestor.getId_gestor());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Gestor> retornaUmVetor() {
		
		ArrayList<Gestor> lista = new ArrayList <Gestor> ();
		
		String sqlSelect = "SELECT id_gestor, nome, cpf, login, senha FROM gestor";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					Gestor g = new Gestor();
					g.setId_gestor(rs.getInt("id_gestor"));
					g.setNome(rs.getString("nome"));
					g.setCpf(rs.getString("cpf"));
					g.setLogin(rs.getString("login"));
					g.setSenha(rs.getString("senha"));
					lista.add(g);
					
				} 
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		
		return lista;
	}
	
	
	public void excluir(int id) {
		String sqlDelete = "DELETE FROM gestor WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public Gestor carregar(int id) {
		Gestor gestor = new Gestor();
		gestor.setId_gestor(id);
		String sqlSelect = "SELECT nome, cpf, login, senha FROM gestor WHERE gestor.id_gestor = ?";
		
		//String sqlSelect = "SELECT nome, fone, email FROM cliente WHERE cliente.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, gestor.getId_gestor());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					gestor.setNome(rs.getString("nome"));
					gestor.setCpf(rs.getString("cpf"));
					gestor.setLogin(rs.getString("login"));
					gestor.setSenha(rs.getString("senha"));
				} else {
					gestor.setId_gestor(-1);
					gestor.setNome(null);
					gestor.setCpf(null);
					gestor.setLogin(null);
					gestor.setSenha(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return gestor;
	}
	
}
