package com.tienda.bean;

public class ItemCompra extends Producto{
	
	private Double cantidad;

	public ItemCompra() {

	}
	public ItemCompra(int sku,String name,double precio,double cantidad) {
		super(sku,name,precio);
		this.cantidad = cantidad;
	}
	public ItemCompra(Producto p, double cantidad) {
		super(p.getSku(),p.getName(),p.getPrecio());
		this.cantidad = cantidad;
	}

	public void setCantidad(double cantidad){
		this.cantidad = cantidad;
	}

	public double getCantidad() {
		return cantidad;
	}

	@ Override
	public String toString(){
		return sku+" "+name+" "+precio+" Euros/kg"+cantidad+" kg";
	}

	@Override
  	public boolean equals(Object o) {
	    if (o == null) return false;
	    if (o == this) return true;
	    if (!(o instanceof ItemCompra)){
	      return false;
	    }
	    ItemCompra item = (ItemCompra) o;
	    if(sku.equals(item.getSku()) && name.equals(item.getName()) && precio.equals(item.getPrecio()) && cantidad.equals(item.getCantidad())) {
	      return true;
	    }
	    else {
	      return false;
	    }
  	}
}