package com.javier.producto.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javier.producto.modelo.TiendaProducto;
import com.javier.producto.repositorios.RepositorioProducto;

@Controller
public class ProductosController {

	@Autowired 
	RepositorioProducto daoProducto;
	@RequestMapping(value="/listado.html", method=RequestMethod.GET)//lo hace solo por el metodo get
    public String Listado(Model modelo){
    	
		List<TiendaProducto> l=daoProducto.get(TiendaProducto.class);//vas a crear una lista utiliando los datos del get
		modelo.addAttribute("productos", l);//objeto del spring para mantener los datos en la memoria coje datos desde la vista al controlador y del controlador a la vista
		
		return "listado";
    }
/***detalle primera forma*************************************/
	@RequestMapping(value="detalle.html", method=RequestMethod.GET)
	public String detalle(Model modelo, HttpServletRequest request){
		int id=Integer.parseInt(request.getParameter("id"));//como me esta pidiendo un entero recupero los parametros y los convierto en enteros
		TiendaProducto e=daoProducto.get(TiendaProducto.class, id);//captura los datos y 
		modelo.addAttribute("productos", e);//añadir ese atributo a la vita  cogiendo los datos para convertirlos en objetos y se envía ya que el controlador necesita objetos
		return "detalle";
     }
	/***detalle segunda forma*************************************/	
	/*@RequestMapping(value="detalle_{id}.html")	
	public String detalle(Model modelo, @PathVariable int id){//la path variable es para poner en la url detalle_128
		      TiendaProducto tp=daoProducto.get(TiendaProducto.class, id);
			modelo.addAttribute("producto",tp);
		      return "detalle";
 }*/

}


	

