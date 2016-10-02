package com.spring.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.spring.model.Creative;
import com.spring.util.DBConnector;
import com.spring.util.DBUtil;

public class DisplayCreativeDAO {

	
	public static List<Creative> DisplayCreative(String emailid){
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
	    
	    String Description = null;
	    String channel = null;
        String status = null;
	    String type = null;
	    String title = null;
	    Integer size = 0;
        String date = null;
        Integer id = 0;
        List<Creative> creative = new ArrayList<Creative>();
	    String query = "Select Id,Title,Description,Channel,Type,Size,DateAdded,Status from FacebookCreative where EmailId="+"'"+emailid+"'"+" UNION Select Id,Title,Description,Channel,Type,Size,DateAdded,Status from DisplayCreative where EmailId="+"'"+emailid+"'"+" UNION Select Id,Title,Description,Channel,Type,Size,DateAdded,Status from RestCreative where EmailId="+"'"+emailid+"'";
		
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
			 Creative creative1 = new Creative();
			 id = rs.getInt("Id");	
			 Description = rs.getString("Description");
			 channel = rs.getString("Channel");
			 status = rs.getString("Status");
			 type = rs.getString("Type");
			 date = rs.getString("DateAdded");
			 size = rs.getInt("size");
			 title = rs.getString("Title");
			 creative1.setId(id);
			 creative1.setDescription(Description);	
			 creative1.setChannel(channel);
			 creative1.setStatus(status);
			 creative1.setType(type);
			 creative1.setDateAdded(date);
		     creative1.setSize(size);
			 creative1.setTitle(title);
			 creative.add(creative1);
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
	
   return creative;
   
   }

	
	
