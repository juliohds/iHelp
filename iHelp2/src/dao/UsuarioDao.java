package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Endereco;
import model.Usuario;
import model.Voluntario;

public class UsuarioDao {

	public int logar(Usuario usuario) {
		String sqlInsert = "select * from voluntario where email= ? and senha= ?";
		boolean flag = false;
		int i = -1;
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {

			stm.setString(1, usuario.getLogin());
			stm.setString(2, usuario.getSenha());

			try (ResultSet rs = stm.executeQuery();) {

				if (rs.next()) {
					i = rs.getInt("id_voluntario");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public Voluntario carregarUsuario(Usuario user) {
		String sql = "select * from voluntario where email= ?";
		Voluntario voluntario = new Voluntario();

		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sql);) {

			stm.setString(1, user.getLogin());

			try (ResultSet rs = stm.executeQuery();) {

				if (rs.next()) {
					
					voluntario.setId_voluntario(rs.getInt("id_voluntario"));
					voluntario.setNome(rs.getString("nome"));
					voluntario.setEmail(rs.getString("email"));
					voluntario.setData_nascimento(rs.getString("data_nascimento"));
					voluntario.setGenero(rs.getString("genero"));
					voluntario.setTelefone(rs.getString("telefone"));
					voluntario.setCelular(rs.getString("celular"));
					voluntario.setRg(rs.getString("rg"));
					voluntario.setCpf(rs.getString("cpf"));
					voluntario.setEstado_civil(rs.getString("estado_civil"));
					voluntario.setSenha(rs.getString("senha"));
					voluntario.setDescricao(rs.getString("descricao"));
					
					Endereco endereco = new Endereco();
					endereco.setEndereco(rs.getString("endereco"));
					endereco.setNumero(rs.getString("numero"));
					endereco.setComplemento(rs.getString("complemento"));
					endereco.setCep(rs.getString("cep"));
					endereco.setEstado(rs.getString("estado"));
					endereco.setCidade(rs.getString("cidade"));
					voluntario.setEndereco(endereco);
										
					
					
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return voluntario;
	}

}