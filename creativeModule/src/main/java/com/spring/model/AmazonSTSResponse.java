package com.spring.model;

public class AmazonSTSResponse {


public String getSessionToken() {
	return sessionToken;
}

public void setSessionToken(String sessionToken) {
	this.sessionToken = sessionToken;
}

public String getSecretAccessKey() {
	return secretAccessKey;
}

public void setSecretAccessKey(String secretAccessKey) {
	this.secretAccessKey = secretAccessKey;
}

public String getAccessKeyId() {
	return AccessKeyId;
}

public void setAccessKeyId(String accessKeyId) {
	AccessKeyId = accessKeyId;
}

private String sessionToken;

private String secretAccessKey;

private String AccessKeyId;

private String signature;

public String getSignature() {
	return signature;
}

public void setSignature(String signature) {
	this.signature = signature;
}

public String getPolicy() {
	return policy;
}

public void setPolicy(String policy) {
	this.policy = policy;
}

private String policy;

public String getUuid() {
	return uuid;
}

public void setUuid(String uuid) {
	this.uuid = uuid;
}

private String uuid;

}
