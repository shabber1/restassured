package com.sample.crud.withoutBdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class sampleTestforCompleteUpdateTest {
@Test
public void putdatatoserverTest() {
	JSONObject jsonObj=new JSONObject();
	jsonObj.put("createdBy", "shfjs");
	jsonObj.put("projectName", "sfgd2");
	jsonObj.put("status", "Created");
	jsonObj.put("teamSize", 0);

	RequestSpecification req = RestAssured.given();
	req.contentType(ContentType.JSON);
	req.body(jsonObj.toJSONString());
	
	Response res=req.put("http://49.249.28.218:8091/project/NH_PROJ_5983");
	res.then().log().all();
	res.then().assertThat().statusCode(200);
}
}
