package com.javier.producto.repositorios;

import org.hibernate.Hibernate;

import com.javier.producto.modelo.TiendaProducto;


public class RepositorioProducto extends Repositorio<TiendaProducto> {
	@Override
	public TiendaProducto get(Class<TiendaProducto> tipo, int id) {
		// TODO Auto-generated method stub
		TiendaProducto e= super.get(tipo, id);

		Hibernate.initialize(e.getTiendaCategoria());
		

		return e;
	}


}
