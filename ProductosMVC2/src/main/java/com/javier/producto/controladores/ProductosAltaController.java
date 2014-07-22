package com.javier.producto.controladores;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javier.producto.modelo.TiendaProducto;
import com.javier.producto.modelo.viewform.ProductoViewForm;
import com.javier.producto.repositorios.RepositorioCategoria;
import com.javier.producto.repositorios.RepositorioProducto;

@Controller
@RequestMapping(value="altaProducto.html")

public class ProductosAltaController {
     @Autowired
     RepositorioProducto daoProducto;
     @Autowired
     RepositorioCategoria daoCategoria;
     
     @RequestMapping(method=RequestMethod.GET)
 	public String alta(ModelMap modelo){

 		ProductoViewForm producto=new ProductoViewForm();
 		modelo.addAttribute("producto", producto);

 		Map<Integer,String> lc=daoCategoria.getMapaOptions();
        modelo.addAttribute("categorias", lc);
 	

 		return "alta";

 	}    
 	@RequestMapping(method=RequestMethod.POST)
 	public String 
 		doAlta(@ModelAttribute("producto") ProductoViewForm producto,
 				BindingResult resultado,
 				HttpServletRequest request){

 		if(resultado.hasErrors()){
 			Map<Integer,String> lc=daoCategoria.getMapaOptions();
 			request.setAttribute("categorias", lc);
 		    return "alta";

 		}
 		TiendaProducto pro=producto.getTiendaProducto();
 		daoProducto.add(pro);
        return "redirect:/listado.html";
 	}






}


