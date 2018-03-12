package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.OS;
import model.Projeto;


public class OSDao {
	
	
	public ArrayList<Projeto> projetosSemVinculo(){
		
		ArrayList<Projeto> lista = new ArrayList<Projeto>();
		
		String sqlSelect = "select id_projeto, nome, descricao, situacao, quantidade from projeto where id_OS is null";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					Projeto g = new Projeto();
					g.setId_projeto(rs.getInt("id_projeto"));
					g.setNome(rs.getString("nome"));
					g.setDescricao(rs.getString("descricao"));
					g.setSituacao(rs.getString("situacao"));
					JOptionPane.showMessageDialog(null, g.getNome());
					g.setQuantidade(rs.getInt("quantidade"));
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
	
public ArrayList<Projeto> projetosVinculados(int id){
		
		ArrayList<Projeto> lista = new ArrayList<Projeto>();
		
		String sqlSelect = "select id_projeto, nome, descricao, situacao, quantidade from projeto where id_OS= ?";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					Projeto g = new Projeto();
					g.setId_projeto(rs.getInt("id_projeto"));
					g.setNome(rs.getString("nome"));
					g.setDescricao(rs.getString("descricao"));
					g.setSituacao(rs.getString("situacao"));
					g.setQuantidade(rs.getInt("quantidade"));
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


	
public ArrayList<OS> retornaUmVetor() {
		
		ArrayList<OS> lista = new ArrayList <OS>();
		
		String sqlSelect = "select id_OS, nome, nome_fantasia, cnpj, email, endereco, numero, complemento, estado, cidade, data_inicio, status, id_projeto, nome_projeto FROM vw_os";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					OS g = new OS();
					g.setId_OS(rs.getInt("id_OS"));
					g.setNome(rs.getString("nome"));
					g.setNome_fantasia(rs.getString("nome_fantasia"));
					g.setCnpj(rs.getString("cnpj"));
					g.setEmail(rs.getString("email"));
					g.setEndereco(rs.getString("endereco"));
					g.setNumero(rs.getString("numero"));
					g.setComplemento(rs.getString("complemento"));
					g.setEstado(rs.getString("estado"));
					g.setCidade(rs.getString("cidade"));
					g.setData_inicio(rs.getString("data_inicio"));
					g.setStatus(rs.getString("status"));
					g.setId_projeto(rs.getInt("id_projeto"));
					g.setNome_projeto(rs.getString("nome_projeto"));
					
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


	public void atualizar(OS os) {
		String sqlUpdate = "UPDATE os SET nome=?, nome_fantasia=?, cnpj=?, email=?, endereco=?, numero=?, cep=?, complemento=?, estado=?, cidade=?, data_inicio=?, status=? WHERE id_OS=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, os.getNome());
			stm.setString(2, os.getNome_fantasia());
			stm.setString(3, os.getCnpj());
			stm.setString(4, os.getEmail());
			stm.setString(5, os.getEndereco());
			stm.setString(6, os.getNumero());
			stm.setString(7, os.getCep());
			stm.setString(8, os.getComplemento());
			stm.setString(9, os.getEstado());
			stm.setString(10, os.getCidade());
			stm.setString(11, os.getData_inicio());
			stm.setString(12, os.getStatus());
			//stm.setInt(13, os.getId_projeto());
			//JOptionPane.showMessageDialog(null, os.getId_OS());
			stm.setInt(13, os.getId_OS());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public OS carregar(int id) {
		OS os = new OS();
		os.setId_OS(id);
		String sqlSelect = "SELECT id_projeto, nome, nome_fantasia, cnpj, email, endereco, numero, complemento, estado, cidade, data_inicio, cep, status FROM os WHERE os.id_OS = ?";
		
		//String sqlSelect = "SELECT nome, fone, email FROM cliente WHERE cliente.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, os.getId_OS());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					os.setId_projeto(rs.getInt("id_projeto"));
					os.setNome(rs.getString("nome"));
					os.setNome_fantasia(rs.getString("nome_fantasia"));
					os.setCnpj(rs.getString("cnpj"));
					os.setCep(rs.getString("cep"));
					os.setEmail(rs.getString("email"));
					os.setEndereco(rs.getString("endereco"));
					os.setNumero(rs.getString("numero"));
					os.setComplemento(rs.getString("complemento"));
					os.setEstado(rs.getString("estado"));
					os.setCidade(rs.getString("cidade"));
					os.setData_inicio(rs.getString("data_inicio"));
					os.setStatus(rs.getString("status"));
					
					
				} else {
					os.setId_OS(-1);
					os.setNome(null);
					os.setNome_fantasia(null);
					os.setCnpj(null);
					os.setEmail(null);
					os.setEndereco(null);
					os.setNumero(null);
					os.setComplemento(null);
					os.setEstado(null);
					os.setCidade(null);
					os.setData_inicio(null);
					os.setStatus(null);
				
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return os;
	}
	
	
	public int criar(OS os) {
		String sqlInsert = "INSERT INTO os(nome, nome_fantasia, cnpj, email, endereco, numero, cep, complemento, estado, cidade, data_inicio, status) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			
			stm.setString(1, os.getNome());
			stm.setString(2, os.getNome_fantasia());
			stm.setString(3, os.getCnpj());
			stm.setString(4, os.getEmail());
			stm.setString(5, os.getEndereco());
			stm.setString(6, os.getNumero());
			stm.setString(7, os.getCep());
			stm.setString(8, os.getComplemento());
			stm.setString(9, os.getEstado());
			stm.setString(10, os.getCidade());
			stm.setString(11, os.getData_inicio());
			stm.setString(12, os.getStatus());
			//stm.setInt(13, os.getId_projeto());
			
			stm.execute();
			
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					os.setId_OS(rs.getInt(1));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return os.getId_OS();
	}	
	
	public boolean excluir(int id) {
		String sqlDelete = "DELETE FROM os WHERE id_OS = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;		
	
	}
	

}
