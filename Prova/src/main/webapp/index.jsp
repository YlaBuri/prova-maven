<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Laboratorios</title>
<%-- <jsp:useBean id="repositorio" class="br.ucsal.lamis.util.Repositorio" scope="application" /> --%>
</head>
<body>
	<form action="./Login" method="post">
		${erro} <br>
		Login: <input name="login" type="text" value="user1"> <br>
		Senha: <input name="senha" type="password" value="1234"> <br>
		<button type="submit">Entrar</button>
	</form>
	
</body>
</html>

