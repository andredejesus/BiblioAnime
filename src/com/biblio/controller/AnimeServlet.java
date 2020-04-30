package com.biblio.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biblio.dao.AnimeDao;
import com.biblio.domain.Anime;


@WebServlet("/animeServlet")
public class AnimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AnimeServlet() {
        super();

    }

    Anime anime = new Anime();
    AnimeDao animeDao = new AnimeDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String acao = request.getParameter("acao");
		
		switch (acao) {
		case "form": {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/paginas/animes/formAnimes.jsp");
			dispatcher.forward(request, response);
			break;
		}
		case "salvar":{
			salvarAnime(request, response);
			break;
		}
		case "meus-animes": {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/paginas/animes/buscarAnimes.jsp");
			dispatcher.forward(request, response);
			break;
		}
		case "buscar-anime": {
			buscarAnimes(request, response);
			break;
		}
		case "editar": {
			buscarAnimePorId(request, response);
			break;
		}
		case "deletar": {
			deletarAnime(request, response);
			break;
		}
		case "detalheAnime": {
			buscarAnime(request, response);
			break;
		}
		default:

		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void salvarAnime(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		
		anime.setNomeAnime(request.getParameter("nomeAnime"));
		anime.setSinopse(request.getParameter("sinopse"));
		anime.setCategoria(request.getParameter("categoria"));
		
		try {
			
			if(id.isEmpty()) {
				
				animeDao.salvarAnime(anime);
				request.setAttribute("mensagemSucesso", "Anime salvo com sucesso.");
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/paginas/animes/formAnimes.jsp");
				dispatcher.forward(request, response);
				
			}else {
				
				anime.setId(Integer.parseInt(id));
				animeDao.alterarAnime(anime);
				request.setAttribute("mensagemSucesso", "Anime editado com sucesso.");
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/paginas/animes/buscarAnimes.jsp");
				dispatcher.forward(request, response);
			}	
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			request.setAttribute("mensagemErro", "Ocorreu um erro. " + e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("mensagemErro", "Ocorreu um erro. " + e.getMessage());
		}
		
		anime = new Anime();
		
	}
	
	private void buscarAnimes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String categoria = request.getParameter("categoria");
		
		try {

			request.setAttribute("animes", animeDao.buscarAnimes(categoria));
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			request.setAttribute("mensagemErro", "Ocorreu um erro. " + e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("mensagemErro", "Ocorreu um erro. " + e.getMessage());
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/paginas/animes/buscarAnimes.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void buscarAnime(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id =  Integer.parseInt(request.getParameter("id"));
		
		try {
			request.setAttribute("anime", animeDao.buscarAnimePorId(id));
			
			
			//RequestDispatcher dispatcher = request.getRequestDispatcher("/paginas/animes/buscarAnimes.jsp");
			//dispatcher.forward(request, response);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private void buscarAnimePorId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id =  Integer.parseInt(request.getParameter("id"));
		
		try {
				
			request.setAttribute("anime", animeDao.buscarAnimePorId(id));
		
			RequestDispatcher dispatcher = request.getRequestDispatcher("/paginas/animes/formAnimes.jsp");
			dispatcher.forward(request, response);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private void deletarAnime(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		String categoria = request.getParameter("categoria");
		
		try {
			
			animeDao.deletarAnime(id);
			
			request.setAttribute("mensagemSucesso", "Anime deletado com sucesso.");
			
			request.setAttribute("animes", animeDao.buscarAnimes(categoria));
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			request.setAttribute("mensagemErro", "Ocorreu um erro. " + e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("mensagemErro", "Ocorreu um erro. " + e.getMessage());
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/paginas/animes/buscarAnimes.jsp");
		dispatcher.forward(request, response);
		
	}

}
