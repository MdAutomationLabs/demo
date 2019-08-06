package com.qa.test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;

public class GetAPITest extends TestBase{
	TestBase testBase;
	RestClient restClient;
	CloseableHttpResponse closebaleHttpResponse;
	String serviceUrl;
	String apiUrl;
	String url;
	@BeforeMethod
	public void setup() {
		 testBase = new TestBase();
		 serviceUrl = prop.getProperty("URL");
		 apiUrl = prop.getProperty("serviceURL");
		 
		 url = serviceUrl + apiUrl;
		
	}
	
	@Test
	public void getTest() throws ClientProtocolException, IOException {
		restClient = new RestClient();
		closebaleHttpResponse = restClient.get(url);
		
		//a. Status Code:
	    int statusCode = closebaleHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status Code--->"+ statusCode);

    	Assert.assertEquals(statusCode, RESPONSE_STATUS_CODE_200, "Status code is not 200");

		//b. Json String:
	//String responseString = EntityUtils.toString(closebaleHttpResponse.getEntity(), "UTF-8");

				JSONObject responseJson = new JSONObject(responseString);
				System.out.println("Response JSON from API---> "+ responseJson);
		
	}

}
