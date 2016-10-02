package com.spring.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.spring.model.Campaign;
import com.spring.util.DBConnector;
import com.spring.util.DBUtil;

public class UpdateCampDAO {


	public static String updateCampaign(Campaign campaign){
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
	    Statement stmt1 = null;
	    String query = null;
	    String query1 = null;
	    
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
		  
		   
	  
	 //   query = "Update CampaignChannel Set Status = '"+status+"'"+" WHERE Id="+id+ " AND Channel ='"+channel+"'"+"AND EmailId="+"'"+emailid+"'";
	    		 
	    query = "Update Campaign Set CampaignName = '"+campName+"', ObjectiveId = '"+ObjectiveId+"', StartDate = '"+startDate +"', EndDate = '"+endDate +"', Approval = '"+Approval+"' Where Id= '"+Id+"'";
	    
	    System.out.println(query);
	    try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	  
	    
	    try {
			stmt.executeUpdate(query);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

 
	    query1 = "Update BudgetCampaign Set TotalBudget = '" +TotalBudget+"', MonthlyCap = '"+MonthlyCap+"', DailyCap = '"+DailyCap+ "', CampaignTypeId = '"+CampaignType+"', MaxBid = '"+MaxBid+"', ExpectedBid = '"+ExpectedBid +"', ClickTracker = '"+ClickTracker+"' Where CampaignId= '"+Id+"'";
	    try {
			stmt1 = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    System.out.println(query1);
	//    status1 = "true";
	    try {
			stmt1.executeUpdate(query1);
			 status1 = "true";
	    
	    } catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	    
	    
	    
	    
	    
			// Run specific query
	
   return status1;
   
   }






}
