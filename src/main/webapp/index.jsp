<%@page import="com.ipartek.modelo.dto.Participante"%>
<%@page import="com.ipartek.modelo.I_Conexion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page
	language="java"
	contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
List<Participante> listaParticipantes = new ArrayList<Participante>();
if (request.getAttribute(I_Conexion.ATR_LISTA_PARTICIPANTES) != null) {
    listaParticipantes = (List) request.getAttribute(I_Conexion.ATR_LISTA_PARTICIPANTES);
} else {
    //TAREA PARA METER EN EL LOG
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="css/cuadricula_prod.css">
<title>Lista de participantes</title>
</head>
<body>
	<header> CABECERA </header>
	<nav>MENU</nav>
	<main>
		<section>
			<form class="insertar" method="post" action="AgregarParticipante"
		enctype="multipart/form-data">

		<H3><label>Nombre:</label></H3>
		<input type="tipo" id="p_nombre" size="tamaño" name="p_nombre" placeholder="Nombre" value="" /> <br>
			
		<H3><label>Apellidos:</label></H3>
		<input type="tipo" id="p_apellidos" size="tamaño" name="p_apellidos" placeholder="Apellidos" /> <br>
			
		<H3><label>Edad:</label></H3>
		<input type="number" id="p_edad" size="tamaño" name="p_edad" placeholder="33" /><br>
		
		<input type="submit" value="Soy un botón submit" /> <br>
			<a href="AgregarParticipante"><input type="button" value="" /></a>
		
	</form>
		</section>
		<section>
			<table class="tabla">
				<caption>Lista de participantes</caption>
				<thead>
					<tr>
						<th scope="col"><h2>Nombre</h2></th>
						<th scope="col"><h2>Apellidos</h2></th>
						<th scope="col"><h2>Edad</h2></th>
					</tr>
				</thead>
				<tbody>
					<%
					for (Participante elem : listaParticipantes) {
					%>
					<tr>
						<th scope="row"><%=elem.getNombre()%></th>
						<td><%=elem.getApellidos()%></td>
						<td><%=elem.getEdad()%></td>
					</tr>
					<%
					}
					%>
				</tbody>
				<tfoot>
					<tr>
						<th
							scope="row"
							colspan="2"># Participantes:</th>
						<td><%=listaParticipantes.size()%></td>
					</tr>
				</tfoot>
			</table>
		</section>
	</main>
	<footer> PIE </footer>
</body>
</html>