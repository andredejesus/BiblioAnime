package com.biblio.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.biblio.dao.AnimeDao;
import com.biblio.domain.Anime;

public class AnimeTest {

	public static void main(String[] args) {
		
		String qualidade = "Assistindo";
		
		AnimeDao animeDao = new AnimeDao();
		
		try {
			
			List<Anime> lista = new ArrayList<>();
			lista = animeDao.buscarAnimes(qualidade);
			
			for (Anime anime : lista) {
				System.out.println("Nome do anime: " + anime.getNomeAnime());
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Ocorreu um erro..." + e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Ocorreu um erro..." + e.getMessage());
		}
		
		
	}
	
}
