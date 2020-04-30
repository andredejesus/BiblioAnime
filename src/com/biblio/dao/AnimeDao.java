package com.biblio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.biblio.domain.Anime;
import com.biblio.factory.ConexaoFactory;

public class AnimeDao {
	
	public void salvarAnime(Anime anime) throws ClassNotFoundException, SQLException {
		
		Connection conexao = ConexaoFactory.getConexao();
		String query = "INSERT INTO tb_anime (nomeAnime, sinopse, categoria) VALUES (?,?,?)";
		PreparedStatement pst = conexao.prepareStatement(query);
		pst.setString(1, anime.getNomeAnime());
		pst.setString(2, anime.getSinopse());
		pst.setString(3, anime.getCategoria());
		pst.execute();
		
	}
	
	public List<Anime> buscarAnimes(String qualidade) throws ClassNotFoundException, SQLException{
		
		Connection conexao = ConexaoFactory.getConexao();
		String query = "SELECT * FROM tb_anime WHERE categoria = ?;";
		PreparedStatement pst = conexao.prepareStatement(query);
		
		pst.setString(1, qualidade);
		ResultSet rs = pst.executeQuery();
		
		List<Anime> animes = new ArrayList<>();
		
		while (rs.next()) {
			Anime anime = new Anime(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			animes.add(anime);
		}
		
		return animes;
	}
	
	public Anime buscarAnimePorId (Integer id) throws ClassNotFoundException, SQLException {
		
		Connection conexao = ConexaoFactory.getConexao();
		String query = "SELECT * FROM tb_anime WHERE id = ?";
		PreparedStatement pst = conexao.prepareStatement(query);
		pst.setInt(1, id);
		
		ResultSet rs = pst.executeQuery();
		
		while (rs.next()) {
			Anime anime = new Anime(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			return anime;
		}
		
		return null;
	}
	
	public void alterarAnime(Anime anime) throws ClassNotFoundException, SQLException {
		
		Connection conexao = ConexaoFactory.getConexao();
		String query = "UPDATE tb_anime SET nomeAnime = ?, sinopse = ?, categoria = ? WHERE id = ?";
		PreparedStatement pst = conexao.prepareStatement(query);
		pst.setString(1, anime.getNomeAnime());
		pst.setString(2, anime.getSinopse());
		pst.setString(3, anime.getCategoria());
		pst.setInt(4, anime.getId());
		pst.execute();
		
	}
	
	public void deletarAnime(Integer id) throws ClassNotFoundException, SQLException {
		Connection conexao = ConexaoFactory.getConexao();
		String query = "DELETE FROM tb_anime WHERE id = ?";
		PreparedStatement pst = conexao.prepareStatement(query);
		pst.setInt(1, id);
		pst.execute();
	}

}
