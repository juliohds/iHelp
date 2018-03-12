package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Projeto;
import model.Voluntario;


public class ProjetoDao {
	
	
	public boolean verificaVinculo(int idP, int idV){
		
		String sql = "select * from projeto_voluntario where id_projeto= ?";
		
		try (Connection conn1 = ConnectionFactory.obtemConexao();
				PreparedStatement stm1 = conn1.prepareStatement(sql);) {
				//stm1.setInt(1, idP);
				stm1.setInt(1, idP);
				
				try (ResultSet rs1 = stm1.executeQuery();) {
					
					if(rs1.next()) {
						return true;
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		
		return false;
	}

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
					//JOptionPane.showMessageDialog(null, g.getNome());
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
	
	public void vincularProjeto(int id_os, int id_projeto){
		
		String sqlSelect = "update projeto set id_OS = ? where id_projeto = ?";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setInt(1, id_os);
				stm.setInt(2, id_projeto);
				stm.execute();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void DesvincularProjeto(int id_os, int id_projeto){
		
		String sqlSelect = "update projeto set id_OS = null where id_OS=? and id_projeto = ?";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setInt(1, id_os);
				stm.setInt(2, id_projeto);
				stm.execute();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
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


public ArrayList<Projeto> retornaUmArray() {
	
	ArrayList<Projeto> lista = new ArrayList <Projeto> ();
	
	String sqlSelect = "SELECT id_projeto, nome, quantidade, descricao, situacao FROM projeto";
	// usando o try with resources do Java 7, que fecha o que abriu
	try (Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
		
		try (ResultSet rs = stm.executeQuery();) {
			while(rs.next()) {
				Projeto p = new Projeto();
				p.setId_projeto(rs.getInt("id_projeto"));
				p.setNome(rs.getString("nome"));
				p.setDescricao(rs.getString("descricao"));
				p.setQuantidade(rs.getInt("quantidade"));
				p.setSituacao(rs.getString("situacao"));
				lista.add(p);
				
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} catch (SQLException e1) {
		System.out.print(e1.getStackTrace());
	}
	
	return lista;
}


public ArrayList<Projeto> vetorFind(String s) {
	
	ArrayList<Projeto> lista = new ArrayList <Projeto> ();
	
	String sqlSelect = "SELECT id_projeto, nome, descricao, quantidade FROM projeto where upper(nome) like ?";
	// usando o try with resources do Java 7, que fecha o que abriu
	try (Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			
			stm.setString(1, "%"+s.toUpperCase()+"%");
			
		try (ResultSet rs = stm.executeQuery();) {
			while(rs.next()) {
				Projeto p = new Projeto();
				p.setId_projeto(rs.getInt("id_projeto"));
				p.setNome(rs.getString("nome"));
				p.setDescricao(rs.getString("descricao"));
				p.setQuantidade(rs.getInt("quantidade"));
				lista.add(p);
				
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} catch (SQLException e1) {
		System.out.print(e1.getStackTrace());
	}
	
	return lista;
}

	public int[] carregaArea(Projeto projeto){
		
		String sql="SELECT id_area from projeto_area where id_projeto = ?";
		int vetor[] = new int[7];
		int i = 0;
		
		try(Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sql);) {
			
			stm.setInt(1, projeto.getId_projeto());
			
			try (ResultSet rs = stm.executeQuery();) {
				
				while (rs.next()) {
					vetor[i] = rs.getInt("id_area");
					i++;
				}
			} catch (Exception e) {
					// TODO: handle exception
				}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		projeto.setId_area(vetor);
		
		return vetor;
	}

	public void inserirDisponibilidade(Projeto projeto){
		
		String sqlInsert = "INSERT INTO disponibilidade (segunda, terca, quarta, quinta, sexta, sabado, domingo, id_projeto) values(?, ?, ?, ?, ?, ?, ?, ?)";
		String s[] = projeto.getDisponibilidade();
		
		try (Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlInsert);){
			
			for (int i = 0; i < s.length; i++) {
				stm.setString(i+1, s[i]);
			}
			stm.setInt(8, projeto.getId_projeto());
			stm.execute();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
		
	public void atualizar(Projeto projeto) {
		String sqlUpdate = "UPDATE projeto SET nome=?, descricao=?, quantidade=?, situacao=? WHERE id_projeto=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, projeto.getNome());
			stm.setString(2, projeto.getDescricao());
			stm.setInt(3, projeto.getQuantidade());
			stm.setString(4,  projeto.getSituacao());
			stm.setInt(5, projeto.getId_projeto());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Projeto carregar(int id) {
		Projeto projeto = new Projeto();
		projeto.setId_projeto(id);
		String sqlSelect = "SELECT nome, descricao, situacao, quantidade FROM projeto WHERE projeto.id_projeto = ?";
		
		//String sqlSelect = "SELECT nome, fone, email FROM cliente WHERE cliente.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, projeto.getId_projeto());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					projeto.setNome(rs.getString("nome"));
					projeto.setDescricao(rs.getString("descricao"));
					projeto.setSituacao(rs.getString("situacao"));
					projeto.setQuantidade(rs.getInt("quantidade"));
					
				} else {
					projeto.setId_projeto(-1);
					projeto.setNome(null);
					projeto.setDescricao(null);
				
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return projeto;
	}
	
	public void excluirArea(int id){
		
		String sql="delete from projeto_area where id_projeto=?";
		
		try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sql);){
			
			stm.setInt(1, id);
			stm.execute();
			//JOptionPane.showMessageDialog(null, "delete * from voluntario_area where id_voluntario="+id);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public int criar(Projeto projeto) {
		String sqlInsert = "INSERT INTO projeto(nome, descricao, situacao, quantidade) values(?, ?, ?, ?)";
		
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
		
			stm.setString(1,  projeto.getNome());
			stm.setString(2,  projeto.getDescricao());
			stm.setString(3, projeto.getSituacao());
			stm.setInt(4, projeto.getQuantidade());
			//stm.setInt(3, projeto.getId_area());
			
			stm.execute();
			
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					projeto.setId_projeto(rs.getInt(1));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return projeto.getId_projeto();
	}	
	
	public void insereArea(Projeto projeto){
		
		int vetor[] = projeto.getId_area();
		int j=0;
		
		for (int i = 0; i < vetor.length; i++) {
			
		if(projeto.getId_area()[i]!=0){
		String sqlQuery2 = "INSERT INTO projeto_area(id_projeto, id_area) values(?,?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm3 = conn.prepareStatement(sqlQuery2);) {
			
			stm3.setInt(1, projeto.getId_projeto());
			stm3.setInt(2, projeto.getId_area()[i]);
			stm3.execute();
			
			//JOptionPane.showMessageDialog(null, "teste to aqui " +voluntario.getId_voluntario() + voluntario.getId_area()[0]);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		}
		}
		
	}

	
	public String[] alterarDisponibilidade(Projeto projeto){
		
		String sqlInsert = "update disponibilidade set segunda=?, terca=?, quarta=?, quinta=?, sexta=?, sabado=?, domingo=? where id_projeto=?";
		String s[] = projeto.getDisponibilidade();
		
		try (Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlInsert);){
			
			for (int i = 0; i < s.length; i++) {
				stm.setString(i+1, s[i]);
			}
			stm.setInt(8, projeto.getId_projeto());
			stm.execute();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return s;
	}
	
	public boolean excluirdisponibilidade(int id){
		
		boolean teste = false;
		
		String sql =  "DELETE from disponibilidade where id_projeto = ?";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sql);){
				
			stm.setInt(1, id);
			stm.execute();
			teste = true;
			
		} catch (SQLException e) {
					e.printStackTrace();
				}
			
		return teste;
	}

	
public String[] carregarDisponibilidade(Projeto projeto){
		
		String sqlInsert = "select segunda, terca, quarta, quinta, sexta, sabado, domingo, id_voluntario, id_projeto from disponibilidade where id_projeto = ?";
		String s[] = new String[7];
		
		try (Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlInsert);){
			
			stm.setInt(1, projeto.getId_projeto());	
			
			try (ResultSet rs = stm.executeQuery();) {
				
				if (rs.next()) {
					
					s[0] = rs.getString("segunda");
					s[1] = rs.getString("terca");
					s[2] = rs.getString("quarta");
					s[3] = rs.getString("quinta");
					s[4] = rs.getString("sexta");
					s[5] = rs.getString("sabado");
					s[6] = rs.getString("domingo");
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			projeto.setDisponibilidade(s);
					
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return s;
	}
	
	public void excluirVinculos(int id){
		
		String sqlDelete = "DELETE FROM projeto_voluntario WHERE id_projeto = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}
	
	public boolean excluir(int id) {
		String sqlDelete = "DELETE FROM projeto WHERE id_projeto = ?";
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

