<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="models.Emprestimo"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>listando emprestimos</title>


</head>
<body>

<c:import url="../Menu.jsp"></c:import>

	<h1>Lista de Emprestimos de todos os tempos:</h1>

	<table border="1" >
		<thead>
			<tr>
				<th>Nome do aluno</th>
				<th>Nome do Livro</th>
				<th>Data de emprestimo</th>
				<th>data devolucao</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="emprestimo" items="${emprestimo }">
				<tr>
					<td>${emprestimo.aluno.nome }</td>
					<td>${emprestimo.livro.titulo }</td>
					
				<td><fmt:formatDate value="${emprestimo.dataEmprestimo.time }"
							pattern="dd/MM/yyyy" /></td>
							 
							
							 
							  <c:if test="${emprestimo.dataDevolucao.time == null }">
            	<td>emprestado</td>
            	
            </c:if>
           <c:if test="${emprestimo.dataDevolucao.time != null }">
            	<td><fmt:formatDate value="${emprestimo.dataDevolucao.time }"
							pattern="dd/MM/yyyy" /></td>
            	
            </c:if>
						
						
						
            	
							
	</tr>
			</c:forEach>


</tbody>








	</table>

</body>
</html>