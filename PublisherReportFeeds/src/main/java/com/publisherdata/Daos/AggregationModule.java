package com.publisherdata.Daos;

import static org.nlpcn.es4sql.TestsConstants.TEST_INDEX;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.elasticsearch.action.admin.cluster.node.info.NodesInfoResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.ImmutableSettings.Builder;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.plugin.nlpcn.QueryActionElasticExecutor;
import org.elasticsearch.plugin.nlpcn.executors.CSVResult;
import org.elasticsearch.plugin.nlpcn.executors.CSVResultsExtractor;
import org.elasticsearch.plugin.nlpcn.executors.CsvExtractorException;
import org.elasticsearch.search.aggregations.Aggregations;
import org.nlpcn.es4sql.SearchDao;
import org.nlpcn.es4sql.exception.SqlParseException;
import org.nlpcn.es4sql.query.QueryAction;
import org.nlpcn.es4sql.query.SqlElasticSearchRequestBuilder;

import com.publisherdata.model.PublisherReport;


//Generates different Report codes corresponding to different publisher Reports.
//Uses Elastic search - Sql query language and Aggregator to generate Report data which is then formatted into Reports.

public class AggregationModule {



	private static TransportClient client;
	
//	private static Client client;
	private static SearchDao searchDao;
	private static AggregationModule INSTANCE;
	
    public static AggregationModule getInstance() {
		
		if(INSTANCE == null)
			return new AggregationModule();
		else
		return INSTANCE;
	}
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
          
     
	// System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("logdata.txt"))));
 //    AggregationModule module = AggregationModule.getInstance();
//	 module.setUp();
//	 module.countAudiencesegmentChannel("2016-08-10","2016-08-12", "Siliconindia_Multiple_Oct_15");
//	 module.getdayQuarterdataChannel("2016-08-10","2016-08-14","MCd");;
//	 module.getOrg("2016-08-10","2016-08-14");
	// module.countAgegroup("2016-08-10","2016-08-12");
//	 module.countGender("2016-08-10","2016-08-14");
//	 module.getAgegroupChannel("2016-08-10","2016-08-12", "MCd");
//	 module.getGenderChannel("2016-08-10","2016-08-12", "Mcd");
//	 module.gettimeofdayQuarter("2016-08-10","2016-08-12");
	// module.getChannelList("2016-08-10","2016-08-14");
	// module.countOrg("2016-08-10","2016-08-14");
	/*		
		
	 setUp();
//	 countTest();
//	 maxTest();
//	 countBrandNameTest1(); 
	 countBrandName("2016-08-10","2016-08-14");
	 countBrowser("2016-08-10","2016-08-14");
	 countOS("2016-08-10","2016-08-14");
	 countModel("2016-08-10","2016-08-14");
	// dateHistogram();
	 countCity("2016-08-10","2016-08-14");
	 countPinCode("2016-08-10","2016-08-14");
	 countLatLong("2016-08-10","2016-08-14");
	 countfingerprint("2016-08-10","2016-08-14");
	
	*/
	 
	}
/*
	public final Client getEsClient() {

		if (client == null) {
			client = getES();
		}
		return client;
	}

	
	public final void setEsClient(final Client esClient) {

		AggregationModule.client = esClient;
	//	searchDao = new SearchDao(client);
	}

	
	private Client getES() {
		try {
			
			final Builder settings = ImmutableSettings.settingsBuilder().put("cluster.name", "elasticsearch");
			
			final TransportClient transportClient = new TransportClient(settings);
			transportClient.addTransportAddress(new InetSocketTransportAddress("locallhost", 9300));
			
			return transportClient;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	*/
	public void setUp() throws Exception {
	//	getEsClient();
	//	searchDao = new SearchDao(client);
		
		if(client == null){
		client = new TransportClient();
		client.addTransportAddress(getTransportAddress());
		
		
		NodesInfoResponse nodeInfos = client.admin().cluster().prepareNodesInfo().get();
		String clusterName = nodeInfos.getClusterName().value();
		System.out.println(String.format("Found cluster... cluster name: %s", clusterName));

        searchDao = new SearchDao(client);
		}
        //refresh to make sure all the docs will return on queries
    //    client.admin().indices().prepareRefresh(TEST_INDEX).execute().actionGet();

		System.out.println("Finished the setup process...");
	   
	}


	public static SearchDao getSearchDao() {
		return searchDao;
	}
	
