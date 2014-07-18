package com.javier.producto.controladores;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javier.producto.modelo.TiendaProducto;
import com.javier.producto.repositorios.RepositorioProducto;

@Controller
@RequestMapping(value="/producto")
public class ProductosRestController {
	
	@Autowired
	RepositorioProducto daoProducto;
    @RequestMapping	(method=RequestMethod.GET,value="/{id}")
	 public @ResponseBody TiendaProducto producto(@PathVariable int id){
	  TiendaProducto e=daoProducto.get(TiendaProducto.class, id);
	return e;  	
		
	      }

    @RequestMapping(method=RequestMethod.GET,
			value="/buscar/{texto}")
	public @ResponseBody List<TiendaProducto> 
				buscar(@PathVariable String texto){

		Map<String, Object> params=new HashMap();
		params.put("texto", "%"+texto+"%");
		List<TiendaProducto> l=daoProducto.find("producto.buscador", params);
		return l;


	}
}
