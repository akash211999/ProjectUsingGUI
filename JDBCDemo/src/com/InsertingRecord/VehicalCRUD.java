package com.InsertingRecord;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class VehicalCRUD {

	public static Connection getCon() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/VehicleData","root","root");
		return con;
	}
	
	public static void insert() throws Exception {
		Connection c1 = VehicalCRUD.getCon();
		Statement st = c1.createStatement();
		String q1 = "insert into vehicle values (101,'BMW');";
		
		st.executeUpdate(q1);
		c1.close();
		st.close();
	}
	
	public static void update() throws Exception {
		Connection c2 = VehicalCRUD.getCon();
		Statement st = c2.createStatement();
		st.executeUpdate("update Vehicle set name = 'THAR' where id = 101");
		
		c2.close();
		st.close();
	}
	
	public static void fetch() throws Exception {
		Connection c1 = VehicalCRUD.getCon();
		Statement st = c1.createStatement();
		
		ResultSet rs = st.executeQuery("select * from Vehicle;");
		while (rs.next()) {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		VehicalCRUD.insert();
		VehicalCRUD.update();
		VehicalCRUD.fetch();
		
	}
	
}
