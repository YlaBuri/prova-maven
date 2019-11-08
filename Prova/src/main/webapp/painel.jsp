<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Painel</title>
</head>
<body>
Bem vindo, ${usuario.login} <a href="./Logout" >Sair</a>
<br>
<a href='./LaboratorioLista'>Laboratorios </a> | <a href="./ReservaLista">Reservas</a>
</body>
</html>