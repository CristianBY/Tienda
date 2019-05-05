package com.tienda.gui;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;


import com.tienda.bean.*;
import com.tienda.dao.*;

public class RealizarCompra extends Application{

	@Override
	public void start(Stage compraStage) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public VBox box (Cliente cliente) {	
		DAOProducto daoProducto = new DAOImpProductoBD();
		List<ItemCompra> carrito = new ArrayList<ItemCompra>();
		Label label = new Label("Productos");
		Label labelCantidad = new Label("Cantidad");
		ChoiceBox listaProductos = new ChoiceBox(FXCollections.observableArrayList(daoProducto.leerTodos()));
		TextField textCantidad = new TextField();
		textCantidad.setMaxWidth(80);
		Button alCarrito = new Button("_Al carrito");
		Button finalizar = new Button("_Finalizar");
		Button verCarrito = new Button("_Ver carrito");
		String cssButton = "-fx-text-fill: white;"
    						+"-fx-font-weight: bold;"
    						+"-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
    						+"-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );";
		alCarrito.setStyle(cssButton);
		finalizar.setStyle(cssButton);
		verCarrito.setStyle(cssButton);
		
		VBox rootCompra = new VBox(label,listaProductos,labelCantidad,textCantidad,alCarrito,verCarrito,finalizar);
		rootCompra.setMaxSize(250, 250);

		alCarrito.setOnAction(e -> {
			Producto producto = (Producto)listaProductos.getValue();
			double cantidad = Double.parseDouble(textCantidad.getText());
			ItemCompra item = new ItemCompra(producto,cantidad);
			carrito.add(item);
			textCantidad.clear();
		});

		verCarrito.setOnAction(e -> {
			CarritoCompra carritoCompra = new CarritoCompra();
			rootCompra.getChildren().add(carritoCompra.mostrarCarritoCompra(carrito));
		});

		finalizar.setOnAction(e -> {
			rootCompra.getChildren().clear();
			DAOCompra daoCompra = new DAOImpCompraBD();
			int factura = daoCompra.enumerar();
			daoCompra.cerrar();
			Compra compra = new Compra(cliente,carrito,factura);
			daoCompra = new DAOImpCompraBD();
			daoCompra.grabar(compra);
			TextArea facturaImp = new TextArea(compra.toString());
			rootCompra.getChildren().add(facturaImp);
		});


	
		return rootCompra;
		
	}

}
