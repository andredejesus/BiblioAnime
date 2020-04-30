package com.biblio.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biblio.dao.usuarioDao;
import com.biblio.domain.Usuario;

@WebServlet("/usuarioServlet")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UsuarioServlet() {
        super();
    }
    
    Usuario usuario = new Usuario();
    usuarioDao usuDao = new usuarioDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String acao = request.getParameter("acao");
		
		switch (acao) {
		
		case "cadastrar":{
			RequestDispatcher dispatcher = request.getRequestDispatcher("/paginas/usuario/formUsuario.jsp");
			dispatcher.forward(request, response);
			break;
		}
		case "salvar":{
			salvarUsuario(request, response);
			break;
		}

		default:

		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void salvarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		usuario.setNome(request.getParameter("nome"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setSenha(request.getParameter("senha"));
		
		try {
			
			usuDao.cadastrarUsuario(usuario);
			request.setAttribute("mensagemSucesso", "Cadastro realizado com sucesso.");
			
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
			request.setAttribute("mensagemErro", "Ocorreu um erro.. " + e.getMessage());
			
		} catch (SQLException e) {
	
			e.printStackTrace();
			request.setAttribute("mensagemErro", "Ocorreu um erro.. " + e.getMessage());
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
		
		
		
	}

}
