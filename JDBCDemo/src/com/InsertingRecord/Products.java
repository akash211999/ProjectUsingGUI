package com.InsertingRecord;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.xdevapi.PreparableStatement;


public class Products {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/products", "root", "root");
		
//		Statement st = con.createStatement();
//		st.executeUpdate("insert into productdata values(101,'book','stationary');");
		
//		PreparedStatement ps = con.prepareStatement("select * from productdata where id = ?");
//		ps.setInt(1,101);
//		ResultSet rs = ps.executeQuery();
//		
//		while(rs.next()) {
//			System.out.println(rs.getInt("id"));
//			System.out.println(rs.getString("pname"));
//			System.out.println(rs.getString("catagory"));
//		}
//	
//		ps.close();
		
		Scanner sc = new Scanner(System.in);
		
		PreparedStatement ps = null;
		
		for(int i=1; i<=5; i++) {
			System.out.println("Enter id");
			int id = sc.nextInt();
			
			System.out.println("Enter pname");
			String pname = sc.next();
			
			System.out.println("Enetr Catagory");
			String Catagory = sc.next();
			
			ps = con.prepareStatement("insert into productdata values(? , ? , ?)");
			ps.setInt(1, id);
			ps.setString(2,pname);
			ps.setString(3, Catagory);
			
			ps.executeUpdate();
			
			
		}
		ps.close();
		con.close();
		
	}

}
