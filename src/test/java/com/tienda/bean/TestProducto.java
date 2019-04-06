package com.tienda.bean;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestProducto {
	@Test
	public void testProducto1() {
		Producto p = new Producto();
		p.setSku(11111);
		p.setName("manzana");
		p.setPrecio(1.2);
		assertEquals(11111,p.getSku());
		assertEquals("manzana",p.getName());
		assertEquals(1.2,p.getPrecio(),0.01);
	}

	@Test
	public void testProducto2() {
		Producto p = new Producto(11111,"manzana",1.2);
		assertEquals(11111,p.getSku());
		assertEquals("manzana",p.getName());
		assertEquals(1.2,p.getPrecio(),0.01);
	}
}