<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="estilo.css">
<title>PROFESOR</title>
</head>
<body>
	<table>
		<tr>
			<th>DATOS PROFESOR</th>
		</tr>
		<tr>
			<th>ID PROFESOR</th>
			<th>NOMBRE</th>
			<th>APELLIDOS</th>
			<th>DESPACHO</th>

		</tr>



		<tr>
			<td><%=request.getAttribute("id")%></td>
			<td><%=request.getAttribute("nombre")%></td>
			<td><%=request.getAttribute("apellidos")%></td>
			<td><%=request.getAttribute("despacho")%></td>

		</tr>



	</table>

	<table>

		<tr>
			<th>ASIGNATURA</th>
			<th >Nº ALUMNOS</th>
			<th >NOTA MEDIA</th>
			<th >NOTAS</th>


		</tr>





		<tr>
			<td><%=request.getAttribute("asignaturas.descripcion")%></td>
			<td><%=request.getAttribute("nalumnos")%></td>
			<td><%=request.getAttribute("notamedia")%></td>
			<td><form action="NotasProfesor.jsp" method="post">
					<input type="hidden" name="idasignatura" value="asignaturas.id">
					<input type="submit" value="CONSULTAR">
				</form></td>
		</tr>



	</table>
</body>
</html>