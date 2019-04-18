package com.tienda.gui;

import java.util.List;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ChoiceBox;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.TextField;



import com.tienda.bean.*;
import com.tienda.dao.*;

public class BuscaFactura extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}
	public VBox busqueda (int parametro1) {
		Compra compra = new Compra();
		DAOImpCompraBD busqueda2 = new DAOImpCompraBD();
		String productos = null;
		VBox box = new VBox();
		double total = 0.0;

		compra = busqueda2.ticket(parametro1);
		System.out.println(compra);
	
 		Label Factura = new Label("Factura"+ compra.getNumFac());
		Label dniNombre = new Label(compra.getCliente().getDni() +"--" + compra.getCliente().getNombre());
		Label direccion = new Label(compra.getCliente().getDireccion());
		box.getChildren().add(Factura);
		box.getChildren().add(dniNombre);
		box.getChildren().add(direccion);

		for (ItemCompra i : compra.getComprado()) {
			total += i.getPrecio()*i.getCantidad();
			productos = i.getSku() + "   " + i.getName()+ " " + i.getCantidad() + "_________" + i.getCantidad()*i.getPrecio() + "€";
			Label comprado = new Label(productos);
			box.getChildren().add(comprado);
			
			
		}
		Label precio = new Label("Total a pagar " + total + "€");
		box.getChildren().add(precio);
		box.setStyle(
				""
						+ "-fx-background-color:white;"
				);
		
		return box;
		
	} 
	public VBox box ()
	{	
		BuscaFactura b = new BuscaFactura();
		Label label = new Label("Introduce el número de factura");
		
		TextField text = new TextField();
		text.setLayoutX(150);
		   //   text.setY(75); 
		Button b1 = new Button("_Buscar");
	
		VBox rootFacturas = new VBox(label,text,b1);
		rootFacturas.setMaxSize(250, 250);

	
		b1.setOnAction(e -> {
		
		
           rootFacturas.getChildren().add(b.busqueda((Integer.parseInt(text.getText()))));
	
		
		});



		
		return rootFacturas;
		
	}	



}
