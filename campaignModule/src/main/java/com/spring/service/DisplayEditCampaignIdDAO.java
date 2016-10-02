package com.spring.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.spring.model.Campaign;
import com.spring.model.ChannelCampaign;
import com.spring.util.DBConnector;

public class DisplayEditCampaignIdDAO {


public static Campaign getCampaignIddata(String campaignId){
			
	
	        String ServerConnectionURL = "jdbc:mysql://52.90.244.81:3306/cuberootapp";
			
		    
		    String DBUser = "root";
		    String DBPass = "Qwerty12@";
		    String DBName = "cuberootapp";
			String TABLENAME = "";
			Connection con = null;
			Connection con1 = null;
			Connection con2 = null;
			Connection con3 = null;
			Connection con4 = null;
			Connection con5 = null;
			Connection con6 = null;
			DBConnector connector = new DBConnector();
			con = connector.getPooledConnection(ServerConnectionURL);
		    String status1 = "false";
		    Statement stmt = null;
		    Statement stmt1 = null;
		    String objective = null;
		    String campName = null;
		    String startDate= null;
	        String endDate = null;
		    String status = null;
		    String title = null;
		    String impressions = null;
		    String clicks = null;
		    String conversions = null;
		    String cost = null;
		    String channel = null;
		    Integer size = 0;
	        String date = null;
	        String id = null;
	        String querychannelid = null;
	        
	        String TotalBudget = null;
	        String MonthlyCap = null;
			String DailyCap = null;
		    String CampaignType = null;
			String MaxBid = null;
			String ExpectedBid = null;
			String ClickTracker = null;
	        String CampaignTypeId = null;
	        
	        ResultSet rs = null;
	        ResultSet rs1 = null;
	        //     List<Campaign> campaign = new ArrayList<Campaign>();
	        String query = "Select Id,CampaignName,StartDate,EndDate,ObjectiveId,Status From Campaign where Id="+campaignId;
	        Statement st = null;
	 //       int k=0;
			try {
				st = con.createStatement();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				rs = st.executeQuery(query);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			Campaign camp = new Campaign();
			
		
			
				try {
					while(rs.next()){
					 
					 id = rs.getString("Id");	
					 startDate = rs.getString("StartDate");
					 endDate = rs.getString("EndDate");
					 status = rs.getString("Status");
					 campName =rs.getString("CampaignName");
//				 date = rs.getString("DateAdded");
//				 size = rs.getInt("size");
//		 title = rs.getString("Title");
					 objective = rs.getString("ObjectiveId");
					 camp.setId(id);
					 camp.setName(campName);
					 camp.setStartdate(startDate);
					 camp.setEnddate(endDate);
					 camp.setStatus(status);
					 camp.setObjective(objective);
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
              String query1 = "Select * From BudgetCampaign where CampaignId="+campaignId;
            
              try {
  				stmt1 = con.createStatement();
  			} catch (SQLException e1) {
  				// TODO Auto-generated catch block
  				e1.printStackTrace();
  			}
  			
  			try {
  				rs1 = stmt1.executeQuery(query1);
  			} catch (SQLException e1) {
  				// TODO Auto-generated catch block
  				e1.printStackTrace();
  			}
              
              
              
  				try {
					while(rs1.next()){
					TotalBudget = rs1.getString("TotalBudget");	
					MonthlyCap= rs1.getString("MonthlyCap");
					DailyCap  = rs1.getString("DailyCap");
				//	CampaignType= rs1.getString("CampaignTypeId");
					MaxBid = rs1.getString("MaxBid");
					ExpectedBid = rs1.getString("ExpectedBid");
					ClickTracker = rs1.getString("ClickTracker");
					CampaignTypeId = rs1.getString("CampaignTypeId");
 	
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
              
  				 camp.setTotalbudget(TotalBudget);
				 camp.setMonthlycap(MonthlyCap);
				 camp.setDailycap(DailyCap);
				 camp.setCampaigntype(CampaignType);
				 camp.setMaxbid(MaxBid);
				 camp.setExpectedbid(ExpectedBid);
				 camp.setClicktracker(ClickTracker);
				 camp.setCampaigntype(CampaignTypeId);
              
              return camp;
              
              
             }
			        
}
