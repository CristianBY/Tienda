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
	public VBox busqueda(int parametro1) {
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
	public VBox box() {
		BuscaFactura b = new BuscaFactura();
		Label label = new Label("Introduce el número de factura");
		
		TextField text = new TextField();
		text.setLayoutX(50);

		Button b1 = new Button("_Buscar");
		b1.setStyle("-fx-text-fill: white;"
    				+"-fx-font-weight: bold;"
    				+"-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
    				+"-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");
	
		VBox rootFacturas = new VBox(label,text,b1);
		rootFacturas.setMaxSize(250, 250);

		b1.setOnAction(e -> {
			rootFacturas.getChildren().clear();
        	rootFacturas.getChildren().add(b.busqueda((Integer.parseInt(text.getText()))));
		
		});

	
		return rootFacturas;
		
	}	



}
