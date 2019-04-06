package com.tienda.bean;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestCliente {
	@Test
	public void testCliente1() {
		Cliente c = new Cliente();
		c.setNombre("Jose");
		c.setDireccion("Avenida de la Paz, 1");
		c.setDni("47326123Y");
		assertEquals("Jose",c.getNombre());
		assertEquals("Avenida de la Paz, 1", c.getDireccion());
		assertEquals("47326123Y", c.getDni());
	}

	@Test
	public void testCliente2() {
		Cliente c = new Cliente("Jose","47326123Y","Avenida de la Paz, 1");
		assertEquals("Jose",c.getNombre());
		assertEquals("Avenida de la Paz, 1", c.getDireccion());
		assertEquals("47326123Y", c.getDni());
	}
}