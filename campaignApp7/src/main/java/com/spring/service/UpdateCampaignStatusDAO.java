package com.spring.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.spring.model.FormData;
import com.spring.util.DBConnector;

public class UpdateCampaignStatusDAO {


	public static void UpdateCampaignStatus(String campaignId, String status){

		   
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
		String query  = null;
		
		query = "Update Campaign Set Status = "+"'"+status+"'"+" Where Id= '"+campaignId+"'";
		
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	status1="true";

	}
	
	
	
	public static void UpdateCampaignChannelStatus(String status, String campaignId, String channelId){

		   
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
				String query  = null;
				
				
				query = "Update Campaign Set Status = "+"'"+status+"'"+" Where Id= '"+campaignId+"'";
				
				try {
					stmt = con.createStatement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					stmt.executeUpdate(query);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			//	status1="true";

		
		
		

	}
	
	
	
	

}
