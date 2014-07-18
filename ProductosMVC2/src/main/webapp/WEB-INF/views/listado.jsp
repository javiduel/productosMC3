<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src ='<c:url value="/resources/js/jquery-1.11.1.min.js"/>'></script>
<title>Insert title here</title>
</head>

<body>
Buscar:<input type="text" id="txtBuscar" 
				placeholder="Pon tu busqueda">
	   <input type="button" id="btnBuscar" value="buscar" onclick="buscar()"> 
<table id="tblDatos">
<c:forEach items="${productos }" var="producto">
 <tr>
   <td>${producto.nombre }</td>
   <td>${producto.precio }</td>
  <td><a href="detalle.html?id=${producto.idProducto}"> Ver detalle</a></td>
  <td><a href="#" id="lnkDetalle" onclick="evento(${producto.idProducto})"> Detalle Ajax</a></td>
  </tr>
   </c:forEach>
</table>
<div id="divDetalle"></div>
<script type="text/javascript">
function buscar(){
	var tx=$("#txtBuscar").val();
	var url="producto/buscar/"+tx;	

	$.get(url,function(res){

		var tabla=$("#tblDatos");

		$("#tblDatos tr").each(function(){
				$(this).remove();

			});



		for(var i=0;i<res.length;i++){
			var h="<tr>";
			h+="<td>"+res[i].nombre+"</td>";
			h+="<td>"+res[i].precio+"</td>";
			h+="<td><a href='detalle.html?id="+
					res[i].idProducto+"'>Detalle</a>";
			h+="<a href='#' onclick='evento("+
				res[i].idProducto+")'>Detalle ajax</a></td>";
			h+="</tr>";	
			tabla.append(h);
			}





		});

}

function evento(id){
  	var url="producto/"+id;
  	$.get(url,function(res){
var resultado="<ul>";
   resultado+="<li>"+ res.nombre+"<li>";
   resultado+="<li>"+ res.precio+"<li>";
   resultado+="<li>"+ res.existencias+"<li>";
   resultado+="<li>"+ res.tiendaCategoria.nombre+"<li>";
   resultado+="<ul>";
   $("#divDetalle").html(resultado);
  	});
	
}

</script>


</body>
</html>
