package com.websystique.springmvc.service;



import java.util.List;

import com.websystique.springmvc.model.Reports;



public interface ReportService {
	
	List<Reports> extractReports(long id, String dateRange, String campaignId);
	 
	List<String> extractCampaignIds(long id,String dateRange);


}
