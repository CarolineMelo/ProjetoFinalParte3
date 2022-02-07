<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Projeto Final</title>
</head>
<body>
	
	<form action="ServletCRUD" method="post">
		<c:choose>
			<c:when test="${ user == null }">
				<label>Nome:</label><input type="text" name="nome" required/>
				<label>País:</label><input type="text" name="pais"/>
				<label>Email:</label><input type="text" name="email"/>
				<label>Telefone:</label><input type="text" name="telefone"/>
			
				<button type="submit" name="option" value="insert">Salvar</button>
			</c:when>
			<c:otherwise>
				<input type="hidden" name="id" value="${user.id}"/>
				<label>Nome:</label><input type="text" name="nome" value="${user.nome}" required/>
				<label>País:</label><input type="text" name="pais" value="${user.pais}"/>
				<label>Email:</label><input type="text" name="email" value="${user.email}"/>
				<label>Telefone:</label><input type="text" name="telefone" value="${user.telefone}"/>
			
				<button type="submit" name="option" value="update">Atualizar</button>
			</c:otherwise>
		</c:choose>
	</form>
</body>
</html>