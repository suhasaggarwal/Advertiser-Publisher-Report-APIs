package com.websystique.springmvc.service;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.model.Reports;

//API gives Optimum CTR,Optimum CPC,Optimum Conv Rate data corresponding to a given campaign.
//Optimum Parameters include - Interest Segment,city,Device_properties, OS, DEVICE_TYPE,demographics - Age, Gender

@Service("reportService")
@Transactional
public class ReportServiceImpl implements ReportService{
	
	private static final AtomicLong counter = new AtomicLong();
	
	ReportDAOImpl repDAO = ReportDAOImpl.getInstance();
	
	List<Reports> report= new ArrayList<Reports>();
	
	String campaignId = null;
	
    public List<Reports> extractReports(long id,String dateRange, String campaignId){
	
        String [] dateInterval = dateRange.split(",");
    	
        
    	
    	if(id == 14){
    	 	report=repDAO.FetchOptimumCTRData(dateInterval[0], dateInterval[1], campaignId);
		    return report;
    	}
    	
    	
    	if(id == 15){
    	 	report=repDAO.FetchOptimumCPCData(dateInterval[0], dateInterval[1], campaignId);
		    return report;
    	}
    	
    	
    	if(id == 16){
    	 	report=repDAO.FetchOptimumConvRateData(dateInterval[0], dateInterval[1], campaignId);
		    return report;
    	}
    	
    	
    	
       
    	
    	return report;
    
    
    
    
    
    
    
    
    
    
    }
		
}
