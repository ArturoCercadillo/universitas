<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="beans.Asignatura"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="estilos.css">
<title>ALUMNO</title>
</head>
<body>
	<table >
		<tr>
			<th>DATOS ALUMNO</th>
		</tr>
		<tr>
			<th>ID ALUMNO</th>
			<th>DNI</th>
			<th>NOMBRE</th>
			<th>APELLIDOS</th>
			<th>MES NACIMIENTO</th>

		</tr>

		

		<tr>
			<td><%=request.getAttribute("id") %></td>
			<td><%=request.getAttribute("dni") %></td>
			<td><%=request.getAttribute("nombre") %></td>
			<td><%=request.getAttribute("apellidos") %></td>
			<td><%=request.getAttribute("mes") %></td>
			

		</tr>
	</table>

	<table >

		<tr>
			<th>ASIGNATURA</th>
			<th >PROFESOR</th>
			<th>NOTA MEDIA</th>
			<th>DESPACHO</th>
			<th>NOTAS</th>

		</tr>

<%
List<Asignatura> asignaturas = (List<Asignatura>) request.getAttribute("asignaturas");

for(Asignatura asignatura : asignaturas){
%>
		
		

		<tr>
			<td><%=asignatura.getDescripcion() %></td>
			<td><%=asignatura.getProfesor() %></td>
			<td>profesores.despacho</td>
			<td>nota.media</td>
			<td><form action="Notas.jsp" method="post">
					<input type="hidden" name="idasignatura"
						value="asignaturas.id"> 
						<input type="hidden"
						name="idalumno" value="alumnos.id"> 
						<input type="submit" value="CONSULTAR">
				</form></td>
		</tr>
	<% } %>	
			

	</table>
</body>
</html>