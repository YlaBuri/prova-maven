
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Laboratorio</title>
</head>
<body>

	<form action="./LaboratorioSalvar" method="post">
		<input name="id" type="hidden" value="${laboratorio.id}"> 
		Nome: <input
			type="text" name="nome" value="${laboratorio.nome}"> <br>
		Descrição: <input type="text" name="descricao"
			value="${laboratorio.descricao}"> <br> 
			
		Bloco: <select name="bloco">
					<option value="">Selecione</option>
					<c:forEach var="bloco" items="${blocos}">
						<option value="${bloco.id}" ${ bloco.id == laboratorio.bloco.id ? 'selected' : ''} >${bloco.nome} </option>
					</c:forEach>

		</select><br>

		<button type="submit">Salvar</button>
	</form>

</body>
</html>