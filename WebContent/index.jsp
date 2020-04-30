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

	<div class="mensagens">
	
		<c:if test="${mensagemSucesso != null}">
			<div class="alert alert-success" role="alert">
 				 ${mensagemSucesso}
			</div>
		</c:if>
		
		<c:if test="${mensagemErro != null}">
			<div class="alert alert-danger" role="alert">
 				 ${mensagemErro}
			</div>
		</c:if>
		
	</div>
	
	<main class="loginUsuario">
	
		<div class="card card-form-login">
	
			  <div class="card-header bg-primary text-light">
			    <h4>Login</h4>
			  </div>
	  
			  <div class="card-body" >
				    
				    <form method="post" action="loginServlet">
				    
				    <input type="hidden" name="acao" value="login"/>
				    
					  <div class="form-group">
					    <label for="email">Endereço de email</label>
					    <input type="email" class="form-control" id="email" name="email" placeholder="Seu email">
					  </div>
					  
					  <div class="form-group">
					    <label for="senha">Senha</label>
					    <input type="password" class="form-control" id="senha" name="senha" placeholder="Senha">
					  </div>
					  
					  <button type="submit" class="btn btn-primary">Enviar</button>
					  <a role="button" class="btn btn-link" href="usuarioServlet?acao=cadastrar">Realizar Cadastro</a>
					  
					</form>
				    
			  </div>
	  
		</div>
	
	</main>


	

</body>

</html>