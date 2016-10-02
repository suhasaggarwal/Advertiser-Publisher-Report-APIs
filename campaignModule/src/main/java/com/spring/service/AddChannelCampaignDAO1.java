package com.spring.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

import com.spring.model.AgeGroup;
import com.spring.model.AudienceSegment;
import com.spring.model.Campaign;
import com.spring.model.ChannelCampaign;
import com.spring.model.Creative;
import com.spring.model.Device;
import com.spring.model.Gender;
import com.spring.model.Geography;
import com.spring.model.Income;
import com.spring.model.OperatingSystem;
import com.spring.model.Resolution;
import com.spring.util.DBConnector;
import com.spring.util.DBUtil;
import com.spring.util.IdealTargetingParametersUpdate;

public class AddChannelCampaignDAO1 {

//Campaign data will be loaded from form and individual fields will be populated
	
   public static String AddChannelCampaignData(ChannelCampaign campaign, String emailid) {
	   
        String status1 = "false";
	
	   if(campaign.getOptimumParameter()!=null && campaign.getCampId()!=null)
	   {
	  
		  status1 = IdealTargetingParametersUpdate.setIdealTargetingParameters(campaign, emailid);
	    }
	   
	   else{
	   
		   String channelId = campaign.getChannelid();
	  
	   List<Creative> creativeId = campaign.getCreative();
       int k= 0;
        String creativeid = "";
	   
	   if(creativeId  != null && creativeId.isEmpty() == false){
	   for(int i=0; i< creativeId.size(); i++){
		   if(i!=0)
		   creativeid = creativeid + ","+  creativeId.get(i).getId(); 
		   else
		   creativeid = creativeId.get(i).getId().toString();
	   }
	   }
	   
	   
	   
	   
	   
	   //	   String ObjectiveId = campaign.getObjective();
	 
	   List<Device> DeviceId = campaign.getDeviceid();
	   String deviceid ="";
	   
	   if(DeviceId != null && DeviceId.isEmpty() == false){
	   for(int i=0; i<DeviceId.size(); i++){
		   
		  deviceid = deviceid + DeviceId.get(i).getId() + ",";
		   
	   }
	   }
	   
	   List<OperatingSystem> OperatingSystemId = campaign.getOperatingsystemid();
	   String operatingsystemid = "";
	   
	   if(OperatingSystemId  != null && OperatingSystemId.isEmpty() == false){
	   for(int i=0; i< OperatingSystemId.size(); i++){
		   
		   operatingsystemid = operatingsystemid +  OperatingSystemId.get(i).getId() + ",";
			   
		   }
	   }
	   
	   
	   String Id = campaign.getId();
	   String Comments = campaign.getComments();
	   String BudgetPercentage = campaign.getBudgetpercentage();
	   String ChannelBudget = campaign.getChannelbudget();
	//   String TotalBudget = campaign.getTotalBudget();
	   String MonthlyCap =  campaign.getMonthlycap();
	   String DailyCap = campaign.getDailycap();
	   String CampaignType = campaign.getCampaigntype();
	   String MaxBid = campaign.getMaxbid();
	   String ExpectedBid = campaign.getExpectedbid();
	   String ClickTracker = campaign.getClicktracker();
	   List<Resolution> ResolutionId = campaign.getResolutionid();
	  
	   String resolutionid = "";
	  
	   if(ResolutionId != null && ResolutionId.isEmpty() == false){
	   for(int i=0; i< ResolutionId.size(); i++){
		   
		   resolutionid  = resolutionid  +  ResolutionId.get(i).getId() + ",";
			   
		   }
	   }
	   
	   String TargetType = campaign.getTargettype();
	   String Lookalike = campaign.getLookalike();
	   List<AudienceSegment> InterestSegmentId = campaign.getInterestsegmentid();;
	   
	   String interestsegmentid = "";
	   
	   if( InterestSegmentId != null &&  InterestSegmentId.isEmpty() == false){
	   for(int i=0; i< InterestSegmentId.size(); i++){
		   
		   interestsegmentid  =  interestsegmentid +   InterestSegmentId.get(i).getParent_id() + ":" + InterestSegmentId.get(i).getId() + ",";
			   
		   }
	   }
	   
	   
	   List<Geography> GeographyId = campaign.getGeographyid();
	  
	   String geographyid = "";
	  
	   if( GeographyId != null &&  GeographyId.isEmpty() == false){
	   for(int i=0; i< GeographyId.size(); i++){
		   
		   geographyid  = geographyid  +  GeographyId.get(i).getId() + ",";
			   
		   }
	   }
	   
	   
	   List<AgeGroup> AgeRange = campaign.getAgerange();
	 
	   String agerangeid = "";
	 
	   
	   if(  AgeRange != null &&  AgeRange.isEmpty() == false){
	   for(int i=0; i< AgeRange.size(); i++){
		   
		   agerangeid  = agerangeid  +  AgeRange.get(i).getId() + ",";
			   
		   }
	   }
	   
	   List<Gender> Gender = campaign.getGender();
	   
	   String gender = "";
	  
	   if(Gender != null &&  Gender.isEmpty() == false){
	   for(int i=0; i< Gender.size(); i++){
		   
		   gender  = gender +  Gender.get(i).getId() + ",";
			   
		   }
	   } 
		   
	   
	   List<Income> IncomeLevel = campaign.getIncomelevel();
	   
        String incomeid = "";
	   
	   if(IncomeLevel != null && IncomeLevel.isEmpty() == false){
	   for(int i=0; i< IncomeLevel.size(); i++){
		   if(i!=0)
		   incomeid = incomeid + ","+  IncomeLevel.get(i).getId(); 
		   else
		   incomeid = IncomeLevel.get(i).getId();
	     
	   }  
	   }
	   
	   
	   
	   String incomelevel = null;
	   String startDate = campaign.getStartdate();
	   String endDate = campaign.getEnddate();
	   String status = campaign.getStatus();
	   String Approval = campaign.getApproval();
	   String Email = emailid;
	 
	    String ServerConnectionURL = "jdbc:mysql://52.90.244.81:3306/cuberootapp";
		String DBUser = "root";
	    String DBPass = "Qwerty12@";
	    String DBName = "cuberootapp";
		String TABLENAME = "";
		Connection con = null;
		DBConnector connector = new DBConnector();
		con = connector.getPooledConnection(ServerConnectionURL);
	    
	    Statement stmt = null;
	    String query1 = null;
	    String query2 = null;
	    String query3 = null;
	    String query4 = null;
	    String query5 = null;
	    String query6 = null;
	    String query7 = null;
	    String query8 = null;
	    String query9 = null;
	    String query10 = null;
	    ResultSet rs = null;
	    Integer lastid = 0;
	    Integer lastid1 = 0;
	    Integer campId = 0;
	    try {
			stmt = con.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
//	    dateadded = new Timestamp(System.currentTimeMillis()).toString();
	//    System.out.println("Saving Facebook DisplayCampaign Data");
/*     query1 = "INSERT INTO Campaign(CampaignName,ObjectiveId,StartDate,EndDate,Status,Approval,Email) VALUES("+"'"+campName+"'"+","+"'"+ObjectiveId+"'"+","+"'"+startDate+"'"+","+"'"+endDate+"'"+","+"'"+status+"'"+","+"'"+Approval+"'"+","+"'"+Email+"'"+")";
	   
	 	 try {
			stmt.executeUpdate(query1);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	 
	 	 
	 	 try {
				rs = stmt.executeQuery("select last_insert_id() as last_id from Campaign");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	 	      try {
				campId = rs.getInt("last_id");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 	 
	 	 
	 	    
	*/ 	      
	 	      
	 	 
	     query2 = "INSERT INTO BudgetCampaignChannel(BudgetPercentage,ChannelBudget,CampaignTypeId,MonthlyCap,DailyCap,MaxBid,ExpectedBid,ClickTracker,Comments)  VALUES("+"'"+BudgetPercentage+"'"+","+"'"+ChannelBudget+"'"+","+"'"+CampaignType+"'"+","+"'"+MonthlyCap+"'"+","+"'"+DailyCap+"'"+","+"'"+MaxBid+"'"+","+"'"+ExpectedBid+"'"+","+"'"+ClickTracker+"'"+ ","+"'"+Comments+"'"+")";
	    
	 	 try {
			stmt.executeUpdate(query2);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    
	 	 try {
			rs = stmt.executeQuery("select last_insert_id() as last_id from BudgetCampaign");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	 	
	 	try {
			if(rs.next()){ 
			 try {
				lastid = rs.getInt("last_id");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 	
	     query4 = "INSERT INTO TargetCampaign(TargetType,Lookalike,InterestSegmentId,GeographyId,AgeRange,Gender,IncomeRange) VALUES("+"'"+TargetType+"'"+","+"'"+Lookalike+"'"+","+"'"+interestsegmentid+"'"+","+"'"+geographyid+"'"+","+"'"+agerangeid+"'"+","+"'"+gender+"'"+","+"'"+incomeid+"'"+")";
	     
	 	 try {
			stmt.executeUpdate(query4);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    
	 	 try {
			rs = stmt.executeQuery("select last_insert_id() as last_id1 from TargetCampaign");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	 	
	 	 try {
			if(rs.next()){
			 try {
				lastid1 = rs.getInt("last_id1");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 	 
	 	 query5 = "INSERT INTO TargetCampaignDevice(TargetCampaignId,DeviceId) VALUES("+"'"+lastid1+"'"+","+"'"+deviceid+"' )";
	      
	 	 try {
			stmt.executeUpdate(query5);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    
		 query6 = "INSERT INTO TargetCampaignOS(TargetCampaignId,OperatingSystemId) VALUES("+"'"+lastid1+"'"+","+"'"+operatingsystemid+"' )";
	     
		 try {
			stmt.executeUpdate(query6);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		 query7 = "INSERT INTO TargetCampaignResolution(TargetCampaignId,ResolutionId) VALUES("+"'"+lastid1+"'"+","+"'"+resolutionid+"' )";	     
		 try {
			stmt.executeUpdate(query7);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
/*
		 query8 = "INSERT INTO CampaignDetail(CampaignId,BudgetCampaignId,TargetCampaignId) VALUES("+"'"+campId+"'"+","+"'"+lastid+"'"+","+"'"+lastid1+"' )";
	     
		 try {
				stmt.executeUpdate(query8);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
*/		 
		 query9 = "INSERT INTO CampaignChannel(CampaignId,CreativeId,ChannelId,Status,EmailId,StartDate,EndDate,BudgetCampaignChannelId,TargetCampaignChannelId) VALUES("+"'"+Id+"'"+","+"'"+creativeid+"'"+","+"'"+channelId+"'"+","+"'"+status+"'"+","+"'"+Email+"'"+","+"'"+startDate+"'"+","+"'"+endDate+"'"+","+"'"+lastid+"'"+","+"'"+lastid1+"' )";
		 
		 try {
				stmt.executeUpdate(query9);
		        status1 = "true";
		 
		 } catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		 
		 
		 
		 
		 
	     System.out.println(query8);   
	
//    if(channel.equals("Facebook"))
 //   query = "INSERT INTO FacebookCreative(Title,Description,Channel,EmailId,Type,Size,Dateadded,Status,NewsFeedTitle,NewsFeedCreativeFile,RHSTitle,RHSMiniDescription,RHSDescription,RHSUploadCreativeFile,MobileSizeUploadTitle,MobileSizeUploadCreativeFile,UploadVideoSlideShowFile,UploadVideoFile) VALUES("+"'"+title+"'"+","+"'"+description+"'"+","+"'"+channel+"'"+","+"'"+emailid+"'"+","+"'"+type+"'"+","+"'"+size+"'"+","+"'"+dateadded+"'"+","+"'"+status+"'"+","+"'"+NewsFeedTitle+"'"+","+"'"+NewsFeedCreativeFile+"'"+","+"'"+RHSTitle+"'"+","+"'"+RHSMiniDescription+"'"+","+"'"+RHSDescription + "'"+","+"'"+ RHSUploadCreativeFile + "'"+","+"'"+ MobileSizeUploadTitle + "'"+","+"'"+ MobileSizeUploadCreativeFile + "'"+","+"'"+ UploadVideoSlideShowFile + "'"+","+"'"+ UploadVideoFile+"'"+")";
    
    //System.out.println(query);
	   //  return status1;
	     
  
	   }
 
			// Run specific query
	
    return status1;
	   
   }


  


}
