package com.tienda.bean;

public class Producto {

    private Integer sku;
    private String name;
    private Double precio;

    public Producto() {
    
    }
    public Producto( int sku, String name, double precio) {
        this.sku = sku;
        this.name = name;
        this.precio = precio; 
    }

    public void setSku(int sku) {
      this.sku = sku;
    }
    public int getSku() {
      return sku;
    }

    public void setName(String name) {
      this.name = name;
    }
    public String getName() {
      return name;
    }

    public void setPrecio(double precio) {
      this.precio = precio;
    }
    public double getPrecio() {
      return precio;
    }

    @ Override
    public String toString() {
      return sku+" "+name+" "+precio+" Euros/kg";
    }

    @ Override
    public boolean equals(Object o) {
      if (o == null) return false;
      if (o == this) return true;
      if (!(o instanceof Producto)){
        return false;
      }
      Producto producto = (Producto) o;
      if(sku.equals(producto.getSku()) && name.equals(producto.getName()) && precio.equals(producto.getPrecio())) {
        return true;
      }
      else {
        return false;
      }
    }

}
