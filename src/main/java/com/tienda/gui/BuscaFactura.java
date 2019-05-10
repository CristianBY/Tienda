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
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import com.tienda.bean.*;
import com.tienda.dao.*;

public class BuscaFactura extends Application{

	@Override
	public void start(Stage facturaStage) throws Exception {
		
	}
	public VBox busquedaPorFactura(int parametro1) {
		Compra compra = new Compra();
		DAOImpCompraBD busqueda2 = new DAOImpCompraBD();
		VBox box = new VBox();
		compra = busqueda2.ticket(parametro1);
		TextArea factura = new TextArea(compra.toString());
		box.getChildren().add(factura);
		factura.setStyle(
				""
						+ "-fx-background-color:white;"
						+"-fx-border-style: solid inside;"
					    +"-fx-border-style: solid inside;" 
						+"-fx-border-width: 1;" 
						+"-fx-border-radius: 1;" 
					    +"-fx-border-color: blue;"
				);
		factura.setTranslateY(50);
		factura.setTranslateX(200);
		factura.setMinSize(250, 250);
		return box;
		
	} 
	public VBox busquedaPorDni(String dni) {
		BuscaFactura b = new BuscaFactura ();
		DAOImpCompraBD busqueda2 = new DAOImpCompraBD();
		VBox box = new VBox();
	    TableView <Compra> table = new TableView();
	    
	   
	    
	    ListView <String> listado = new ListView();
	    ObservableList<String> facturas =FXCollections.observableArrayList(busqueda2.tickets(dni));
	    listado.setItems(facturas);
		Button b1 = new Button("_Factura");
		b1.setStyle("-fx-text-fill: white;"
				+"-fx-font-weight: bold;"
				+"-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
				+"-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");

		
		b1.setTranslateY(100);
		b1.setTranslateX(275);
		b1.setOnAction(e -> {
		box.getChildren().clear();
		box.getChildren().add(b.busquedaPorFactura(Integer.parseInt(listado.getSelectionModel().getSelectedItem())));
		}
		);
	
        
		box.getChildren().addAll(listado,b1);
		listado.setStyle(
				""
						+ "-fx-background-color:white;"
						+"-fx-border-style: solid inside;"
					    +"-fx-border-style: solid inside;" 
						+"-fx-border-width: 1;" 
						+"-fx-border-radius: 1;" 	
					    +"-fx-border-color: blue;"
				);
		listado.setTranslateY(50);
		listado.setTranslateX(200);
		listado.setMinSize(250, 250);
		
				return box;
		
	} 
	
	
	
	
	
	public VBox box() {
		BuscaFactura b = new BuscaFactura();
		Label label = new Label("Introduce el número de factura");
		Label label2 = new Label("Introduce el Dni del cliente");
		DAOImpCompraBD busqueda = new DAOImpCompraBD();

		TextField text = new TextField();
		TextField text2 = new TextField();
		text.setLayoutX(50);

		Button b1 = new Button("_Buscar");
		Button b2 = new Button("_Buscar");
		b1.setStyle("-fx-text-fill: white;"
    				+"-fx-font-weight: bold;"
    				+"-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
    				+"-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");
		b2.setStyle("-fx-text-fill: white;"
				+"-fx-font-weight: bold;"
				+"-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
			+"-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");
	
		VBox rootFacturas = new VBox(label,text,b1,label2,text2,b2);
		rootFacturas.setMaxSize(250, 250);

		b1.setOnAction(e -> {
			rootFacturas.getChildren().clear();
        	rootFacturas.getChildren().add(b.busquedaPorFactura((Integer.parseInt(text.getText()))));
        
		
		});
		b2.setOnAction(e -> {
			System.out.println(busqueda.tickets(text2.getText()));
			rootFacturas.getChildren().clear();
			rootFacturas.getChildren().add(b.busquedaPorDni(text2.getText()));
			System.out.println();
        
		
		});

	
		return rootFacturas;
		
	}	



}
