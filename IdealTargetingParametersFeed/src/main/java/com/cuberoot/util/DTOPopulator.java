package com.cuberoot.util;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.websystique.springmvc.model.Reports;


/**
 * Utility for converting ResultSets into DTO
 */
public class DTOPopulator {
    /**
     * Populate a result set into DTO
     
     */
    public static List<Reports> populateDTO(ResultSet resultSet)
            throws Exception {
       
    	   List<Reports> report = new ArrayList<Reports>();
           Reports reportDTO = null;
    	   String name;
           while (resultSet.next()) {
        	int total_rows = resultSet.getMetaData().getColumnCount();
            Reports obj = new Reports();
            for (int i = 0; i < total_rows; i++) {
               name = resultSet.getMetaData().getColumnLabel(i + 1).toLowerCase();
              
               
            
               if( name.equals("analyseddate"))
            	 obj.setDate(resultSet.getObject(i + 1).toString());
            
               if( name.equals("campaignid"))
            	  obj.setCampaign_id(resultSet.getObject(i + 1).toString());
            
              if( name.equals("channel"))   
            	   obj.setChannel(resultSet.getObject(i + 1).toString());
                             
            
              if( name.equals("optimisationparameter")){
            	  if(resultSet.getObject(i + 1).toString().equals("CITY"))
            	  obj.setCity(resultSet.getString("optimumvalues"));
              
            	  if(resultSet.getObject(i + 1).toString().equals("Audience_Segment"))
                	 obj.setAudience_segment(resultSet.getString("optimumvalues"));
            	  
            	  if(resultSet.getObject(i + 1).toString().equals("OS"))
                	  obj.setOs(resultSet.getString("optimumvalues"));
              
            	  if(resultSet.getObject(i + 1).toString().equals("Age"))
                	  obj.setAge(resultSet.getString("optimumvalues"));
              
            	  if(resultSet.getObject(i + 1).toString().equals("Gender"))
                	  obj.setGender(resultSet.getString("optimumvalues"));
             
              
              
              }  
           
                         
              if(name.equals("ctr"))
                  obj.setCtr("1"); 
            
              
              if(name.equals("cpc"))
                  obj.setCpc("1");
            
            
              if(name.equals("convrate"))
                  obj.setConvrate("1");
            
            
            
            }
            report.add(obj);
        
        }
        return report;
    }
    
}