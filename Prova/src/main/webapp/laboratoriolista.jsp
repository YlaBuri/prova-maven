<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista Laboratorios</title>
</head>
<body>

	<table border="1">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Bloco</th>
				<th><a href="./LaboratorioForm" >Novo Laboratorio</a></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="l" items="${laboratorios}">
			<tr>
				<td>${l.nome}</td>
				<td>${l.bloco.nome}</td>
				<td><a href='./LaboratorioForm?id=${l.id}'>Editar</a> | <a
					href='./LaboratorioExcluir?id=${l.id}'>Excluir</a></td>
			</tr>
			</c:forEach>
		</tbody>

	</table>
	<a href="./Painel">Painel</a>
</body>
</html>