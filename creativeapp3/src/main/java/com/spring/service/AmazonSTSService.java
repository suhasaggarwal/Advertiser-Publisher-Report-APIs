package com.spring.service;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import Decoder.BASE64Encoder;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.securitytoken.AWSSecurityTokenServiceClient;
import com.amazonaws.services.securitytoken.model.Credentials;
import com.amazonaws.services.securitytoken.model.GetSessionTokenRequest;
import com.amazonaws.services.securitytoken.model.GetSessionTokenResult;
import com.spring.model.AmazonSTSResponse;
import com.spring.util.UUIDGenerator;

public class AmazonSTSService {

public static AmazonSTSResponse getSTSToken(){


AWSCredentials credentials = new BasicAWSCredentials("AKIAIRHJHKLFQ77VLK5A", "p7lGRHwDH15HKW9rC1wq9ApMvtE0sd16H5UvXuKS");
	
AWSSecurityTokenServiceClient sts_client = new AWSSecurityTokenServiceClient(credentials);

GetSessionTokenRequest session_token_request = new GetSessionTokenRequest();
session_token_request.setDurationSeconds(9600);

GetSessionTokenResult session_token_result =
sts_client.getSessionToken(session_token_request);

Credentials session_creds = session_token_result.getCredentials();


Date expiryTime = new Date(System.currentTimeMillis()+360*60*1000);

SimpleDateFormat dateFormat = new SimpleDateFormat(
        "yyyy-MM-dd hh:mm:ss");


Calendar now = Calendar.getInstance();
int year = now.get(Calendar.YEAR);
int month = now.get(Calendar.MONTH) + 1; // Note: zero based!
int day = now.get(Calendar.DAY_OF_MONTH)+1;
int hour = now.get(Calendar.HOUR_OF_DAY)+3;
int minute = now.get(Calendar.MINUTE);
int second = now.get(Calendar.SECOND);


//String expireTime = dateFormat.format(expiryTime);

String expireTime = year + "-"+month+"-"+day+'T'+hour + ':' + "00:00.000Z";

System.out.println(expireTime);
String uuid = UUIDGenerator.generate();
/*
String policy_document =
"{\"expiration\": \""+expireTime+"\""+"," +
  "\"conditions\": [" +
    "{\"bucket\": \"creativedata\"}," +
    "[\"starts-with\", \"$key\", \""+uuid+"\""+"]," +
    "{\"acl\": \"public-read-write\"}," +
    "{\"x-amz-security-token\": \""+session_creds.getSessionToken()+"\""+"}"+
    "]" +
"}";
*/


//Specification of bucket policy includes expiration time, temporary session token,acl

String policy_document =
"{\"expiration\": \""+expireTime+"\""+"," +
  "\"conditions\": [" +
    "{\"bucket\": \"creativedata\"}," +
    "[\"starts-with\", \"$key\", \"\"]," +
    "[\"starts-with\", \"$Content-Type\", \"\"],"+
    "{\"acl\": \"public-read\"}," +
    "{\"x-amz-security-token\": \""+session_creds.getSessionToken()+"\""+"}"+
    "]" +
"}";

//Policy is base 64 encoded and signed using  HmacSHA1

System.out.println(policy_document);

String signature = null;
String policy = null;
try {
	policy = (new BASE64Encoder()).encode(
	policy_document.getBytes("UTF-8")).replaceAll("\n","").replaceAll("\r","");
} catch (UnsupportedEncodingException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

Mac hmac = null;
try {
	hmac = Mac.getInstance("HmacSHA1");
} catch (NoSuchAlgorithmException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
try {
	hmac.init(new SecretKeySpec(session_creds.getSecretAccessKey().getBytes("UTF-8"), "HmacSHA1"));
} catch (InvalidKeyException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (UnsupportedEncodingException e) {
	// TODO Auto-generated catch block+
	
	
	
	e.printStackTrace();
}
try {
    signature = (new BASE64Encoder()).encode(
	hmac.doFinal(policy.getBytes("UTF-8")))
	.replaceAll("\n", "");
} catch (IllegalStateException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (UnsupportedEncodingException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

//Temporary credentials derived are returned in response


AmazonSTSResponse response = new AmazonSTSResponse();
response.setAccessKeyId(session_creds.getAccessKeyId());
response.setSecretAccessKey(session_creds.getSecretAccessKey());
response.setSessionToken(session_creds.getSessionToken());
response.setPolicy(policy);
response.setSignature(signature);
response.setUuid(uuid);

return response;

}

}