package com.javier.producto.repositorios;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.javier.producto.modelo.TiendaCategoria;


public class RepositorioCategoria extends Repositorio<TiendaCategoria> {
	public Map<Integer, String> getMapaOptions(){

		List<TiendaCategoria> l=get(TiendaCategoria.class);
		Map<Integer, String> mapa=new HashMap<Integer, String>();

		for (TiendaCategoria categoria : l) {

			mapa.put(categoria.getIdCategoria(),
					categoria.getNombre());
		}

		return mapa;
	}


}
