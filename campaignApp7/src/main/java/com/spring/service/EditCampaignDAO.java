package com.spring.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.spring.util.DBConnector;
import com.spring.util.DBUtil;

public class EditCampaignDAO {

	public static String updateCampaignChannel(String id,String channel, String emailid, String status){
		    String ServerConnectionURL = "jdbc:mysql://52.90.244.81:3306/cuberootapp";
			String DBUser = "root";
		    String DBPass = "Qwerty12@";
		    String DBName = "cuberootapp";
			String TABLENAME = "";
			Connection con = null;
			DBConnector connector = new DBConnector();
			con = connector.getPooledConnection(ServerConnectionURL);
		    String status1 = "false";
		    Statement stmt = null;
		    String query = null;
		    
		  
		    query = "Update CampaignChannel Set Status = '"+status+"'"+" WHERE Id="+id+ " AND Channel ='"+channel+"'"+"AND EmailId="+"'"+emailid+"'";
		    		
		    
		    System.out.println(query);
		try {
			
			stmt = con.createStatement();
			stmt.executeUpdate(query);
			status1="true";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		  
			DBUtil.close(stmt);
			DBUtil.close(con);
		
		}

	 
				// Run specific query
		
	   return status1;
	   
	   }

	
	
	public static String updateCampaign(String id, String status, String emailid){
		   String ServerConnectionURL = "jdbc:mysql://52.90.244.81:3306/cuberootapp";
			String DBUser = "root";
		    String DBPass = "Qwerty12@";
		    String DBName = "cuberootapp";
			String TABLENAME = "";
			Connection con = null;
			DBConnector connector = new DBConnector();
			con = connector.getPooledConnection(ServerConnectionURL);
		    String status1 = "false";
		    Statement stmt = null;
		    
		    try{	
		    
		   
		    String query = "Update Campaign Set Status = '"+status+"'"+" WHERE Id="+id+ " AND EmailId="+"'"+emailid+"'";
		    stmt = con.createStatement();
			stmt.executeUpdate(query);
	    	
	}
	catch(Exception e){
		
		e.printStackTrace();
		  
			} finally {
				
			  
				DBUtil.close(stmt);
				DBUtil.close(con);
			
			}

		 
					// Run specific query
			
		   return status1;
	   
	   }	
	
	
	
	
	
}
