package com.websystique.springmvc.service;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.model.Reports;

@Service("reportService")
@Transactional

//This API gives cpm,cpc,cpp as well as performance data for all channels cumulative on which a campaign ran.
//Corresponding to this data channel will be depicted as all 

public class ReportServiceImpl implements ReportService{
	
	private static final AtomicLong counter = new AtomicLong();
	
	ReportDAOImpl repDAO = ReportDAOImpl.getInstance();
	
	List<Reports> report= new ArrayList<Reports>();
	
	List<String> campaignIds = new ArrayList<String>();
	
    String campaignId = null;
	
    public List<Reports> extractReports(long id,String dateRange,String campaignId){
	
        String [] dateInterval = dateRange.split(",");
    	
    	
    	if(id == 1){
    	 	report=repDAO.FetchImpressionsData(dateInterval[0], dateInterval[1], campaignId);
		    return report;
    	}
    	
    	
    	if(id == 2){
    	 	report=repDAO.FetchClicksData(dateInterval[0], dateInterval[1], campaignId);
		    return report;
    	}
    	
    	
    	if(id == 3){
    	 	report=repDAO.FetchConversionsData(dateInterval[0], dateInterval[1], campaignId);
		    return report;
    	}
    	
    	
    	if(id == 4){
    	 	report=repDAO.FetchCostData(dateInterval[0], dateInterval[1], campaignId);
		    return report;
    	}
    	
    	
    
    	if(id == 17){
    	 	report=repDAO.FetchReachData(dateInterval[0], dateInterval[1], campaignId);
		    return report;
    	}
    	
    	
    	if(id == 18){
    	 	report=repDAO.FetchMetricsData(dateInterval[0], dateInterval[1], campaignId);
		    return report;
    	}
    	
    	
    	
    	
    	return report;
    

    }
		

    public List<String> extractCampaignIds(long id,String dateRange){
      
    	  String [] dateInterval = dateRange.split(",");

          if( id == 16){
           campaignIds = repDAO.extractCampaignIds(dateInterval[0], dateInterval[1]);
           return campaignIds;
           
          }
    
          return campaignIds;
    
    
    }



}
