<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="ReservaForm">Nova Reserva</a>|<a href="Painel">Painel</a><br>

	<table border="1">
		<thead>
			<tr>
				<th>Laboratorio</th>
				<th>Data</th>
				<th>inicio da reserva</th>
				<th>final da reserva</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="r" items="${reservas}">
				<tr>
					<td>${r.laboratorio.nome}</td>
					<td>${r.data}</td>
					<td>${r.horaInicio}</td>
					<td>${r.horaFinal}</td>
					<td><a href="ReservaExcluir?id=${r.id}">Excluir</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>