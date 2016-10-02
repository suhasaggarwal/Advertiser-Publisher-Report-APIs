package com.spring.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.spring.model.Creative;
import com.spring.util.DBConnector;
import com.spring.util.DBUtil;

public class EditCreativeDAO {

	public static String deleteCreative(Integer id,String channel, String emailid){
		    String ServerConnectionURL = "jdbc:mysql://52.90.244.81:3306/cuberootapp";
			String DBUser = "root";
		    String DBPass = "Qwerty12@";
		    String DBName = "cuberootapp";
			String TABLENAME = "";
			Connection con = null;
			DBConnector connector = new DBConnector();
			con = connector.getPooledConnection();
		    String status1 = "false";
		    Statement stmt = null;
		    String query = null;
		    
		    if(channel.equals("Facebook"))
		    query = "Delete from FacebookCreative where Id in ("+id+") AND EmailId="+emailid ;
	    
		    else if(channel.equals("DBM") || channel.equals("Adwords")) 
		    query = "Delete from DisplayCreative where Id in ("+id+") AND EmailId="+emailid ;
		
		    else
		    query= "Delete from RestCreative where Id in ("+id+") AND EmailId="+emailid ;
		    
		    
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

	
	
	public static String updateCreative(Integer id, String title, String description, String channel, String status, String emailid){
		   String ServerConnectionURL = "jdbc:mysql://52.90.244.81:3306/cuberootapp";
			String DBUser = "root";
		    String DBPass = "Qwerty12@";
		    String DBName = "cuberootapp";
			String TABLENAME = "";
			Connection con = null;
			DBConnector connector = new DBConnector();
			con = connector.getPooledConnection();
		    String status1 = "false";
		    Statement stmt = null;
		    String query = null;
		    
		    if(channel.equals("Facebook"))
	//	    query = "Update FacebookCreative(Title,Description,Channel,Status) VALUES("+"'"+title+"'"+","+"'"+description+"'"+","+"'"+channel+"'"+","+"'"+status +"'"+")"+ " WHERE Id="+id+ " AND EmailId="+emailid;
		    query = "Update FacebookCreative Set Title = '"+title+"'"+","+"Description = '"+description+ "'"+","+"Channel = '"+channel+"'"+","+"Status = '"+status+"'"+" WHERE Id="+id+ " AND EmailId="+"'"+emailid+"'";
		    	
		    	
		    	
		    else if(channel.equals("DBM") || channel.equals("Adwords"))
		//	query = "Update DisplayCreative(Title,Description,Channel,Status) VALUES("+"'"+title+"'"+","+"'"+description+"'"+","+"'"+channel+"'"+","+"'"+status +"'"+")"+ " WHERE Id="+id+ " AND EmailId="+emailid;
		     query = "Update DisplayCreative Set Title = '"+title+"'"+","+"Description = '"+description+ "'"+","+"Channel = '"+channel+"'"+","+"Status = '"+status+"'"+" WHERE Id="+id+ " AND EmailId="+"'"+emailid+"'";
	    	  
		 
		    else{
		    		 query = "Update RestCreative Set Title = '"+title+"'"+","+"Description = '"+description+ "'"+","+"Channel = '"+channel+"'"+","+"Status = '"+status+"'"+" WHERE Id="+id+ " AND EmailId="+"'"+emailid+"'";
			    	  
		    }
		    
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
	
/*	
	public static String updateFullCreativeData(Creative creative, String emailid){
		   String ServerConnectionURL = "jdbc:mysql://52.90.244.81:3306/cuberootapp";
			String DBUser = "root";
		    String DBPass = "Qwerty12@";
		    String DBName = "cuberootapp";
			String TABLENAME = "";
			Connection con = null;
			DBConnector connector = new DBConnector();
			con = connector.getPooledConnection();
		    String status1 = "false";
		    Statement stmt = null;
		    String query = null;
		    String channel = creative.getChannel();
		    
		    if(channel.equals("Facebook")){
	
		    if(creative.getNewsFeedTitle() != null)	
		    	
		    	//	    query = "Update FacebookCreative(Title,Description,Channel,Status) VALUES("+"'"+title+"'"+","+"'"+description+"'"+","+"'"+channel+"'"+","+"'"+status +"'"+")"+ " WHERE Id="+id+ " AND EmailId="+emaili
		    	query = "Update FacebookCreative Set NewsFeedTitle = '"+creative.getNewsFeedTitle()+"'"+" WHERE Id="+creative.getId()+ " AND EmailId="+"'"+emailid+"'";
		    	
            if(creative.getFbRHSTitle() != null)	
		    	
		    	//	    query = "Update FacebookCreative(Title,Description,Channel,Status) VALUES("+"'"+title+"'"+","+"'"+description+"'"+","+"'"+channel+"'"+","+"'"+status +"'"+")"+ " WHERE Id="+id+ " AND EmailId="+emaili
		    	query = "Update FacebookCreative Set RHSTitle = '"+creative.getFbRHSTitle()+"'"+" Set RHSMiniDescription= '"+creative.getFbRHSMiniDescription()+"'"+" Set RHSDescription='"+creative.getFbRHSDescription()+"'"+" WHERE Id="+creative.getId()+ " AND EmailId="+"'"+emailid+"'";
		    	
            if(creative.getFbMobileAdTitle() != null)	
		    	
		    	//	    query = "Update FacebookCreative(Title,Description,Channel,Status) VALUES("+"'"+title+"'"+","+"'"+description+"'"+","+"'"+channel+"'"+","+"'"+status +"'"+")"+ " WHERE Id="+id+ " AND EmailId="+emaili
		    	query = "Update FacebookCreative Set MobileSizeUploadTitle = '"+creative.getFbMobileAdTitle()+"'"+" WHERE Id="+creative.getId()+ " AND EmailId="+"'"+emailid+"'";
		    	
		    
		    
		    
		    
		    } 	
		    	
		    else if(channel.equals("DBM") || channel.equals("Adwords"))
		//	query = "Update DisplayCreative(Title,Description,Channel,Status) VALUES("+"'"+title+"'"+","+"'"+description+"'"+","+"'"+channel+"'"+","+"'"+status +"'"+")"+ " WHERE Id="+id+ " AND EmailId="+emailid;
		     query = "Update DisplayCreative Set Title = '"+title+"'"+","+"Description = '"+description+ "'"+","+"Channel = '"+channel+"'"+","+"Status = '"+status+"'"+" WHERE Id="+id+ " AND EmailId="+"'"+emailid+"'";
	    	  
		 
		    else{
		    		 query = "Update RestCreative Set Title = '"+title+"'"+","+"Description = '"+description+ "'"+","+"Channel = '"+channel+"'"+","+"Status = '"+status+"'"+" WHERE Id="+id+ " AND EmailId="+"'"+emailid+"'";
			    	  
		    }
		    
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
*/	
	
	
	
}
