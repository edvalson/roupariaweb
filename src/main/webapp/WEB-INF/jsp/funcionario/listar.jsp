<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- para estruturas de controle e repetição e setar variáveis -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> <!-- para formatações -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  <!-- para funções -->

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta charset="UTF-8" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="viewport" content="width=device-width" />
	<title>Rouparia Web</title>
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"></link>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<c:import url="${request.contextPath}/menu" />
 <div class="panel panel-default">
		<div class="panel-heading">
		   <tr>
			<th><h1><strong>Lista de Funcionários</strong></h1></th>   
			<br />
		    <br />
          </tr>
			<c:url var= "urlFiltro" value="/funcionario/filtrar" />
		    <form:form method="get" action="${urlFiltro}" modelAttribute="filtro">
			    <strong>Matrícula: </strong> <form:input path="matricula"/>
			    <strong>Nome: </strong><form:input path="nome"/> 
			   <input class="btn btn-sm btn-success" type="submit" value="pesquisar">
		    </form:form>
		    <br />
		    
		</div>
		<div class="panel-body">
			<div class="table-responsive">
				<table class="table table-sm table-striped table-hover table-bordered">
					<thead>
						<tr>
						    <th>ID</th>
							<th>MATRÍCULA</th>
							<th>NOME</th>
							<th>FUNÇÃO</th>
							<th><center>AÇÕES</center></th>
						</tr>
					</thead>
					<tbody>
					
					<c:forEach var="funcionario" items="${funcionarios}" >
			
		            <tr>
		                <td>${funcionario.id}</td>
			            <td>${funcionario.matricula}</td>
			            <td>${funcionario.nome}</td>
			            <td>${funcionario.funcao}</td>
	                <td>
			    <div class="btn-group pull-right">
				<a  class="btn btn-sm btn-primary" href='<c:url value="/funcionario/${funcionario.id}/remove" />'>remover</a>
				<a class="delete btn btn-sm btn-danger" href='<c:url value="/funcionario/${funcionario.id}/form" />'>editar</a>
				</div>
			</td>
		</tr>
		</c:forEach>
						
					</tbody>
				</table>
			</div>
		</div>
		<div class="panel-footer">
		   <c:url var="url" value="/funcionario/form" />
		   <a class="btn btn-sm btn-success" href='${url}'>Novo Funcionário</a>
		   <c:url var="url" value="/atendimento/listar" />
		   <a class="btn btn-sm btn-success" href='${url}'>Lista de Atendimentos</a>
	</div>
	</div>
	<c:import url="${request.contextPath}/rodape" />
</body>
</html>