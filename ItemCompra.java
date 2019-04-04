public class ItemCompra extends Producto{
	
	private Double cantidad;

	public ItemCompra() {

	}
	public ItemCompra(int sku,double precio,String name,double cantidad) {
		super(sku,name,precio);
		this.cantidad = cantidad;
	}
	public ItemCompra(Producto p, double cantidad) {
		super(p.getSku(),p,getName(),p.getPrecio());
		this.cantidad = cantidad;
	}

	public void setCantidad(double cantidad){
		this.cantidad = cantidad;
	}

	public double getCantidad() {
		return cantidad;
	}
}