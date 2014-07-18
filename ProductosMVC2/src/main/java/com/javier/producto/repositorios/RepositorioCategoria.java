package com.javier.producto.repositorios;

import org.hibernate.Hibernate;

import com.javier.producto.modelo.TiendaCategoria;


public class RepositorioCategoria extends Repositorio<TiendaCategoria> {
	@Override
	public TiendaCategoria get(Class<TiendaCategoria> tipo, int id) {
		// TODO Auto-generated method stub
		TiendaCategoria e= super.get(tipo, id);

		//Hibernate.initialize(e.getTiendaProducto());
		

		return e;
	}


}
