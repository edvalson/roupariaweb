<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- para estruturas de controle e repeti��o e setar vari�veis -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> <!-- para formata��es -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  <!-- para fun��es -->

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
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
			<th><h1><strong>Lista de Pedidos</strong></h1></th>   
			<br />
		    <br />
          </tr>
			<c:url var= "urlFiltro" value="/pedido/filtrar" />
		    <form:form method="get" action="${urlFiltro}" modelAttribute="filtro">
			    <strong>Paciente: </strong> <form:input path="paciente"/>
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
						    <th>PACIENTE</th>
							<th>PE�A</th>
							<th><center>A��ES</center></th>
						</tr>
					</thead>
					<tbody>
					
					<c:forEach var="pedido" items="${pedidos}" >
			
		            <tr>
		                <td>${pedido.id}</td>
		                <td>${pedido.paciente.nome}</td>
			            <td>${pedido.peca.nome}</td>
			            
	                <td>
			    <div class="btn-group pull-right">
				<a  class="btn btn-sm btn-primary" href='<c:url value="/pedido/${pedido.id}/remove" />'>remover</a>
				<a class="delete btn btn-sm btn-danger" href='<c:url value="/pedido/${pedido.id}/form" />'>editar</a>
				</div>
			</td>
		</tr>
		</c:forEach>
						
					</tbody>
				</table>
			</div>
		</div>
		<div class="panel-footer">
		   <c:url var="url" value="/pedido/form" />
		   <a class="btn btn-sm btn-success" href='${url}'>Novo Pedido</a>
		   <c:url var="url" value="/atendimento/listar" />
		   <a class="btn btn-sm btn-success" href='${url}'>Lista de Atendimentos</a>
	</div>
	</div>
	<c:import url="${request.contextPath}/rodape" />
</body>
</html>