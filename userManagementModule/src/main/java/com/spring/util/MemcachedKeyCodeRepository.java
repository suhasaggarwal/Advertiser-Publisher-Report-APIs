package com.spring.util;



import java.io.IOException;
import java.util.concurrent.Future;

import net.spy.memcached.MemcachedClient;

import org.apache.log4j.Logger;


public class MemcachedKeyCodeRepository {

    public static MemcachedClient memcache;

    private static MemcachedKeyCodeRepository INSTANCE=null;
	
	public static MemcachedKeyCodeRepository getInstance() {
		 
		if(INSTANCE == null){
			  return new MemcachedKeyCodeRepository();
			 }
			  else
			 {
				  return INSTANCE ;
			 }
		
	}
    
    
    public Logger logger = Logger.getLogger(MemcachedKeyCodeRepository.class);

    public MemcachedKeyCodeRepository(){
        try {
            init();
        } catch (IOException ex) {
            logger.fatal(ex.getMessage(), ex);
        }

    }

    protected void init() throws IOException{
    //    memcache  = new MemcachedClient(AddrUtil.getAddresses("127.0.0.1:11211"));
        
    }

	
	
	public String getUserInfo(String key) {
        return (String)memcache.get(key);
	}
	
	
	public void putUserInfo(String token,String emailId) {
		Future fs=memcache.set(token, 60*6*60,emailId );
	}


  
   
    
    
    
}
