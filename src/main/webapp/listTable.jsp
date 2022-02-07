<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css">
</head>
<body>
	<form action="ServletCRUD" method="post">
		<button type="submit" name="option" value="insertForm">Cadastrar Usuário</button>
	</form>
	
		<table>
			<thead>
				<tr>
					<th>Id</th>
					<th>Nome</th>
					<th>País</th>
					<th>Email</th>
					<th>Telefone</th>
					<th>Ações</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach var="usuario" items="${listUser}">
					<tr>
						<form action="CRUDController" method="post">
							<td>
								<c:out value="${usuario.id}"/>
								<input type="hidden" name="id" value="${usuario.id}"/>
							</td>
							<td><c:out value="${usuario.nome}"/></td>
							<td><c:out value="${usuario.pais}"/></td>
							<td><c:out value="${usuario.email}"/></td>
							<td><c:out value="${usuario.telefone}"/></td>
							<td><button type="submit" name="option" value="delete">Deletar</button><button type="submit" name="option" value="updateForm">Atualizar</button></td>
						</form>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	
</body>
</html>

