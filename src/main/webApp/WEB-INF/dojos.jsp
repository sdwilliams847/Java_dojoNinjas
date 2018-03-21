<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dojos</title>
</head>
<body>
	<h1>New Dojo</h1>

	<form:form method="POST" action="/dojos/new" modelAttribute="dojo">
		<form:label path="name">Name:
			<form:input path="name"></form:input>
			<form:errors path="name"></form:errors>
		</form:label>
		
		<input type="submit" value="Create">
	</form:form>
</body>
</html>