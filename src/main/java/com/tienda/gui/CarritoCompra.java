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
import javafx.scene.control.ListView;
import javafx.scene.control.ChoiceBox;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;


import com.tienda.bean.*;
import com.tienda.dao.*;

public class CarritoCompra extends Application{

	@Override
	public void start(Stage CarritoCompra) throws Exception {
		// TODO Auto-generated method stub
		
	}
	public VBox mostrarCarritoCompra (List<ItemCompra> carrito) {	

		ChoiceBox listaProductosComprados = new ChoiceBox(FXCollections.observableArrayList(carrito));
		Button eliminar = new Button("_Eliminar");
		Button volver = new Button("_Volver");
		String cssButton = "-fx-text-fill: white;"
    						+"-fx-font-weight: bold;"
    						+"-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
    						+"-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );";
		eliminar.setStyle(cssButton);
		volver.setStyle(cssButton);
		
		VBox rootCarrito = new VBox(listaProductosComprados,eliminar,volver);
		rootCarrito.setMaxSize(250, 250);

		eliminar.setOnAction(e -> {
			ItemCompra item = (ItemCompra)listaProductosComprados.getValue();
			carrito.remove(carrito.indexOf(item));
			rootCarrito.getChildren().clear();
			rootCarrito.getChildren().add(mostrarCarritoCompra(carrito));
		});

		volver.setOnAction(e -> {
			rootCarrito.getChildren().clear();
		});
	
		return rootCarrito;
		
	}
}