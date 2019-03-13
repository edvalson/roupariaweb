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
<title>Registro de Pedidos</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"></link>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<c:import url="${request.contextPath}/menu" />

   <div class="panel panel-default">
		<div class="panel-heading">
			<strong>Registro de Pedidos</strong>
			<br />
		    <br />
    
     <c:url var="url" value="/pedido/save" />
 
	<br />
	<form:form method="post" action="${url}" modelAttribute="pedido">
	    <form:hidden path="id"/>
		<table>
		
		   <div class="form-group row">
						<div class="col-md-4">
													
							<div class="form-group col-md-1">
							<label for="nome">Paciente:</label>
							<form:select items="${pacientesSelect}"  length="300" path="paciente.id" />
						</div>
								
													
						</div>
				   </div>	
			

			</table>
		     <br/>
		     <br/>
		     <br/>
		<div class="form-group row">
					<button type="submit" class="btn btn-sm btn-primary">Salvar</button>
					<c:url var="url" value="/pedido/listar" />
		   <a class="btn btn-sm btn-primary" href='${url}'>Cancelar</a>
				</div>

	</form:form>
	</div>
	
	<c:import url="${request.contextPath}/rodape" />
</body>
</html>