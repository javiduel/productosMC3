package com.javier.producto.controladores;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javier.producto.modelo.TiendaProducto;
import com.javier.producto.modelo.viewform.ProductoViewForm;
import com.javier.producto.repositorios.RepositorioCategoria;
import com.javier.producto.repositorios.RepositorioProducto;

@Controller
@RequestMapping(value="modificarProducto.html")

public class ModificadorProductoController {
     @Autowired
     RepositorioProducto daoProducto;
     @Autowired
     RepositorioCategoria daoCategoria;
     
     @RequestMapping(value="/{id}",method=RequestMethod.GET)
 	public String modificar(ModelMap modelo, @PathVariable int id){

    	 TiendaProducto pro=daoProducto.get(TiendaProducto.class, id); 		
    	 ProductoViewForm producto=new ProductoViewForm();
 		 producto.fromTiendaProducto(pro);
    	 modelo.addAttribute("producto", producto);

 		Map<Integer,String> lc=daoCategoria.getMapaOptions();
        modelo.addAttribute("categorias", lc);
 	

 		return "modificar";

 	}    
 	@RequestMapping(value="/{id}", method=RequestMethod.POST)
 	public String 
 		doModificar(@ModelAttribute("producto") ProductoViewForm producto,
 				BindingResult resultado,
 				HttpServletRequest request){

 		if(resultado.hasErrors()){
 			Map<Integer,String> lc=daoCategoria.getMapaOptions();
 			request.setAttribute("categorias", lc);
 		    return "modificar";

 		}
 		TiendaProducto pro=producto.getTiendaProducto();
 		daoProducto.update(pro);
        return "redirect:/listado.html";
 	}






}


