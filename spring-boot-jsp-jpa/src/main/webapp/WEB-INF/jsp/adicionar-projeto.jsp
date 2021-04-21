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
		<%@include file="header.jsp"%>

		<main role="main" class="inner cover">
			<c:if test="${adicionarProjetoSuccess}"><div>Projeto adicionado com sucesso: ${projetoSalvo.id} - ${projetoSalvo.nome}</div></c:if>

			<c:url var="adicionar_projeto_url" value="/pessoa/adicionar" />
			<form:form action="${adicionar_projeto_url}" method="post" modelAttribute="projeto">
				<form:label path="nome">Nome: </form:label>
				<form:input type="text" path="nome" /><br/>
				
				<form:label path="description">Data Nascimento: </form:label>
				<form:input type="text" path="datanascimento" /><br/>
				
				<form:label path="cpf">CPF: </form:label>
				<form:input type="number" size="11" path="cpf" /><br/>
				
				<form:label path="funcionario">Funcionario: </form:label></br>
				<form:input type="radio" path="sim" value="true" /><br/>
				<form:label path="sim">Sim </form:label>
				<form:input type="radio" path="nao" value="false" /><br/>
				<form:label path="nao">Não </form:label>
							
				<input type="submit" value="Cadastrar" />
			</form:form>
		</main>

		<%@include file="footer.jsp"%>
	</div>

</body>

</html><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<%@include file="header.jsp"%>

		<main role="main" class="inner cover">
			<c:if test="${addTesteSuccess}"><div>Pessoa adicionada com sucesso: ${pessoaSalva.id} - ${pessoaSalva.nome}</div></c:if>

			<c:url var="add_teste_url" value="/pessoa/adicionar" />
			<form:form action="${add_teste_url}" method="post" modelAttribute="pessoa">
				<form:label path="nome">Nome: </form:label>
				<form:input type="text" path="nome" /><br/>
				
				<form:label path="description">Data: </form:label>
				<form:input type="text" path="datanascimento" /><br/>
				
				<form:label path="cpf">CPF: </form:label>
				<form:input type="text" path="cpf" /><br/>
				
				<form:label path="funcionario">Funcionario: </form:label>
				<form:input type="text" path="funcionario" /><br/>
								
				<input type="submit" value="submit" />
			</form:form>
		</main>

		<%@include file="footer.jsp"%>
	</div>
</body>
<script>
$(function() {
    $.datepicker.setDefaults({
        onClose:function(date, inst){
            $("#selectedDtaeVal").html(date);
        }
    });

    $("#datepicker").datepicker();
});
</script>
</html>