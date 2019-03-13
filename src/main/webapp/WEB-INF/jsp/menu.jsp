<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bem Vindo ao Sistema de Rouparia -  Usuário: ${usuario.login}</title>
<style type="text/css">
		
	</style>
<link href="<c:url value ='/css/bootstrap.min.css'/>" rel="stylesheet"
	type="text/css" />
<script src="<c:url value ='/js/bootstrap.min.js'/>" type="text/javascript"></script>
</head>
<body>


		

			
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <c:url var="url" value="/atendimento/listar" />
      <a class="navbar-brand" href='${url}'> ROUPARIA WEB</a>
    </div>
    <center><b>Bem Vindo ao Sistema de Rouparia -  Usuário: ${usuario.login}</b></center>
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"></li>
        <li><a href="<c:url value='/paciente/listar' />"> Pacientes</a></li>
        <li><a href="<c:url value='/leito/listar' />">Leitos</a></li>
        <li><a href="<c:url value='/peca/listar' />">Peças</a></li>
        <li><a href="<c:url value='/pedido/listar' />">Pedidos</a></li>
       	<li><a href="<c:url value='/funcionario/listar' />">Funcionários</a></li>
        <li><a href="<c:url value='/estoque/listar' />">Estoques</a></li>
        
      </ul>
      <ul class="nav navbar-nav navbar-right">
         <li><a href="<c:url value='/loginForm' />"> Sair</a></li>
       
      </ul>
    </div>
  </div>
</nav>