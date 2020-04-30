<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>BiblioAnime</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href="resources/css/style.css">

</head>

<body>
	
	<main class="cadastroUsuario">
	
		<h3 class="tituloCadastro">Cadastro</h3>
		
		<div class="card">

			 <div class="card-body">
	

			    <form method="post" action="usuarioServlet?acao=salvar">
			    
					  <div class="form-group">
					    <label for="nome">Nome</label>
					    <input type="text" class="form-control" id="nome" name="nome" placeholder="Seu nome">
					  </div>
					  
					  <div class="form-group">
					    <label for="email">Email</label>
					    <input type="email" class="form-control" id="email" name="email" placeholder="Seu e-mail">
					  </div>
					  
					  <div class="form-group">
					    <label for="senha">Senha</label>
					    <input type="password" class="form-control" id="senha" name="senha" placeholder="Senha">
 					  </div>
					  
					  <button type="submit" class="btn btn-primary">Enviar</button>
					  
				</form>
			    
			 </div>
		</div>
		
	</main>

	

</body>

</html>