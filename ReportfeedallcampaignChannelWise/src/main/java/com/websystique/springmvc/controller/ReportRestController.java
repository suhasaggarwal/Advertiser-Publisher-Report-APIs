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

//Application code - b9

@RestController
public class ReportRestController {

	
	//Controller receives data from Service API and generates a JSON feed to feed into visualisation component.
	//API format <Report/Reportcode/Daterange, as nothing is specified after daterange, all campaignids are picked and cumulative report is shown channel wise.
	@Autowired
	ReportService reportService;  //Service which will do all data retrieval/manipulation work

	//-------------------Retrieve Report with Id--------------------------------------------------------
	
	@RequestMapping(value = "/report/{id}/{dateRange}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Reports>> getReport(@PathVariable("id") long id,@PathVariable("dateRange") String dateRange) {
		System.out.println("Fetching Report with id " + id);
		List<Reports> report = reportService.extractReports(id,dateRange);
		if (report == null) {
			System.out.println("Report with id " + id + " not found");
			return new ResponseEntity<List<Reports>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Reports>>(report, HttpStatus.OK);
	}

	
	
	

}
