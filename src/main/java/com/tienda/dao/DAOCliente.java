package com.tienda.dao;

import com.tienda.bean.Cliente;

public interface DAOCliente {
	void grabar (Cliente cliente);
	Cliente leer (String dni);
	void cerrar();
}