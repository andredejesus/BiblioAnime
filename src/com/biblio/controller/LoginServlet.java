package com.biblio.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.biblio.dao.usuarioDao;
import com.biblio.domain.Usuario;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();

    }
    
    Usuario usuario = new Usuario();
    usuarioDao usuDao = new usuarioDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String acao = request.getParameter("acao");
		
		switch (acao) {
		case "login": {
			login(request, response);
			break;
		}
		case "sair":{
			logout(request, response);
			break;
		}
		default:

		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}
	
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String inputEmail = request.getParameter("email");
		String inputSenha = request.getParameter("senha");
		
		try {
			
			usuario = usuDao.buscarUsuario(inputEmail, inputSenha);
			
			if(usuario.getEmail().equals(inputEmail) && usuario.getSenha().equals(inputSenha)) {
				
				HttpSession session = request.getSession();
				
				session.setAttribute("usuarioSession", usuario);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/paginas/usuario/home.jsp");
				dispatcher.forward(request, response);
				
			}
			
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}
	
	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		session.invalidate();
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
		
	}

}
