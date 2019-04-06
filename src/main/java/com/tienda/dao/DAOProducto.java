package com.tienda.dao;

import java.util.List;

import com.tienda.bean.Producto;

public interface DAOProducto{
	List<Producto> leerTodos();
	void grabar(Producto producto);
	void cerrar();
}