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

	<header>
		<jsp:include page="/paginas/templates/header.jsp"></jsp:include>
	</header>

	<main class="main main-cadastro-anime">
		
		<aside>
			<jsp:include page="/paginas/templates/menu.jsp"></jsp:include>
		</aside>
		
		<div class="containerPrincipal">
		
		<h3 class="titulo-cadastrar-anime">Cadastrar Anime</h3>
		
		<c:if test="${mensagemSucesso != null}">
		
			<div class="alert alert-success alerta-form-animes" role="alert">
			  ${mensagemSucesso}
			</div>
		
		</c:if>
		
		<c:if test="${mensagemErro != null}">
		
			<div class="alert alert-danger" role="alert">
			  ${mensagemErro}
			</div>
		
		</c:if>
		
		<div class="card card-cadastro-anime">
		
			  <div class="card-body">
			  
			    <form method="post" action="animeServlet?acao=salvar">
			    
			    	<input type="hidden" class="form-control" id="id" value="${anime.id}" name="id">
			    		
					  <div class="form-group">
					    <label for="nomeAnime">Nome do anime</label>
					    <input type="text" class="form-control" id="nomeAnime" value="${anime.nomeAnime}" name="nomeAnime" placeholder="Informe o nome de um anime">
					  </div>
					  
					  <div class="form-group">
					    <label for="sinopse">Descrição / Sinopse</label>
					    <textarea class="form-control" id="sinopse"  name="sinopse" rows="3">${anime.sinopse}</textarea>
					  </div>
					  
					  <div class="form-group">
					  
					      <label for="categoria">Status do anime</label>
					      
					      <select id="categoria" class="form-control" name="categoria" >
					        <option selected>
					        <c:if test="${anime.categoria != null}">
					        	${anime.categoria}
					        </c:if>
					        <c:if test="${anime.categoria == null}">
					        	Escolher...
					        </c:if>
					        
					        </option>
					        <option value="Assistindo">Assistindo</option>
					        <option value="Anime para assistir">Animes para assistir</option>
					        <option value="Finalizado">Finalizado</option>
					      </select>
					      
					   </div>

					  
					  <button type="submit" class="btn btn-primary">Cadastrar</button>
					  
				</form>
			  </div>
		</div>
		
		</div>
		
		
	
	</main>

</body>

</html>