package com.websystique.springmvc.service;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.model.Reports;

@Service("reportService")
@Transactional
public class ReportServiceImpl implements ReportService{
	
	private static final AtomicLong counter = new AtomicLong();
	
	ReportDAOImpl repDAO = ReportDAOImpl.getInstance();
	
	List<Reports> report= new ArrayList<Reports>();
	
    public List<Reports> extractReports(long id,String dateRange){
	
        String [] dateInterval = dateRange.split(",");
    	
  /*  	
    	if(id == 1){
    	 	report=repDAO.FetchImpressionsData(dateInterval[0], dateInterval[1]);
		    return report;
    	}
    	
    	
    	if(id == 2){
    	 	report=repDAO.FetchClicksData(dateInterval[0], dateInterval[1]);
		    return report;
    	}
    	
    	
    	if(id == 3){
    	 	report=repDAO.FetchConversionsData(dateInterval[0], dateInterval[1]);
		    return report;
    	}
    	
    	
    	if(id == 4){
    	 	report=repDAO.FetchCostData(dateInterval[0], dateInterval[1]);
		    return report;
    	}
    	
    	
    	if(id == 5){
    	 	report=repDAO.FetchAudienceSegmentImpData(dateInterval[0], dateInterval[1]);
		    return report;
    	}
    	
    	
    	if(id == 6){
    	 	report=repDAO.FetchCityImpData(dateInterval[0], dateInterval[1]);
		    return report;
    	}
    	
    	
    	if(id == 7){
    	 	report=repDAO.FetchDeviceImpData(dateInterval[0], dateInterval[1]);
		    return report;
    	}
        
    	if(id == 8){
    	 	report=repDAO.FetchOSImpData(dateInterval[0], dateInterval[1]);
		    return report;
    	}
   */
     
        
        
        
        
    	if(id == 1){
    	 	report=repDAO.FetchChannelImpData(dateInterval[0], dateInterval[1]);
		    return report;
    	}
    	
    	if(id == 2){
    	 	report=repDAO.FetchChannelClicksData(dateInterval[0], dateInterval[1]);
		    return report;
    	}
    	
    	if(id == 3){
    	 	report=repDAO.FetchChannelConvData(dateInterval[0], dateInterval[1]);
		    return report;
    	}
    	
    	if(id == 4){
    	 	report=repDAO.FetchChannelCostData(dateInterval[0], dateInterval[1]);
		    return report;
    	}
    	
    	if(id == 17){
    	 	report=repDAO.FetchChannelReachData(dateInterval[0], dateInterval[1]);
		    return report;
    	}
    	
 
    	
   
   //Fetch CPM,CPC,CPP data for all channels which will be displayed on top left for all channels
    	
    	   	
    	
    	if(id == 18){
    	 	report=repDAO.FetchChannelMetricsData(dateInterval[0], dateInterval[1]);
		    return report;
    	}
    	
    	
    	
    
    	
    	
    	return report;
    
    
    
    
    
    
    
    
    
    
    }
		
}
