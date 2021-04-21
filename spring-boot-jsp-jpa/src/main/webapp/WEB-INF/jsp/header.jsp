<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<header class="masthead mb-auto">
 	<c:url var="home_teste_url" value="/index" />
 	
	<c:url var="listar_pessoa_url" value="/pessoas/listar" />
	<c:url var="adicionar_pessoa_url" value="/pessoas/adicionar" />
	
	<c:url var="listar_projeto_url" value="/projetos/listar" />
	<c:url var="adicionar_projeto_url" value="/projetos/adicionar" />
	
	<div class="inner">
  		<h3 class="masthead-brand">Teste Desbravador</h3>
  		<nav class="nav nav-masthead justify-content-center">
    		<a class="nav-link active" href="${home_teste_url}">Home</a>
    		<a class="nav-link" href="${listar_pessoa_url}">Incluir Pessoa</a>
    		<a class="nav-link" href="${adicionar_pessoa_url}">Listar Pessoa</a>
    		
    		<a class="nav-link" href="${listar_projeto_url}">Incluir Projeto</a>
    		<a class="nav-link" href="${adicionar_projeto_url}">Listar Projetos</a>
   		</nav>
  	</div>
</header>

      