	public static Creative DisplayCreativeIddetails(String creativeId, String channel, String emailid){
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
	    
	    String Description = null;
	    
        String status = null;
	    String type = null;
	    String title = null;
	    Integer size = 0;
        String date = null;
        Integer id = 0;
        Creative creative1 = new Creative();
        List<Creative> creative = new ArrayList<Creative>();
	    String query = null;
        if(channel.equals("Facebook"))
	    query = "Select * from FacebookCreative where EmailId="+"'"+emailid+"'"+"And Id="+"'"+creativeId+"'"; 
		
	    else if(channel.equals("DBM"))
	    query = "Select * from DisplayCreative where EmailId="+"'"+emailid+"'"+"And Id="+"'"+creativeId+"'";
				
	    else if(channel.equals("Adwords"))	
	    query = "Select * from DisplayCreative where EmailId="+"'"+emailid+"'"+"And Id="+"'"+creativeId+"'"; 
	   
	    else
	    query = "Select * from RestCreative where EmailId="+"'"+emailid+"'"+"And Id="+"'"+creativeId+"'"; 
	    	
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
			
			 id = rs.getInt("Id");	
			 Description = rs.getString("Description");
			 channel = rs.getString("Channel");
			 status = rs.getString("Status");
			 type = rs.getString("Type");
			 date = rs.getString("DateAdded");
			 size = rs.getInt("size");
			 title = rs.getString("Title");
			 
			 
			 creative1.setId(id);
			 creative1.setDescription(Description);	
			 creative1.setChannel(channel);
			 creative1.setStatus(status);
			 creative1.setType(type);
			 creative1.setDateAdded(date);
		     creative1.setSize(size);
			 creative1.setTitle(title);
			 if(channel.equals("Facebook"))
			 creative1.setFacebookCreative(rs.getString("FacebookCreative"));

			 
			 if(channel.equals("Facebook"))
			 {
			  
			  creative1.setNewsFeedTitle(rs.getString("NewsFeedTitle"));
			  creative1.setNewsFeedCreativeUrl(rs.getString("NewsFeedCreativeFile"));
			  creative1.setFbRHSTitle(rs.getString("RHSTitle"));	 
			  creative1.setFbRHSMiniDescription(rs.getString("RHSMiniDescription"));
			  creative1.setFbRHSDescription(rs.getString("RHSDescription"));
			  creative1.setFbRHSCreativeUrl(rs.getString("RHSUploadCreativeFile"));	
			  creative1.setFbMobileAdCreativeUrl(rs.getString("MobileSizeUploadCreativeFile"));
			  creative1.setFbMobileAdTitle(rs.getString("MobileSizeUploadTitle"));
			  creative1.setFbSlideShowUrls(rs.getString("UploadVideoSlideShowFile"));
			  creative1.setFbVideoUrl(rs.getString("UploadVideoFile"));
			 
			 }
			 
			 else if(channel.equals("DBM"))
			 {
				 creative1.setDispVastTagUrl(rs.getString("VastTag"));
				 creative1.setDispUploadCreativeVideoUrl(rs.getString("UploadVideoFile"));
			     creative1.setDispUploadCreativeUrl(rs.getString("UploadFile"));
			//     creative1.setDispThirdPartyTagUrl(rs.getString);
			 
			 }
			 
			 else if(channel.equals("Adwords"))		 
			 {

				 creative1.setDispVastTagUrl(rs.getString("VastTag"));
				 creative1.setDispUploadCreativeVideoUrl("UploadVideoFile");
			     creative1.setDispUploadCreativeUrl(rs.getString("UploadFile"));
			//     creative1.setDispThirdPartyTagUrl(rs.getString());
			 
				 
				 
			 }
			 else
			 {
				 creative1.setWhatsAppAdImageUrl(rs.getString("WhatsAppAdImageFile"));
				 creative1.setWhatsAppAdText(rs.getString("WhatsAppAdText"));
				 creative1.setWhatsAppAdVideoUrl(rs.getString("WhatsAppAdVideoFile"));
			     creative1.setSmsText(rs.getString("SMSText"));
			     creative1.setEmailMrktImageUrl(rs.getString("EmailMrktUploadUrl"));
			     creative1.setEmailMrktTextHTML(rs.getString("EmailMrktTextHTML"));
			     creative1.setContentMrktText(rs.getString("ContentMrktText"));
			     creative1.setContentMrktImageUrl(rs.getString("ContentMrktImageUrl"));
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
	
   return creative1;
   
   }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Display creative based on filters

	public static List<Creative> DisplayCreative(String emailid,String channel,String type,String dateadded,String status){
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
	    String Description = null;
	//    String channel = null;
   //     String status = null;
	//    String type = null;
	    String title = null;
	    Integer size = 0;
        String date = null;
        Integer id = 0;
        List<Creative> creative = new ArrayList<Creative>();
	    
	    
	    PreparedStatement ps = null;
/*	
	    if(channel == null && type == null && dateadded == null && status == null){    
	    
	    try {
			ps = con.prepareStatement("Select Id,Title,Description,Channel,UserId,Type,Size,Dateadded,Status from Creative where EmailId=?");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    try {
			ps.setString(1,Id);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    
	    
	     ResultSet rs = null;
		try {
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			while(rs.next()){
			 Creative creative1 = new Creative();
				
			 Description = rs.getString("Description");
			 channel = rs.getString("Channel");
			 status = rs.getString("Status");
			 type = rs.getString("Type");
			 date = rs.getString("Date Added");
			 size = rs.getInt("size");
			 title = rs.getString("Title");
			 creative1.setDescription(Description);	
			 creative1.setChannel(channel);
			 creative1.setStatus(status);
			 creative1.setType(type);
			 creative1.setDate(date);
		     creative1.setSize(size);
			 creative1.setTitle(title);
			 creative.add(creative1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         // Run specific query
	
   return creative;
	   
	    }
	*/    
	    
	    if(channel != null && type == null && dateadded == null && status == null){  
	    	 
	    	
	    	if(channel.equals("Facebook")){
	    	try {
	 			ps = con.prepareStatement("Select Id,Title,Description,Channel,UserId,Type,Size,Dateadded,Status from FacebookCreative where emailId=?");
	 		} catch (SQLException e1) {
	 			// TODO Auto-generated catch block
	 			e1.printStackTrace();
	 		}
	 	    try {
	 			ps.setString(1,emailid);
	 			
	 		} catch (SQLException e1) {
	 			// TODO Auto-generated catch block
	 			e1.printStackTrace();
	 		}
	    }
	 	    else if (channel.equals("Display"))
	 	    {
	 	   	try {
	 			ps = con.prepareStatement("Select Id,Title,Description,Channel,UserId,Type,Size,Dateadded,Status from DisplayCreative where emailId=?");
	 		} catch (SQLException e1) {
	 			// TODO Auto-generated catch block
	 			e1.printStackTrace();
	 		}
	 	    try {
	 			ps.setString(1,emailid);
	 			
	 		} catch (SQLException e1) {
	 			// TODO Auto-generated catch block
	 			e1.printStackTrace();
	 		}
	 	    	
	 	    	
	 	    }
	 	    else{
	 	    	
	 	    	try {
		 			ps = con.prepareStatement("Select Id,Title,Description,Channel,UserId,Type,Size,Dateadded,Status from RestCreative where emailId=?");
		 		} catch (SQLException e1) {
		 			// TODO Auto-generated catch block
		 			e1.printStackTrace();
		 		}
		 	    try {
		 			ps.setString(1,emailid);
		 			
		 		} catch (SQLException e1) {
		 			// TODO Auto-generated catch block
		 			e1.printStackTrace();
		 		}
		 	    		
	 	    }
	    	
	 	    	
	 	    
	 	     ResultSet rs = null;
	 		try {
	 			rs = ps.executeQuery();
	 		} catch (SQLException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}
	 		 try {
	 			while(rs.next()){
	 			 Creative creative1 = new Creative();
	 				
	 			 Description = rs.getString("Description");
	 			 channel = rs.getString("Channel");
	 			 status = rs.getString("Status");
	 			 type = rs.getString("Type");
	 			 date = rs.getString("Dateadded");
	 			 size = rs.getInt("size");
	 			 title = rs.getString("Title");
	 			 creative1.setDescription(Description);	
	 			 creative1.setChannel(channel);
	 			 creative1.setStatus(status);
	 			 creative1.setType(type);
	 			 creative1.setDateAdded(dateadded);
	 		     creative1.setSize(size);
	 			 creative1.setTitle(title);
	 			 creative.add(creative1);
	 			}
	 		} catch (SQLException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}
	          // Run specific query
	 	
	    return creative;
	 	   
	    
	    
	    
   }

	
	    if(channel == null && type != null && dateadded == null && status == null){  
	    	 try {
	 			ps = con.prepareStatement("Select Id,Title,Description,Channel,UserId,Type,Size,Dateadded,Status from FacebookCreative where emailId="+"and type=");
	 		} catch (SQLException e1) {
	 			// TODO Auto-generated catch block
	 			e1.printStackTrace();
	 		}
	 	    try {
	 			ps.setString(1,emailid);
	 			ps.setString(2,type);
	 		//	ps.setString(3,type);
	 		} catch (SQLException e1) {
	 			// TODO Auto-generated catch block
	 			e1.printStackTrace();
	 		}
	 	    
	 	    
	 	     ResultSet rs = null;
	 		try {
	 			rs = ps.executeQuery();
	 		} catch (SQLException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}
	 		 try {
	 			while(rs.next()){
	 			 Creative creative1 = new Creative();
	 				
	 			 Description = rs.getString("Description");
	 			 channel = rs.getString("Channel");
	 			 status = rs.getString("Status");
	 			 type = rs.getString("Type");
	 			 date = rs.getString("Dateadded");
	 			 size = rs.getInt("size");
	 			 title = rs.getString("Title");
	 			 creative1.setDescription(Description);	
	 			 creative1.setChannel(channel);
	 			 creative1.setStatus(status);
	 			 creative1.setType(type);
	 			 creative1.setDateAdded(date);
	 		     creative1.setSize(size);
	 			 creative1.setTitle(title);
	 			 creative.add(creative1);
	 			}
	 		} catch (SQLException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}
	          // Run specific query
	 	
	    return creative;
	 	   
	    
	    
	    
  }

	    
	    
	    if(channel == null && type == null && dateadded != null && status == null){  
	    	 try {
	 			ps = con.prepareStatement("Select * from Creative where emailId=? and channel=? and type=? and dateadded=?");
	 		} catch (SQLException e1) {
	 			// TODO Auto-generated catch block
	 			e1.printStackTrace();
	 		}
	 	    try {
	 			ps.setString(1,emailid);
	 			ps.setString(2, channel);
	 			ps.setString(3,type);
	 			ps.setString(4,dateadded);
	 		} catch (SQLException e1) {
	 			// TODO Auto-generated catch block
	 			e1.printStackTrace();
	 		}
	 	    
	 	    
	 	     ResultSet rs = null;
	 		try {
	 			rs = ps.executeQuery();
	 		} catch (SQLException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}
	 		 try {
	 			while(rs.next()){
	 			 Creative creative1 = new Creative();
	 				
	 			 Description = rs.getString("Description");
	 			 channel = rs.getString("Channel");
	 			 status = rs.getString("Status");
	 			 type = rs.getString("Type");
	 			 date = rs.getString("Dateadded");
	 			 size = rs.getInt("size");
	 			 title = rs.getString("Title");
	 			 creative1.setDescription(Description);	
	 			 creative1.setChannel(channel);
	 			 creative1.setStatus(status);
	 			 creative1.setType(type);
	 			 creative1.setDateAdded(date);
	 		     creative1.setSize(size);
	 			 creative1.setTitle(title);
	 			 creative.add(creative1);
	 			}
	 		} catch (SQLException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}
	          // Run specific query
	 	
	    return creative;
	 	   
	    
	    
	    
 }
	
	
	    if(channel == null && type == null && dateadded == null && status != null){  
	    	 try {
	 			ps = con.prepareStatement("Select * from Creative where emailId=? and channel=? and type=? and dateadded=? and status=?");
	 		} catch (SQLException e1) {
	 			// TODO Auto-generated catch block
	 			e1.printStackTrace();
	 		}
	 	    try {
	 			ps.setString(1,emailid);
	 			ps.setString(2, channel);
	 			ps.setString(3,type);
	 			ps.setString(4,dateadded);
	 			ps.setString(5,status);
	 		} catch (SQLException e1) {
	 			// TODO Auto-generated catch block
	 			e1.printStackTrace();
	 		}
	 	    
	 	    
	 	     ResultSet rs = null;
	 		try {
	 			rs = ps.executeQuery();
	 		} catch (SQLException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}
	 		 try {
	 			while(rs.next()){
	 			 Creative creative1 = new Creative();
	 				
	 			 Description = rs.getString("Description");
	 			 channel = rs.getString("Channel");
	 			 status = rs.getString("Status");
	 			 type = rs.getString("Type");
	 			 date = rs.getString("Date Added");
	 			 size = rs.getInt("size");
	 			 title = rs.getString("Title");
	 			 creative1.setDescription(Description);	
	 			 creative1.setChannel(channel);
	 			 creative1.setStatus(status);
	 			 creative1.setType(type);
	 			 creative1.setDateAdded(dateadded);
	 		     creative1.setSize(size);
	 			 creative1.setTitle(title);
	 			 creative.add(creative1);
	 			}
	 		} catch (SQLException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}
	          // Run specific query
	 	
	    return creative;
	 	   
	    
	    
	    
}
	  
	   
	 return creative;   
	    
	}	
	


}
