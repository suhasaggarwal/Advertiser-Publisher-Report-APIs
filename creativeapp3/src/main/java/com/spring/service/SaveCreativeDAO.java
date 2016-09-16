package com.spring.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import com.spring.util.DBConnector;
import com.spring.util.DBUtil;

public class SaveCreativeDAO {

   public static String saveFacebookCreative(String title,String description,String channel, String emailid, String type,Integer size,String dateadded,String status,String NewsFeedTitle,String NewsFeedCreativeFile,String RHSTitle, String RHSMiniDescription, String RHSDescription, String RHSUploadCreativeFile, String MobileSizeUploadTitle, String MobileSizeUploadCreativeFile, String UploadVideoSlideShowFile , String UploadVideoFile){
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
	    String query1 = null;
	    dateadded = new Timestamp(System.currentTimeMillis()).toString();
	    System.out.println("Saving Facebook Creative Data");
	    
	    query1 = "INSERT INTO Creative(Title,Description,Channel,UserId,Type,Size,Dateadded,Status) VALUES("+"'"+title+"'"+","+"'"+description+"'"+","+"'"+channel+"'"+","+"'"+emailid+"'"+","+"'"+type+"'"+","+"'"+size+"'"+","+"'"+dateadded+"'"+","+"'"+status+"'"+")";
	    System.out.println(query1);   
	
    if(channel.equals("Facebook"))
    query = "INSERT INTO FacebookCreative(Title,Description,Channel,EmailId,Type,Size,Dateadded,Status,NewsFeedTitle,NewsFeedCreativeFile,RHSTitle,RHSMiniDescription,RHSDescription,RHSUploadCreativeFile,MobileSizeUploadTitle,MobileSizeUploadCreativeFile,UploadVideoSlideShowFile,UploadVideoFile) VALUES("+"'"+title+"'"+","+"'"+description+"'"+","+"'"+channel+"'"+","+"'"+emailid+"'"+","+"'"+type+"'"+","+"'"+size+"'"+","+"'"+dateadded+"'"+","+"'"+status+"'"+","+"'"+NewsFeedTitle+"'"+","+"'"+NewsFeedCreativeFile+"'"+","+"'"+RHSTitle+"'"+","+"'"+RHSMiniDescription+"'"+","+"'"+RHSDescription + "'"+","+"'"+ RHSUploadCreativeFile + "'"+","+"'"+ MobileSizeUploadTitle + "'"+","+"'"+ MobileSizeUploadCreativeFile + "'"+","+"'"+ UploadVideoSlideShowFile + "'"+","+"'"+ UploadVideoFile+"'"+")";
    
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


   public static String saveDisplayCreative(String title,String description,String channel,String emailid, String type,Integer size,String dateadded,String status,String UploadFile,String UploadVideoFile,String vasttag){
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
	    String query1 = null;
	    dateadded = new Timestamp(System.currentTimeMillis()).toString();
	    
	    query1 = "INSERT INTO Creative(Title,Description,Channel,EmailId,UserId,Type,Size,DateAdded,Status) VALUES("+"'"+title+"'"+","+"'"+description+"'"+","+"'"+channel+"'"+","+"'"+emailid+"'"+","+"'"+type+"'"+","+"'"+size+"'"+","+"'"+dateadded+"'"+","+"'"+status+"'"+")";
	    System.out.println(query1);
	    
	    
	   if(channel.equals("DBM") || channel.equals("Adwords"))
        query = "INSERT INTO DisplayCreative(Title,Description,Channel,EmailId,Type,Size,DateAdded,Status,UploadFile,UploadVideoFile,VastTag) VALUES("+"'"+title+"'"+","+"'"+description+"'"+","+"'"+channel+"'"+","+"'"+emailid+"'"+","+"'"+type+"'"+","+"'"+size+"'"+","+"'"+dateadded+"'"+","+"'"+status +"'"+","+"'"+UploadFile+"'"+","+"'"+UploadVideoFile+"'"+","+"'"+vasttag+"'"+")";
   	
  
   	
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
   
   
   public static String saveWhatsappCreative(String title,String description,String channel, String emailid, String type,Integer size,String dateadded,String status, String WhatsAppAdText, String WhatsAppAdImageUrl, String WhatsAppAdVideoUrl){
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
	    String query1 = null;
        String query = null;
        dateadded = new Timestamp(System.currentTimeMillis()).toString();
        
	    query = "INSERT INTO Creative(Title,Description,Channel,EmailId,UserId,Type,Size,Dateadded,Status) VALUES("+"'"+title+"'"+","+"'"+description+"'"+","+"'"+channel+"'"+","+"'"+emailid+"'"+","+"'"+type+"'"+","+"'"+size+"'"+","+"'"+dateadded+"'"+","+"'"+status+"'"+")";
	    System.out.println(query);
       
	    if(channel.equals("WhatsApp"))	
        query1 = "INSERT INTO RestCreative(Title,Description,Channel,EmailId,Type,Size,DateAdded,Status) VALUES("+"'"+title+"'"+","+"'"+description+"'"+","+"'"+channel+"'"+","+"'"+emailid+"'"+","+"'"+type+"'"+","+"'"+size+"'"+","+"'"+dateadded+"'"+","+"'"+status +"'"+","+"'"+WhatsAppAdText+"'"+","+"'"+WhatsAppAdImageUrl + "'"+","+"'"+WhatsAppAdVideoUrl+"'"+")";
  	
  
  	
  try {
		
		stmt = con.createStatement();
		
		stmt.executeUpdate(query1);
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

   
   public static String saveEmailCreative(String title,String description,String channel,String emailid, String type,Integer size,String dateadded,String status,String EmailMrktUploadUrl, String EmailMrktTextHTML){
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
	    String query1 = null;
	    dateadded = new Timestamp(System.currentTimeMillis()).toString();
        String query = null;
	    
	    query = "INSERT INTO Creative(Title,Description,Channel,EmailId,UserId,Type,Size,Dateadded,Status) VALUES("+"'"+title+"'"+","+"'"+description+"'"+","+"'"+channel+"'"+","+"'"+emailid+"'"+","+"'"+type+"'"+","+"'"+size+"'"+","+"'"+dateadded+"'"+","+"'"+status+"'"+")";
	    System.out.println(query);
	
	
 
        if(channel.equals("Email"))		
        query1 = "INSERT INTO RestCreative(Title,Description,Channel,EmailId,Type,Size,DateAdded,Status,EmailMrktUploadUrl,EmailMrktTextHTML) VALUES("+title+"'"+","+"'"+description+"'"+","+"'"+channel+"'"+","+"'"+emailid+"'"+","+"'"+type+"'"+","+"'"+size+"'"+","+"'"+dateadded+"'"+","+"'"+status +"'"+","+"'"+EmailMrktUploadUrl+"'"+","+"'"+EmailMrktTextHTML+"'"+")";
 
 
 	
 try {
		
		stmt = con.createStatement();
		
		stmt.executeUpdate(query1);
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
   
   
   public static String saveContentCreative(String title,String description,String channel, String emailid, String type,Integer size,String dateadded,String status, String ContentMrktText, String ContentMrktImageUrl){
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
	    String query1 = null;
	    dateadded = new Timestamp(System.currentTimeMillis()).toString();

        String query = null;
	    
	    query = "INSERT INTO Creative(Title,Description,Channel,EmailId,UserId,Type,Size,Dateadded,Status) VALUES("+"'"+title+"'"+","+"'"+description+"'"+","+"'"+channel+"'"+","+"'"+emailid+"'"+","+"'"+type+"'"+","+"'"+size+"'"+","+"'"+dateadded+"'"+","+"'"+status+"'"+")";
	    System.out.println(query);
	    
	    
	
        if(channel.equals("Content"))		
        query1 = "INSERT INTO RestCreative(Title,Description,Channel,EmailId,Type,Size,DateAdded,Status,ContentMrktText,ContentMrktImageUrl) VALUES("+title+"'"+","+"'"+description+"'"+","+"'"+channel+"'"+","+"'"+emailid+"'"+","+"'"+type+"'"+","+"'"+size+"'"+","+"'"+dateadded+"'"+","+"'"+status +"'"+","+"'"+ContentMrktText+"'"+","+"'"+ContentMrktImageUrl+"'"+")";
 	
 	
 try {
		
		stmt = con.createStatement();
		
		stmt.executeUpdate(query1);
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



}
