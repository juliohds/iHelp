package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Endereco;
import model.Projeto;
import model.Voluntario;
import service.ProjetoService;
import service.VoluntarioService;


public class VoluntarioDao {
	
	
	public void VincularVoluntario(int idP, int idV){
				
		String sql = "insert into projeto_voluntario (id_projeto, id_voluntario) values(?, ?)";
		
		try (Connection conn1 = ConnectionFactory.obtemConexao();
				PreparedStatement stm1 = conn1.prepareStatement(sql);) {
				stm1.setInt(1, idP);
				stm1.setInt(2, idV);
				stm1.execute();
			
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		
			
		
	}
	
	public boolean verificaVinculo(int idP, int idV){
		
		String sql = "select * from projeto_voluntario where id_voluntario= ?";
		
		try (Connection conn1 = ConnectionFactory.obtemConexao();
				PreparedStatement stm1 = conn1.prepareStatement(sql);) {
				//stm1.setInt(1, idP);
				stm1.setInt(1, idV);
				
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
	
	public void excluirVinculo(int id){
		
		String sql= "delete from projeto_voluntario where id_voluntario=?";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
			 PreparedStatement stm = conn.prepareStatement(sql);){
			 stm.setInt(1, id);

			 stm.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public void DesvincularVoluntario(int idP, int idV){
		
		String sql= "delete from projeto_voluntario where id_projeto=? and id_voluntario=?";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
			 PreparedStatement stm = conn.prepareStatement(sql);){
			 stm.setInt(1, idP);
			 stm.setInt(2, idV);
			 stm.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public ArrayList<Voluntario> retornaVoluntariosVinculados(int id_projeto){
		
		ArrayList<Voluntario> lista = new ArrayList();
		VoluntarioService vs = new VoluntarioService();
		
		ProjetoService ps = new ProjetoService();
		Projeto projeto = new Projeto();
		projeto = ps.carregar(id_projeto);
		int max = projeto.getQuantidade();
		
		String sql = "SELECT * from projeto_voluntario where id_projeto=?";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
			 PreparedStatement stm = conn.prepareStatement(sql);) {
			 stm.setInt(1, id_projeto);
			 
			 try(ResultSet rs = stm.executeQuery();) {
				
				 while(rs.next() || max==0 ) {
					 
					 Voluntario v = new Voluntario();
					 v = vs.carregar(rs.getInt("id_voluntario"));
					 lista.add(v);
					 max--;
					 
				}
				 
				 
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return lista;
		
	}
	
public Voluntario[] retornaUmVetor() {
		
		String sqlCount = "SELECT count(id_voluntario) as 'contador' from voluntario";
		int i = 0;
		
		try (Connection conn1 = ConnectionFactory.obtemConexao();
				PreparedStatement stm1 = conn1.prepareStatement(sqlCount);) {
			
			try (ResultSet rs1 = stm1.executeQuery();) {
				
				if(rs1.next()) {
					i = rs1.getInt("contador");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
				
		Voluntario[] voluntario = new Voluntario[i];
		int count = 0;
		
		String sqlSelect = "SELECT id_voluntario, nome, email, data_nascimento, genero, telefone, celular, rg, cpf, endereco, numero, complemento, cep, estado_civil, senha, descricao, estado, cidade FROM voluntario";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					Voluntario g = new Voluntario();
					Endereco endereco = new Endereco();
					g.setId_voluntario(rs.getInt("id_voluntario"));
					g.setNome(rs.getString("nome"));
					g.setEmail(rs.getString("email"));
					g.setData_nascimento(rs.getString("data_nascimento"));
					g.setGenero(rs.getString("genero"));
					g.setTelefone(rs.getString("telefone"));
					g.setCelular(rs.getString("celular"));
					g.setRg(rs.getString("rg"));
					g.setCpf(rs.getString("cpf"));
					g.setEstado_civil(rs.getString("estado_civil"));
					g.setSenha(rs.getString("senha"));
					g.setDescricao(rs.getString("descricao"));
					
					endereco.setEndereco(rs.getString("endereco"));
					endereco.setNumero(rs.getString("numero"));
					endereco.setComplemento(rs.getString("complemento"));
					endereco.setCep(rs.getString("cep"));
					endereco.setEstado(rs.getString("estado"));
					endereco.setCidade(rs.getString("cidade"));
					
					g.setEndereco(endereco);
					voluntario[count] = g;
					count++;
					
				} 
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		
		return voluntario;
	}
	
public ArrayList<Voluntario> retornaUmArray() {
	
	ArrayList<Voluntario> lista = new ArrayList <Voluntario> ();
	
	String sqlSelect = "SELECT id_voluntario, nome, email, senha FROM voluntario";
	// usando o try with resources do Java 7, que fecha o que abriu
	try (Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
		
		try (ResultSet rs = stm.executeQuery();) {
			while(rs.next()) {
				Voluntario v = new Voluntario();
				v.setId_voluntario(rs.getInt("id_voluntario"));
				v.setNome(rs.getString("nome"));
				v.setEmail(rs.getString("email"));
				v.setSenha(rs.getString("senha"));
				carregarDisponibilidade(v);
				carregaArea(v);
				lista.add(v);
				
				
				
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} catch (SQLException e1) {
		System.out.print(e1.getStackTrace());
	}
	
	return lista;
}

	public void inserirDisponibilidade(Voluntario voluntario){
		
		String sqlInsert = "INSERT INTO disponibilidade (segunda, terca, quarta, quinta, sexta, sabado, domingo, id_voluntario) values(?, ?, ?, ?, ?, ?, ?, ?)";
		String s[] = voluntario.getDisponibilidade();
		
		try (Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlInsert);){
			
			for (int i = 0; i < s.length; i++) {
				stm.setString(i+1, s[i]);
			}
			stm.setInt(8, voluntario.getId_voluntario());
			stm.execute();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void excluirdisponibilidade(int id){
		
		String sql =  "DELETE from disponibilidade where id_voluntario = ?";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sql);){
				
			stm.setInt(1, id);
			stm.execute();
			
		} catch (SQLException e) {
					e.printStackTrace();
				}
				
	}
	
	public String[] carregarDisponibilidade(Voluntario voluntario){
		
		String sqlInsert = "select segunda, terca, quarta, quinta, sexta, sabado, domingo, id_voluntario, id_projeto from disponibilidade where id_voluntario = ?";
		String s[] = new String[7];
		
		try (Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlInsert);){
			
			stm.setInt(1, voluntario.getId_voluntario());	
			
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
			
			voluntario.setDisponibilidade(s);
					
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return s;
	}
	
	
	public int criar(Voluntario voluntario) {
		String sqlInsert = "INSERT INTO voluntario(nome, email, data_nascimento, genero, telefone, celular, rg, cpf, endereco, numero, complemento, cep, estado_civil, senha, descricao, estado, cidade) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Endereco endereco = voluntario.getEndereco();
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
		
			stm.setString(1,  voluntario.getNome());
			stm.setString(2,  voluntario.getEmail());
			stm.setString(3,  voluntario.getData_nascimento());
			stm.setString(4,  voluntario.getGenero());
			stm.setString(5,  voluntario.getTelefone());
			stm.setString(6,  voluntario.getCelular());
			stm.setString(7,  voluntario.getRg());
			stm.setString(8,  voluntario.getCpf());
			stm.setString(9,  endereco.getEndereco());
			stm.setString(10, endereco.getNumero());
			stm.setString(11, endereco.getComplemento());
			stm.setString(12, endereco.getCep());
			stm.setString(13, voluntario.getEstado_civil());
			stm.setString(14, voluntario.getSenha());
			stm.setString(15, voluntario.getDescricao());
			stm.setString(16, endereco.getEstado());
			stm.setString(17, endereco.getCidade());
			stm.execute();
			
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					voluntario.setId_voluntario(rs.getInt(1));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			//JOptionPane.showMessageDialog(null, "VL="+vetor.length+" vetor[0] = "+vetor[0]+" vetor[1] = "+vetor[1]);
			//for (int j = 0; j > vetor.length; j++) {
			
								
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return voluntario.getId_voluntario();
	}	
	
	public Voluntario carregaArea(Voluntario voluntario){
		
		String sql="SELECT id_area from voluntario_area where id_voluntario = ?";
		int vetor[] = new int[7];
		int i = 0;
		
		try(Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sql);) {
			
			stm.setInt(1, voluntario.getId_voluntario());
			
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
		
		voluntario.setId_area(vetor);
		
		return voluntario;
	}
	
	public void excluirArea(int id){
		
		String sql="delete from voluntario_area where id_voluntario=?";
		
		try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sql);){
			
			stm.setInt(1, id);
			stm.execute();
			//JOptionPane.showMessageDialog(null, "delete * from voluntario_area where id_voluntario="+id);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void insereArea(Voluntario voluntario){
		
		int vetor[] = voluntario.getId_area();
		int j=0;
		
		for (int i = 0; i < vetor.length; i++) {
			
		
		String sqlQuery2 = "INSERT INTO voluntario_area(id_voluntario, id_area) values(?,?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm3 = conn.prepareStatement(sqlQuery2);) {
			
			stm3.setInt(1, voluntario.getId_voluntario());
			stm3.setInt(2, voluntario.getId_area()[i]);
			stm3.execute();
			
			//JOptionPane.showMessageDialog(null, "teste to aqui " +voluntario.getId_voluntario() + voluntario.getId_area()[0]);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		}
		
	}
	
		public Voluntario carregar(int id) {
			Voluntario voluntario = new Voluntario();
			voluntario.setId_voluntario(id);
		String sqlSelect = "SELECT id_voluntario, nome, email, data_nascimento, genero, telefone, celular, rg, cpf, endereco, numero, complemento, cep ,estado_civil, senha, descricao, estado, cidade FROM voluntario WHERE voluntario.id_voluntario = ?";
		
		//String sqlSelect = "SELECT nome, fone, email FROM cliente WHERE cliente.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, voluntario.getId_voluntario());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					Endereco endereco = new Endereco();
					voluntario.setId_voluntario(rs.getInt("id_voluntario"));
					voluntario.setNome(rs.getString("nome"));
					voluntario.setEmail(rs.getString("email"));
					voluntario.setData_nascimento(rs.getString("data_nascimento"));
					voluntario.setGenero(rs.getString("genero"));
					voluntario.setTelefone(rs.getString("telefone"));
					voluntario.setCelular(rs.getString("celular"));
					voluntario.setRg(rs.getString("rg"));
					voluntario.setCpf(rs.getString("cpf"));
					endereco.setEndereco(rs.getString("endereco"));
					endereco.setNumero(rs.getString("numero"));
					endereco.setComplemento(rs.getString("complemento"));
					endereco.setCep(rs.getString("cep"));
					voluntario.setEstado_civil(rs.getString("estado_civil"));
					voluntario.setSenha(rs.getString("senha"));
					voluntario.setDescricao(rs.getString("descricao"));
					endereco.setEstado(rs.getString("estado"));
					endereco.setCidade(rs.getString("cidade"));
					voluntario.setEndereco(endereco);
					
				} else {
					voluntario.setId_voluntario(-1);
					voluntario.setNome(null);
					voluntario.setCpf(null);
					voluntario.setData_nascimento(null);
					voluntario.setGenero(null);
					voluntario.setTelefone(null);
					voluntario.setCelular(null);
					voluntario.setRg(null);
					voluntario.setCpf(null);
					voluntario.setEndereco(null);
					voluntario.setEstado_civil(null);
					voluntario.setSenha(null);
					voluntario.setDescricao(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return voluntario;
	}
		
		public void excluir(int id) {
			String sqlDelete = "DELETE FROM voluntario WHERE id_voluntario = ?";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (Connection conn = ConnectionFactory.obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
				stm.setInt(1, id);
				stm.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		
		public Voluntario atualizar(Voluntario voluntario) {
			String sqlUpdate = "UPDATE voluntario SET nome=?, email=?, data_nascimento=?, genero=?, telefone=?, celular=?, rg=?, cpf=?, endereco=?, numero=?, complemento=?, cep=?, estado_civil=?, senha=?, descricao=?, estado=?, cidade=? WHERE id_voluntario=?";
			
			Endereco endereco = voluntario.getEndereco();
			// usando o try with resources do Java 7, que fecha o que abriu
			try (Connection conn = ConnectionFactory.obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
				stm.setString(1,  voluntario.getNome());
				stm.setString(2,  voluntario.getEmail());
				stm.setString(3,  voluntario.getData_nascimento());
				stm.setString(4,  voluntario.getGenero());
				stm.setString(5,  voluntario.getTelefone());
				stm.setString(6,  voluntario.getCelular());
				stm.setString(7,  voluntario.getRg());
				stm.setString(8,  voluntario.getCpf());
				
				stm.setString(9,  endereco.getEndereco());
				stm.setString(10, endereco.getNumero());
				stm.setString(11, endereco.getComplemento());
				stm.setString(12, endereco.getCep());
				stm.setString(13, voluntario.getEstado_civil());
				stm.setString(14, voluntario.getSenha());
				stm.setString(15, voluntario.getDescricao());
				stm.setString(16, endereco.getEstado());
				stm.setString(17, endereco.getCidade());
				stm.setInt(18, voluntario.getId_voluntario());
				stm.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return voluntario;
		}
		
		public String[] alterarDisponibilidade(Voluntario voluntario){
			
			String sqlInsert = "update disponibilidade set segunda=?, terca=?, quarta=?, quinta=?, sexta=?, sabado=?, domingo=? where id_voluntario=?";
			String s[] = voluntario.getDisponibilidade();
			
			try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);){
				
				for (int i = 0; i < s.length; i++) {
					stm.setString(i+1, s[i]);
				}
				stm.setInt(8, voluntario.getId_voluntario());
				stm.execute();
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			return s;
		}
}

