package com.spring.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.spring.model.FormData;
import com.spring.util.DBConnector;
import com.spring.util.DBUtil;

public class UpdateCampaignStatusDAO {


	public static String UpdateCampaignStatus(String campaignId, String status){

		   
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
		
		try {
			stmt.executeUpdate(query);
			status1="true";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	status1="true";
    
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			
		    DBUtil.close(stmt);
			
			DBUtil.close(con);
			
		} 
		
		
		
		return status1;
	}
	
	
	
	public static String UpdateCampaignChannelStatus(String status, String campaignId, String channelId){

		   
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
				
				
				query = "Update CampaignChannel Set Status = "+"'"+status+"'"+" Where CampaignId= '"+campaignId+"' And ChannelId= '"+channelId+"'";
				
				try {
					stmt = con.createStatement();
				
				try {
					stmt.executeUpdate(query);
					status1="true";
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			//	status1="true";

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				finally{
					
				    DBUtil.close(stmt);
					DBUtil.close(con);
					
				} 
				
		return status1;
		
		

	}
	
	
	
	

}
