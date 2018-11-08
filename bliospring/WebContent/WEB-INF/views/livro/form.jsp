<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>form de livro</title>
</head>
<body>

	<h1>Adicionar Livro</h1>
	<form action="/bliospring/livro" method="post">

		<div>
			<label>título:</label> <input type="text" name="titulo">
		</div>
		<div>

			<label>autor:</label> <input type="text" name="autor">
		</div>
		<div>
			<label>editora:</label> <input type="text" name="editora">
		</div>
		<div>
			<label> ano de edição: </label><input type="text" name="anoEdicao">

		</div>
		<div>
			<label> ano de publicação: </label><input type="text"
				name="anoPublicacao">
		</div>
		<div>
			<button type="submit">Adicionar</button>
		</div>
	</form>
</body>
</html>