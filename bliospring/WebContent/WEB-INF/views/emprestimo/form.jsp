<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	<c:import url="../Menu.jsp"></c:import>
	<h1>Adicionar Emprestimo</h1>
	<form action="/bliospring/emprestimo" method="post">
		<h2>
			Alunos <select name="aluno.id">
				<c:forEach var="aluno" items="${aluno }">
					<option value="${aluno.id }" >${aluno.nome }</option>
					
					
					
				</c:forEach>
				<c:forEach var="aluno" items= "${aluno }">   <input type="hidden" name="aluno.id" value="${aluno.id }"></c:forEach>
				
			
			
			
			</select>
		</h2>

		<h2>
			Livros <select name="livro.id">
				<c:forEach var="livro" items="${livro }">
					<option value="${livro.id }">${livro.titulo }</option>
				</c:forEach>
			</select>
		</h2>
		<button type="submit">Adicionar</button>
	</form>
</body>
</html>












