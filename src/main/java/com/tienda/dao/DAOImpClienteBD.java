package com.tienda.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import com.tienda.bean.Cliente;

public class DAOImpClienteBD implements DAOCliente {
	
	private Connection con;

	public DAOImpClienteBD(){
		try {
			con = DriverManager.getConnection("jdbc:sqlite:datos/tienda.db");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public DAOImpClienteBD(String conexion){ // Para cualquier conexion p.ej con mysql
    	try {
      		con = DriverManager.getConnection(conexion);
    	} catch (SQLException e) {
      		System.out.println(e.getMessage());
    	}
	}

	public void grabar (Cliente cliente) {
		String sql = "INSERT INTO cliente(Nombre,Dni,Direccion) VALUES(?,?,?)";
	   	try{
	   		PreparedStatement pstmt = con.prepareStatement(sql);
      		pstmt.setString(1, cliente.getNombre());
       		pstmt.setString(2, cliente.getDni());
	      	pstmt.setString(3, cliente.getDireccion());
	      	pstmt.executeUpdate();
	     	System.out.println("Insertado cliente en la DB ");
	   	} catch (SQLException e) {
	    	System.out.println("***" + e.getMessage() + "***");
	   	}
	   		  	   
	}

	public Cliente leer (String dni) {
		Cliente cliente = null;
		String sql = "SELECT Nombre, Dni, Direccion FROM cliente WHERE Dni LIKE '"+dni+"'";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			cliente = new Cliente(rs.getString("Nombre"),rs.getString("Dni"),rs.getString("Direccion"));
		} catch (SQLException e) {
			System.out.println("***" + e.getMessage() + "***");
    	}
		return cliente;
	}

	public List<Cliente> leerTodos () {
		Cliente cliente;
		List<Cliente> clientes = new ArrayList<Cliente>();
		String sql = "SELECT Nombre, Dni, Direccion FROM cliente";
		try{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				cliente = new Cliente(rs.getString("Nombre"),rs.getString("Dni"),rs.getString("Direccion"));
				clientes.add(cliente);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}  
		return clientes;
	}

	public void cerrar() {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}  
	}
}