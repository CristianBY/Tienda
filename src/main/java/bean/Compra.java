package bean;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class Compra {
  private Cliente cliente;
  private List<ItemCompra> comprado;
  private int numFac;
  private Date fecha;

  public Compra() {
    cliente = new Cliente();
    comprado = new List<ItemCompra>();
    numFac = 0;
    fecha = new java.util.Date();
  }

  public Compra(Cliente cliente,List<ItemCompra> comprado,int numFac) {
    this.cliente = cliente;
    this.comprado = comprado;
    this.numFac = numFac;
    fecha = new java.util.Date();
  }  

  public Compra(Cliente cliente,List<ItemCompra> comprado,int numFac, Date fecha) {
    this.cliente = cliente;
    this.comprado = comprado;
    this.numFac = numFac;
    this.fecha = fecha;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public List<ItemCompra> getComprado() {
    return comprado;
  }

  public int getNumFac(){
    return numFac;
  }

  public Date getFecha(){
    return fecha;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public void setComprado(List<ItemCompra> comprado) { 
    this.comprado = comprado;
  }

  public void setNumFac(int numFac) {
    this.numFac = numFac;
  }
  
  public Date setFecha(Date fecha) {
    return fecha;
  }

  @ Override
  public String toString() {
    String cadena;
    double total = 0;
    cadena = "\t\t****Factura: "+numFac+"****\n\n";
    cadena += cliente.getNombre()+" - "+ cliente.getDni()+"\n"+cliente.getDireccion()+"\n\n";
    for (ItemCompra items :comprado){
      total += items.getPrecio()*items.getCantidad();
      cadena += items.getSku()+"  "+String.format("%-10s",items.getName())+" ----- "+items.getCantidad()
      +"\t"+String.format("%.2f",items.getPrecio()*items.getCantidad())+"\n";
    }
    cadena += "  \t\t\tTotal: "+ String.format("%.2f",total)+" Euros\n\n";
    cadena += fecha;
    return cadena;
  }
}

