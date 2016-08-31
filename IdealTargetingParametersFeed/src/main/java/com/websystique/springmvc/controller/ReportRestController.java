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

//Ideal Targeting paramters
//APIs to display Ideal Targeting parameters corresponding to campaign


@RestController
public class ReportRestController {

	@Autowired
	ReportService reportService;  //Service which will do all data retrieval/manipulation work

	//-------------------Retrieve Report with Id--------------------------------------------------------
	
	@RequestMapping(value = "/report/{id}/{campaign_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Reports>> getReport(@PathVariable("id") long id,@PathVariable("campaign_id") String campaignId) {
		System.out.println("Fetching Report with id " + id);
		String dateRange = "2016-05-05,2016-05-05";
		List<Reports> report = reportService.extractReports(id,dateRange,campaignId);
		if (report == null) {
			System.out.println("Report with id " + id + " not found");
			return new ResponseEntity<List<Reports>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Reports>>(report, HttpStatus.OK);
	}
	
	
	

}
