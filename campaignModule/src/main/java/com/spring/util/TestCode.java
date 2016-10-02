package com.spring.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.spring.model.AgeGroup;
import com.spring.model.AudienceSegment;
import com.spring.model.CampaignType;
import com.spring.model.Channel;
import com.spring.model.ChannelCampaign;
import com.spring.model.Device;
import com.spring.model.Gender;
import com.spring.model.Geography;
import com.spring.model.Income;
import com.spring.model.Objective;
import com.spring.model.OperatingSystem;
import com.spring.model.Resolution;
import com.spring.model.TrackerType;

public class TestCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	    ChannelCampaign camp = new ChannelCampaign();	
		
	    String ServerConnectionURL = "jdbc:mysql://52.90.244.81:3306/cuberootapp";
		String DBUser = "root";
	    String DBPass = "Qwerty12@";
	    String DBName = "cuberootapp";
		String TABLENAME = "";
		
		   List <OperatingSystem> osList = new ArrayList<OperatingSystem>();
	        List <Device> deviceList = new ArrayList<Device>();
	        List <Objective> objectiveList = new ArrayList<Objective>();
	        List<Geography> cityList = new ArrayList<Geography>();
	        List<Income> incList = new ArrayList<Income>();
	        List<CampaignType> cmpList = new ArrayList<CampaignType>();
	        List<TrackerType> trkList = new ArrayList<TrackerType>();
	        List<Gender> genderList = new ArrayList<Gender>();
	        List<AgeGroup> agegroupList = new ArrayList<AgeGroup>();
	        List<Resolution> resolutionList = new ArrayList<Resolution>();
	        List<Channel> channelList = new ArrayList<Channel>();
	        Map<String,AudienceSegment> parentCategoryMap = new HashMap<String,AudienceSegment>();
	        List<AudienceSegment> subcategoryList = new ArrayList<AudienceSegment>();
	        List<AudienceSegment> finalcategoryList = new ArrayList<AudienceSegment>();
		
		Connection con = null;
		
		DBConnector connector = new DBConnector();
		con = connector.getPooledConnection(ServerConnectionURL);
	    
	    Statement st = null;
		 //       int k=0;
				try {
					st = con.createStatement();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
	    ResultSet rs1= null;
	    
	    ResultSet rs2 = null;
	    
	    ResultSet rs3 = null;
	    
        ResultSet rs4 = null;
	    
	    ResultSet rs5 = null;
	   
	    String Id = null;
        String name = null;
	    
	    
		String url = "http://54.84.60.73:8080/b5/report/14/390878914";
			
	 	   String content = null;
		try {
			content = HttpUtil.executeRequest(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 	
	 	    JSONParser parser = new JSONParser();

	 	     Object obj = null;
			try {
				obj = parser.parse(content);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 	     
	 	     JSONArray jsonObject = (JSONArray) obj;
		
	
	 	    JSONObject obj1 = (JSONObject) jsonObject.get(0);
 			System.out.println(obj1.get("age"));
	
            String age = obj1.get("age").toString();
            age = age.replace("Undetermined,","");
 			age= age.substring(age.indexOf(":")+1, age.indexOf("P2"));
 			
 			System.out.println(age);
 			
 			String []age1 = null;
 			String agelist = "";
 			age1 = age.split(",");
 		    for(int i =0; i < age1.length; i++)
 		    { 
 		    	if(i!=0)
 		    	agelist = agelist+",'"+age1[i]+"'"; 
 		    	else
 		    	agelist = "'"+age1[i]+"'";
 		    }

	         String query1 = "Select * from AgeGroup where AgeGroup in ("+agelist+")";
	
	         System.out.println(query1);
	 		 String agegroup2 = null;	
	         
	         try {
					rs5 = st.executeQuery(query1);
					while(rs5.next()){
			            AgeGroup age2 = new AgeGroup();
					    Id = rs5.getString("Id");
			            agegroup2 = rs5.getString("AgeGroup");
			            age2.setId(Id);
			            age2.setAgeGroup(agegroup2);
						agegroupList.add(age2);
						}
		        
		        } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
 			
 			
 			 
 			JSONObject obj2 = (JSONObject) jsonObject.get(1);
 			System.out.println(obj2.get("audience_segment"));
 			
 			
 			String as = obj2.get("audience_segment").toString();
 			
 			as = as.substring(as.indexOf(":")+1, as.indexOf("P2"));
 			
 			System.out.println(as);
 			
 			String []as1 = null;
 			String aslist = "";
 			as1 = as.split(",");
 		    for(int i =0; i < as1.length; i++){
 		         	if(i!=0)
 	 		    	aslist = aslist+",'"+as1[i]+"'"; 
 	 		    	else
 	 		    	aslist = "'"+as1[i]+"'";
 		    }

	         String query2 = "Select * from category where category in ("+aslist+")";
	         System.out.println(query2);
 		    
	         String parent_id = null;
	         
	         
	         try{
	         rs4 = st.executeQuery(query2);
				
				while(rs4.next()){
		            AudienceSegment segment = new AudienceSegment();
				    Id = rs4.getString("id");
		            name = rs4.getString("category");
		            parent_id = rs4.getString("parent_id");
		            segment.setId(Id);
					segment.setAudienceSegmentName(name);
					segment.setParent_id(parent_id);
					finalcategoryList.add(segment);
				
				
				}
		        
                 } catch (SQLException e) {
		// TODO Auto-generated catch block
		           e.printStackTrace();
	            }
	
	         
	         
	         
 		    
  			JSONObject obj3 = (JSONObject) jsonObject.get(2);
 			System.out.println(obj3.get("city"));
 			
	         String city = obj3.get("city").toString();
	         city = city.substring(city.indexOf(":")+1, city.indexOf("P2"));
	         System.out.println(city);
	
	         String []cities = null;
	         String citylist = "";
	         cities = city.split(",");
	         for(int i =0; i < cities.length; i++){
	        	       if(i!=0)
	 	 		    	citylist = citylist+",'"+cities[i]+"'"; 
	 	 		    	else
	 	 		    	citylist = "'"+cities[i]+"'"; 
	         }
	        	 
	         String query3 = "Select * from Geography where City in ("+citylist+")";
	         System.out.println(query3);
	
	         try {
					rs2 = st.executeQuery(query3);
					while(rs2.next()){
			            Geography geo = new Geography();
					    Id = rs2.getString("Id");
			            city = rs2.getString("City");
			            geo.setId(Id);
			            geo.setCity(city);
						cityList.add(geo);
						}
		        
		        } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	         
	         
	         
	         
	            JSONObject obj4 = (JSONObject) jsonObject.get(4);
	 			System.out.println(obj4.get("gender"));
	 			
		         String gender = obj4.get("gender").toString();
		         
		         gender = gender.substring(gender.indexOf(":")+1, gender.indexOf("P2"));
		         System.out.println(gender);
		
		         String []gender1 = null;
		         String genderlist = null;
		         gender1 = gender.split(",");
		         for(int i =0; i < gender1.length; i++){
		        	 if(i!=0){
		 	 		    	genderlist = genderlist+",'"+gender1[i]+"'"; 
		        	 }
		        	 else{
		 	 		     	genderlist = "'"+gender1[i]+"'";  
		         }
		         }
		        	 
		         String query4 = "Select * from Gender where Gender in ("+genderlist+")";
	
		         System.out.println(query4);
	
		         String genderType= null;
		         
		         try {
						rs3 = st.executeQuery(query4);
						while(rs3.next()){
				            Gender gender2 = new Gender();
						    Id = rs3.getString("Id");
				            genderType = rs3.getString("Gender");
				            gender2.setId(Id);
				            gender2.setGenderType(genderType);
							genderList.add(gender2);
							}
			        
			        } catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		         
		         
		         
		         
		         
		         JSONObject obj5 = (JSONObject) jsonObject.get(5);
		 			System.out.println(obj5.get("os"));
		 			
			         String os = obj5.get("os").toString();
			         os = os.substring(os.indexOf(":")+1,os.indexOf("P1", os.indexOf("P1")+1));
			         System.out.println(os);
			
			         String []os1 = null;
			         String oslist = null;
			         os1 = os.split(",");
			         for(int i =0; i < os1.length; i++){
			        	 if(i!=0)
			 	 		    	oslist = oslist+",'"+os1[i]+"'"; 
			 	 		    	else
			 	 		     	oslist = "'"+os1[i]+"'";  
			         }
			 
			         String query5 = "Select * from OperatingSystems where Name in ("+oslist+")";
			         System.out.println(query5);
	
			         try {
			 			rs1 =  st.executeQuery(query5);
			 			while(rs1.next()){
			             OperatingSystem os2 = new OperatingSystem();
			 		     Id = rs1.getString("Id");
			             name = rs1.getString("Name");
			             os2.setId(Id);
			             os2.setOperatingSystemName(name);
			 			 osList.add(os2);
			 			}
			         } catch (SQLException e) {
			 			// TODO Auto-generated catch block
			 			e.printStackTrace();
			 		}
	
	
	                  camp.setGender(genderList);
	                  camp.setGeographyid(cityList);
	                  camp.setAgerange(agegroupList);
	                  camp.setInterestsegmentid(finalcategoryList);
	                  camp.setOperatingsystemid(osList);
	
	           
	
	
	
	}

		
		          
		
		
	
}
