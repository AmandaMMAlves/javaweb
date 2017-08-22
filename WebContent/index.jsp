<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta charset="utf-8">
	</head>
	<body>
		<p>Bem vindo ao nosso gerenciador de empresas!<br/></p>
		
		<c:if test="${not empty usuarioLogado}">
			<p>Logado como ${usuarioLogado.email}</p>
		</c:if>
		
		<form action="novaEmpresa" method="post">
			Nome: <input type="text" name="nome"/><br/>
			<input type="submit" value="Enviar"/>
		</form>
		
		<form action="login" method="POST">
			Email: <input type="email" name="email"/><br/>
			Senha: <input type="password" name="senha"/><br/>
			<input type="submit" value="Enviar"/>
		</form>
		
		<form action="logout" method="post">
			<input type="submit" value="Deslogar"/>
		</form>
	</body>
</html>