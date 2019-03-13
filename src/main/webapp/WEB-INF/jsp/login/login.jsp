<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- para estruturas de controle e repetição e setar variáveis -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- para formatações -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!-- para funções -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value='resources/css/bootstrap.min.css' />" rel="stylesheet">
<script src="<c:url value='resources/js/bootstrap.min.js'/>"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tela de Login</title>
</head>

<body>
	<c:url var="url" value="/logar" />

	<br />
	<form:form method="post" action="${url}" modelAttribute="usuario">

		<table>

			<tr>
				<td>Login</td>
				<td><form:input path="login" /> <form:errors path="login"
						cssClass="error" /></td>
			</tr>
			<tr>
				<td>Senha</td>
				<td><form:input path="senha" /> <form:errors path="senha"
						cssClass="error" /></td>
			</tr>

			<tr>
				<td><input type='submit' value='Logar' /></td>
				<td></td>
			</tr>

		</table>

	</form:form>
</body>
</html>