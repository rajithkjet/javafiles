package services;

import java.sql.ResultSet;
import java.sql.Statement;

import controller.DBConnect;
import model.customer;

public class customerService {
	
	public void regCustomer(customer cus) {
		try {
			String query="insert into customer values('"+cus.getEmail()+"','"+cus.getName()+"','"+cus.getAge()+"','"+cus.getPassword()+"')";
			
			Statement statement=DBConnect.getConnection().createStatement();
			statement.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		
		
		
	}

	}
	public boolean validate(customer cus) {
		try {
			String query="select * from customer where email='"+cus.getEmail()+"' and password='"+cus.getPassword()+"'";
			
			Statement statement=DBConnect.getConnection().createStatement();
			ResultSet rs=statement.executeQuery(query);
			if(rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		
		
		
	}
		return false;
	
}}
