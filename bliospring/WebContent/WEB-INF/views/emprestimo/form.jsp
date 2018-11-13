<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><%@taglib
	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>form de emprestimo</title>
</head>
<body>
<select>
  <option value="volvo">Volvo</option>
  <option value="saab">Saab</option>
  <option value="opel">Opel</option>
  <option value="audi">Audi</option>
</select>
			


<form action="/bliospring/emprestimo" method="post">
			<c:forEach var="aluno" items="${aluno}">


			<select name="aluno.id">
                   <option value="${aluno.id}" >${aluno.nome}</option>
		
					</select>
				
				
			

			</c:forEach>
			<button type="submit">Adicionar</button>
</form>
		









</body>
</html>