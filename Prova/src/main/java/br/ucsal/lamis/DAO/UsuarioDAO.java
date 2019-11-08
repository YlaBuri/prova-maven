package br.ucsal.lamis.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.ucsal.lamis.model.Usuario;
import br.ucsal.lamis.util.BancoUtil;

public class UsuarioDAO {
	
	public static Usuario autenticar(Usuario usuario) {
		
		Connection con = BancoUtil.getConnection(); 
		try { 
			 String sql="select * from usuarios where login=? and senha=?;";
			 PreparedStatement pstmt= con.prepareStatement(sql);
			 pstmt.setString(1, usuario.getLogin());
			 pstmt.setString(2, usuario.getSenha());
			 ResultSet resultSet=pstmt.executeQuery();
			 
			 if(resultSet.next()){ 
				 	usuario = new Usuario();
					usuario.setId(resultSet.getInt("usuario_id"));
					usuario.setLogin(resultSet.getString("login"));
					usuario.setSenha(resultSet.getString("senha")); 
			 } 
			 else {
				 return null;
			 }
			 resultSet.close(); 
			 pstmt.close(); 
		 } catch (SQLException e) { 
			 e.printStackTrace(); 
		 } 	
		return usuario;
	}
	
	public static Usuario obterUsuario(Integer id) {
		Usuario usuario=null;
		Connection con = BancoUtil.getConnection(); 
		try { 
			 String sql="select * from usuarios where usuario_id=?;";
			 PreparedStatement pstmt= con.prepareStatement(sql);
			 pstmt.setInt(1, id);
			 ResultSet resultSet=pstmt.executeQuery();
			 
			 if(resultSet.next()){ 
				usuario = new Usuario();
				usuario.setId(resultSet.getInt("usuario_id"));
				usuario.setLogin(resultSet.getString("login"));
				usuario.setSenha(resultSet.getString("senha"));
			 } 
			 resultSet.close(); 
			 pstmt.close(); 
		 } catch (SQLException e) { 
			 e.printStackTrace(); 
		 } 	
		return usuario;
	}
	
	
}