/*
	public static void countTest() throws CsvExtractorException, Exception {
		Aggregations result = query(String.format("SELECT COUNT(*),brandName,browser_name FROM enhanceduserdata group by brandName,browser_name", TEST_INDEX));
		String query = String.format("SELECT COUNT(*)as count,brandName,browser_name FROM enhanceduserdata group by brandName,browser_name","enhanceduserdata");
		CSVResult csvResult = getCsvResult(false, query);
        List<String> headers = csvResult.getHeaders();
        List<String> lines = csvResult.getLines();
        System.out.println(headers);
        System.out.println(lines);
		
		
		//		System.out.println(result.asMap().toString());
	//	ValueCount count = result.get("COUNT(*)");
	//	Assert.assertEquals(1000, count.getValue());
	}
	
	
	
	public static void maxTest() throws CsvExtractorException, Exception {
		Aggregations result = query(String.format("SELECT COUNT(*),brandName,browser_name FROM enhanceduserdata group by brandName,browser_name", TEST_INDEX));
		String query = String.format("SELECT min(request_time) FROM enhanceduserdata","enhanceduserdata");
		CSVResult csvResult = getCsvResult(false, query);
        List<String> headers = csvResult.getHeaders();
        List<String> lines = csvResult.getLines();
        System.out.println(headers);
        System.out.println(lines);
		
		
		//		System.out.println(result.asMap().toString());
	//	ValueCount count = result.get("COUNT(*)");
	//	Assert.assertEquals(1000, count.getValue());
	}

	
	
	public static void countBrandNameTest1() throws CsvExtractorException, Exception {
		Aggregations result = query(String.format("SELECT COUNT(*),brandName,browser_name FROM enhanceduserdata group by brandName,browser_name", TEST_INDEX));
		String query = String.format("SELECT COUNT(*)as count,brandName FROM enhanceduserdata group by brandName","enhanceduserdata");
		CSVResult csvResult = getCsvResult(false, query);
        List<String> headers = csvResult.getHeaders();
        List<String> lines = csvResult.getLines();
        System.out.println(headers);
        System.out.println(lines);
		
		
		//		System.out.println(result.asMap().toString());
	//	ValueCount count = result.get("COUNT(*)");
	//	Assert.assertEquals(1000, count.getValue());
	}
	
*/	
	

	
	public List<PublisherReport> countBrandName(String startdate, String enddate) throws CsvExtractorException, Exception {
		Aggregations result = query(String.format("SELECT COUNT(*),brandName,browser_name FROM enhanceduserdata group by brandName,browser_name", TEST_INDEX));
		String query = String.format("SELECT COUNT(*)as count,brandName FROM enhanceduserdata where date between "+"'"+startdate+"'"+" and "+"'"+enddate+"'"+ " group by brandName","enhanceduserdata");
		CSVResult csvResult = getCsvResult(false, query);
        List<String> headers = csvResult.getHeaders();
        List<String> lines = csvResult.getLines();
        List<PublisherReport> pubreport = new ArrayList<PublisherReport>();
        String [] data;
        for(int i=0;i<lines.size();i++)
        {
        	PublisherReport obj = new PublisherReport();
       // 	obj.setDate(lines.get(i));
        	data = lines.get(i).split(",");
        	obj.setBrandname(data[0]);
            obj.setCount(data[1]);
            pubreport.add(obj);
        	 
        }
        
        System.out.println(headers);
        System.out.println(lines);
		
		return pubreport;
		//		System.out.println(result.asMap().toString());
	//	ValueCount count = result.get("COUNT(*)");
	//	Assert.assertEquals(1000, count.getValue());
	}
	
	public List<PublisherReport> countBrowser(String startdate,String enddate) throws CsvExtractorException, Exception {
		Aggregations result = query(String.format("SELECT COUNT(*),brandName,browser_name FROM enhanceduserdata group by brandName,browser_name", TEST_INDEX));
		String query = String.format("SELECT COUNT(*)as count,browser_name FROM enhanceduserdata where date between "+"'"+startdate+"'"+" and "+"'"+enddate+"'"+" group by browser_name","enhanceduserdata");
		CSVResult csvResult = getCsvResult(false, query);
        List<String> headers = csvResult.getHeaders();
        List<String> lines = csvResult.getLines();
        List<PublisherReport> pubreport = new ArrayList<PublisherReport>();
        String [] data;
        for(int i=0;i<lines.size();i++)
        {
        	PublisherReport obj = new PublisherReport();
       // 	obj.setDate(lines.get(i));
        	data = lines.get(i).split(",");
        	obj.setBrowser(data[0]);
            obj.setCount(data[1]);
            pubreport.add(obj);
        	 
        }
        
        
        System.out.println(headers);
        System.out.println(lines);
	//	
		return pubreport;
		//		System.out.println(result.asMap().toString());
	//	ValueCount count = result.get("COUNT(*)");
	//	Assert.assertEquals(1000, count.getValue());
	}
	
	
	public List<PublisherReport> countOS(String startdate,String enddate) throws CsvExtractorException, Exception {
		Aggregations result = query(String.format("SELECT COUNT(*),brandName,browser_name FROM enhanceduserdata group by brandName,browser_name", TEST_INDEX));
		String query = String.format("SELECT COUNT(*)as count,system_os FROM enhanceduserdata where date between "+"'"+startdate+"'"+" and "+"'"+enddate+"'"+" group by system_os","enhanceduserdata");
		CSVResult csvResult = getCsvResult(false, query);
        List<String> headers = csvResult.getHeaders();
        List<String> lines = csvResult.getLines();
        System.out.println(headers);
        System.out.println(lines);
        List<PublisherReport> pubreport = new ArrayList<PublisherReport>();
        String [] data;
        for(int i=0;i<lines.size();i++)
        {
        	PublisherReport obj = new PublisherReport();
       // 	obj.setDate(lines.get(i));
        	data = lines.get(i).split(",");
        	obj.setOs(data[0]);
            obj.setCount(data[1]);
            pubreport.add(obj);
        	 
        }
        
		
		return pubreport;
        
        //		System.out.println(result.asMap().toString());
	//	ValueCount count = result.get("COUNT(*)");
	//	Assert.assertEquals(1000, count.getValue());
	}
	
	public List<PublisherReport> countModel(String startdate,String enddate) throws CsvExtractorException, Exception {
		Aggregations result = query(String.format("SELECT COUNT(*),brandName,browser_name FROM enhanceduserdata group by brandName,browser_name", TEST_INDEX));
		String query = String.format("SELECT COUNT(*)as count,modelName FROM enhanceduserdata where date between "+"'"+startdate+"'"+" and "+"'"+enddate+"'"+" group by modelName","enhanceduserdata");
		CSVResult csvResult = getCsvResult(false, query);
        List<String> headers = csvResult.getHeaders();
        List<String> lines = csvResult.getLines();
        List<PublisherReport> pubreport = new ArrayList<PublisherReport>();
        String [] data;
        for(int i=0;i<lines.size();i++)
        {
        	PublisherReport obj = new PublisherReport();
       // 	obj.setDate(lines.get(i));
        	data = lines.get(i).split(",");
        	obj.setMobile_device_properties(data[0]);
            obj.setCount(data[1]);
            pubreport.add(obj);
        	 
        }
        
		
       return pubreport;
		
		//		System.out.println(result.asMap().toString());
	//	ValueCount count = result.get("COUNT(*)");
	//	Assert.assertEquals(1000, count.getValue());
	}
	
	
	public List<PublisherReport> countCity(String startdate,String enddate) throws CsvExtractorException, Exception {
		Aggregations result = query(String.format("SELECT COUNT(*),brandName,browser_name FROM enhanceduserdata group by brandName,browser_name", TEST_INDEX));
		String query = String.format("SELECT COUNT(*)as count,city FROM enhanceduserdata where date between "+"'"+startdate+"'"+" and "+"'"+enddate+"'"+" group by city","enhanceduserdata");
		CSVResult csvResult = getCsvResult(false, query);
        List<String> headers = csvResult.getHeaders();
        List<String> lines = csvResult.getLines();
        List<PublisherReport> pubreport = new ArrayList<PublisherReport>();
        String [] data;
        for(int i=0;i<lines.size();i++)
        {
        	PublisherReport obj = new PublisherReport();
       // 	obj.setDate(lines.get(i));
        	data = lines.get(i).split(",");
        	obj.setCity(data[0]);
            obj.setCount(data[1]);
            pubreport.add(obj);
        	 
        }
        
		
		return pubreport;
        
		//		System.out.println(result.asMap().toString());
	//	ValueCount count = result.get("COUNT(*)");
	//	Assert.assertEquals(1000, count.getValue());
	}
	
	
	public List<PublisherReport> countPinCode(String startdate,String enddate) throws CsvExtractorException, Exception {
		Aggregations result = query(String.format("SELECT COUNT(*),brandName,browser_name FROM enhanceduserdata group by brandName,browser_name", TEST_INDEX));
		String query = String.format("SELECT COUNT(*)as count,postalcode FROM enhanceduserdata where date between "+"'"+startdate+"'"+" and "+"'"+enddate+"'"+" group by postalcode","enhanceduserdata");
		CSVResult csvResult = getCsvResult(false, query);
        List<String> headers = csvResult.getHeaders();
        List<String> lines = csvResult.getLines();
        System.out.println(headers);
        System.out.println(lines);
        List<PublisherReport> pubreport = new ArrayList<PublisherReport>();
        String [] data;
        for(int i=0;i<lines.size();i++)
        {
        	PublisherReport obj = new PublisherReport();
       // 	obj.setDate(lines.get(i));
        	data = lines.get(i).split(",");
        	obj.setPostalcode(data[0]);
            obj.setCount(data[1]);
            pubreport.add(obj);
        	 
        }
        
		
        return pubreport;
        
		//		System.out.println(result.asMap().toString());
	//	ValueCount count = result.get("COUNT(*)");
	//	Assert.assertEquals(1000, count.getValue());
	
		
		//		System.out.println(result.asMap().toString());
	//	ValueCount count = result.get("COUNT(*)");
	//	Assert.assertEquals(1000, count.getValue());
	}
	
	
	
	
	
	public List<PublisherReport> countLatLong(String startdate,String enddate) throws CsvExtractorException, Exception {
		Aggregations result = query(String.format("SELECT COUNT(*),brandName,browser_name FROM enhanceduserdata group by brandName,browser_name", TEST_INDEX));
		String query = String.format("SELECT COUNT(*)as count,latitude_longitude FROM enhanceduserdata where date between "+"'"+startdate+"'"+" and "+"'"+enddate+"'"+" group by latitude_longitude","enhanceduserdata");
		CSVResult csvResult = getCsvResult(false, query);
        List<String> headers = csvResult.getHeaders();
        List<String> lines = csvResult.getLines();
        System.out.println(headers);
        System.out.println(lines);
        List<PublisherReport> pubreport = new ArrayList<PublisherReport>();
        String [] data;
        String [] dashcount;
        for(int i=0;i<lines.size();i++)
        {
        	PublisherReport obj = new PublisherReport();
       // 	obj.setDate(lines.get(i));
        	data = lines.get(i).split(",");
        	dashcount = data[0].split("_");
        	if(dashcount.length == 3 && data[0].charAt(data[0].length()-1) != '_' ){
        	if(dashcount[2].isEmpty()==false){ 
        	obj.setLatitude_longitude(data[0]);
            obj.setCount(data[1]);
            pubreport.add(obj);
        	} 
        }
        }
        return pubreport;
        
        
		//		System.out.println(result.asMap().toString());
	//	ValueCount count = result.get("COUNT(*)");
	//	Assert.assertEquals(1000, count.getValue());
	}
	
	
	
	
	
	
	public List<PublisherReport> countfingerprint(String startdate,String enddate) throws CsvExtractorException, Exception {
		Aggregations result = query(String.format("SELECT COUNT(*),brandName,browser_name FROM enhanceduserdata group by brandName,browser_name", TEST_INDEX));
		String query = String.format("SELECT count(distinct(fingerprint_id))as reach,date"
				+ " FROM enhanceduserdata where date between "+"'"+startdate+"'"+" and "+"'"+enddate+"'"+" group by date","enhanceduserdata");
		CSVResult csvResult = getCsvResult(false, query);
        List<String> headers = csvResult.getHeaders();
        List<String> lines = csvResult.getLines();
        List<PublisherReport> pubreport = new ArrayList<PublisherReport>();
        String [] data;
        for(int i=0;i<lines.size();i++)
        {
        	PublisherReport obj = new PublisherReport();
       // 	obj.setDate(lines.get(i));
        	data = lines.get(i).split(",");
        	obj.setDate(data[0]);
            obj.setReach(data[1]);
            pubreport.add(obj);
        	 
        }
        
		
        return pubreport;
        
		//		System.out.println(result.asMap().toString());
	//	ValueCount count = result.get("COUNT(*)");
	//	Assert.assertEquals(1000, count.getValue());
	}
	
	
	public List<PublisherReport> countAudienceSegment(String startdate,String enddate) throws CsvExtractorException, Exception {
		Aggregations result = query(String.format("SELECT COUNT(*),brandName,browser_name FROM enhanceduserdata group by brandName,browser_name", TEST_INDEX));
		String query = String.format("SELECT COUNT(*)as count,audience_segment FROM enhanceduserdata where date between "+"'"+startdate+"'"+" and "+"'"+enddate+"'"+" group by audience_segment","enhanceduserdata");
		CSVResult csvResult = getCsvResult(false, query);
        List<String> headers = csvResult.getHeaders();
        List<String> lines = csvResult.getLines();
        List<PublisherReport> pubreport = new ArrayList<PublisherReport>();
        String [] data;
        
        System.out.println(headers);
        System.out.println(lines);
        String query1 = String.format("SELECT COUNT(*)as count,subcategory FROM enhanceduserdata where date between "+"'"+startdate+"'"+" and "+"'"+enddate+"'"+" group by subcategory","enhanceduserdata");
		CSVResult csvResult1 = getCsvResult(false, query1);
        List<String> headers1 = csvResult1.getHeaders();
        List<String> lines1 = csvResult1.getLines();
        List<PublisherReport> pubreport1 = new ArrayList<PublisherReport>();
        String [] data1;
        
        
        
        for(int i=0;i<lines.size();i++)
        {
        	PublisherReport obj = new PublisherReport();
       // 	obj.setDate(lines.get(i));
        	data = lines.get(i).split(",");
            obj.setAudience_segment(data[0]);
            obj.setCount(data[1]);
          
            if(data[0].equals("tech")==false && data[0].equals("india")==false)
            {  
            for(int j=0;j<lines1.size();j++)
            {
            	PublisherReport obj1 = new PublisherReport();
           // 	obj.setDate(lines.get(i));
            	data1 = lines1.get(j).split(",");
                
            	if(data1[0].contains(data[0])){
            		obj1.setAudience_segment(data1[0]);
                    obj1.setCount(data1[1]);
                    obj.getAudience_segment_data().add(obj1);
            	}
            
             }
           
		
           pubreport.add(obj);
          }
            
            } 
        
            return pubreport;
        
		//		System.out.println(result.asMap().toString());
	//	ValueCount count = result.get("COUNT(*)");
	//	Assert.assertEquals(1000, count.getValue());
	}
	
	
	public List<PublisherReport> countISP(String startdate,String enddate) throws CsvExtractorException, Exception {
		Aggregations result = query(String.format("SELECT COUNT(*),brandName,browser_name FROM enhanceduserdata group by brandName,browser_name", TEST_INDEX));
		String query = String.format("SELECT COUNT(*)as count,ISP FROM enhanceduserdata where date between "+"'"+startdate+"'"+" and "+"'"+enddate+"'"+" group by ISP","enhanceduserdata");
		CSVResult csvResult = getCsvResult(false, query);
        List<String> headers = csvResult.getHeaders();
        List<String> lines = csvResult.getLines();
        List<PublisherReport> pubreport = new ArrayList<PublisherReport>();
        String [] data;
        for(int i=0;i<lines.size();i++)
        {
        	PublisherReport obj = new PublisherReport();
       // 	obj.setDate(lines.get(i));
        	data = lines.get(i).split(",");
        	obj.setISP(data[0]);
            obj.setCount(data[1]);
            pubreport.add(obj);
        	 
        }
        
        
        System.out.println(headers);
        System.out.println(lines);
	//	
		return pubreport;
		//		System.out.println(result.asMap().toString());
	//	ValueCount count = result.get("COUNT(*)");
	//	Assert.assertEquals(1000, count.getValue());
	}
	
	
	
	public List<PublisherReport> countOrg(String startdate,String enddate) throws CsvExtractorException, Exception {
		Aggregations result = query(String.format("SELECT COUNT(*),brandName,browser_name FROM enhanceduserdata group by brandName,browser_name", TEST_INDEX));
		String query = String.format("SELECT organisation FROM enhanceduserdata where date between "+"'"+startdate+"'"+" and "+"'"+enddate+"'"+" and organisation NOT IN (Select DISTINCT(ISP) FROM enhanceduserdata)","enhanceduserdata");
		CSVResult csvResult = getCsvResult(false, query);
        List<String> headers = csvResult.getHeaders();
        List<String> lines = csvResult.getLines();
        List<PublisherReport> pubreport = new ArrayList<PublisherReport>();
        String [] data;
        for(int i=0;i<lines.size();i++)
        {
        	PublisherReport obj = new PublisherReport();
       // 	obj.setDate(lines.get(i));
        	data = lines.get(i).split(",");
        	obj.setOrganisation(data[0]);
            obj.setCount(data[1]);
            pubreport.add(obj);
        	 
        }
        
        
        System.out.println(headers);
        System.out.println(lines);
	//	
		return pubreport;
		//		System.out.println(result.asMap().toString());
	//	ValueCount count = result.get("COUNT(*)");
	//	Assert.assertEquals(1000, count.getValue());
	}
	
	
	
	
	public Set<String> getChannelList(String startdate,String enddate) throws CsvExtractorException, Exception {
	//	Aggregations result = query(String.format("SELECT COUNT(*),brandName,browser_name FROM enhanceduserdata group by brandName,browser_name", TEST_INDEX));
		String query = String.format("SELECT DISTINCT(channel_name)as channelName FROM enhanceduserdata where date between "+"'"+startdate+"'"+" and "+"'"+enddate+"'" ,"enhanceduserdata");
		CSVResult csvResult = getCsvResult(false, query);
        List<String> headers = csvResult.getHeaders();
        List<String> lines = csvResult.getLines();
        List<String> finallines = new ArrayList<String>();
        Set<String> data = new HashSet<String>();
        data.addAll(lines);

        System.out.println(headers);
        System.out.println(finallines);
		
		return data;
		//		System.out.println(result.asMap().toString());
	//	ValueCount count = result.get("COUNT(*)");
	//	Assert.assertEquals(1000, count.getValue());
	}
	
	
	
	
	
	
	public List<PublisherReport> gettimeofdayQuarter(String startdate, String enddate) throws SQLFeatureNotSupportedException, SqlParseException, CsvExtractorException, Exception  {
      //  String query = String.format("select count(*),brandName,screen_properties,resolution_properties,browser_name,system_os from enhanceduserdata" +
        //        " group by date_histogram('field'='request_time','interval'='1d','alias'='days'),brandName,screen_properties,resolution_properties,browser_name,system_os","enhanceduserdata");
       
		
	//	String query = "Select count(*) from enhanceduserdata WHERE date between "+"'"+startdate+"'"+" and "+"'"+enddate+"' GROUP BY date_histogram(field='request_time','interval'='4h','alias'='interval','format=HH:mm:ss')";
		
		String query = "Select count(*) from enhanceduserdata WHERE date between "+"'"+startdate+"'"+" and "+"'"+enddate+"' GROUP BY HOUR(request_time)";
		
		CSVResult csvResult = getCsvResult(false, query);
        List<String> headers = csvResult.getHeaders();
        List<String> lines = csvResult.getLines();
        List<PublisherReport> pubreport = new ArrayList<PublisherReport>();
        String [] data;
        for(int i=0;i<lines.size();i++)
        {
        	PublisherReport obj = new PublisherReport();
       // 	obj.setDate(lines.get(i));
        	data = lines.get(i).split(",");
        	obj.setTime_of_day(data[0]);
            obj.setCount(data[1]);
            pubreport.add(obj);
        	 
        }
        System.out.println(headers);
        System.out.println(lines);
    	return pubreport;
	
        
       
   //     Assert.assertEquals(3, lines.size());
   //     Assert.assertTrue("2014-08-14 00:00:00,477.0", lines.contains("2014-08-14 00:00:00,477.0"));
   //     Assert.assertTrue("2014-08-18 00:00:00,5664.0", lines.contains("2014-08-18 00:00:00,5664.0"));
    //    Assert.assertTrue("2014-08-22 00:00:00,3795.0", lines.contains("2014-08-22 00:00:00,3795.0"));
    }

	
	
	
	public  List<PublisherReport> gettimeofdayDaily(String startdate, String enddate) throws SQLFeatureNotSupportedException, SqlParseException, CsvExtractorException, Exception  {
	      //  String query = String.format("select count(*),brandName,screen_properties,resolution_properties,browser_name,system_os from enhanceduserdata" +
	        //        " group by date_histogram('field'='request_time','interval'='1d','alias'='days'),brandName,screen_properties,resolution_properties,browser_name,system_os","enhanceduserdata");
	       
			
			String query = "Select count(*) from enhanceduserdata WHERE date between "+"'"+startdate+"'"+" and "+"'"+enddate+"' GROUP BY date_histogram(field='request_time','interval'='1d')";
			CSVResult csvResult = getCsvResult(false, query);
	        List<String> headers = csvResult.getHeaders();
	        List<String> lines = csvResult.getLines();
	        List<PublisherReport> pubreport = new ArrayList<PublisherReport>();
	        String [] data;
	        for(int i=0;i<lines.size();i++)
	        {
	        	PublisherReport obj = new PublisherReport();
	       // 	obj.setDate(lines.get(i));
	        	data = lines.get(i).split(",");
	        	obj.setTime_of_day(data[0]);
	            obj.setCount(data[1]);
	            pubreport.add(obj);
	        	 
	        }
	        System.out.println(headers);
	        System.out.println(lines);
	    	return pubreport;
		
	        
	       
	   //     Assert.assertEquals(3, lines.size());
	   //     Assert.assertTrue("2014-08-14 00:00:00,477.0", lines.contains("2014-08-14 00:00:00,477.0"));
	   //     Assert.assertTrue("2014-08-18 00:00:00,5664.0", lines.contains("2014-08-18 00:00:00,5664.0"));
	    //    Assert.assertTrue("2014-08-22 00:00:00,3795.0", lines.contains("2014-08-22 00:00:00,3795.0"));
	    }
	
	
	
	
	
	public List<PublisherReport> gettimeofday(String startdate, String enddate) throws SQLFeatureNotSupportedException, SqlParseException, CsvExtractorException, Exception  {
	      //  String query = String.format("select count(*),brandName,screen_properties,resolution_properties,browser_name,system_os from enhanceduserdata" +
	        //        " group by date_histogram('field'='request_time','interval'='1d','alias'='days'),brandName,screen_properties,resolution_properties,browser_name,system_os","enhanceduserdata");
	       
			
			String query = "Select count(*) from enhanceduserdata WHERE date between "+"'"+startdate+"'"+" and "+"'"+enddate+"' GROUP BY date_histogram(field='request_time','interval'='1h')";
			CSVResult csvResult = getCsvResult(false, query);
	        List<String> headers = csvResult.getHeaders();
	        List<String> lines = csvResult.getLines();
	        List<PublisherReport> pubreport = new ArrayList<PublisherReport>();
	        String [] data;
	        for(int i=0;i<lines.size();i++)
	        {
	        	PublisherReport obj = new PublisherReport();
	       // 	obj.setDate(lines.get(i));
	        	data = lines.get(i).split(",");
	        	obj.setTime_of_day(data[0]);
	            obj.setCount(data[1]);
	            pubreport.add(obj);
	        	 
	        }
	        System.out.println(headers);
	        System.out.println(lines);
	    	return pubreport;
		
	        
	       
	   //     Assert.assertEquals(3, lines.size());
	   //     Assert.assertTrue("2014-08-14 00:00:00,477.0", lines.contains("2014-08-14 00:00:00,477.0"));
	   //     Assert.assertTrue("2014-08-18 00:00:00,5664.0", lines.contains("2014-08-18 00:00:00,5664.0"));
	    //    Assert.assertTrue("2014-08-22 00:00:00,3795.0", lines.contains("2014-08-22 00:00:00,3795.0"));
	    }

	
	
	public List<PublisherReport> countGender(String startdate,String enddate) throws CsvExtractorException, Exception {
		Aggregations result = query(String.format("SELECT COUNT(*),brandName,browser_name FROM enhanceduserdata group by brandName,browser_name", TEST_INDEX));
		String query = String.format("SELECT COUNT(*)as count,gender FROM enhanceduserdata where date between "+"'"+startdate+"'"+" and "+"'"+enddate+"'"+" group by gender","enhanceduserdata");
		CSVResult csvResult = getCsvResult(false, query);
        List<String> headers = csvResult.getHeaders();
        List<String> lines = csvResult.getLines();
        List<PublisherReport> pubreport = new ArrayList<PublisherReport>();
        String [] data;
        System.out.println(headers);
        System.out.println(lines);
        
        
        
        for(int i=0;i<lines.size();i++)
        {
        	PublisherReport obj = new PublisherReport();
       // 	obj.setDate(lines.get(i));
        	data = lines.get(i).split(",");
        	obj.setGender(data[0]);
            obj.setCount(data[1]);
            pubreport.add(obj);
        	 
        }
        
        
        System.out.println(headers);
        System.out.println(lines);
	//	
		return pubreport;
		//		System.out.println(result.asMap().toString());
	//	ValueCount count = result.get("COUNT(*)");
	//	Assert.assertEquals(1000, count.getValue());
	}
	
	public List<PublisherReport> countAgegroup(String startdate,String enddate) throws CsvExtractorException, Exception {
		Aggregations result = query(String.format("SELECT COUNT(*),brandName,browser_name FROM enhanceduserdata group by brandName,browser_name", TEST_INDEX));
		String query = String.format("SELECT COUNT(*)as count,agegroup FROM enhanceduserdata where date between "+"'"+startdate+"'"+" and "+"'"+enddate+"'"+" group by agegroup","enhanceduserdata");
		CSVResult csvResult = getCsvResult(false, query);
        List<String> headers = csvResult.getHeaders();
        List<String> lines = csvResult.getLines();
        List<PublisherReport> pubreport = new ArrayList<PublisherReport>();
        String [] data;
        System.out.println(headers);
        System.out.println(lines);
        
        
        for(int i=0;i<lines.size();i++)
        {
        	PublisherReport obj = new PublisherReport();
       // 	obj.setDate(lines.get(i));
        	data = lines.get(i).split(",");
        	obj.setAge(data[0]);
            obj.setCount(data[1]);
            pubreport.add(obj);
        	 
        }
        
        
        System.out.println(headers);
        System.out.println(lines);
	//	
		return pubreport;
		//		System.out.println(result.asMap().toString());
	//	ValueCount count = result.get("COUNT(*)");
	//	Assert.assertEquals(1000, count.getValue());
	}
	

	
	
	
	
	
	
	public List<PublisherReport> getOrg(String startdate, String enddate) throws SQLFeatureNotSupportedException, SqlParseException, CsvExtractorException, Exception  {
	      //  String query = String.format("select count(*),brandName,screen_properties,resolution_properties,browser_name,system_os from enhanceduserdata" +
	        //        " group by date_histogram('field'='request_time','interval'='1d','alias'='days'),brandName,screen_properties,resolution_properties,browser_name,system_os","enhanceduserdata");
/*	       
		String query = "Select count(*),ISP from enhanceduserdata where channel_name = '"+channel_name+"' and date between "+"'"+startdate+"'"+" and "+"'"+enddate+"'"+" GROUP BY ISP";
		CSVResult csvResult = getCsvResult(false, query);
      List<String> headers = csvResult.getHeaders();
      List<String> lines = csvResult.getLines();
      String [] data;
      String [] data2;
      Set<String> Isps = new HashSet<String>();
      
      for(int i=0;i<lines.size();i++)
      {
      	
     // 	obj.setDate(lines.get(i));
      	data = lines.get(i).split(",");
      	data2 = data[0].split("_");
      	Isps.add(data2[0]);
         // Isps.add(data2[1]);
      }	
*/
		    String query1 = "Select count(*),organisation from enhanceduserdata where date between "+"'"+startdate+"'"+" and "+"'"+enddate+"'"+" GROUP BY organisation";
			CSVResult csvResult1 = getCsvResult(false, query1);
	        List<String> headers1 = csvResult1.getHeaders();
	        List<String> lines1 = csvResult1.getLines();
	        List<PublisherReport> pubreport = new ArrayList<PublisherReport>();
	        String [] data1;
	        String [] data3;
	        for(int i=0;i<lines1.size();i++)
	        {
	        	PublisherReport obj = new PublisherReport();
	       // 	obj.setDate(lines.get(i));
	        	data1 = lines1.get(i).split(",");
	        	if(data1[0].contains("broadband")==false && data1[0].contains("communication")==false && data1[0].contains("cable")==false && data1[0].contains("telecom")==false && data1[0].contains("network")==false && data1[0].contains("isp")==false && data1[0].contains("hathway")==false && data1[0].contains("internet")==false && data1[0].contains("Sify")==false && data1[0].equals("_ltd")==false && data1[0].equals("Googlebot")==false && data1[0].equals("Bsnl")==false){
	        	obj.setOrganisation(data1[0]);
	            obj.setCount(data1[1]);
	            
	            pubreport.add(obj);
	        	 
	        }
	        }
	        
	        System.out.println(headers1);
	        System.out.println(lines1);
	    	return pubreport;
		
	        
	       
	   //     Assert.assertEquals(3, lines.size());
	   //     Assert.assertTrue("2014-08-14 00:00:00,477.0", lines.contains("2014-08-14 00:00:00,477.0"));
	   //     Assert.assertTrue("2014-08-18 00:00:00,5664.0", lines.contains("2014-08-18 00:00:00,5664.0"));
	    //    Assert.assertTrue("2014-08-22 00:00:00,3795.0", lines.contains("2014-08-22 00:00:00,3795.0"));
	    }
	
	
	public List<PublisherReport> getdayQuarterdata(String startdate, String enddate) throws SQLFeatureNotSupportedException, SqlParseException, CsvExtractorException, Exception  {
	      //  String query = String.format("select count(*),brandName,screen_properties,resolution_properties,browser_name,system_os from enhanceduserdata" +
	        //        " group by date_histogram('field'='request_time','interval'='1d','alias'='days'),brandName,screen_properties,resolution_properties,browser_name,system_os","enhanceduserdata");
	       
			
			String query = "Select count(*),QuarterValue from enhanceduserdata where date between "+"'"+startdate+"'"+" and "+"'"+enddate+"'"+" GROUP BY QuarterValue";
			CSVResult csvResult = getCsvResult(false, query);
	        List<String> headers = csvResult.getHeaders();
	        List<String> lines = csvResult.getLines();
	        List<PublisherReport> pubreport = new ArrayList<PublisherReport>();
	        String [] data;
	        for(int i=0;i<lines.size();i++)
	        {
	        	PublisherReport obj = new PublisherReport();
	       // 	obj.setDate(lines.get(i));
	        	data = lines.get(i).split(",");
	        	if(data[0].equals("quarter1"))
	        	 data[0]="quarter1 (00 - 04 AM)";
	        	
	        	if(data[0].equals("quarter2"))	
	        	 data[0]="quarter2 (04 - 08 AM)";
	        	
	        	if(data[0].equals("quarter3"))	
	        	 data[0]="quarter3 (08 - 12 AM)";	
	        	
	        	if(data[0].equals("quarter4"))	
	        	 data[0]="quarter4 (12 - 16 PM)";			
	        	
	        	if(data[0].equals("quarter5"))
	        	 data[0]="quarter5 (16 - 20 PM)";		
	        	
	        	if(data[0].equals("quarter6"))	
	            data[0]="quarter6 (20 - 24 PM)";		
	        		
	        	obj.setTime_of_day(data[0]);
	            obj.setCount(data[1]);
	           
	            pubreport.add(obj);
	        	 
	        }
	        System.out.println(headers);
	        System.out.println(lines);
	    	return pubreport;
		
	        
	       
	   //     Assert.assertEquals(3, lines.size());
	   //     Assert.assertTrue("2014-08-14 00:00:00,477.0", lines.contains("2014-08-14 00:00:00,477.0"));
	   //     Assert.assertTrue("2014-08-18 00:00:00,5664.0", lines.contains("2014-08-18 00:00:00,5664.0"));
	    //    Assert.assertTrue("2014-08-22 00:00:00,3795.0", lines.contains("2014-08-22 00:00:00,3795.0"));
	    }
	
	
		
	
	public List<PublisherReport> countBrandNameChannel(String startdate, String enddate, String channel_name) throws CsvExtractorException, Exception {
	//	Aggregations result = query(String.format("SELECT COUNT(*),brandName,browser_name FROM enhanceduserdata group by brandName,browser_name", TEST_INDEX));
		String query = "SELECT COUNT(*)as count,brandName FROM enhanceduserdata where channel_name = '"+channel_name+"' and date between "+"'"+startdate+"'"+" and "+"'"+enddate+"'"+ " group by brandName";
		System.out.println(query);
		CSVResult csvResult = getCsvResult(false, query);
        List<String> headers = csvResult.getHeaders();
        List<String> lines = csvResult.getLines();
        List<PublisherReport> pubreport = new ArrayList<PublisherReport>();
        String [] data;
        for(int i=0;i<lines.size();i++)
        {
        	PublisherReport obj = new PublisherReport();
       // 	obj.setDate(lines.get(i));
        	data = lines.get(i).split(",");
        	obj.setBrandname(data[0]);
            obj.setCount(data[1]);
            obj.setChannelName(channel_name);
            pubreport.add(obj);
        	 
        }
        
        System.out.println(headers);
        System.out.println(lines);
		
		return pubreport;
		//		System.out.println(result.asMap().toString());
	//	ValueCount count = result.get("COUNT(*)");
	//	Assert.assertEquals(1000, count.getValue());
	}
	
	public List<PublisherReport> countBrowserChannel(String startdate,String enddate, String channel_name) throws CsvExtractorException, Exception {
		Aggregations result = query(String.format("SELECT COUNT(*),brandName,browser_name FROM enhanceduserdata group by brandName,browser_name", TEST_INDEX));
		String query = "SELECT COUNT(*)as count,browser_name FROM enhanceduserdata where channel_name ="+"'"+channel_name+"' and date between "+"'"+startdate+"'"+" and "+"'"+enddate+"'"+" group by browser_name";
		CSVResult csvResult = getCsvResult(false, query);
        List<String> headers = csvResult.getHeaders();
        List<String> lines = csvResult.getLines();
        List<PublisherReport> pubreport = new ArrayList<PublisherReport>();
        String [] data;
        for(int i=0;i<lines.size();i++)
        {
        	PublisherReport obj = new PublisherReport();
       // 	obj.setDate(lines.get(i));
        	data = lines.get(i).split(",");
        	obj.setBrowser(data[0]);
            obj.setCount(data[1]);
            obj.setChannelName(channel_name);
            pubreport.add(obj);
        	 
        }
        
        
        System.out.println(headers);
        System.out.println(lines);
	//	
		return pubreport;
		//		System.out.println(result.asMap().toString());
	//	ValueCount count = result.get("COUNT(*)");
	//	Assert.assertEquals(1000, count.getValue());
	}
	
	
	public List<PublisherReport> countOSChannel(String startdate,String enddate, String channel_name) throws CsvExtractorException, Exception {
		Aggregations result = query(String.format("SELECT COUNT(*),brandName,browser_name FROM enhanceduserdata group by brandName,browser_name", TEST_INDEX));
		String query = String.format("SELECT COUNT(*)as count,system_os FROM enhanceduserdata where channel_name = '"+channel_name+"' and date between "+"'"+startdate+"'"+" and "+"'"+enddate+"'"+" group by system_os","enhanceduserdata");
		CSVResult csvResult = getCsvResult(false, query);
        List<String> headers = csvResult.getHeaders();
        List<String> lines = csvResult.getLines();
        System.out.println(headers);
        System.out.println(lines);
        List<PublisherReport> pubreport = new ArrayList<PublisherReport>();
        String [] data;
        for(int i=0;i<lines.size();i++)
        {
        	PublisherReport obj = new PublisherReport();
       // 	obj.setDate(lines.get(i));
        	data = lines.get(i).split(",");
        	obj.setOs(data[0]);
            obj.setCount(data[1]);
            obj.setChannelName(channel_name);
            pubreport.add(obj);
        	 
        }
        
		
		return pubreport;
        
        //		System.out.println(result.asMap().toString());
	//	ValueCount count = result.get("COUNT(*)");
	//	Assert.assertEquals(1000, count.getValue());
	}
	
	public List<PublisherReport> countModelChannel(String startdate,String enddate, String channel_name) throws CsvExtractorException, Exception {
		Aggregations result = query(String.format("SELECT COUNT(*),brandName,browser_name FROM enhanceduserdata group by brandName,browser_name", TEST_INDEX));
		String query = String.format("SELECT COUNT(*)as count,modelName FROM enhanceduserdata where channel_name = '"+channel_name+"' and date between "+"'"+startdate+"'"+" and "+"'"+enddate+"'"+" group by modelName","enhanceduserdata");
		CSVResult csvResult = getCsvResult(false, query);
        List<String> headers = csvResult.getHeaders();
        List<String> lines = csvResult.getLines();
        List<PublisherReport> pubreport = new ArrayList<PublisherReport>();
        String [] data;
        for(int i=0;i<lines.size();i++)
        {
        	PublisherReport obj = new PublisherReport();
       // 	obj.setDate(lines.get(i));
        	data = lines.get(i).split(",");
        	obj.setMobile_device_properties(data[0]);
            obj.setCount(data[1]);
            obj.setChannelName(channel_name);
            pubreport.add(obj);
        	 
        }
        
		
       return pubreport;
		
		//		System.out.println(result.asMap().toString());
	//	ValueCount count = result.get("COUNT(*)");
	//	Assert.assertEquals(1000, count.getValue());
	}
	
	
	public List<PublisherReport> countCityChannel(String startdate,String enddate, String channel_name) throws CsvExtractorException, Exception {
		Aggregations result = query(String.format("SELECT COUNT(*),brandName,browser_name FROM enhanceduserdata group by brandName,browser_name", TEST_INDEX));
		String query = String.format("SELECT COUNT(*)as count,city FROM enhanceduserdata where channel_name = '"+channel_name+"' and date between "+"'"+startdate+"'"+" and "+"'"+enddate+"'"+" group by city","enhanceduserdata");
		CSVResult csvResult = getCsvResult(false, query);
        List<String> headers = csvResult.getHeaders();
        List<String> lines = csvResult.getLines();
        List<PublisherReport> pubreport = new ArrayList<PublisherReport>();
        String [] data;
        for(int i=0;i<lines.size();i++)
        {
        	PublisherReport obj = new PublisherReport();
       // 	obj.setDate(lines.get(i));
        	data = lines.get(i).split(",");
        	obj.setCity(data[0]);
            obj.setCount(data[1]);
            obj.setChannelName(channel_name);
            pubreport.add(obj);
        	 
        }
        
		
		return pubreport;
        
		//		System.out.println(result.asMap().toString());
	//	ValueCount count = result.get("COUNT(*)");
	//	Assert.assertEquals(1000, count.getValue());
	}
	
	
	public List<PublisherReport> countfingerprintChannel(String startdate,String enddate,String channel_name) throws CsvExtractorException, Exception {
		Aggregations result = query(String.format("SELECT COUNT(*),brandName,browser_name FROM enhanceduserdata group by brandName,browser_name", TEST_INDEX));
		String query = "SELECT count(distinct(fingerprint_id))as reach,date"
				+ " FROM enhanceduserdata where channel_name = '"+channel_name+"' and date between "+"'"+startdate+"'"+" and "+"'"+enddate+"'"+" group by date";
		CSVResult csvResult = getCsvResult(false, query);
        List<String> headers = csvResult.getHeaders();
        List<String> lines = csvResult.getLines();
        List<PublisherReport> pubreport = new ArrayList<PublisherReport>();
        String [] data;
        for(int i=0;i<lines.size();i++)
        {
        	PublisherReport obj = new PublisherReport();
       // 	obj.setDate(lines.get(i));
        	data = lines.get(i).split(",");
        	obj.setDate(data[0]);
            obj.setReach(data[1]);
            obj.setChannelName(channel_name);
            pubreport.add(obj);
        	 
        }
        
        return pubreport;
        
	}
	
	
	public List<PublisherReport> countAudiencesegmentChannel(String startdate,String enddate, String channel_name) throws CsvExtractorException, Exception {
		Aggregations result = query(String.format("SELECT COUNT(*),brandName,browser_name FROM enhanceduserdata group by brandName,browser_name", TEST_INDEX));
		String query = String.format("SELECT COUNT(*)as count,audience_segment FROM enhanceduserdata where channel_name = '"+channel_name+"' and date between "+"'"+startdate+"'"+" and "+"'"+enddate+"'"+" group by audience_segment","enhanceduserdata");
		CSVResult csvResult = getCsvResult(false, query);
        List<String> headers = csvResult.getHeaders();
        List<String> lines = csvResult.getLines();
        List<PublisherReport> pubreport = new ArrayList<PublisherReport>();
        String [] data;
       
        
        String query1 = String.format("SELECT COUNT(*)as count,subcategory FROM enhanceduserdata where channel_name = '"+channel_name+"' and date between "+"'"+startdate+"'"+" and "+"'"+enddate+"'"+" group by subcategory","enhanceduserdata");
		CSVResult csvResult1 = getCsvResult(false, query1);
        List<String> headers1 = csvResult1.getHeaders();
        List<String> lines1 = csvResult1.getLines();
        List<PublisherReport> pubreport1 = new ArrayList<PublisherReport>();
        String [] data1;
        
        System.out.println(headers1);
        System.out.println(lines1);
        
        for(int i=0;i<lines.size();i++)
        {
        	PublisherReport obj = new PublisherReport();
       // 	obj.setDate(lines.get(i));
        	data = lines.get(i).split(",");
            obj.setAudience_segment(data[0]);
            obj.setCount(data[1]);
            obj.setChannelName(channel_name);
         
            if(data[0].equals("tech")==false && data[0].equals("india")==false)
            {
            for(int j=0;j<lines1.size();j++)
            {
            	PublisherReport obj1 = new PublisherReport();
           // 	obj.setDate(lines.get(i));
            	data1 = lines1.get(j).split(",");
                
            	if(data1[0].contains(data[0])) {
            		obj1.setAudience_segment(data1[0]);
                    obj1.setCount(data1[1]);
                    obj1.setChannelName(channel_name);
            		obj.getAudience_segment_data().add(obj1);
            	}
            
             }
            pubreport.add(obj);
		
        }
        }
            return pubreport;
        
		//		System.out.println(result.asMap().toString());
	//	ValueCount count = result.get("COUNT(*)");
	//	Assert.assertEquals(1000, count.getValue());
	}
	
	
	
	
	
	public List<PublisherReport> gettimeofdayChannel(String startdate, String enddate, String channel_name) throws SQLFeatureNotSupportedException, SqlParseException, CsvExtractorException, Exception  {
	      //  String query = String.format("select count(*),brandName,screen_properties,resolution_properties,browser_name,system_os from enhanceduserdata" +
	        //        " group by date_histogram('field'='request_time','interval'='1d','alias'='days'),brandName,screen_properties,resolution_properties,browser_name,system_os","enhanceduserdata");
	       
			
			String query = "Select count(*) from enhanceduserdata where channel_name = '"+channel_name+"' and date between "+"'"+startdate+"'"+" and "+"'"+enddate+"'"+" GROUP BY date_histogram(field='request_time','interval'='1h')";
			CSVResult csvResult = getCsvResult(false, query);
	        List<String> headers = csvResult.getHeaders();
	        List<String> lines = csvResult.getLines();
	        List<PublisherReport> pubreport = new ArrayList<PublisherReport>();
	        String [] data;
	        for(int i=0;i<lines.size();i++)
	        {
	        	PublisherReport obj = new PublisherReport();
	       // 	obj.setDate(lines.get(i));
	        	data = lines.get(i).split(",");
	        	obj.setTime_of_day(data[0]);
	            obj.setCount(data[1]);
	            obj.setChannelName(channel_name);
	            pubreport.add(obj);
	        	 
	        }
	        System.out.println(headers);
	        System.out.println(lines);
	    	return pubreport;
		
	        
	       
	   //     Assert.assertEquals(3, lines.size());
	   //     Assert.assertTrue("2014-08-14 00:00:00,477.0", lines.contains("2014-08-14 00:00:00,477.0"));
	   //     Assert.assertTrue("2014-08-18 00:00:00,5664.0", lines.contains("2014-08-18 00:00:00,5664.0"));
	    //    Assert.assertTrue("2014-08-22 00:00:00,3795.0", lines.contains("2014-08-22 00:00:00,3795.0"));
	    }
	
	
	public List<PublisherReport> countPinCodeChannel(String startdate,String enddate,String channel_name) throws CsvExtractorException, Exception {
		Aggregations result = query(String.format("SELECT COUNT(*),brandName,browser_name FROM enhanceduserdata group by brandName,browser_name", TEST_INDEX));
		String query = String.format("SELECT COUNT(*)as count,postalcode FROM enhanceduserdata where channel_name = '"+channel_name+"' and date between "+"'"+startdate+"'"+" and "+"'"+enddate+"'"+" group by postalcode","enhanceduserdata");
		CSVResult csvResult = getCsvResult(false, query);
        List<String> headers = csvResult.getHeaders();
        List<String> lines = csvResult.getLines();
        System.out.println(headers);
        System.out.println(lines);
        List<PublisherReport> pubreport = new ArrayList<PublisherReport>();
        String [] data;
        for(int i=0;i<lines.size();i++)
        {
        	PublisherReport obj = new PublisherReport();
       // 	obj.setDate(lines.get(i));
        	data = lines.get(i).split(",");
        	obj.setPostalcode(data[0]);
            obj.setCount(data[1]);
            obj.setChannelName(channel_name);
            pubreport.add(obj);
        	 
        }
        
		
        return pubreport;
        
		//		System.out.println(result.asMap().toString());
	//	ValueCount count = result.get("COUNT(*)");
	//	Assert.assertEquals(1000, count.getValue());
	
		
		//		System.out.println(result.asMap().toString());
	//	ValueCount count = result.get("COUNT(*)");
	//	Assert.assertEquals(1000, count.getValue());
	}
	
	
	
	
	
	public List<PublisherReport> countLatLongChannel(String startdate,String enddate, String channel_name) throws CsvExtractorException, Exception {
		Aggregations result = query(String.format("SELECT COUNT(*),brandName,browser_name FROM enhanceduserdata group by brandName,browser_name", TEST_INDEX));
		String query = String.format("SELECT COUNT(*)as count,latitude_longitude FROM enhanceduserdata where channel_name = '"+channel_name+"' and date between "+"'"+startdate+"'"+" and "+"'"+enddate+"'"+" group by latitude_longitude","enhanceduserdata");
		CSVResult csvResult = getCsvResult(false, query);
        List<String> headers = csvResult.getHeaders();
        List<String> lines = csvResult.getLines();
        System.out.println(headers);
        System.out.println(lines);
        List<PublisherReport> pubreport = new ArrayList<PublisherReport>();
        String [] data;
        String [] dashcount;
        for(int i=0;i<lines.size();i++)
        {
        	PublisherReport obj = new PublisherReport();
       // 	obj.setDate(lines.get(i));
        	data = lines.get(i).split(",");
        	dashcount = data[0].split("_");
        	
        	if(dashcount.length == 3 && data[0].charAt(data[0].length()-1) != '_' ){
        	if(dashcount[2].isEmpty()==false){ 
        	obj.setLatitude_longitude(data[0]);
            obj.setCount(data[1]);
            obj.setChannelName(channel_name);
        	}
        	
        	pubreport.add(obj);
        	}
        }
		
        return pubreport;
        
        
		//		System.out.println(result.asMap().toString());
	//	ValueCount count = result.get("COUNT(*)");
	//	Assert.assertEquals(1000, count.getValue());
	}
	
	
	
	public List<PublisherReport> gettimeofdayQuarterChannel(String startdate, String enddate, String channel_name) throws SQLFeatureNotSupportedException, SqlParseException, CsvExtractorException, Exception  {
	      //  String query = String.format("select count(*),brandName,screen_properties,resolution_properties,browser_name,system_os from enhanceduserdata" +
	        //        " group by date_histogram('field'='request_time','interval'='1d','alias'='days'),brandName,screen_properties,resolution_properties,browser_name,system_os","enhanceduserdata");
	       
			
			String query = "Select count(*) from enhanceduserdata where channel_name = '"+channel_name+"' and date between "+"'"+startdate+"'"+" and "+"'"+enddate+"'"+" GROUP BY date_histogram(field='request_time','interval'='4h')";
			CSVResult csvResult = getCsvResult(false, query);
	        List<String> headers = csvResult.getHeaders();
	        List<String> lines = csvResult.getLines();
	        List<PublisherReport> pubreport = new ArrayList<PublisherReport>();
	        String [] data;
	        for(int i=0;i<lines.size();i++)
	        {
	        	PublisherReport obj = new PublisherReport();
	       // 	obj.setDate(lines.get(i));
	        	data = lines.get(i).split(",");
	        	obj.setTime_of_day(data[0]);
	            obj.setCount(data[1]);
	            obj.setChannelName(channel_name);
	            pubreport.add(obj);
	        	 
	        }
	        System.out.println(headers);
	        System.out.println(lines);
	    	return pubreport;
		
	        
	       
	   //     Assert.assertEquals(3, lines.size());
	   //     Assert.assertTrue("2014-08-14 00:00:00,477.0", lines.contains("2014-08-14 00:00:00,477.0"));
	   //     Assert.assertTrue("2014-08-18 00:00:00,5664.0", lines.contains("2014-08-18 00:00:00,5664.0"));
	    //    Assert.assertTrue("2014-08-22 00:00:00,3795.0", lines.contains("2014-08-22 00:00:00,3795.0"));
	    }
	
	
	public List<PublisherReport> gettimeofdayDailyChannel(String startdate, String enddate, String channel_name) throws SQLFeatureNotSupportedException, SqlParseException, CsvExtractorException, Exception  {
	      //  String query = String.format("select count(*),brandName,screen_properties,resolution_properties,browser_name,system_os from enhanceduserdata" +
	        //        " group by date_histogram('field'='request_time','interval'='1d','alias'='days'),brandName,screen_properties,resolution_properties,browser_name,system_os","enhanceduserdata");
	       
			
			String query = "Select count(*) from enhanceduserdata where channel_name = '"+channel_name+"' and date between "+"'"+startdate+"'"+" and "+"'"+enddate+"'"+" GROUP BY date_histogram(field='request_time','interval'='1d')";
			CSVResult csvResult = getCsvResult(false, query);
	        List<String> headers = csvResult.getHeaders();
	        List<String> lines = csvResult.getLines();
	        List<PublisherReport> pubreport = new ArrayList<PublisherReport>();
	        String [] data;
	        for(int i=0;i<lines.size();i++)
	        {
	        	PublisherReport obj = new PublisherReport();
	       // 	obj.setDate(lines.get(i));
	        	data = lines.get(i).split(",");
	        	obj.setTime_of_day(data[0]);
	            obj.setCount(data[1]);
	            obj.setChannelName(channel_name);
	            pubreport.add(obj);
	        	 
	        }
	        System.out.println(headers);
	        System.out.println(lines);
	    	return pubreport;
		
	        
	       
	   //     Assert.assertEquals(3, lines.size());
	   //     Assert.assertTrue("2014-08-14 00:00:00,477.0", lines.contains("2014-08-14 00:00:00,477.0"));
	   //     Assert.assertTrue("2014-08-18 00:00:00,5664.0", lines.contains("2014-08-18 00:00:00,5664.0"));
	    //    Assert.assertTrue("2014-08-22 00:00:00,3795.0", lines.contains("2014-08-22 00:00:00,3795.0"));
	    }
	
	
	public List<PublisherReport> getdayQuarterdataChannel(String startdate, String enddate, String channel_name) throws SQLFeatureNotSupportedException, SqlParseException, CsvExtractorException, Exception  {
	      //  String query = String.format("select count(*),brandName,screen_properties,resolution_properties,browser_name,system_os from enhanceduserdata" +
	        //        " group by date_histogram('field'='request_time','interval'='1d','alias'='days'),brandName,screen_properties,resolution_properties,browser_name,system_os","enhanceduserdata");
	       
			
			String query = "Select count(*),QuarterValue from enhanceduserdata where channel_name = '"+channel_name+"' and date between "+"'"+startdate+"'"+" and "+"'"+enddate+"'"+" GROUP BY QuarterValue";
			CSVResult csvResult = getCsvResult(false, query);
	        List<String> headers = csvResult.getHeaders();
	        List<String> lines = csvResult.getLines();
	        List<PublisherReport> pubreport = new ArrayList<PublisherReport>();
	        String [] data;
	        for(int i=0;i<lines.size();i++)
	        {
	        	PublisherReport obj = new PublisherReport();
	       // 	obj.setDate(lines.get(i));
	        	data = lines.get(i).split(",");
	        	
	        	
	        	    if(data[0].equals("quarter1"))
		        	 data[0]="quarter1 (00 - 04 AM)";
		        	
		        	if(data[0].equals("quarter2"))	
		        	 data[0]="quarter2 (04 - 08 AM)";
		        	
		        	if(data[0].equals("quarter3"))	
		        	 data[0]="quarter3 (08 - 12 AM)";	
		        	
		        	if(data[0].equals("quarter4"))	
		        	 data[0]="quarter4 (12 - 16 PM)";			
		        	
		        	if(data[0].equals("quarter5"))
		        	 data[0]="quarter5 (16 - 20 PM)";		
		        	
		        	if(data[0].equals("quarter6"))	
		            data[0]="quarter6 (20 - 24 PM)";		
	        	
	        	
	        	obj.setTime_of_day(data[0]);
	            obj.setCount(data[1]);
	            obj.setChannelName(channel_name);
	            pubreport.add(obj);
	        	 
	        }
	        System.out.println(headers);
	        System.out.println(lines);
	    	return pubreport;
		
	        
	       
	   //     Assert.assertEquals(3, lines.size());
	   //     Assert.assertTrue("2014-08-14 00:00:00,477.0", lines.contains("2014-08-14 00:00:00,477.0"));
	   //     Assert.assertTrue("2014-08-18 00:00:00,5664.0", lines.contains("2014-08-18 00:00:00,5664.0"));
	    //    Assert.assertTrue("2014-08-22 00:00:00,3795.0", lines.contains("2014-08-22 00:00:00,3795.0"));
	    }
	
	
	
	
	
	
	
	
	
	public List<PublisherReport> getGenderChannel(String startdate, String enddate, String channel_name) throws SQLFeatureNotSupportedException, SqlParseException, CsvExtractorException, Exception  {
	      //  String query = String.format("select count(*),brandName,screen_properties,resolution_properties,browser_name,system_os from enhanceduserdata" +
	        //        " group by date_histogram('field'='request_time','interval'='1d','alias'='days'),brandName,screen_properties,resolution_properties,browser_name,system_os","enhanceduserdata");
	       
			
			String query = "Select count(*),gender from enhanceduserdata where channel_name = '"+channel_name+"' and date between "+"'"+startdate+"'"+" and "+"'"+enddate+"'"+" GROUP BY gender";
			CSVResult csvResult = getCsvResult(false, query);
	        List<String> headers = csvResult.getHeaders();
	        List<String> lines = csvResult.getLines();
	        List<PublisherReport> pubreport = new ArrayList<PublisherReport>();
	        String [] data;
	        System.out.println(headers);
	        System.out.println(lines);
	        
	        for(int i=0;i<lines.size();i++)
	        {
	        	PublisherReport obj = new PublisherReport();
	       // 	obj.setDate(lines.get(i));
	        	data = lines.get(i).split(",");
	        	obj.setGender(data[0]);
	            obj.setCount(data[1]);
	            obj.setChannelName(channel_name);
	            pubreport.add(obj);
	        	 
	        }
	        System.out.println(headers);
	        System.out.println(lines);
	    	return pubreport;
		
	        
	       
	   //     Assert.assertEquals(3, lines.size());
	   //     Assert.assertTrue("2014-08-14 00:00:00,477.0", lines.contains("2014-08-14 00:00:00,477.0"));
	   //     Assert.assertTrue("2014-08-18 00:00:00,5664.0", lines.contains("2014-08-18 00:00:00,5664.0"));
	    //    Assert.assertTrue("2014-08-22 00:00:00,3795.0", lines.contains("2014-08-22 00:00:00,3795.0"));
	    }
	
	
	public List<PublisherReport> getAgegroupChannel(String startdate, String enddate, String channel_name) throws SQLFeatureNotSupportedException, SqlParseException, CsvExtractorException, Exception  {
	      //  String query = String.format("select count(*),brandName,screen_properties,resolution_properties,browser_name,system_os from enhanceduserdata" +
	        //        " group by date_histogram('field'='request_time','interval'='1d','alias'='days'),brandName,screen_properties,resolution_properties,browser_name,system_os","enhanceduserdata");
	       
			
			String query = "Select count(*),agegroup from enhanceduserdata where channel_name = '"+channel_name+"' and date between "+"'"+startdate+"'"+" and "+"'"+enddate+"'"+" GROUP BY agegroup";
			CSVResult csvResult = getCsvResult(false, query);
	        List<String> headers = csvResult.getHeaders();
	        List<String> lines = csvResult.getLines();
	        List<PublisherReport> pubreport = new ArrayList<PublisherReport>();
	        String [] data;
	        for(int i=0;i<lines.size();i++)
	        {
	        	PublisherReport obj = new PublisherReport();
	       // 	obj.setDate(lines.get(i));
	        	data = lines.get(i).split(",");
	        	obj.setAge(data[0]);
	            obj.setCount(data[1]);
	            obj.setChannelName(channel_name);
	            pubreport.add(obj);
	        	 
	        }
	        System.out.println(headers);
	        System.out.println(lines);
	    	return pubreport;
		
	        
	       
	   //     Assert.assertEquals(3, lines.size());
	   //     Assert.assertTrue("2014-08-14 00:00:00,477.0", lines.contains("2014-08-14 00:00:00,477.0"));
	   //     Assert.assertTrue("2014-08-18 00:00:00,5664.0", lines.contains("2014-08-18 00:00:00,5664.0"));
	    //    Assert.assertTrue("2014-08-22 00:00:00,3795.0", lines.contains("2014-08-22 00:00:00,3795.0"));
	    }
	
	
	public List<PublisherReport> getISPChannel(String startdate, String enddate, String channel_name) throws SQLFeatureNotSupportedException, SqlParseException, CsvExtractorException, Exception  {
	      //  String query = String.format("select count(*),brandName,screen_properties,resolution_properties,browser_name,system_os from enhanceduserdata" +
	        //        " group by date_histogram('field'='request_time','interval'='1d','alias'='days'),brandName,screen_properties,resolution_properties,browser_name,system_os","enhanceduserdata");
	       
			
			String query = "Select count(*),ISP from enhanceduserdata where channel_name = '"+channel_name+"' and date between "+"'"+startdate+"'"+" and "+"'"+enddate+"'"+" GROUP BY ISP";
			CSVResult csvResult = getCsvResult(false, query);
	        List<String> headers = csvResult.getHeaders();
	        List<String> lines = csvResult.getLines();
	        List<PublisherReport> pubreport = new ArrayList<PublisherReport>();
	        String [] data;
	        for(int i=0;i<lines.size();i++)
	        {
	        	PublisherReport obj = new PublisherReport();
	       // 	obj.setDate(lines.get(i));
	        	data = lines.get(i).split(",");
	        	obj.setISP(data[0]);
	            obj.setCount(data[1]);
	            obj.setChannelName(channel_name);
	            pubreport.add(obj);
	        	 
	        }
	        System.out.println(headers);
	        System.out.println(lines);
	    	return pubreport;
		
	        
	       
	   //     Assert.assertEquals(3, lines.size());
	   //     Assert.assertTrue("2014-08-14 00:00:00,477.0", lines.contains("2014-08-14 00:00:00,477.0"));
	   //     Assert.assertTrue("2014-08-18 00:00:00,5664.0", lines.contains("2014-08-18 00:00:00,5664.0"));
	    //    Assert.assertTrue("2014-08-22 00:00:00,3795.0", lines.contains("2014-08-22 00:00:00,3795.0"));
	    }
	
	
	public List<PublisherReport> getOrgChannel(String startdate, String enddate, String channel_name) throws SQLFeatureNotSupportedException, SqlParseException, CsvExtractorException, Exception  {
	      //  String query = String.format("select count(*),brandName,screen_properties,resolution_properties,browser_name,system_os from enhanceduserdata" +
	        //        " group by date_histogram('field'='request_time','interval'='1d','alias'='days'),brandName,screen_properties,resolution_properties,browser_name,system_os","enhanceduserdata");
/*	       
		String query = "Select count(*),ISP from enhanceduserdata where channel_name = '"+channel_name+"' and date between "+"'"+startdate+"'"+" and "+"'"+enddate+"'"+" GROUP BY ISP";
		CSVResult csvResult = getCsvResult(false, query);
        List<String> headers = csvResult.getHeaders();
        List<String> lines = csvResult.getLines();
        String [] data;
        String [] data2;
        Set<String> Isps = new HashSet<String>();
        
        for(int i=0;i<lines.size();i++)
        {
        	
       // 	obj.setDate(lines.get(i));
        	data = lines.get(i).split(",");
        	data2 = data[0].split("_");
        	Isps.add(data2[0]);
           // Isps.add(data2[1]);
        }	
*/
		    String query1 = "Select count(*),organisation from enhanceduserdata where channel_name = '"+channel_name+"' and date between "+"'"+startdate+"'"+" and "+"'"+enddate+"'"+" GROUP BY organisation";
			CSVResult csvResult1 = getCsvResult(false, query1);
	        List<String> headers1 = csvResult1.getHeaders();
	        List<String> lines1 = csvResult1.getLines();
	        List<PublisherReport> pubreport = new ArrayList<PublisherReport>();
	        String [] data1;
	        String [] data3;
	        for(int i=0;i<lines1.size();i++)
	        {
	        	PublisherReport obj = new PublisherReport();
	       // 	obj.setDate(lines.get(i));
	        	data1 = lines1.get(i).split(",");
	        	if(data1[0].contains("broadband")==false && data1[0].contains("communication")==false && data1[0].contains("cable")==false && data1[0].contains("telecom")==false && data1[0].contains("network")==false && data1[0].contains("isp")==false && data1[0].contains("hathway")==false && data1[0].contains("internet")==false && data1[0].equals("_ltd")==false && data1[0].equals("Googlebot")==false && data1[0].contains("Sify")==false && data1[0].contains("Bsnl")==false){
	        	obj.setOrganisation(data1[0]);
	            obj.setCount(data1[1]);
	            obj.setChannelName(channel_name);
	            pubreport.add(obj);
	        	 
	        }
	        }
	        
	        System.out.println(headers1);
	        System.out.println(lines1);
	    	return pubreport;
		
	        
	       
	   //     Assert.assertEquals(3, lines.size());
	   //     Assert.assertTrue("2014-08-14 00:00:00,477.0", lines.contains("2014-08-14 00:00:00,477.0"));
	   //     Assert.assertTrue("2014-08-18 00:00:00,5664.0", lines.contains("2014-08-18 00:00:00,5664.0"));
	    //    Assert.assertTrue("2014-08-22 00:00:00,3795.0", lines.contains("2014-08-22 00:00:00,3795.0"));
	    }
	
	
	
	
		
	 private static CSVResult getCsvResult(boolean flat, String query) throws SqlParseException, SQLFeatureNotSupportedException, Exception, CsvExtractorException {
	        return getCsvResult(flat,query,false,false);
	    }

	    private static CSVResult getCsvResult(boolean flat, String query,boolean includeScore , boolean includeType) throws SqlParseException, SQLFeatureNotSupportedException, Exception, CsvExtractorException {
	        SearchDao searchDao = getSearchDao();
	        QueryAction queryAction = searchDao.explain(query);
	        Object execution =  QueryActionElasticExecutor.executeAnyAction(searchDao.getClient(), queryAction);
	        return new CSVResultsExtractor(includeScore,includeType).extractResults(execution, flat, ",");
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void sumTest() throws IOException, SqlParseException, SQLFeatureNotSupportedException {
	//	Aggregations result = query(String.format("SELECT SUM(balance) FROM %s/account", TEST_INDEX));
	//	Sum sum = result.get("SUM(balance)");
	//	assertThat(sum.getValue(), equalTo(25714837.0));
	}

    // script on metric aggregation tests. uncomment if your elastic has scripts enable (disabled by default)
    //todo: find a way to check if scripts are enabled
//    @Test
//    public void sumWithScriptTest() throws IOException, SqlParseException, SQLFeatureNotSupportedException {
//        Aggregations result = query(String.format("SELECT SUM(script('','doc[\\'balance\\'].value + doc[\\'balance\\'].value')) as doubleSum FROM %s/account", TEST_INDEX));
//        Sum sum = result.get("doubleSum");
//        assertThat(sum.getValue(), equalTo(25714837.0*2));
//    }
//
//    @Test
//    public void sumWithImplicitScriptTest() throws IOException, SqlParseException, SQLFeatureNotSupportedException {
//        Aggregations result = query(String.format("SELECT SUM(balance + balance) as doubleSum FROM %s/account", TEST_INDEX));
//        Sum sum = result.get("doubleSum");
//        assertThat(sum.getValue(), equalTo(25714837.0*2));
//    }
//
//    @Test
//    public void sumWithScriptTestNoAlias() throws IOException, SqlParseException, SQLFeatureNotSupportedException {
//        Aggregations result = query(String.format("SELECT SUM(balance + balance) FROM %s/account", TEST_INDEX));
//        Sum sum = result.get("SUM(script=script(balance + balance,doc('balance').value + doc('balance').value))");
//        assertThat(sum.getValue(), equalTo(25714837.0*2));
//    }
//
//    @Test
//    public void scriptedMetricAggregation() throws SQLFeatureNotSupportedException, SqlParseException {
//        Aggregations result = query ("select scripted_metric('map_script'='if(doc[\\'balance\\'].value > 49670){ if(!_agg.containsKey(\\'ages\\')) { _agg.put(\\'ages\\',doc[\\'age\\'].value); } " +
//                "else { _agg.put(\\'ages\\',_agg.get(\\'ages\\')+doc[\\'age\\'].value); }}'," +
//                "'reduce_script'='sumThem = 0; for (a in _aggs) { if(a.containsKey(\\'ages\\')){ sumThem += a.get(\\'ages\\');} }; return sumThem;') as wierdSum from " + TEST_INDEX + "/account");
//        ScriptedMetric metric = result.get("wierdSum");
//        Assert.assertEquals(136L,metric.aggregation());
//    }
//
//    @Test
//    public void scriptedMetricConcatWithStringParamAndReduceParamAggregation() throws SQLFeatureNotSupportedException, SqlParseException {
//        String query = "select scripted_metric(\n" +
//                "  'init_script' = '_agg[\"concat\"]=[] ',\n" +
//                "  'map_script'='_agg.concat.add(doc[field].value)' ,\n" +
//                "  'combine_script'='return _agg.concat.join(delim);',\t\t\t\t\n" +
//                "  'reduce_script'='_aggs.removeAll(\"\"); return _aggs.join(delim)'," +
//                "'@field' = 'name.firstname' , '@delim'=';',@reduce_delim =';' ) as all_characters \n" +
//                "from "+TEST_INDEX+"/gotCharacters";
//        Aggregations result = query (query);
//        ScriptedMetric metric = result.get("all_characters");
//        List<String> names = Arrays.asList(metric.aggregation().toString().split(";"));
//
//
//        Assert.assertEquals(4,names.size());
//        String[] expectedNames = new String[]{"brandon","daenerys","eddard","jaime"};
//        for(String name : expectedNames){
//            Assert.assertTrue("not contains:" + name,names.contains(name));
//        }
//    }
//
//    @Test
//    public void scriptedMetricAggregationWithNumberParams() throws SQLFeatureNotSupportedException, SqlParseException {
//        Aggregations result = query ("select scripted_metric('map_script'='if(doc[\\'balance\\'].value > 49670){ if(!_agg.containsKey(\\'ages\\')) { _agg.put(\\'ages\\',doc[\\'age\\'].value+x); } " +
//                "else { _agg.put(\\'ages\\',_agg.get(\\'ages\\')+doc[\\'age\\'].value+x); }}'," +
//                "'reduce_script'='sumThem = 0; for (a in _aggs) { if(a.containsKey(\\'ages\\')){ sumThem += a.get(\\'ages\\');} }; return sumThem;'" +
//                ",'@x'=3) as wierdSum from " + TEST_INDEX + "/account");
//        ScriptedMetric metric = result.get("wierdSum");
//        Assert.assertEquals(148L,metric.aggregation());
//    }
//


	private static Aggregations query(String query) throws SqlParseException, SQLFeatureNotSupportedException {
        SqlElasticSearchRequestBuilder select = getSearchRequestBuilder(query);
		return ((SearchResponse)select.get()).getAggregations();
	}

    private static SqlElasticSearchRequestBuilder getSearchRequestBuilder(String query) throws SqlParseException, SQLFeatureNotSupportedException {
        SearchDao searchDao = getSearchDao();
        return (SqlElasticSearchRequestBuilder) searchDao.explain(query).explain();
    }


    private static InetSocketTransportAddress getTransportAddress() {
		String host = System.getenv("ES_TEST_HOST");
		String port = System.getenv("ES_TEST_PORT");

		if(host == null) {
			host = "10.12.2.61";
			System.out.println("ES_TEST_HOST enviroment variable does not exist. choose default 'localhost'");
		}

		if(port == null) {
			port = "9300";
			System.out.println("ES_TEST_PORT enviroment variable does not exist. choose default '9300'");
		}

		System.out.println(String.format("Connection details: host: %s. port:%s.", host, port));
		return new InetSocketTransportAddress(host, Integer.parseInt(port));
	}


















	


}
