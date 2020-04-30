package com.biblio.test;

import java.sql.SQLException;

import com.biblio.dao.usuarioDao;
import com.biblio.domain.Usuario;

public class usuarioTest {
	
	public static void main(String[] args) {
		
		Usuario usu = new Usuario();
		usuarioDao usuDao = new usuarioDao();
		
		/*SALVAR USUARIO*/
		
		/*usu.setNome("André de Jesus");
		usu.setEmail("andre@gmail.com");
		usu.setSenha("12345678");
		
		
		
		
		try {
			usuDao.cadastrarUsuario(usu);
			System.out.println("Usuário salvo com sucesso!");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
			System.out.println("Ocorreu um erro: " + e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Ocorreu um erro de SQL: " + e.getMessage());
		}*/
		
		/*REALIZAR LOGIN USUARIO*/
		
		/*String emailPreenchido = "andre@gmail.com";
		String senhaPreenchida = "12345678";

		try {
			usu = usuDao.buscarUsuario(emailPreenchido, senhaPreenchida);
			
			if(usu.getEmail().equals(emailPreenchido)  && usu.getSenha().equals(senhaPreenchida) ) {
				
				System.out.println("Usuário autenticado!");
			}else {
				System.out.println("Usuário não autenticado!");
			}
			
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
			System.out.println("Erro" + e.getMessage());
			
			
		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("Erro" + e.getMessage());
		}*/
		
	}

}
