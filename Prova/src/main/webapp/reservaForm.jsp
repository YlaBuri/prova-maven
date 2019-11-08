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

	<form action="ReservaSalvar" method="post">
	${erro}
	<br>
		selecione o laboratorio
		<select name="laboratorio">
			<option>Selecione</option>
			<c:forEach var="lami" items="${lamis}">
				<option value="${lami.id}">${lami.nome}</option>
			</c:forEach>
		</select>
		<br>
		Dia da reserva: <input type="date" name="data"><br>
		Hora de inicio: <input type="time" name="horaInicio"><br>
		Hora Final: <input type="time" name="horaFinal"><br>
		Objetivo: <input type="text" name="objetivo"><br>
		Descrição: <input type="text" name="descricao"><br>
		<button type="submit">Salvar</button>
		
	</form>
</body>
</html>