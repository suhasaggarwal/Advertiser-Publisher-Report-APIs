package com.spring.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring.model.Creative;
import com.spring.util.DBConnector;
import com.spring.util.DBUtil;

public class GetUrlDAO {


	public static String GetUrlCreative(String  Id, String channel){

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
	  
	     String NewsFeedCreativeUrl;
	     
	  
	     String fbRHSCreativeUrl;
	     
	   
	     String fbMobileAdCreativeUrl;
	     
	    
	     String fbSlideShowUrls;
	     
	 
	     String fbVideoUrl;
	     
	    
	     String DispUploadCreativeUrl;
	     
	    
	     String DispUploadCreativeVideoUrl;
	     
	    
	    
	     
	    
	     String EmailMrktImageUrl;
	    
	  
	     String ContentMrktImageUrl;
	   
	     String WhatsAppAdImageUrl;
	    
	     String WhatsAppAdVideoUrl;

        List<Creative> creative = new ArrayList<Creative>();
	  
        if(channel.equals("Facebook"))
         query = "Select * from FacebookCreative where Id ="+Id;
     
        else if(channel.equals("DBM"))
         query = "Select * from DisplayCreative where Id ="+Id;
         
        else if(channel.equals("Adwords"))	   
    	 query =  "Select * from DisplayCreative where Id ="+Id;  
    	   
        else
        query = "Select * from RestCreative where Id ="+Id;
        
        Statement st = null;
		try {
			st = con.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	      
	      // execute the query, and get a java resultset
	     ResultSet rs = null;
		try {
			rs = st.executeQuery(query);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		 try {
			while(rs.next()){
			
				if(channel.equals("Facebook")){
				NewsFeedCreativeUrl = rs.getString("NewsFeedCreativeFile");
					  
				if( NewsFeedCreativeUrl.equals("null")==false && NewsFeedCreativeUrl.isEmpty() == false)
				return NewsFeedCreativeUrl;
					  
			    fbRHSCreativeUrl =  rs.getString("RHSUploadCreativeFile");
				if(fbRHSCreativeUrl.equals("null")==false && fbRHSCreativeUrl.isEmpty() == false)	   
				return fbRHSCreativeUrl; 
					   
			   fbMobileAdCreativeUrl = rs.getString("MobileSizeUploadCreativeFile");
				if(fbMobileAdCreativeUrl.equals("null")==false && fbMobileAdCreativeUrl.isEmpty() == false)	     
				return fbMobileAdCreativeUrl; 	    
			    
				fbSlideShowUrls = rs.getString("UploadVideoSlideShowFile");
				if(fbSlideShowUrls.equals("null")==false && fbSlideShowUrls.isEmpty() == false )	     
					return fbSlideShowUrls;
					
					
			     fbVideoUrl = rs.getString("UploadVideoFile");
				if(fbVideoUrl.equals("null")==false && fbVideoUrl.isEmpty() == false)
			      return fbVideoUrl;
			     
			     
				}		
					
					
				  if(channel.equals("DBM")){
					 
					 
				  DispUploadCreativeUrl = rs.getString("UploadFile");	 
				  if( DispUploadCreativeUrl.equals("null")==false &&  DispUploadCreativeUrl.isEmpty() == false)
				      return DispUploadCreativeUrl; 
				  
				  
				  
			      DispUploadCreativeVideoUrl = rs.getString("UploadVideoFile");
			      if(DispUploadCreativeVideoUrl.equals("null")==false && DispUploadCreativeVideoUrl.isEmpty() == false)
				      return  DispUploadCreativeVideoUrl; 
					 
				 }
			   
				 
					
				 if(channel.equals("Adwords")){
					 
					 
				  DispUploadCreativeUrl = rs.getString("UploadFile");	 
				 if(DispUploadCreativeUrl.equals("null")==false && DispUploadCreativeUrl.isEmpty() == false)	
				    return DispUploadCreativeUrl;
				  
			      DispUploadCreativeVideoUrl = rs.getString("UploadVideoFile");
					if(DispUploadCreativeVideoUrl.equals("null")==false &&  DispUploadCreativeVideoUrl.isEmpty()) 
					return  DispUploadCreativeVideoUrl;
				 }
			
			
				 if(channel.equals("WhatsApp")){
					 
					 
					 WhatsAppAdImageUrl = rs.getString("WhatsAppAdImageFile");	 
				     if(WhatsAppAdImageUrl.equals("null")==false && WhatsAppAdImageUrl.isEmpty()==false)		 
					 return WhatsAppAdImageUrl;
					 
					 WhatsAppAdVideoUrl = rs.getString("WhatsAppAdVideoFile");
						 if( WhatsAppAdVideoUrl.equals("null")==false && WhatsAppAdVideoUrl.isEmpty() == false )
						 return WhatsAppAdVideoUrl;
					 }
				
				 
				    if(channel.equals("Content")){
					 
					 
				    ContentMrktImageUrl = rs.getString("ContentMrktImageUrl");	 
				    if( ContentMrktImageUrl.equals("null")==false &&  ContentMrktImageUrl.isEmpty() == false )
						 return  ContentMrktImageUrl;
				   
						 
						 
					 }
				 
				     if(channel.equals("Email")){
						 
				    	 EmailMrktImageUrl = rs.getString("EmailMrktUploadUrl");
			             if(EmailMrktImageUrl.equals("null")==false && EmailMrktImageUrl.isEmpty() == false )
							  return EmailMrktImageUrl;
						 }
			
				 
				     
			}
				
				
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally {
				
			    DBUtil.close(rs);
				DBUtil.close(st);
				DBUtil.close(con);
			
			}
		 
		 
		 
		 // Run specific query
	
return "";

	}








}
