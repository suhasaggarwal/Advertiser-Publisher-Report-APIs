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

//Reports corresponding to Impression,clicks,cost,conversion,reach are generated corresponding to channels and are grouped by channels - Facebook,DBM(Programmatic),Adwords


public class ReportDAOImpl {

	

	private static ReportDAOImpl INSTANCE;

	private static final Logger logger = Logger.getLogger(ReportDAOImpl.class);

	public static ReportDAOImpl getInstance() {
		
		if(INSTANCE == null)
			return new ReportDAOImpl();
		else
		return INSTANCE;
	}

	public List<Reports> FetchImpressionsData(String startDate, String endDate) {
		Connection connection = null;
		Statement preparedStatement = null;
		ResultSet rs = null;
		String QueryString = null;
		List<Reports> obj1 = null;
		List<Reports> obj2 = null;
	//	JSONObject jo = new JSONObject();
		List<Reports> obj3 = null;
		int ReportCode = 1;
		
		
		try {
			DBConnector obj = new DBConnector();
			connection = obj.getPooledConnection();

			if (connection != null) {

				QueryString = "Select sum(impression)as impression,date,campaign_id,channel FROM datawarehouse WHERE date between "
						+ "'"+startDate + "' AND '" + endDate + "' GROUP by date,campaign_id";
				
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
                obj2=DTOProcessor.ProcessReportDTO(obj1, startDate, endDate, ReportCode);
                obj3=DTOFilter.FilterReportDTO(obj2,startDate, endDate, ReportCode); 	
				
				
				//	jo.put("data",obj1);
				
				//Resultset to json converter
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

	public List<Reports> FetchClicksData(String startDate, String endDate) {
		Connection connection = null;
		Statement preparedStatement = null;
		ResultSet rs = null;
		String QueryString = null;
		List<Reports> obj1 = null;
	//	JSONObject jo = new JSONObject();
		List<Reports> obj2 = null;
		//	JSONObject jo = new JSONObject();
	    List<Reports> obj3 = null;
		
		
		int ReportCode = 2;
		
		
		try {
			DBConnector obj = new DBConnector();
			connection = obj.getPooledConnection();

			if (connection != null) {

				QueryString = "Select sum(clicks)as clicks,date,campaign_id,channel FROM datawarehouse WHERE date between "
						+ "'"+startDate + "' AND '" + endDate + "' GROUP by date,campaign_id";
				
                System.out.println(QueryString+"\n");
				
				preparedStatement = connection.createStatement();
				
				rs = preparedStatement.executeQuery(QueryString);

				obj1=DTOPopulator.populateDTO(rs);
				obj2=DTOProcessor.ProcessReportDTO(obj1, startDate, endDate, ReportCode);
				obj3=DTOFilter.FilterReportDTO(obj2,startDate, endDate, ReportCode); 	
				
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
		
		
		return obj3;
	}

	public List<Reports> FetchConversionsData(String startDate, String endDate) {
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

				QueryString = "Select sum(conversions)as conversions,date,campaign_id,channel FROM datawarehouse WHERE date between "
						+ "'"+startDate + "' AND '" + endDate + "' GROUP by date,campaign_id";
				
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
		
		
		return obj3;
	}



	public List<Reports> FetchCostData(String startDate, String endDate) {
		Connection connection = null;
		Statement preparedStatement = null;
		ResultSet rs = null;
		String QueryString = null;
		List<Reports> obj1 = null;
	//	JSONObject jo = new JSONObject();
		List<Reports> obj2 = null;
		//	JSONObject jo = new JSONObject();
		List<Reports> obj3 = null;
		int ReportCode = 4;
		
		
		
		try {
			DBConnector obj = new DBConnector();
			connection = obj.getPooledConnection();


			if (connection != null) {

				QueryString = "Select sum(mediacost)as cost,date,campaign_id,channel FROM datawarehouse WHERE date between "
						+ "'"+startDate + "' AND '" + endDate + "' GROUP by date,campaign_id";
				
                System.out.println(QueryString+"\n");
				
				preparedStatement = connection.createStatement();
				
				rs = preparedStatement.executeQuery(QueryString);

				obj1=DTOPopulator.populateDTO(rs);
				obj2=DTOProcessor.ProcessReportDTO(obj1, startDate, endDate, ReportCode);
				obj3=DTOFilter.FilterReportDTO(obj2,startDate, endDate, ReportCode); 	
				
				
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
		
		return obj3;
	}

	public List<Reports> FetchAudienceSegmentImpData(String startDate, String endDate) {
		Connection connection = null;
		Statement preparedStatement = null;
		ResultSet rs = null;
		String QueryString = null;
		List<Reports> obj1 = null;
	//	JSONObject jo = new JSONObject();
		
		try {
			DBConnector obj = new DBConnector();
			connection = obj.getPooledConnection();


			if (connection != null) {

				QueryString ="SELECT SUM(impression)AS impression,date,campaign_id,audience_segment,channel FROM datawarehouse WHERE audience_segment != '' GROUP BY date,campaign_id,audience_segment";
				
                System.out.println(QueryString+"\n");
				
				preparedStatement = connection.createStatement();
				
				rs = preparedStatement.executeQuery(QueryString);

				obj1=DTOPopulator.populateDTO(rs);

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


	public List<Reports> FetchAudienceSegmentClickData(String startDate, String endDate) {
		Connection connection = null;
		Statement preparedStatement = null;
		ResultSet rs = null;
		String QueryString = null;
		List<Reports> obj1 = null;
	//	JSONObject jo = new JSONObject();
		
		try {
			DBConnector obj = new DBConnector();
			connection = obj.getPooledConnection();


			if (connection != null) {

				QueryString ="SELECT SUM(clicks)AS clicks,date,campaign_id,audience_segment,channel FROM datawarehouse WHERE audience_segment != '' GROUP BY date,campaign_id,audience_segment";
				
	            System.out.println(QueryString+"\n");
				
				preparedStatement = connection.createStatement();
				
				rs = preparedStatement.executeQuery(QueryString);

				obj1=DTOPopulator.populateDTO(rs);

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


	public List<Reports> FetchDeviceImpData(String startDate, String endDate) {
		Connection connection = null;
		Statement preparedStatement = null;
		ResultSet rs = null;
		String QueryString = null;
		List<Reports> obj1 = null;
	//	JSONObject jo = new JSONObject();
		
		try {
			DBConnector obj = new DBConnector();
			connection = obj.getPooledConnection();


			if (connection != null) {

				QueryString ="SELECT SUM(impression)AS impression,date,campaign_id,device_type,channel FROM datawarehouse WHERE device_type != '' GROUP BY date,campaign_id,device_type";
				
                System.out.println(QueryString+"\n");
				
				preparedStatement = connection.createStatement();
				
				rs = preparedStatement.executeQuery(QueryString);

				obj1=DTOPopulator.populateDTO(rs);

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


	public List<Reports> FetchCityImpData(String startDate, String endDate) {
		Connection connection = null;
		Statement preparedStatement = null;
		ResultSet rs = null;
		String QueryString = null;
		List<Reports> obj1 = null;
		//JSONObject jo = new JSONObject();
		
		try {
			DBConnector obj = new DBConnector();
			connection = obj.getPooledConnection();


			if (connection != null) {

				QueryString ="SELECT SUM(impression)AS impression,date,campaign_id,city,channel FROM datawarehouse WHERE city != '' GROUP BY date,campaign_id,city";
				
                System.out.println(QueryString+"\n");
				
				preparedStatement = connection.createStatement();
				
				rs = preparedStatement.executeQuery(QueryString);

				obj1=DTOPopulator.populateDTO(rs);

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

	
	
	public List<Reports> FetchOSImpData(String startDate, String endDate) {
		Connection connection = null;
		Statement preparedStatement = null;
		ResultSet rs = null;
		String QueryString = null;
		List<Reports> obj1 = null;
	//	JSONObject jo = new JSONObject();
		
		try {
			DBConnector obj = new DBConnector();
			connection = obj.getPooledConnection();


			if (connection != null) {

				QueryString ="SELECT SUM(impression)AS impression,date,campaign_id,os,channel FROM datawarehouse WHERE os != '' GROUP BY date,campaign_id,os";
				
                System.out.println(QueryString+"\n");
				
				preparedStatement = connection.createStatement();
				
				rs = preparedStatement.executeQuery(QueryString);

				obj1=DTOPopulator.populateDTO(rs);

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

				QueryString = "Select sum(impression)as impression,sum(mediacost)as cost,date,channel FROM datawarehouse WHERE date between "
						+ "'"+startDate + "' AND '" + endDate + "' GROUP by date,channel";
				
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

				QueryString = "Select sum(clicks)as clicks,sum(mediacost)as cost,date,channel FROM datawarehouse WHERE date between "
						+ "'"+startDate + "' AND '" + endDate + "' GROUP by date,channel";
				
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

				QueryString = "Select sum(conversions)as conversions,sum(mediacost)as cost,date,channel FROM datawarehouse WHERE date between "
						+ "'"+startDate + "' AND '" + endDate + "' GROUP by date,channel";
				
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

				QueryString = "Select sum(mediacost)as cost,date,channel FROM datawarehouse WHERE date between "
						+ "'"+startDate + "' AND '" + endDate + "' GROUP by date,channel";
				
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

				QueryString = "Select sum(reach)as reach,sum(mediacost)as cost,date,channel FROM datawarehouse WHERE date between "
						+ "'"+startDate + "' AND '" + endDate + "' GROUP by date,channel";
				
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


}
