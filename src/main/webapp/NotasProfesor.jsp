<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="estilo.css">
<title>NOTAS alumnos.nombre alumnos.apellidos EN
	asignaturas.descripcion</title>
</head>
<body>
	<table>
		<tr>
			<th colspan="2">ALUMNO</th>
			<th>NOTA</th>
			<th>DESCRIPCION</th>
			<th>AÑADIR</th>
		</tr>


		<tr>
			<td><%=request.getAttribute("nombre")%></td>
			<td><%=request.getAttribute("apellidos")%></td>
			<td><%=request.getAttribute("calificacion")%></td>
			<td><%=request.getAttribute("descripcion")%></td>
		</tr>
		<tr>
			<td colspan="5"><form action="EditaAlumno" method="post">
					NOTA: <br><input type="hidden" name="idasignatura" value="asignaturas.id">
					DESCRIPCION: <input type="hidden" name="idalumno" value="alumnos.id"> <input
						type="text" name="nota"> <br> <br> <input
						type="text" name="descripcion"> <br> <br>
				</form></td>
		</tr>


	</table>
</body>
</html>