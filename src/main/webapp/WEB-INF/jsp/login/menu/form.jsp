<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- para estruturas de controle e repetição e setar variáveis -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> <!-- para formatações -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  <!-- para funções -->
 	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listagem de Peças</title>
</head>
<body>
    <c:url var="url" value="/login/menu" />
	<a href='${url}'>Novo</a>
	<br />
		 <!--
			
			<c:if test="${mensagem != null}">
				
			<script>
				alert('${mensagem}');
			</script>
		    </c:if>
		    
		    <br />
		    <br />
		    <br />
		     -->
		     
		     <c:url var= "urlFiltro" value="/peca/filtrar" />
		    <form:form method="get" action="${urlFiltro}" modelAttribute="filtro">
			    Nome: <form:input path="nome"/>
			    Tamanho: <form:input path="tamanho"/> 
			    <input type="submit" value="pesquisar">
		    </form:form>
		    
		    <br />
		    <br />
		    <br />
	<table>
		<tr>
			<td>Nome</td>
			<td>Tamanho</td>
			<td>Ações</td>
		</tr>
		
		<c:forEach var="peca" items="${pecas}" >
			
		<tr>
			<td>${peca.nome}</td>
			<td>${peca.tamanho}</td>
	        <td>
			    
				<a href='<c:url value="/peca/${peca.id}/remove" />'>remover</a>
				<a href='<c:url value="/peca/${peca.id}/form" />'>editar</a>
			</td>
		</tr>
		</c:forEach>

	</table>


</body>
</html>