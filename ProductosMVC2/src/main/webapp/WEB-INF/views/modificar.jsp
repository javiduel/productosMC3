<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Datos del producto<br />
	<form:form method="post" commandName="producto">
	<form:hidden path="idProducto"/>    
		Nombre:<form:input path="nombre"/><br />
		Descripcion:<form:input path="descripcion"/><br />
		Existencias:<form:input path="existencias"/><br />
		Precio:<form:input path="precio"/><br />
		Categoria: <form:select path="idCategoria">
			<form:options items="${categorias}"/>
		</form:select>
		<br />
	<input type="submit" value="Guardar" />

	</form:form>


</body>
</html>