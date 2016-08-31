package com.websystique.springmvc.service;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

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

//This API gives datewise CPM,CPC,CPP as well as Performance data of all campaigns corresponding to Advertisers on All channels 
//In the visualisation panel - channel name will be depicted as all for this API. Data is only grouped by date.	

	public List<Reports> FetchChannelImpData(String startDate, String endDate) {
		Connection connection = null;
		Statement preparedStatement = null;
		ResultSet rs = null;
		String QueryString = null;
		List<Reports> obj1 = null;
	//	JSONObject jo = new JSONObject();
		List<Reports> obj2 = null;
		List<Reports> obj3 = null;
		int ReportCode = 9;
		
		
		try {
			DBConnector obj = new DBConnector();
			connection = obj.getPooledConnection();


			if (connection != null) {

				QueryString = "Select sum(impression)as impression,sum(mediacost)as cost,date FROM datawarehouse WHERE date between "
						+ "'"+startDate + "' AND '" + endDate + "' GROUP by date";
				
                System.out.println(QueryString+"\n");
				
				preparedStatement = connection.createStatement();
				
				rs = preparedStatement.executeQuery(QueryString);

				obj1=DTOPopulator.populateDTO(rs);
				obj2=DTOProcessor.ProcessChannelDTO(obj1, startDate, endDate, ReportCode);
				obj3=DTOFilter.FilterChannelDTO(obj2,startDate, endDate, ReportCode); 	
				

			//	jo.put("",obj1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
     
		 finally{
			 
			    DBUtil.close(rs);
				DBUtil.close(preparedStatement);
				DBUtil.close(connection);
				
			} 
		
		
		return obj3;
	}


	public List<Reports> FetchChannelClicksData(String startDate, String endDate) {
		Connection connection = null;
		Statement preparedStatement = null;
		ResultSet rs = null;
		String QueryString = null;
		List<Reports> obj1 = null;
	//	JSONObject jo = new JSONObject();
		List<Reports> obj2 = null;
		List<Reports> obj3 = null;
		int ReportCode = 10;
		
		try {
			DBConnector obj = new DBConnector();
			connection = obj.getPooledConnection();


			if (connection != null) {

				QueryString = "Select sum(clicks)as clicks,sum(mediacost)as cost,date FROM datawarehouse WHERE date between "
						+ "'"+startDate + "' AND '" + endDate + "' GROUP by date";
				
                System.out.println(QueryString+"\n");
				
				preparedStatement = connection.createStatement();
				
				rs = preparedStatement.executeQuery(QueryString);

				obj1=DTOPopulator.populateDTO(rs);
				obj2=DTOProcessor.ProcessChannelDTO(obj1, startDate, endDate, ReportCode);
				obj3=DTOFilter.FilterChannelDTO(obj2,startDate, endDate, ReportCode); 	
				

			//	jo.put("",obj1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
       
		 finally{
				
				DBUtil.close(rs);
				DBUtil.close(preparedStatement);
				DBUtil.close(connection);
			
			} 
		
		
		return obj3;
	}



	public List<Reports> FetchChannelConvData(String startDate, String endDate) {
		Connection connection = null;
		Statement preparedStatement = null;
		ResultSet rs = null;
		String QueryString = null;
		List<Reports> obj1 = null;
	//	JSONObject jo = new JSONObject();
		List<Reports> obj2 = null;
		List<Reports> obj3 = null;
		int ReportCode = 11;
		
		
		try {
			DBConnector obj = new DBConnector();
			connection = obj.getPooledConnection();


			if (connection != null) {

				QueryString = "Select sum(conversions)as conversions,sum(mediacost)as cost,date FROM datawarehouse WHERE date between "
						+ "'"+startDate + "' AND '" + endDate + "' GROUP by date ";
				
                System.out.println(QueryString+"\n");
				
				preparedStatement = connection.createStatement();
				
				rs = preparedStatement.executeQuery(QueryString);

				obj1=DTOPopulator.populateDTO(rs);
				obj2=DTOProcessor.ProcessChannelDTO(obj1, startDate, endDate, ReportCode);
				obj3=DTOFilter.FilterChannelDTO(obj2,startDate, endDate, ReportCode); 	
				

			//	jo.put("",obj1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
     
		 finally{
				
			    DBUtil.close(rs);
				DBUtil.close(preparedStatement);
				DBUtil.close(connection);
				
			} 
		
		
		
		return obj3;
	}


	public List<Reports> FetchChannelCostData(String startDate, String endDate) {
		Connection connection = null;
		Statement preparedStatement = null;
		ResultSet rs = null;
		String QueryString = null;
		List<Reports> obj1 = null;
	//	JSONObject jo = new JSONObject();
		List<Reports> obj2 = null;
		List<Reports> obj3 = null;
		int ReportCode = 12;
		
		try {
			DBConnector obj = new DBConnector();
			connection = obj.getPooledConnection();


			if (connection != null) {

				QueryString = "Select sum(mediacost)as cost,date FROM datawarehouse WHERE date between "
						+ "'"+startDate + "' AND '" + endDate + "' GROUP by date ";
				
                System.out.println(QueryString+"\n");
				
				preparedStatement = connection.createStatement();
				
				rs = preparedStatement.executeQuery(QueryString);

				obj1=DTOPopulator.populateDTO(rs);
				obj2=DTOProcessor.ProcessChannelDTO(obj1, startDate, endDate, ReportCode);
				obj3=DTOFilter.FilterChannelDTO(obj2,startDate, endDate, ReportCode); 	
				

			//	jo.put("",obj1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
    
		 finally{
			    
			    DBUtil.close(rs);
				DBUtil.close(preparedStatement);

				DBUtil.close(connection);
	        } 
		
		
		
		return obj3;
	}

	
	
	public List<Reports> FetchChannelReachData(String startDate, String endDate) {
		Connection connection = null;
		Statement preparedStatement = null;
		ResultSet rs = null;
		String QueryString = null;
		List<Reports> obj1 = null;
	//	JSONObject jo = new JSONObject();
		List<Reports> obj2 = null;
		List<Reports> obj3 = null;
		int ReportCode = 12;
		
		try {
			DBConnector obj = new DBConnector();
			connection = obj.getPooledConnection();


			if (connection != null) {

				QueryString = "Select sum(reach)as reach,sum(mediacost)as cost,date FROM datawarehouse WHERE date between "
						+ "'"+startDate + "' AND '" + endDate + "' GROUP by date";
				
                System.out.println(QueryString+"\n");
				
				preparedStatement = connection.createStatement();
				
				rs = preparedStatement.executeQuery(QueryString);

				obj1=DTOPopulator.populateDTO(rs);
				obj2=DTOProcessor.ProcessChannelDTO(obj1, startDate, endDate, ReportCode);
				obj3=DTOFilter.FilterChannelDTO(obj2,startDate, endDate, ReportCode); 	
				

			//	jo.put("",obj1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
 
		 finally{
				
			 
			    DBUtil.close(rs);
				DBUtil.close(preparedStatement);
				DBUtil.close(connection);
				
			} 
		
		
		
		
		return obj3;




	}


//Fetch CPM,CPC,CPP data for all channels for a given date range, cumulative of dates displayed on top left section of graph
	
	
	public List<Reports> FetchChannelMetricsData(String startDate, String endDate) {
		Connection connection = null;
		Statement preparedStatement = null;
		ResultSet rs = null;
		String QueryString = null;
		List<Reports> obj1 = null;
	//	JSONObject jo = new JSONObject();
		List<Reports> obj2 = null;
		List<Reports> obj3 = null;
		int ReportCode = 9;
		
		
		try {
			DBConnector obj = new DBConnector();
			connection = obj.getPooledConnection();


			if (connection != null) {

				QueryString = "Select sum(impression)as impression,sum(clicks)as clicks,sum(mediacost)as cost,sum(conversions)as conversions FROM datawarehouse WHERE date between "
						+ "'"+startDate + "' AND '" + endDate + "'";
				
                System.out.println(QueryString+"\n");
				
				preparedStatement = connection.createStatement();
				
				rs = preparedStatement.executeQuery(QueryString);

				obj1=DTOPopulator.populateDTO(rs);
			//	obj2=DTOProcessor.ProcessChannelDTO(obj1, startDate, endDate, ReportCode);
			//	obj3=DTOFilter.FilterChannelDTO(obj2,startDate, endDate, ReportCode); 	
				

			//	jo.put("",obj1);
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
