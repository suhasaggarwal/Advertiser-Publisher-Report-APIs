package com.websystique.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.websystique.springmvc.model.Reports;
import com.websystique.springmvc.service.ReportService;


//Application code - c2

@RestController
public class ReportRestController {

	@Autowired
	ReportService reportService;  //Service which will do all data retrieval/manipulation work

	//-------------------Retrieve Report with Id--------------------------------------------------------
	
	@RequestMapping(value = "/report/{id}/{dateRange}/{campaign_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Reports>> getReport(@PathVariable("id") long id,@PathVariable("dateRange") String dateRange,@PathVariable("campaign_id") String campaignId) {
		System.out.println("Fetching Report with id " + id);
		List<Reports> report = reportService.extractReports(id,dateRange,campaignId);
		if (report == null) {
			System.out.println("Report with id " + id + " not found");
			return new ResponseEntity<List<Reports>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Reports>>(report, HttpStatus.OK);
	}

	@RequestMapping(value = "/report/{id}/{dateRange}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<String>> getReport(@PathVariable("id") long id,@PathVariable("dateRange") String dateRange) {
		System.out.println("Fetching Report with id " + id);
		List<String> campIds = reportService.extractCampaignIds(id,dateRange);
		if (campIds == null){
		    System.out.println("Report with id " + id + " not found");
			return new ResponseEntity<List<String>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<String>>(campIds, HttpStatus.OK);
}
	
	
	
	

}
