package com.javier.producto.modelo.viewform;

import com.javier.producto.modelo.TiendaCategoria;
import com.javier.producto.modelo.TiendaProducto;

public class ProductoViewForm {
     private Integer idproducto;
     private String nombre;
     private String descripcion;
     private Integer existencias;
     private double precio;
     private Integer idCategoria;
	public ProductoViewForm() {
		
	}
	public ProductoViewForm(Integer idproducto, String nombre,
			String descripcion, Integer existencias, double precio,
			Integer idCategoria) {
		
		this.idproducto = idproducto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.existencias = existencias;
		this.precio = precio;
		this.idCategoria = idCategoria;
	}
	
	public TiendaProducto getTiendaProducto(){
		TiendaProducto producto=new TiendaProducto();
		producto.setIdProducto(idproducto);
        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
	    producto.setExistencias(existencias);
	    producto.setPrecio(precio);
	    
        
        TiendaCategoria c=new TiendaCategoria();
	    c.setIdCategoria(idCategoria);
        producto.setTiendaCategoria(c);
        return producto;
	}
	public void fromTiendaProducto(TiendaProducto producto){
		setIdproducto(producto.getIdProducto());
	    setNombre(producto.getNombre());
	    setDescripcion(producto.getDescripcion());
	    setExistencias(producto.getExistencias());
	    setPrecio(producto.getPrecio());
	    setIdCategoria(producto.getTiendaCategoria().getIdCategoria());
	    
	}

	
	
	public Integer getIdproducto() {
		return idproducto;
	}
	public void setIdproducto(Integer idproducto) {
		this.idproducto = idproducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getExistencias() {
		return existencias;
	}
	public void setExistencias(Integer existencias) {
		this.existencias = existencias;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Integer getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
	
     
}
