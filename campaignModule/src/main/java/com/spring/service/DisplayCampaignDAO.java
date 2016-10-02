package com.spring.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.spring.model.Campaign;
import com.spring.model.DisplayCampaign;
import com.spring.util.DBConnector;
import com.spring.util.DBUtil;

public class DisplayCampaignDAO {

	
	public static List<Campaign> DisplayCampaign(String emailid){
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
		Connection con4 = null;
		Connection con5 = null;
		Connection con6 = null;
		DBConnector connector = new DBConnector();
		con = connector.getPooledConnection(ServerConnectionURL);
		con2 =  connector.getPooledConnection(ServerConnectionURL1);
	    String status1 = "false";
	    Statement stmt = null;
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
        List<Campaign> campaign = new ArrayList<Campaign>();
	    String query = "Select Id,CampaignName,StartDate,EndDate,ObjectiveId,Status From Campaign where EmailId="+"'"+emailid+"'";
		String queryPerformanceData;
		String queryPerformanceDatachannelwise;
		String queryChannelSpecificData;
		String queryChannelSpecificData1;
	    Statement st = null;
	    Statement st1 = null;
	    Statement st2 = null;
	    Statement st3 = null;
	    Statement st4 = null;
	    Statement st5 = null;
	    Statement st6 = null;
	    String channelid= null;
	    String channelList="";
	    String channelName="";
	    int k=0;
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
	     ResultSet rs4 = null;
	     ResultSet rs5 = null;
	     ResultSet rs6 = null;
		try {
			rs = st.executeQuery(query);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		 try {
			while(rs.next()){
			 Campaign camp = new Campaign();
			 id = rs.getString("Id");	
			 startDate = rs.getString("StartDate");
			 endDate = rs.getString("EndDate");
			 status = rs.getString("Status");
			 campName =rs.getString("CampaignName");
//			 date = rs.getString("DateAdded");
//			 size = rs.getInt("size");
	//		 title = rs.getString("Title");
			 objective = rs.getString("ObjectiveId");
			 camp.setId(id);
			 camp.setName(campName);
			 camp.setStartdate(startDate);
			 camp.setEnddate(endDate);
			 camp.setStatus(status);
			 camp.setObjective(objective);
			 k=0;
			 channelList="";
			 queryChannelSpecificData = "Select Distinct(ChannelId)as channelid From CampaignChannel where CampaignId='"+id+"'";
	//		 con = connector.getPooledConnection(ServerConnectionURL);
			 st6 = con.createStatement();
			 rs6 =  st6.executeQuery(queryChannelSpecificData);
			 while(rs6.next()){
				 if(k!=0)
				 channelList=channelList+","+rs6.getString("channelid");
				 else
				 channelList=rs6.getString("channelid");
			     k++;
			 }
			 
	//		 if(channelList != null && channelList.isEmpty()==false && channelList.length() !=1)
		//	 channelList = channelList.substring(0, channelList.length()-2);
			 queryChannelSpecificData1 = "Select Name from Channel where Id in ("+channelList+")";
			 if(channelList !="" && channelList !=null){
	//		 con = connector.getPooledConnection(ServerConnectionURL);
			 st5 = con.createStatement();
			 rs5 =  st5.executeQuery(queryChannelSpecificData1);
			 }
			 
			 
			 
			 
			 queryPerformanceData = "Select sum(impression)as impressions,sum(clicks)as clicks,sum(mediacost)as cost,sum(conversions)as conversions FROM datawarehouse WHERE campaign_id in ("+id+")";
		//	 con2 =  connector.getPooledConnection(ServerConnectionURL1);
			 st2 = con2.createStatement();
			 rs2 =  st2.executeQuery(queryPerformanceData);
		     
			 if(rs2.next()){
			 impressions = rs2.getString("impressions");
		     clicks = rs2.getString("clicks");
		     cost = rs2.getString("cost");	
		     conversions =  rs2.getString("conversions");	
		//     camp.setId(id);
		//	 camp.setCampaignName(campName);
		//	 camp.setStartDate(startDate);
		//	 camp.setEndDate(endDate);
		//	 camp.setStatus(status);
			 camp.setImpression(impressions);
			 camp.setClick(clicks);
			 camp.setCost(cost);
			 camp.setConversion(conversions);
			 if(impressions!=null && clicks!=null)
			 camp.setCtr((Double.parseDouble(clicks)/Double.parseDouble(impressions)));
			 }
		  
             while(rs5.next()){
			 channelName = rs5.getString("Name"); 	 
			 
		     queryPerformanceDatachannelwise = "Select sum(impression)as impressions,sum(clicks)as clicks,sum(mediacost)as cost,sum(conversions)as conversions,channel FROM datawarehouse WHERE campaign_id in ("+id+") and channel like '%"+channelName+"%'";
		//	 con2 = connector.getPooledConnection(ServerConnectionURL1);	
			 st1 = con2.createStatement();
			 rs1 =  st1.executeQuery(queryPerformanceDatachannelwise);
			 Campaign camp1 = new Campaign();
			 camp1.setId(id);
			 camp1.setName(campName);
			 camp1.setStartdate(startDate);
			 camp1.setEnddate(endDate);
			 camp1.setStatus(status);
			 
			 camp1.setChannel(channelName);
			 
			 while(rs1.next()){
			 
             impressions =  rs1.getString("impressions");
             clicks = rs1.getString("clicks");
			 cost = rs1.getString("cost");	 
		     conversions = rs1.getString("conversions");		 
			 channel = rs1.getString("channel");	 
			
			 camp1.setImpression(impressions);
			 camp1.setClick(clicks);
			 camp1.setCost(cost);
			 camp1.setConversion(conversions);
			
			 if(impressions!=null && clicks!=null)
			 camp1.setCtr((Double.parseDouble(clicks)/Double.parseDouble(impressions)));
			 
			 if(channelName !=null && channelName.isEmpty()==false && channelName.equals("Programmatic")==false)
			 querychannelid = "Select Id from Channel Where Name like '%"+channelName+"%'";
			 
				 
		//	 con = connector.getPooledConnection(ServerConnectionURL);
			 st3 = con.createStatement();
			 rs3 =  st3.executeQuery(querychannelid);
			 if(rs3.next()){		 
		     if(channelName !=null && channelName.isEmpty()==false && channelName.equals("Programmatic")==false)
			 channelid = rs3.getString("Id");
		     else
		     channelid = "3";
			 camp1.setChannelid(channelid);
			 }
			 queryChannelSpecificData = "Select Status From CampaignChannel where CampaignId='"+id+"' And channelId = '"+channelid+"'"; 
//			 con = connector.getPooledConnection(ServerConnectionURL);
			 st4 = con.createStatement();
			 rs4 =  st4.executeQuery(queryChannelSpecificData);
			 if(rs4.next()){
			 camp1.setStatus(rs4.getString("Status"));
			 
			 }
			 
			 camp.getChannelwiseData().add(camp1);
			 }
			 }		 
		     
		     
			 campaign.add(camp);
			}
		} catch (Exception e) {
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