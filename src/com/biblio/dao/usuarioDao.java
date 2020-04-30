package com.biblio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.biblio.domain.Usuario;
import com.biblio.factory.ConexaoFactory;

public class usuarioDao {
	
	public void cadastrarUsuario(Usuario usuario) throws ClassNotFoundException, SQLException {
		
		Connection conexao = ConexaoFactory.getConexao();
		String query = "INSERT INTO tb_usuario (nome, email, senha) VALUES (?,?,?);";
		PreparedStatement pst = conexao.prepareStatement(query);
		pst.setString(1, usuario.getNome());
		pst.setString(2, usuario.getEmail());
		pst.setString(3, usuario.getSenha());
		pst.execute();
		
	}
	
	public Usuario buscarUsuario(String email, String senha) throws ClassNotFoundException, SQLException {
		
		Connection conexao = ConexaoFactory.getConexao();
		String query = "SELECT * FROM tb_usuario WHERE email = ? and senha = ?;";
		PreparedStatement pst = conexao.prepareStatement(query);
		pst.setString(1, email);
		pst.setString(2, senha);
		ResultSet rs = pst.executeQuery();
		
		while(rs.next()) {
			Usuario usuario = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			return usuario;
		}
		
		return null;
	}

}
