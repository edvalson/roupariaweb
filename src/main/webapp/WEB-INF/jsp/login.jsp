<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


	
	<link href="<c:url value='resources/css/bootstrap.min.css' />" rel="stylesheet">
    <script src="<c:url value='resources/js/bootstrap.min.js'/>"></script>

<body>
<br/>
     <center> <img src="<c:url value="/imagens/roupariaweb.jpg"/>"> <center/>
   
    <c:url var="url" value="/logar" />
	<div class="container-fluid">
		<div id="loginbox" style="margin-top: 50px;"
			class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Acesse o Sistema</div>
					
				</div>

				<div style="padding-top: 20px" class="panel-body">
	
					<div style="display: none" id="login-alert"
						class="alert alert-danger col-sm-12"></div>
					<form:form action="${url}" method="post" modelAttribute="usuario"
						class="form-horizontal">

						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> 
								<form:input cssStyle="width:50px" maxlength="10" path="login" size="10" class="form-control" />
								<form:errors path="login"/>
						</div>

						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
								<form:input  type="password" cssStyle="width:50px" maxlength="10" path="senha" size="10" class="form-control" />
								<form:errors path="senha"/>
						</div>

						<div style="margin-top: 10px" class="form-group">
							<div class="col-sm-12 controls">
								<input type="submit"  class="btn btn-primary" value="Login" />
								
							</div>
						</div>


					</form:form>



				</div>
			</div>
		</div>
	</div>
</body>