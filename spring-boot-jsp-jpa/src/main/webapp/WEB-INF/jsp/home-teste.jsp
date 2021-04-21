<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
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
	  <%@include file="header.jsp" %>
	  
      <main role="main" class="inner cover">
        <h1 class="cover-heading">Marlon Dauernheimer</h1>
        <p class="lead">Teste para vaga de backend</p>
        <p class="lead">
          	<div class="text-center">
	  			<img src="<c:url value="${contextPath}/images/desbravador.png"/>" class="rounded"/>
			</div>
        </p>
      </main>

      <%@include file="footer.jsp"%>
    </div>
 </body>

</html>