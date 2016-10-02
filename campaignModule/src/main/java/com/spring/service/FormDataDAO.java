package com.spring.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.model.AgeGroup;
import com.spring.model.AudienceSegment;
import com.spring.model.CampaignType;
import com.spring.model.Channel;
import com.spring.model.Device;
import com.spring.model.FormData;
import com.spring.model.Gender;
import com.spring.model.Geography;
import com.spring.model.Income;
import com.spring.model.Objective;
import com.spring.model.OperatingSystem;
import com.spring.model.Resolution;
import com.spring.model.TrackerType;
import com.spring.util.DBConnector;
import com.spring.util.DBUtil;



public class FormDataDAO {

	public static FormData getTargetingData(){
		
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
	    String query = null;
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
        String query11 = null;
        ResultSet rs = null;
        String Id = null;
        String name = null;
        String parent_id = null;
        String city = null;
        String genderType = null;
        String agegroup = null;
        String resolution =null;
        String count = null;
        String trackertype= null;
        String campaigntype= null;
        FormData formdata= new FormData();
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
        AudienceSegment segment1 = null;
        AudienceSegment segment2 = null;
        try {
			stmt = con.createStatement();
		
        query = "Select Id,Name FROM OperatingSystems";
        try {
			rs =  stmt.executeQuery(query);
			while(rs.next()){
            OperatingSystem os = new OperatingSystem();
		    Id = rs.getString("Id");
            name = rs.getString("Name");
            os.setId(Id);
            os.setOperatingSystemName(name);
			osList.add(os);
			}
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
       
        query1 = "Select Id,Name FROM Device";
        try {
			rs = stmt.executeQuery(query1);
			while(rs.next()){
	            Device device = new Device();
			    Id = rs.getString("Id");
	            name = rs.getString("Name");
	            device.setId(Id);
	            device.setDeviceName(name);
				deviceList.add(device);
				}
        
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
        
        
        
    	    query2 = "Select id,parent_id,category,count FROM category";
	        try {
				rs = stmt.executeQuery(query2);
				
				while(rs.next()){
		            AudienceSegment segment = new AudienceSegment();
				    Id = rs.getString("id");
		            name = rs.getString("category");
		            parent_id = rs.getString("parent_id");
		            count = rs.getString("count");
		            if(parent_id.equals("0")){
		            segment.setId(Id);
					segment.setAudienceSegmentName(name);
					segment.setCount(count);
					parentCategoryMap.put(Id ,segment);
		            }
		            else{
		            	 segment.setId(Id);
						 segment.setAudienceSegmentName(name);
						 segment.setParent_id(parent_id);
						 segment.setCount(count);
						 subcategoryList.add(segment);
	                }
				}
	          
				for(int i=0; i<subcategoryList.size();i++){
	        	  
	        	  segment1 = subcategoryList.get(i);
	        	  parentCategoryMap.get(segment1.getParent_id()).getSubcategory().add(segment1);
	        	  
	          }
				for (Map.Entry<String, AudienceSegment> entry : parentCategoryMap.entrySet())
				{
					finalcategoryList.add(entry.getValue());
				}
	        } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       
				query3 = "Select Id,City FROM Geography";
		        try {
					rs = stmt.executeQuery(query3);
					while(rs.next()){
			            Geography geo = new Geography();
					    Id = rs.getString("Id");
			            city = rs.getString("City");
			            geo.setId(Id);
			            geo.setCity(city);
						cityList.add(geo);
						}
		        
		        } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
		        
		        
		        query4= "Select Id,Gender FROM Gender";
		        try {
					rs = stmt.executeQuery(query4);
					while(rs.next()){
			            Gender gender = new Gender();
					    Id = rs.getString("Id");
			            genderType = rs.getString("Gender");
			            gender.setId(Id);
			            gender.setGenderType(genderType);
						genderList.add(gender);
						}
		        
		        } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		       
		        
		        query5= "Select Id,AgeGroup FROM AgeGroup";
		        try {
					rs = stmt.executeQuery(query5);
					while(rs.next()){
			            AgeGroup age = new AgeGroup();
					    Id = rs.getString("Id");
			            agegroup = rs.getString("AgeGroup");
			            age.setId(Id);
			            age.setAgeGroup(agegroup);
						agegroupList.add(age);
						}
		        
		        } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
		        
		        query6= "Select Id,Resolution FROM Resolution";
		        try {
					rs = stmt.executeQuery(query6);
					while(rs.next()){
			            Resolution res = new Resolution();
					    Id = rs.getString("Id");
			            resolution = rs.getString("Resolution");
			            res.setId(Id);
			            res.setResolution(resolution);
						resolutionList.add(res);
						}
		        
		        } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
		        query7 = "Select Id,Name,TrackerType,CampaignType FROM Objective";
		        try {
					rs = stmt.executeQuery(query7);
					while(rs.next()){
			            Objective obj = new Objective();
					    Id = rs.getString("Id");
			            name = rs.getString("Name");
			            trackertype = rs.getString("TrackerType");
			            campaigntype = rs.getString("CampaignType");		
			            obj.setId(Id);
			            obj.setObjectiveName(name);
						obj.setCampaignType(campaigntype);
						obj.setTrackerType(trackertype);
			            objectiveList.add(obj);
						}
		        
		        } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
		        
		        
		        query8 = "Select Id,Name FROM Channel";
		        try {
					rs = stmt.executeQuery(query8);
					while(rs.next()){
			            Channel channel = new Channel();
					    Id = rs.getString("Id");
			            name = rs.getString("Name");
			            channel.setId(Id);
			            channel.setChannelName(name);
						channelList.add(channel);
						}
		        
		        } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
		        
		       
		        query9 = "Select Id,Name FROM IncomeRange";
		        try {
					rs = stmt.executeQuery(query9);
					while(rs.next()){
			            Income inc = new Income();
					    Id = rs.getString("Id");
			            name = rs.getString("Name");
			            inc.setId(Id);
			            inc.setName(name);
						incList.add(inc);
						}
		        
		        } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
		        

		        query10 = "Select Id,Name FROM CampaignType";
		        try {
					rs = stmt.executeQuery(query10);
					while(rs.next()){
			            CampaignType cmp = new CampaignType();
					    Id = rs.getString("Id");
			            name = rs.getString("Name");
			            cmp.setId(Id);
			            cmp.setCampaigntype(name);
						cmpList.add(cmp);
						}
		        
		        } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
		        
		        query11 = "Select Id,Name FROM TrackerType";
		        try {
					rs = stmt.executeQuery(query11);
					while(rs.next()){
			            TrackerType trk = new TrackerType();
					    Id = rs.getString("Id");
			            name = rs.getString("Name");
			            trk.setId(Id);
			            trk.settrackertype(name);
						trkList.add(trk);
						}
		        
		        } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
		        
		        
		        
		        
				
				formdata.setAudienceSegmentData(finalcategoryList);
				formdata.setDevicedata(deviceList);
	            formdata.setOsdata(osList);
	            formdata.setGeo(cityList);
	            formdata.setAgeGroup(agegroupList);
	            formdata.setGender(genderList);
	            formdata.setResolution(resolutionList);
	            formdata.setObjective(objectiveList);
	            formdata.setChannel(channelList);
	            formdata.setInc(incList);
	            formdata.setTrackertype(trkList);
	            formdata.setCampaigntype(cmpList);
	         
              } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }  
           finally{
			
		    DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
			
		}   
	            
	            
	            
	           return formdata;
	
	
	
	
	
	
	}

}