<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>Teste Desbravador</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link href="<c:url value="${contextPath}/css/bootstrap/bootstrap.min.css"/>" rel="stylesheet" type="text/css">
	<script	src="<c:url value="${contextPath}/js/bootstrap/bootstrap.min.js"/>"></script>
	<script	src="<c:url value="${contextPath}/js/jquery/jquery-3.6.0.min.js"/>"></script>
</head>
<body class="text-center">
	<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
		<%@include file="header.jsp"%>

		<main role="main" class="inner cover">
		
		<c:url var="remover_projeto_url" value="/projetos/remover/" />
		
		<table class="table table-striped">
		  <thead>
		    <tr>
		      <th scope="col">Id</th>
		      <th scope="col">Nome</th>
		      <th scope="col">Opções</th>
		    </tr>
		  </thead>
		  <tbody>
		  		<c:forEach items="${projetos}" var="projeto">
                    <tr>
                        <td>${projeto.id}</td>
                        <td>${projeto.nome}</td>
                        <td><a class="btn btn-large btn-primary" href="${remover_projeto_url}${projeto.id}">Remover</a></td>
                    </tr>
                </c:forEach>
		  </tbody>
		</table>
	</main>

		<%@include file="footer.jsp"%>
	</div>

</body>

</html>