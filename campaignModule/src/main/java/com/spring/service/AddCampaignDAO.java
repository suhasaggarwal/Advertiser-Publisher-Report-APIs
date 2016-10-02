package com.spring.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

import com.spring.model.Campaign;
import com.spring.util.DBConnector;
import com.spring.util.DBUtil;

public class AddCampaignDAO {

//Campaign data will be loaded from form and individual fields will be populated
	
   public static String AddCampaignData(Campaign campaign, String emailid) {
	   
	   String campName = campaign.getName();
	//   String campId = campaign.getId();
	   
	   String ObjectiveId = campaign.getObjective();
	 
	   String Id = campaign.getId();
	 
	   String TotalBudget = campaign.getTotalbudget();
	   String MonthlyCap =  campaign.getMonthlycap();
	   String DailyCap = campaign.getDailycap();
	  
	   String MaxBid = campaign.getMaxbid();
	   String ExpectedBid = campaign.getExpectedbid();
	   String ClickTracker = campaign.getClicktracker();
	
	   String CampaignType = campaign.getCampaigntype();
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
	    try {
			stmt = con.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
//	    dateadded = new Timestamp(System.currentTimeMillis()).toString();
	//    System.out.println("Saving Facebook DisplayCampaign Data");
	    
	//     ObjectiveId = "1";
	 //    CampaignType = "1";
	 //    startDate = "2016-09-01 12:00:00";
	 //    endDate =	"2016-09-06 13:00:00";	 
	     query1 = "INSERT INTO Campaign(CampaignName,ObjectiveId,StartDate,EndDate,Status,Approval,EmailId) VALUES("+"'"+campName+"'"+","+"'"+ObjectiveId+"'"+","+"'"+startDate+"'"+","+"'"+endDate+"'"+","+"'"+status+"'"+","+"'"+Approval+"'"+","+"'"+Email+"'"+")";
	   
	 	 try {
			stmt.executeUpdate(query1);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	  
	 	 
	 	 try {
				rs = stmt.executeQuery("select max(Id) as last_id from Campaign");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	 	    
	 	 
	 	     try {
				if(rs.next()){
				 try {
					campId = rs.getInt("last_id");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 	 
	 	    
	 	      
	 	      
	 	 
	     query2 = "INSERT INTO BudgetCampaign(TotalBudget,MonthlyCap,DailyCap,CampaignTypeId,MaxBid,ExpectedBid,ClickTracker,CampaignId)  VALUES("+"'"+TotalBudget+"'"+","+"'"+MonthlyCap+"'"+","+"'"+DailyCap+"'"+","+"'"+CampaignType+"'"+","+"'"+MaxBid+"'"+","+"'"+ExpectedBid+"'"+","+"'"+ClickTracker+"'"+ ","+"'"+campId+"'"+")";
	    
	 	 try {
			stmt.executeUpdate(query2);
		    status1 = "true";
	 	 } catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    
	 	 try {
			rs = stmt.executeQuery("select max(Id) as last_id from BudgetCampaign");
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
	 	 /* 
	 	 
	     query4 = "INSERT INTO TargetCampaign(TargetType,Lookalike,InterestSegmentId,GeographyId,AgeRange,Gender,IncomeLevel) VALUES("+"'"+TargetType+"'"+","+"'"+Lookalike+"'"+","+"'"+InterestSegmentId+"'"+","+"'"+GeographyId+"'"+","+"'"+AgeRange+"'"+","+"'"+Gender+"'"+","+"'"+IncomeLevel+"'"+")";
	     
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
			lastid1 = rs.getInt("last_id1");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	 	 
	 	 query5 = "INSERT INTO TargetCampaignDevice(TargetCampaignId,DeviceId) VALUES("+"'"+lastid1+"'"+","+"'"+DeviceId+"' )";
	      
	 	 try {
			stmt.executeUpdate(query5);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    
		 query6 = "INSERT INTO TargetCampaignOS(TargetCampaignId,OperatingSystemId) VALUES("+"'"+lastid1+"'"+","+"'"+OperatingSystemId+"' )";
	     
		 try {
			stmt.executeUpdate(query6);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		 query7 = "INSERT INTO TargetCampaignResolution(TargetCampaignId,ResolutionId) VALUES("+"'"+lastid1+"'"+","+"'"+ResolutionId+"' )";	     
		 try {
			stmt.executeUpdate(query7);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		 query8 = "INSERT INTO CampaignDetail(CampaignId,BudgetCampaignId,TargetCampaignId) VALUES("+"'"+campId+"'"+","+"'"+lastid+"'"+","+"'"+lastid1+"' )";
	     
		 try {
				stmt.executeUpdate(query8);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		 
		 query9 = "INSERT INTO CampaignChannel(CampaignId,CreativeId,ChannelId,Status,EmailId,BudgetCampaignId,TargetCampaignId) VALUES("+"'"+campId+"'"+","+"'"+creativeId+"'"+","+"'"+channelId+"'"+","+"'"+status+"'"+","+"'"+Email+"'"+","+"'"+lastid+"'"+","+"'"+lastid1+"' )";
		 
		 try {
				stmt.executeUpdate(query9);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		 
		 
		 
		 
		 
	     System.out.println(query8);   
	
//    if(channel.equals("Facebook"))
 //   query = "INSERT INTO FacebookCreative(Title,Description,Channel,EmailId,Type,Size,Dateadded,Status,NewsFeedTitle,NewsFeedCreativeFile,RHSTitle,RHSMiniDescription,RHSDescription,RHSUploadCreativeFile,MobileSizeUploadTitle,MobileSizeUploadCreativeFile,UploadVideoSlideShowFile,UploadVideoFile) VALUES("+"'"+title+"'"+","+"'"+description+"'"+","+"'"+channel+"'"+","+"'"+emailid+"'"+","+"'"+type+"'"+","+"'"+size+"'"+","+"'"+dateadded+"'"+","+"'"+status+"'"+","+"'"+NewsFeedTitle+"'"+","+"'"+NewsFeedCreativeFile+"'"+","+"'"+RHSTitle+"'"+","+"'"+RHSMiniDescription+"'"+","+"'"+RHSDescription + "'"+","+"'"+ RHSUploadCreativeFile + "'"+","+"'"+ MobileSizeUploadTitle + "'"+","+"'"+ MobileSizeUploadCreativeFile + "'"+","+"'"+ UploadVideoSlideShowFile + "'"+","+"'"+ UploadVideoFile+"'"+")";
    
    //System.out.println(query);
    */	
  

 
			// Run specific query
	
   return status1;
   
   }


  


}
