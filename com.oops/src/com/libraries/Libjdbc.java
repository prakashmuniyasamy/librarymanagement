package com.libraries;

import java.sql.*;

public class Libjdbc {
	Libjdbc(){
		
		connect();
	}
	
	public Connection connect;
	
	public void connect() {
	
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	   connect=DriverManager.getConnection(
	    "jdbc:mysql://localhost:3306/librarym","10decoders","10decoders");
	}catch (Exception e) {
		System.out.println(e);
	}
}
	
	}


