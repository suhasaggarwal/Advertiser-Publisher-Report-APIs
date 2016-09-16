package com.spring.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.spring.model.DisplayCampaign;
import com.spring.util.DBConnector;
import com.spring.util.DBUtil;

public class DisplayCampaignDAO {

	
	public static List<DisplayCampaign> DisplayCampaign(String emailid){
	    String ServerConnectionURL = "jdbc:mysql://52.90.244.81:3306/cuberootapp";
		String ServerConnectionURL1 = "jdbc:mysql://52.90.244.81:3306/datastore1";
	    
	    String DBUser = "root";
	    String DBPass = "Qwerty12@";
	    String DBName = "cuberootapp";
		String TABLENAME = "";
		Connection con = null;
		Connection con1 = null;
		Connection con2 = null;
		Connection con3 = null;
		DBConnector connector = new DBConnector();
		con = connector.getPooledConnection(ServerConnectionURL);
	    String status1 = "false";
	    Statement stmt = null;
	    
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
        List<DisplayCampaign> campaign = new ArrayList<DisplayCampaign>();
	    String query = "Select Id,CampaignName,StartDate,EndDate,Status From Campaign where EmailId="+"'"+emailid+"'";
		String queryPerformanceData;
		String queryPerformanceDatachannelwise;
		String queryChannelSpecificData;
	    Statement st = null;
	    Statement st1 = null;
	    Statement st2 = null;
	    Statement st3 = null;
		try {
			st = con.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	      
	      // execute the query, and get a java resultset
	     ResultSet rs = null;
	     ResultSet rs1 = null;
	     ResultSet rs2 = null;
	     ResultSet rs3 = null;
		try {
			rs = st.executeQuery(query);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		 try {
			while(rs.next()){
			 DisplayCampaign camp = new DisplayCampaign();
			 id = rs.getString("Id");	
			 startDate = rs.getString("StartDate");
			 endDate = rs.getString("EndDate");
			 status = rs.getString("Status");
			 campName =rs.getString("CampaignName");
//			 date = rs.getString("DateAdded");
//			 size = rs.getInt("size");
	//		 title = rs.getString("Title");
			 queryPerformanceData = "Select sum(impression)as impressions,sum(clicks)as clicks,sum(mediacost)as cost,sum(conversions)as conversions FROM datawarehouse WHERE campaign_id in ("+id+")";
			 con2 =  connector.getPooledConnection(ServerConnectionURL1);
			 st2 = con2.createStatement();
			 rs2 =  st2.executeQuery(queryPerformanceData);
			 if(rs2.next()){
			 impressions = rs2.getString("impressions");
		     clicks = rs2.getString("clicks");
		     cost = rs2.getString("cost");	
		     conversions =  rs2.getString("conversions");	
		     camp.setId(id);
			 camp.setCampaignName(campName);
			 camp.setStartDate(startDate);
			 camp.setEndDate(endDate);
			 camp.setStatus(status);
			 camp.setImpression(impressions);
			 camp.setClick(clicks);
			 camp.setCost(cost);
			 camp.setConversion(conversions);
			 camp.setCtr((Double.parseDouble(clicks)/Double.parseDouble(impressions)));
			 }
		     queryPerformanceDatachannelwise = "Select sum(impression)as impressions,sum(clicks)as clicks,sum(mediacost)as cost,sum(conversions)as conversions,channel FROM datawarehouse WHERE campaign_id in ("+id+") GROUP by channel";
			 con1 = connector.getPooledConnection(ServerConnectionURL1);	
			 st1 = con1.createStatement();
			 rs1 =  st1.executeQuery(queryPerformanceDatachannelwise);
			 while(rs1.next()){
			 DisplayCampaign camp1 = new DisplayCampaign();
             impressions =  rs1.getString("impressions");
             clicks = rs1.getString("clicks");
			 cost = rs1.getString("cost");	 
		     conversions = rs1.getString("conversions");		 
			 channel = rs1.getString("channel");	 
			 camp1.setId(id);
			 camp1.setCampaignName(campName);
			 camp1.setStartDate(startDate);
			 camp1.setEndDate(endDate);
			 camp1.setStatus(status);
			 camp1.setImpression(impressions);
			 camp1.setClick(clicks);
			 camp1.setCost(cost);
			 camp1.setConversion(conversions);
			 camp1.setChannel(channel);
			 camp1.setCtr((Double.parseDouble(clicks)/Double.parseDouble(impressions)));
			 queryChannelSpecificData = "Select Status From CampaignChannel where Id="+"'"+id+"'";
			 con3 = connector.getPooledConnection(ServerConnectionURL);
			 st3 = con3.createStatement();
			 rs3 =  st3.executeQuery(queryChannelSpecificData);
			 if(rs3.next()){
			 camp1.setStatus(rs3.getString("Status"));
			 }
			 camp.getChannelwiseData().add(camp1);
			 
			 }		 
			 campaign.add(camp);
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
	
   return campaign;
   
   }

}