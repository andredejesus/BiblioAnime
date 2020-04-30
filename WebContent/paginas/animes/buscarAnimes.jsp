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

	<main class="main main-buscar-animes">
		
			<aside>
				<jsp:include page="/paginas/templates/menu.jsp"></jsp:include>
			</aside>
			
			<div class="containerPrincipal">
			
					 <h3 class="titulo-buscar-anime">Buscar Animes</h3>
				
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
				
				<div class="card card-buscar-anime">
				
					  <div class="card-body">
					  
					    <form method="post" action="animeServlet?acao=buscar-anime">
							  
							  <div class="form-group">
							  
							      <label for="categoria">Status do anime</label>
							      
							      <select id="categoria" class="form-control" name="categoria" >
							        <option selected>Escolher...</option>
							        <option value="Assistindo">Assistindo</option>
							        <option value="Anime para assistir">Animes para assistir</option>
							        <option value="Finalizado">Finalizado</option>
							      </select>
							      
							   </div>
		
							  
							  <button type="submit" class="btn btn-primary">Buscar</button>
							  
						</form>
						
					  </div>
					  
				</div>
				
				
				<h3 class="titulo-lista-anime">Animes</h3>
				
				<c:choose>
				
				<c:when test="${not empty animes}">
				
				
					<table class="table table-hover" style="padding: 0px 30px; text-align:center; margin-right: 20px;">
						
						<thead>
							<tr>
								<th>Anime</th>
								<th>Detalhes do anime</th>
								<th>Ações</th>
							</tr>
						</thead>
						
						<tbody>
						
							<c:forEach var="anime" items="${animes}">
							
								<tr>
									<td>${anime.nomeAnime}</td>
									<td><a role="button" 
										   href="#"
										   class="btn btn-link botaoDetalhe" 
										   data-nomeAnime="${anime.nomeAnime}" 
										   data-sinopse="${anime.sinopse}">Visualizar</a></td>
									<td>
										<a role="button" class="btn btn-warning" href="animeServlet?acao=editar&id=${anime.id}" >Editar</a>
										<a role="button" class="btn btn-danger" data-toggle="modal" data-target="#modalDelete" data-url="animeServlet?acao=deletar&id=${anime.id}" href="#" >Deletar</a>
									</td>
								</tr>
								
							</c:forEach>
							
						</tbody>
						
					</table>
				
				</c:when>
				
				<c:otherwise>
					<p style="margin-left:20px;">Nenhum anime encontrado</p>
				</c:otherwise>

			</c:choose>	
		
		</div>
		
		<!-- MODAL DELETE -->
		
		<div class="modal fade" id="modalDelete" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		    
		      <div class="modal-header bg-danger text-light" >
		        <h5 class="modal-title" id="modalLabel">Confirmação</h5>
		        
		        <button type="button" class="close text-light" data-dismiss="modal" aria-label="Fechar">
		          <span aria-hidden="true">&times;</span>    
		        </button>
		        
		      </div>
		      
		      <div class="modal-body">
		       	<h4>Você realmente deseja deletar esse livro? </h4>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Não</button>
		         <button type="button" id="recebeURL" data-dismiss="modal" class="btn btn-primary confirmarExclusao">Sim</button>
		      </div>
		    </div>
		  </div>
		</div>
		
		<!-- MODAL VISUALIZAR DETALHE -->
		
		<div class="modal fade" id="modalDetalhe" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		    
		      <div class="modal-header bg-dark text-light">
		        <h5 class="modal-title" id="modalLabel">Detalhes do Anime</h5>
		        
		        <button type="button" class="close text-light" data-dismiss="modal" aria-label="Fechar">
		          <span aria-hidden="true">&times;</span>
		        </button>
		        
		      </div>
		      
		      <div class="modal-body">
		       	
		       		<div class="card">
		       		
		       		<img class="card-img-top" src="resources/img/sem-imagem.jpg" alt="Imagem de capa do card">
					  
					  <div class="card-body" style="width: 100%;">
					  
					  	<h5 class="card-title"></h5>
					  
					    <p class="card-text" style="text-align: justify;" ></p>
					  
					  </div>
					</div>
		       	
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-dark" data-dismiss="modal">Fechar</button>
		      </div>
		    </div>
		  </div>
		</div>

	
	</main>
	
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

<script type="text/javascript" src="resources/js/scripts.js"> </script>

</body>

</html>