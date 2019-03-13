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
<title>Cadastro de Funcionários</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"></link>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

   <div class="panel panel-default">
		<div class="panel-heading">
			<strong>Cadastro de Funcionários</strong>
			<br />
		    <br />
    
     <c:url var="url" value="/funcionario/save" />
 
	<br />
	<form:form method="post" action="${url}" modelAttribute="funcionario">
	    <form:hidden path="id"/>
		<table>
			
			<div class="form-group row">                                                          
					<div class="col-md-4" >
					    <label>Nome</label>
						<form:input class="form-control input-sm" autofocus="autofocus" placeholder="Informe o nome do funcionário" maxlength="50" path="nome"/>
						<form:errors path="nome"/>
					</div>
			</div>
			
			<div class="form-group row">                                                          
							<div class="col-md-4" >
							    <label>Matrícula</label>
							    <form:input class="form-control input-sm" autofocus="autofocus" placeholder="Informe a matrícula do funcionário" maxlength="50" path="matricula"/>
						<form:errors path="matricula"/>
							</div>
			</div>
			
			<div class="form-group row">                                                          
							<div class="col-md-4" >
							    <label>Função</label>
							    <form:input class="form-control input-sm" autofocus="autofocus" placeholder="Informe a função do funcionário" maxlength="50" path="funcao"/>
						<form:errors path="funcao"/>
							</div>
			</div>
			
			
			</table>
		     <br/>
		     <br/>
		     <br/>
		<div class="form-group row">
					<button type="submit" class="btn btn-sm btn-primary">Salvar</button>
					<c:url var="url" value="/funcionario/listar" />
		   <a class="btn btn-sm btn-primary" href='${url}'>Cancelar</a>
				</div>

	</form:form>
	</div>
</body>
</html>