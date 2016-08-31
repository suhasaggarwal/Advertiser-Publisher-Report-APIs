package com.websystique.springmvc.service;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.cuberoot.util.DBConnector;
import com.cuberoot.util.DTOFilter;
import com.cuberoot.util.DTOPopulator;
import com.cuberoot.util.DTOProcessor;

import com.websystique.springmvc.model.Reports;


public class ReportDAOImpl {

	

	private static ReportDAOImpl INSTANCE;

	private static final Logger logger = Logger.getLogger(ReportDAOImpl.class);

	public static ReportDAOImpl getInstance() {
		
		if(INSTANCE == null)
			return new ReportDAOImpl();
		else
		return INSTANCE;
	}

	public List<Reports> FetchOptimumCTRData(String startDate, String endDate,String campaignId) {
		Connection connection = null;
		Statement preparedStatement = null;
		ResultSet rs = null;
		String QueryString = null;
		List<Reports> obj1 = null;
		List<Reports> obj2 = null;
	//	JSONObject jo = new JSONObject();
		List<Reports> obj3 = null;
		int ReportCode = 1;
		String date; String channel; String audience_segment;
		String city; String os;String campId;
		
		try {
			DBConnector obj = new DBConnector();
			connection = obj.getPooledConnection();

			if (connection != null) {

			//	QueryString = "Select OptimisationValue,date,campaign_id,channel,CTR FROM idealtargetingparameters WHERE CTR = 1 AND date between "
			//			+ "'"+startDate + "' AND '" + endDate + "' GROUP by date,campaign_id,channel";
				if(campaignId.equals("all")){
					QueryString = "SELECT OptimumValues,AnalysedDate,CampaignId,Channel,CTR,OptimisationParameter FROM idealtargetingparameters WHERE CTR = 1 AND AnalysedDate LIKE "+"'%"+startDate+"%'"+" GROUP BY AnalysedDate,CampaignId,Channel,OptimisationParameter";
				}
				else{
				QueryString = "SELECT OptimumValues,AnalysedDate,CampaignId,Channel,CTR,OptimisationParameter FROM idealtargetingparameters WHERE CTR = 1 AND AnalysedDate LIKE "+"'%"+startDate+"%'"+" AND CampaignId in ("+campaignId+") GROUP BY AnalysedDate,CampaignId,Channel,OptimisationParameter";
				}
				System.out.println(QueryString+"\n");
				
				preparedStatement = connection.createStatement();
				
				rs = preparedStatement.executeQuery(QueryString);

			//	int count = 0;

			//	while (rs.next()) {
			//	    ++count;
				    // Get data from the current row and use it
			//	}
				
			//	System.out.println(count);
				
				
				obj1=DTOPopulator.populateDTO(rs);
               
				/*
				for(int i =0; i< obj3.size(); i++){
					date=obj3.get(i).getDate();
					
					channel=obj3.get(i).getChannel();
					audience_segment=obj3.get(i).getAudience_segment();
					city=obj3.get(i).getCity();
					os=obj3.get(i).getOs();
					campId = obj3.get(i).getCampaign_id();
					Map<String, Object> campData = null;
					campData=IndexCategoriesData.putJsonDocument(campId,date,channel, audience_segment,city,os, device_type, conversions);
					System.out.println(campData);
					IndexCategoriesData.postElasticSearch(campData,"reportdata");
				
				//	jo.put("data",obj1);
				
				}	//Resultset to json converter
			        */
			
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
        
       finally{
    	   
    	    DBUtil.close(rs);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
			
		} 
		
		
		return obj1;
	}

	public List<Reports> FetchOptimumCPCData(String startDate, String endDate, String campaignId) {
		Connection connection = null;
		Statement preparedStatement = null;
		ResultSet rs = null;
		String QueryString = null;
		List<Reports> obj1 = null;
	//	JSONObject jo = new JSONObject();
		List<Reports> obj2 = null;
		//	JSONObject jo = new JSONObject();
	    List<Reports> obj3 = null;
	    String date;String impressions; String clicks; String channel; String audience_segment;
		String city; String os; String device_type; String conversions;String campId;
		
		int ReportCode = 2;
		
		
		try {
			DBConnector obj = new DBConnector();
			connection = obj.getPooledConnection();

			if (connection != null) {

				if(campaignId.equals("all")){
                QueryString = "SELECT OptimumValues,AnalysedDate,CampaignId,Channel,CPC,OptimisationParameter FROM idealtargetingparameters WHERE CPC = 1 AND AnalysedDate LIKE "+"'%"+startDate+"%'"+" GROUP BY AnalysedDate,CampaignId,Channel,OptimisationParameter";
				}
				else{
					QueryString = "SELECT OptimumValues,AnalysedDate,CampaignId,Channel,CPC,OptimisationParameter FROM idealtargetingparameters WHERE CPC = 1 AND AnalysedDate LIKE "+"'%"+startDate+"%'"+" AND CampaignId in ("+campaignId+") GROUP BY AnalysedDate,CampaignId,Channel,OptimisationParameter";	
				}
				
				System.out.println(QueryString+"\n");
				
				preparedStatement = connection.createStatement();
				
				rs = preparedStatement.executeQuery(QueryString);

				obj1=DTOPopulator.populateDTO(rs);
					
			
				
				
				
				// populate the array
			//	jo.put("data",obj1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

        finally{
        	
        	DBUtil.close(rs);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
			
		} 
		
		
		
		return obj1;
	}

	public List<Reports> FetchOptimumConvRateData(String startDate, String endDate, String campaignId) {
		Connection connection = null;
		Statement preparedStatement = null;
		ResultSet rs = null;
		String QueryString = null;
		List<Reports> obj1 = null;
		List<Reports> obj2 = null;
		//	JSONObject jo = new JSONObject();
		List<Reports> obj3 = null;
	    int ReportCode = 3;
		
		try {
			DBConnector obj = new DBConnector();
			connection = obj.getPooledConnection();


			if (connection != null) {

				if(campaignId.equals("all")){
				QueryString = "SELECT OptimumValues,AnalysedDate,CampaignId,Channel,ConvRate,OptimisationParameter FROM idealtargetingparameters WHERE ConvRate = 1 AND AnalysedDate LIKE "+"'%"+startDate+"%'"+" GROUP BY AnalysedDate,CampaignId,Channel,OptimisationParameter";
				}
				else{
					QueryString = "SELECT OptimumValues,AnalysedDate,CampaignId,Channel,ConvRate,OptimisationParameter FROM idealtargetingparameters WHERE ConvRate = 1 AND AnalysedDate LIKE "+"'%"+startDate+"%'"+" AND CampaignId in ("+campaignId+") GROUP BY AnalysedDate,CampaignId,Channel,OptimisationParameter";	
				}
					
					System.out.println(QueryString+"\n");
				
				preparedStatement = connection.createStatement();
				
				rs = preparedStatement.executeQuery(QueryString);

				obj1=DTOPopulator.populateDTO(rs);
				obj2=DTOProcessor.ProcessReportDTO(obj1, startDate, endDate, ReportCode);
				obj3=DTOFilter.FilterReportDTO(obj2,startDate, endDate, ReportCode); 	
				
				//jo.put("data",obj1);
			
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
  
        finally{
        	
        	DBUtil.close(rs);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
			
		} 
		
		
		return obj1;
	}



	

	









}
