package com.spring.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

public class EditCampaignChannelDAO {





	public static String updateCampaignChannel(ChannelCampaign campaign, String emailid){
	
		   String channelId = campaign.getChannelid();
		   List<Creative> creative = campaign.getCreative();
//		   String ObjectiveId = campaign.getObjective();
		   String creativeid="";
		  
		   
		   if(creative != null && creative.isEmpty() == false){
		   for(int i=0; i<creative.size(); i++){
			   
			  creativeid = creativeid + creative.get(i).getId() + ",";
			   
		   }
		   }
		   
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
		   
		   if(IncomeLevel  != null &&  IncomeLevel.isEmpty() == false){
			   for(int i=0; i< IncomeLevel.size(); i++){
				   
				   if(i!=0)
				   incomeid  = incomeid + ","+  IncomeLevel.get(i).getId();
				   else
				   incomeid = IncomeLevel.get(i).getId();
				   
				   
				   }
			   } 
		   
		   List<Creative> creative1 = campaign.getCreative();
		   
           creativeid = "";
		   
		   if(creative1  != null &&  creative1.isEmpty() == false){
			   for(int i=0; i< creative1.size(); i++){
				   
				   if(i!=0)
				   creativeid  = creativeid + ","+  creative1.get(i).getId().toString();
				   else
				   creativeid = creative1.get(i).getId().toString();
				   
				   
				   }
			   } 
		   
		   
		   
		   
		   String incomelevel = null;
		   String startDate = campaign.getStartdate();
		   String endDate = campaign.getEnddate();
		   String status = campaign.getStatus();
		   String Approval = campaign.getApproval();
		   String Email = emailid;
		   String targetcampaignchannelid = null;
		   String budgetcampaignchannelid = null;
		    
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
		    ResultSet rs1 = null;
		   
		    
		    
	        query1  = "Select Id,BudgetCampaignChannelId,TargetCampaignChannelId From CampaignChannel Where CampaignId="+campaign.getId()+" And ChannelId="+campaign.getChannelid();
	    
	    //Make a list of Device object,Segment Object,Operating System Id,IncomeId,GeographyId
	    //Generate a List of Device object, Segment Object, Operating system, Income Object, Geography Object Corresponding to campaign, This targeting information will be passed to the from for display.
	    //Separate Controller for submitting edit form data, it will call Update Queries will get Campaign DTO from jackson core and will populate it in Database. Same holds for budget campaign Data.
	       
	        
	        try {
				stmt = con.createStatement();
			
	        
	         try {
				rs = stmt.executeQuery(query1);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    
	        try {
				if(rs.next()){
					
				  targetcampaignchannelid = rs.getString("TargetCampaignChannelId"); 	
				  
				  budgetcampaignchannelid  = rs.getString("BudgetCampaignChannelId");
				   
				 
				
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	         
	         
	         
	        query2 = "Update TargetCampaign Set InterestSegmentId = '"+interestsegmentid+"'"+","+"GeographyId = '"+geographyid+ "'"+","+"IncomeRange = '"+incomeid+"'"+", Gender = '"+gender+ "'"+","+" AgeRange = '"+agerangeid+"'"+" WHERE Id="+targetcampaignchannelid;
	    	  
	        try {
				stmt.executeUpdate(query2);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        
	        
	        //	    query = "Update CampaignChannel Set Status = '"+status+"'"+" WHERE Id="+id+ " AND Channel ='"+channel+"'"+"AND EmailId="+"'"+emailid+"'";
	    	
	        query3 = "Update TargetCampaignDevice Set DeviceId = '"+deviceid+"' WHERE TargetCampaignId="+targetcampaignchannelid;
	        
	        try {
				stmt.executeUpdate(query3);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        
	        
 	        query4 = "Update TargetCampaignOS Set OperatingSystemId = '"+operatingsystemid+"' WHERE TargetCampaignId="+targetcampaignchannelid;
 	        
 	   //     query5 = "Update TargetCampaignResolution Set Resolution = '"+
 	      
 	       try {
			stmt.executeUpdate(query4);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
 	       
 	       
 	      query9 = "Update TargetCampaignResolution Set ResolutionId = '"+resolutionid+"' WHERE TargetCampaignId="+targetcampaignchannelid;
	        
 	 	   //     query5 = "Update TargetCampaignResolution Set Resolution = '"+
 	 	      
 	 	       try {
 				stmt.executeUpdate(query9);
 			} catch (SQLException e1) {
 				// TODO Auto-generated catch block
 				e1.printStackTrace();
 			}
 	 	        
 	       
 	       
 	       
 	       
 	       
 	        
 	        
 	        query6 = "Update BudgetCampaignChannel Set BudgetPercentage = '"+BudgetPercentage+"'"+", ChannelBudget = '"+ChannelBudget+ "'"+","+" MonthlyCap = '"+MonthlyCap+"'"+", DailyCap = '"+DailyCap+"'"+", MaxBid = '"+MaxBid+ "'"+","+" ExpectedBid = '"+ExpectedBid+"'"+","+" ClickTracker= '"+ClickTracker+"', Comments='"+Comments+"' Where Id="+budgetcampaignchannelid;
	    	  
 	       try {
			stmt.executeUpdate(query6);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
 	        
 	        
 	  //      query7 = "Update CampaignChannel Set CreativeId = '"+creativeId+"'"+","+" Set StartDate = '"+startDate+ "'"+","+" Set EndDate = '"+endDate+"'"+" Where CampaignId="+campaign.getId()+" And ChannelId="+campaign.getChannelid();
 	       	    
 	      query7 = "UPDATE CampaignChannel SET CreativeId = '"+creativeid+"', StartDate = '"+startDate+ "'"+","+" EndDate = '"+endDate+"'"+" WHERE CampaignId='"+campaign.getId()+"' AND ChannelId='"+campaign.getChannelid()+"' AND emailId='"+emailid+"'";
      	    
 	       
 	       try {
			stmt.executeUpdate(query7);
		    status1 = "true";
 	       } catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
 	        
 	        
//	    System.out.println(query);
	
	        } catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// Run specific query
	
             finally{
				
			    DBUtil.close(rs);
				DBUtil.close(rs1);
				DBUtil.close(stmt);
				DBUtil.close(con);
				
			} 
	        
	        
	        
   return status1;
   
   }










}
